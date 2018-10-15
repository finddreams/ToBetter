package com.finddreams.tobetter.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.HttpManager;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.ResponseUserDataBean;
import com.finddreams.tobetter.databinding.ActivityMainBinding;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.cache.model.CacheResult;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        login();
    }

    private void initData() {
        List<Fragment> fragments = new ArrayList<>(3);
        fragments.add(TodoListFragment.newInstance(false));
        fragments.add(TodoListFragment.newInstance(true));
        fragments.add(FundFragment.newInstance());
        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments);
        binding.viewPager.setAdapter(adapter);
        binding.viewPager.setOffscreenPageLimit(3);
    }

    private void initView() {
        binding.navigation.setupWithViewPager(binding.viewPager);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        binding.title.setText(R.string.to_do_list);
                        binding.addTodo.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        binding.title.setText(R.string.complete_list);
                        binding.addTodo.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        binding.title.setText(R.string.fund);
                        binding.addTodo.setVisibility(View.INVISIBLE);

                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
        binding.addTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TodoListEditActivity.class));
            }
        });
    }

    private void login() {
        HttpManager.post("/user/login").params("username", "finddreams").params("password", "www2008com").baseUrl(MyApplication.baseurl)
                .cacheKey("/user/login")
                .cacheMode(CacheMode.FIRSTREMOTE)
                .execute(new SimpleCallBack<CacheResult<ResponseUserDataBean>>() {
                    @Override
                    public void onError(ApiException e) {
                        Logger.d(e.getMessage());

                    }

                    @Override
                    public void onSuccess(CacheResult<ResponseUserDataBean> responseUserDataBeanCacheResult) {
                        if (responseUserDataBeanCacheResult.isFromCache) {
                            Logger.d(responseUserDataBeanCacheResult.data.toString());
                        }
                        initData();
                    }

                });
    }
    private static class MainViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments;

        public MainViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

}
