package com.finddreams.tobetter.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.Constant;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ItemTodolistBinding;
import com.finddreams.tobetter.databinding.ItemTodolistTitleBinding;

import me.drakeet.multitype.ItemViewBinder;

public class TodoItemBinder extends ItemViewBinder<ResponseTodoListBean.TodoListBeanX.TodoListBean,BaseBindingViewHolder<ItemTodolistBinding>> {
    @NonNull
    @Override
    protected BaseBindingViewHolder<ItemTodolistBinding> onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        ItemTodolistBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_todolist, parent, false);
            return new BaseBindingViewHolder<>(viewDataBinding);
    }

    @Override
    protected void onBindViewHolder(@NonNull BaseBindingViewHolder<ItemTodolistBinding> holder, @NonNull ResponseTodoListBean.TodoListBeanX.TodoListBean item) {
        ItemTodolistBinding binding = holder.getBinding();
        String level = item.level;
        Context context = binding.getRoot().getContext();
        if (TextUtils.equals(level, Constant.Important_Level_A)) {
            binding.title.setTextColor(context.getResources().getColor(R.color.level_A));
            binding.content.setTextColor(context.getResources().getColor(R.color.level_A));
            binding.date.setTextColor(context.getResources().getColor(R.color.level_A));
        } else if (TextUtils.equals(level, Constant.Important_Level_B)) {
            binding.title.setTextColor(context.getResources().getColor(R.color.level_A));
            binding.content.setTextColor(context.getResources().getColor(R.color.level_A));
            binding.date.setTextColor(context.getResources().getColor(R.color.level_A));
        } else if (TextUtils.equals(level, Constant.Important_Level_C)) {
            binding.title.setTextColor(context.getResources().getColor(R.color.level_C));
            binding.content.setTextColor(context.getResources().getColor(R.color.level_C));
            binding.date.setTextColor(context.getResources().getColor(R.color.level_C));
        } else if (TextUtils.equals(level, Constant.Important_Level_D)) {
            binding.title.setTextColor(context.getResources().getColor(R.color.level_D));
            binding.content.setTextColor(context.getResources().getColor(R.color.level_D));
            binding.date.setTextColor(context.getResources().getColor(R.color.level_D));
        }
        binding.setList(item);
    }
}
