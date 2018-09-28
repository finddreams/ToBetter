package com.finddreams.tobetter.app;

import android.app.Application;
import android.util.Log;

import com.igexin.sdk.PushManager;
import com.igexin.sdk.PushService;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

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

        // com.getui.demo.DemoPushService 为第三方自定义推送服务
        PushManager.getInstance().initialize(this.getApplicationContext(), PushService.class);
    }
}
