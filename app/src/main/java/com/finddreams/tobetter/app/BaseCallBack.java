package com.finddreams.tobetter.app;

import com.finddreams.tobetter.bean.BaseResponseResult;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zhouyou.http.callback.CallBack;
import com.zhouyou.http.callback.SimpleCallBack;
import com.zhouyou.http.exception.ApiException;

public abstract class BaseCallBack<T extends BaseResponseResult> extends CallBack<String> {

    @Override
    public void onSuccess(String s) {
        try {
            T t = new Gson().fromJson(s, ClassTypeReflect.getModelClazz(getClass()));
            onSuccess(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            onError(new ApiException(e, 100000));
        }
    }

    public abstract void onSuccess(T t);

    @Override
    public void onStart() {

    }

    @Override
    public void onCompleted() {

    }
}
