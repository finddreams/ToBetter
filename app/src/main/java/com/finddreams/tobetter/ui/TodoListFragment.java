package com.finddreams.tobetter.ui;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.adapter.ToDoListAdapter;
import com.finddreams.tobetter.app.Constant;
import com.finddreams.tobetter.app.HttpManager;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.BaseApiResult;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.FragmentTodolistBinding;
import com.finddreams.tobetter.event.UpdateDataEvent;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class TodoListFragment extends BaseFragment {

    private FragmentTodolistBinding binding;
    private ToDoListAdapter toDoListAdapter;
    public List<ResponseTodoListBean.TodoListBeanX.TodoListBean> allListBeans=new ArrayList<>();

    public static TodoListFragment newInstance() {

        Bundle args = new Bundle();

        TodoListFragment fragment = new TodoListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todolist, container, false);
        initView();
        return binding.getRoot();
    }

    private void initView() {

        binding.refreshLayout.setOnRefreshListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getToDoList();
            }
        });
        binding.recycleView.setSwipeMenuCreator(new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
                int width = getResources().getDimensionPixelSize(R.dimen.dp_80);

                // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
                // 2. 指定具体的高，比如80;
                // 3. WRAP_CONTENT，自身高度，不推荐;
                int height = getResources().getDimensionPixelSize(R.dimen.dp_80);
                SwipeMenuItem deleteItem = new SwipeMenuItem(context)
                        .setBackground(R.drawable.selector_red)
                        .setText("删除")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。

                SwipeMenuItem addItem = new SwipeMenuItem(context)
                        .setBackground(R.drawable.selector_green)
                        .setText("添加")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(addItem); // 添加菜单到右侧。
            }
        });
        binding.recycleView.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                int position = menuBridge.getPosition();
                // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                menuBridge.closeMenu();
                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
                if (!allListBeans.isEmpty()) {
                    ResponseTodoListBean.TodoListBeanX.TodoListBean todoListBean = allListBeans.get(adapterPosition);
                    if (position == 0) {
                        removeItem(todoListBean.getId());
                    } else if (position == 1) {

                    }
                    allListBeans.remove(todoListBean);
                    toDoListAdapter.notifyItemRemoved(adapterPosition);
                }
            }
        });
//        binding.recycleView.setItemViewSwipeEnabled(true); // 策划删除，默认关闭。
    }

    @Override
    public void onResume() {
        super.onResume();
        getToDoList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Override
    protected void initData() {
        toDoListAdapter = new ToDoListAdapter();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycleView.setAdapter(toDoListAdapter);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(UpdateDataEvent event) {
        /* Do something */
        getToDoList();
    }


    private void getToDoList() {

        EasyHttp.post("/lg/todo/list/0/json").baseUrl(MyApplication.baseurl)
                .execute(new CallBackProxy<BaseApiResult<ResponseTodoListBean>, ResponseTodoListBean>(new SimpleCallBack<ResponseTodoListBean>() {
                    @Override
                    public void onError(ApiException e) {
                        Logger.d(e.getMessage());
                        binding.refreshLayout.finishRefresh();
                    }

                    @Override
                    public void onSuccess(ResponseTodoListBean response) {
                        binding.refreshLayout.finishRefresh();
                        if (response != null) {
                            List<ResponseTodoListBean.TodoListBeanX> todoList = response.getTodoList();
                            setTodoListBeans(todoList);
                        }
                    }
                }) {
                });
    }
    public void removeItem(int todoId){
        HttpManager.post(String.format(Constant.DELETE_TODO_URI, todoId))
                .baseUrl(MyApplication.baseurl)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Logger.d(s);
//                        EventBus.getDefault().post(new UpdateDataEvent());
                    }
                });

    }

    public void setTodoListBeans(List<ResponseTodoListBean.TodoListBeanX> todoListBeans){
        allListBeans.clear();
        for (int i = 0; i < todoListBeans.size(); i++) {
            ResponseTodoListBean.TodoListBeanX todoListBeanXX = todoListBeans.get(i);
            ResponseTodoListBean.TodoListBeanX.TodoListBean title = new ResponseTodoListBean.TodoListBeanX.TodoListBean();
            title.isTitle=true;
            title.setDateStr(todoListBeanXX.getDate()+"");
            allListBeans.add(title);
            List<ResponseTodoListBean.TodoListBeanX.TodoListBean> todoList = todoListBeanXX.getTodoList();
            for (int j = 0; j < todoList.size(); j++) {
                ResponseTodoListBean.TodoListBeanX.TodoListBean todoListBean = todoList.get(i);
                String content = todoListBean.getContent();
                if (content.contains(Constant.Important_Level_A)){
                    todoListBean.level=Constant.Important_Level_A;
                    content=content.replace(Constant.Important_Level_A,"");
                }else if (content.contains(Constant.Important_Level_B)){
                    todoListBean.level=Constant.Important_Level_B;
                    content=content.replace(Constant.Important_Level_B,"");
                }else if (content.contains(Constant.Important_Level_C)){
                    todoListBean.level=Constant.Important_Level_C;
                    content=content.replace(Constant.Important_Level_C,"");
                }else if (content.contains(Constant.Important_Level_D)){
                    todoListBean.level=Constant.Important_Level_D;
                    content=content.replace(Constant.Important_Level_D,"");
                }
                todoListBean.setContent(content);
                allListBeans.add(todoListBean);
            }
            toDoListAdapter.setTodoListBeans(allListBeans);
        }
    }
}
