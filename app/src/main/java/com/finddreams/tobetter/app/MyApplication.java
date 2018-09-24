package com.finddreams.tobetter.app;

import android.app.Application;

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
    }
}
