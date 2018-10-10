package com.finddreams.tobetter.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.Constant;
import com.finddreams.tobetter.app.HttpManager;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.ResponseAddList;
import com.finddreams.tobetter.databinding.ActivityTodoListEditBinding;
import com.orhanobut.logger.Logger;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.Calendar;

public class TodoListEditActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ActivityTodoListEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list_edit);
        initView();
    }

    private void initView() {
        Calendar now = Calendar.getInstance();
        final int year = now.get(Calendar.YEAR);
        final int month = now.get(Calendar.MONTH) + 1;
        final int day = now.get(Calendar.DAY_OF_MONTH);
        setDate(year, month, day);
        binding.todoDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        TodoListEditActivity.this,
                        year,
                        month, // Initial month selection
                        day // Inital day selection
                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        binding.saveTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToDoList();
            }
        });
        binding.title.setText("添加TODO");
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void addToDoList() {
        String content = binding.todoDes.getText().toString();
        String level = Constant.Important_Level_A;
        content += level;
        HttpManager.post("/lg/todo/add/json")
                .params("title", binding.todoName.getText().toString())
                .params("content", content)
                .params("date", binding.todoDate.getText().toString())
                .baseUrl(MyApplication.baseurl)
                .execute(new SimpleCallBack<ResponseAddList>() {
                    @Override
                    public void onError(ApiException e) {
                        showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(ResponseAddList s) {
                        Logger.d(s);
                        showToast("添加成功！");
                        finish();
                    }
                });


    }

    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        setDate(i, i1, i2);
    }

    private void setDate(int year, int month, int day) {
        String date = year + "-" + month + "-" + day;
        binding.todoDate.setText(date);
        Logger.d(date);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
