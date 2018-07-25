package com.example.huangcong.largeimage_worldmap.activity.list;

import android.content.Context;
import android.graphics.Canvas;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

/**
 * Created by huangcong on 2018/7/24
 */
public class ConstraintLayoutNative extends ConstraintLayout {

    public ConstraintLayoutNative(Context context){
        super(context);
    }


    public ConstraintLayoutNative(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConstraintLayoutNative(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void offsetTopAndBottom(int offset) {
        super.offsetTopAndBottom(offset);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
