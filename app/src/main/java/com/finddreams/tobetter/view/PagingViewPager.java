package com.finddreams.tobetter.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/**
 * enjoy your coding life.
 * Created by Deg on 2015/8/1 0001.
 */
public class PagingViewPager extends ViewPager  {

    /**
     * control can scroll
     */
    private boolean isPagingEnabled = false;

    public PagingViewPager(Context context) {
        super(context);
    }

    public PagingViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagingEnabled(boolean b) {
        this.isPagingEnabled = b;
    }

}
