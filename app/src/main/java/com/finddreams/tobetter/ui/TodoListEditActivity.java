package com.finddreams.tobetter.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.ResponseTodoListBean;
import com.finddreams.tobetter.databinding.ActivityTodoListEditBinding;
import com.orhanobut.logger.Logger;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.Calendar;

public class TodoListEditActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ActivityTodoListEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list_edit);
        binding.etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        TodoListEditActivity.this,
                        now.get(Calendar.YEAR), // Initial year selection
                        now.get(Calendar.MONTH), // Initial month selection
                        now.get(Calendar.DAY_OF_MONTH) // Inital day selection
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        binding.btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDoList();
            }
        });
    }

    private void addToDoList() {
        EasyHttp.post("/lg/todo/add/json")
                .params("title", binding.etTitle.getText().toString())
                .params("content", binding.etContent.getText().toString())
                .params("date", "")
                .baseUrl(MyApplication.baseurl).execute(new SimpleCallBack<ResponseTodoListBean>() {
            @Override
            public void onError(ApiException e) {
                Logger.d(e);
            }

            @Override
            public void onSuccess(ResponseTodoListBean responseTodoListBean) {
                Logger.d(responseTodoListBean.errorMsg);
            }

        });
    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        Logger.d(i+""+i1+""+i2);
    }
}