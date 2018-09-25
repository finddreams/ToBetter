package com.finddreams.tobetter.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ItemTodolistBinding;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<BaseBindingViewHolder<ItemTodolistBinding>> {
    public List<ResponseTodoListBean.DataBean.TodoListBeanX.TodoListBean> allListBeans=new ArrayList<>();

    public void setTodoListBeans( List<ResponseTodoListBean.DataBean.TodoListBeanX> todoListBeans) {
        for (int i = 0; i < todoListBeans.size(); i++) {
            ResponseTodoListBean.DataBean.TodoListBeanX todoListBeanXX = todoListBeans.get(i);
            List<ResponseTodoListBean.DataBean.TodoListBeanX.TodoListBean> todoList = todoListBeanXX.todoList;
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
    public void onBindViewHolder(@NonNull BaseBindingViewHolder<ItemTodolistBinding> baseBindingViewHolder, int i) {
        ItemTodolistBinding binding = baseBindingViewHolder.getBinding();
        ResponseTodoListBean.DataBean.TodoListBeanX.TodoListBean todoListBeanX = allListBeans.get(i);
        binding.setList(todoListBeanX);
    }

    @Override
    public int getItemCount() {
        return allListBeans.size();
    }

}
