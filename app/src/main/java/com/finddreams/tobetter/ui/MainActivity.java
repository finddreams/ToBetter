package com.finddreams.tobetter.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.adapter.ToDoListAdapter;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.BaseResponseBean;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ActivityMainBinding;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.ArrayList;
import java.util.Date;
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
        EasyHttp.post("/user/login").params("username", "finddreams").params("password", "www2008com").baseUrl(MyApplication.baseurl).execute(new SimpleCallBack<String>() {
            @Override
            public void onError(ApiException e) {

            }

            @Override
            public void onSuccess(String s) {
                Logger.d(s);
                getToDoList();
            }

        });
    }

    private void getToDoList() {
        EasyHttp.post("/lg/todo/list/0/json").baseUrl(MyApplication.baseurl).execute(new SimpleCallBack<ResponseTodoListBean>() {
            @Override
            public void onError(ApiException e) {
                Logger.d(e);
            }

            @Override
            public void onSuccess(ResponseTodoListBean data) {
                List<ResponseTodoListBean.TodoListBeanXX> todoList = data.todoList;
                toDoListAdapter.setTodoListBeans(todoList);
            }
        });
    }

}
