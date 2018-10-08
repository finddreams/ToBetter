package com.finddreams.tobetter.bean;

import com.zhouyou.http.model.ApiResult;

public class BaseApiResult<T> extends ApiResult<T>{
    public int errorCode;
    public String errorMsg;

    @Override
    public int getCode() {
        return errorCode;
    }

    @Override
    public String getMsg() {
        return errorMsg;
    }
    @Override
    public boolean isOk() {
        return getCode()==0;//如果不是0表示成功，请重写isOk()方法。
    }

    @Override
    public String toString() {
        return "BaseApiResult{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + getData() +
                '}';
    }
}
