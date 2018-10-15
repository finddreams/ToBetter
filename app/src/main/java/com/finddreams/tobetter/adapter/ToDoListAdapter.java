package com.finddreams.tobetter.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.Constant;
import com.finddreams.tobetter.app.HttpManager;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ItemTodolistBinding;
import com.finddreams.tobetter.databinding.ItemTodolistTitleBinding;
import com.finddreams.tobetter.event.UpdateDataEvent;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<BaseBindingViewHolder<ViewDataBinding>> {
    public List<ResponseTodoListBean.TodoListBeanX.TodoListBean> allListBeans = new ArrayList<>();
    private Context context;
    private int Type_Item = 1;
    private int Type_Title = 2;

    public void setTodoListBeans(List<ResponseTodoListBean.TodoListBeanX.TodoListBean> allListBeans) {
        this.allListBeans.clear();
        this.allListBeans.addAll(allListBeans);
        Logger.d(this.allListBeans);
        notifyDataSetChanged();
    }
    @Override
    public BaseBindingViewHolder<ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ViewDataBinding viewDataBinding;
        context = viewGroup.getContext();
        if (viewType == Type_Title) {
            viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_todolist_title, viewGroup, false);
            return new BaseBindingViewHolder<>(viewDataBinding);
        }
        viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_todolist, viewGroup, false);
        return new BaseBindingViewHolder<>(viewDataBinding);
    }

    @Override
    public int getItemViewType(int position) {
        ResponseTodoListBean.TodoListBeanX.TodoListBean todoListBean = allListBeans.get(position);
        if (todoListBean.isTitle) {
            return Type_Title;
        }
        return Type_Item;
    }


    @Override
    public void onBindViewHolder(@NonNull BaseBindingViewHolder<ViewDataBinding> baseBindingViewHolder, final int position) {
        int itemViewType = getItemViewType(position);
        final ResponseTodoListBean.TodoListBeanX.TodoListBean todoListBeanX = allListBeans.get(position);
        String level = todoListBeanX.level;
        if (itemViewType == Type_Title) {
            ItemTodolistTitleBinding binding = (ItemTodolistTitleBinding) baseBindingViewHolder.getBinding();
            long date = todoListBeanX.getDate();
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(date);
            binding.setContent(instance.get(Calendar.YEAR)+"-"+(instance.get(Calendar.MONTH)+1)+"-"+instance.get(Calendar.DAY_OF_MONTH));
        } else {
            ItemTodolistBinding binding = (ItemTodolistBinding) baseBindingViewHolder.getBinding();
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
            binding.setList(todoListBeanX);
        }
    }

    @Override
    public int getItemCount() {
        return allListBeans.size();
    }

}
