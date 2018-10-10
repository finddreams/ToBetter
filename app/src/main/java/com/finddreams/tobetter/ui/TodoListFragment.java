package com.finddreams.tobetter.ui;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.adapter.ToDoListAdapter;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.BaseApiResult;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.FragmentTodolistBinding;
import com.finddreams.tobetter.event.UpdateDataEvent;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

public class TodoListFragment extends BaseFragment {

    private FragmentTodolistBinding binding;
    private ToDoListAdapter toDoListAdapter;

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
                            toDoListAdapter.setTodoListBeans(todoList);
                        }
                    }
                }) {
                });
    }

    @Override
    protected void initData() {
        toDoListAdapter = new ToDoListAdapter();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recycleView.setAdapter(toDoListAdapter);
    }
}
