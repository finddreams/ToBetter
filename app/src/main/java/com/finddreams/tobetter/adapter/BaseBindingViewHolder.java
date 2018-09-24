package com.finddreams.tobetter.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by lx on 17-11-20.
 */

public class BaseBindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    private T binding;
    private OnItemClickListener onItemClickListener;

    public BaseBindingViewHolder(T binding) {
        super(binding.getRoot());
        this.binding = binding;
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            }
        });
    }

    public T getBinding() {
        return binding;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
