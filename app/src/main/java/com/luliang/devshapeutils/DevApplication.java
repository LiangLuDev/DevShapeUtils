package com.luliang.devshapeutils;

import android.app.Application;

import com.luliang.shapeutils.ShapeUtils;

/**
 * Created by LuLiang on 2018/2/26.
 *
 * @author LuLiang
 * @github https://github.com/LiangLuDev
 */

public class DevApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        ShapeUtils.init(this);
    }
}
