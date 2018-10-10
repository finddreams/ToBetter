package com.finddreams.tobetter.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.Constant;
import com.finddreams.tobetter.app.HttpManager;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.ResponseAddList;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ItemTodolistBinding;
import com.finddreams.tobetter.event.UpdateDataEvent;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<BaseBindingViewHolder<ItemTodolistBinding>> {
    public List<ResponseTodoListBean.TodoListBeanX.TodoListBean> allListBeans=new ArrayList<>();

    public void setTodoListBeans( List<ResponseTodoListBean.TodoListBeanX> todoListBeans) {
        allListBeans.clear();
        for (int i = 0; i < todoListBeans.size(); i++) {
            ResponseTodoListBean.TodoListBeanX todoListBeanXX = todoListBeans.get(i);
            List<ResponseTodoListBean.TodoListBeanX.TodoListBean> todoList = todoListBeanXX.getTodoList();
            allListBeans.addAll(todoList);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseBindingViewHolder<ItemTodolistBinding> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemTodolistBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_todolist, viewGroup, false);

        return new BaseBindingViewHolder<>(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindingViewHolder<ItemTodolistBinding> baseBindingViewHolder, final int i) {
        ItemTodolistBinding binding = baseBindingViewHolder.getBinding();
        final ResponseTodoListBean.TodoListBeanX.TodoListBean todoListBeanX = allListBeans.get(i);
        binding.setList(todoListBeanX);
        binding.itemDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = todoListBeanX.getId();
                removeItem(todoListBeanX,id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allListBeans.size();
    }
    public void removeItem(final ResponseTodoListBean.TodoListBeanX.TodoListBean bean, int todoId){
        HttpManager.post(String.format(Constant.DELETE_TODO_URI, todoId))
                .baseUrl(MyApplication.baseurl)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        Logger.d(s);
                        EventBus.getDefault().post(new UpdateDataEvent());
                    }
                });

    }
}
