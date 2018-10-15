package com.finddreams.tobetter.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.databinding.FragmentFundBinding;

public class FundFragment extends BaseFragment {

    private FragmentFundBinding binding;

    public static FundFragment newInstance() {

        Bundle args = new Bundle();

        FundFragment fragment = new FundFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fund, container, false);

        return binding.getRoot();
    }

    @Override
    protected void initData() {

    }
}
