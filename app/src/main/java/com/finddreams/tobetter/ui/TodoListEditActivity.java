package com.finddreams.tobetter.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.finddreams.tobetter.R;
import com.finddreams.tobetter.app.BaseCallBack;
import com.finddreams.tobetter.app.MyApplication;
import com.finddreams.tobetter.bean.BaseApiResult;
import com.finddreams.tobetter.bean.ResultBean;
import com.finddreams.tobetter.bean.TestApiResult1;
import com.finddreams.tobetter.databinding.ActivityTodoListEditBinding;
import com.orhanobut.logger.Logger;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.callback.CallBackProxy;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

import java.util.Calendar;

public class TodoListEditActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private ActivityTodoListEditBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo_list_edit);
        binding.btSelectTime.setOnClickListener(new View.OnClickListener() {
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
        onTestOne();
    }

    private void addToDoList() {
        EasyHttp.post("/lg/todo/add/json")
                .params("title", binding.etTitle.getText().toString())
                .params("content", binding.etContent.getText().toString())
                .params("date", binding.etDate.getText().toString())
                .baseUrl(MyApplication.baseurl)
                .execute(new BaseCallBack<BaseApiResult>() {
                    @Override
                    public void onError(ApiException e) {

                    }

                    @Override
                    public void onSuccess(BaseApiResult responseTodoListBean) {
                        Logger.d(responseTodoListBean.errorCode);
                    }
                });


    }

    public void onTestOne(){
        //方式一
        EasyHttp.get("/mobile/get")
                .baseUrl("http://apis.juhe.cn")
                .readTimeOut(30 * 1000)//局部定义读超时
                .writeTimeOut(30 * 1000)
                .connectTimeout(30 * 1000)
                .params("phone", "18688994275")
                .params("dtype", "json")
                .params("key", "5682c1f44a7f486e40f9720d6c97ffe4")
                .execute(new CallBackProxy<TestApiResult1<ResultBean>, ResultBean>(new SimpleCallBack<ResultBean>() {
                    @Override
                    public void onError(ApiException e) {
                        showToast(e.getMessage());
                    }

                    @Override
                    public void onSuccess(ResultBean response) {
                        if (response != null) showToast(response.toString());
                    }
                }) {
                });
    }
    @Override
    public void onDateSet(DatePickerDialog datePickerDialog, int i, int i1, int i2) {
        String date = i + "-" + i1 + 1 + "-" + i2;
        binding.etDate.setText(date);
        Logger.d(date);
    }
    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
