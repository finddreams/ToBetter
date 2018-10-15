package com.finddreams.tobetter.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ItemTodolistTitleBinding;

import me.drakeet.multitype.ItemViewBinder;

public class TodoTitleItemBinder extends ItemViewBinder<ResponseTodoListBean.TodoListBeanX.TodoListBean,BaseBindingViewHolder<ItemTodolistTitleBinding>> {
    @NonNull
    @Override
    protected BaseBindingViewHolder<ItemTodolistTitleBinding> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ItemTodolistTitleBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_todolist_title, parent, false);
            return new BaseBindingViewHolder<>(viewDataBinding);
    }

    @Override
    protected void onBindViewHolder(@NonNull BaseBindingViewHolder<ItemTodolistTitleBinding> holder, @NonNull ResponseTodoListBean.TodoListBeanX.TodoListBean item) {
        ItemTodolistTitleBinding binding = holder.getBinding();
        binding.setContent(item.getDateStr());
    }
}
