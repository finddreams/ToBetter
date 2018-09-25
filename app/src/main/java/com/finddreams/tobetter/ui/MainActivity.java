package com.finddreams.tobetter.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.adapter.ToDoListAdapter;
import com.finddreams.tobetter.app.BaseCallBack;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.BaseResponseResult;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ActivityMainBinding;
import com.orhanobut.logger.Logger;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.CallClazzProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.model.ApiResult;

import java.util.List;

import io.reactivex.Observable;


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
    }

    private void login() {
        EasyHttp.post("/user/login").params("username", "finddreams").params("password", "www2008com")
                .baseUrl(MyApplication.baseurl).execute(new SimpleCallBack<String>() {
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
        EasyHttp.post("/lg/todo/list/0/json").baseUrl(MyApplication.baseurl)
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(String responseTodoListBean) {
                        //请求成功
//                        List<ResponseTodoListBean.DataBean.TodoListBeanX> todoList = responseTodoListBean.data.todoList;
//                        toDoListAdapter.setTodoListBeans(todoList);
                    }
                });

    }

}
