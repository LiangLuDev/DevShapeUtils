package com.luliang.devshapeutils;

import android.databinding.BindingAdapter;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.shape.DevShape;

/**
 * Created on 2018/7/11
 *
 * @author LuLiang
 * @github https://github.com/LiangLuDev
 */
public class DevShapeTest {


    private static final String TAG = "DevShapeTest";

    @BindingAdapter("android:solid")
    public static void setShape(View view, String color){
        Log.d(TAG, "setShape: "+color);
        DevShapeUtils.shape(DevShape.OVAL)
                .solid(color)
                .into(view);
    }

}
