package com.finddreams.tobetter.app;

import android.app.Application;
import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.zhouyou.http.EasyHttp;
import com.zhouyou.http.cookie.CookieManger;

public class MyApplication extends Application {
    public static String baseurl = "http://wanandroid.com";

    @Override
    public void onCreate() {
        super.onCreate();
        EasyHttp.init(this);//默认初始化
        EasyHttp.getInstance().setCookieStore(new CookieManger(this)).debug("Better");
        Logger.addLogAdapter(new AndroidLogAdapter());
        XGPushConfig.enableDebug(this,true);
        XGPushConfig.enableOtherPush(getApplicationContext(), true);
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
//token在设备卸载重装的时候有可能会变
                Log.d("TPush", "注册成功，设备token为：" + data);
            }
            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });
    }
}
