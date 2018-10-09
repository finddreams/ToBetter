package com.finddreams.tobetter.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.adapter.ToDoListAdapter;
import com.finddreams.tobetter.app.HttpManager;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.BaseApiResult;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.bean.ResponseUserDataBean;
import com.finddreams.tobetter.databinding.ActivityMainBinding;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cache.model.CacheMode;
import com.zhouyou.http.cache.model.CacheResult;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ToDoListAdapter toDoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        toDoListAdapter = new ToDoListAdapter();
        binding.recycleView.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleView.setAdapter(toDoListAdapter);
        login();
        binding.btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TodoListEditActivity.class));
            }
        });
        binding.refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getToDoList();
            }
        });
    }

    private void login() {
        EasyHttp.post("/user/login").params("username", "finddreams").params("password", "www2008com")
                .baseUrl(MyApplication.baseurl)
                .execute(new CallBackProxy<BaseApiResult<ResponseUserDataBean>, ResponseUserDataBean>(new SimpleCallBack<ResponseUserDataBean>() {
                    @Override
                    public void onError(ApiException e) {
                        Logger.d(e.getMessage());
                    }

                    @Override
                    public void onSuccess(ResponseUserDataBean response) {
                        Logger.d(response.getUsername());
                        getToDoList();
                    }
                }) {
                });
        HttpManager.post("/user/login").params("username", "finddreams").params("password", "www2008com").baseUrl(MyApplication.baseurl).cacheMode(CacheMode.FIRSTREMOTE)
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
                        getToDoList();
                    }

                });
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

}
