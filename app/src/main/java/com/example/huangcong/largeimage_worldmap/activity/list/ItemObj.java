package com.example.huangcong.largeimage_worldmap.activity.list;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

/**
 * author: huangcong .
 * date:  2018/7/20
 */
public class ItemObj {

    @DrawableRes
    public int imageRes;

    @StringRes
    public int strRes;

    public ItemObj(int imageRes, int strRes) {
        this.imageRes = imageRes;
        this.strRes = strRes;
    }
}
