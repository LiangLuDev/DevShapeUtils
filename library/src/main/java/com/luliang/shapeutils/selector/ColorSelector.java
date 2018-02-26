package com.luliang.shapeutils.selector;

import android.content.res.ColorStateList;
import android.widget.TextView;

import com.luliang.shapeutils.interfaces.IDevUtils;


/**
 * Created by LuLiang on 2018/2/10.
 * <p>
 * 字体颜色状态选择器（字体颜色）
 *
 * @author LuLiang
 * @github https://github.com/LiangLuDev
 */

public class ColorSelector implements IDevUtils<ColorStateList, TextView> {
    private static ColorSelector mColorSelector;
    //触摸颜色
    private int pressedColor;
    //正常颜色
    private int normalColor;

    public static ColorSelector getInstance() {
        mColorSelector = new ColorSelector();
        return mColorSelector;
    }

    /**
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public ColorSelector selectorColor(int pressedColorResId, int normalColorResId) {
        this.pressedColor = pressedColorResId;
        this.normalColor = normalColorResId;
        return this;
    }


    @Override
    public void into(TextView textView) {
        textView.setTextColor(createColorSelector());
    }

    @Override
    public ColorStateList build() {
        return createColorSelector();
    }

    /**
     * 创建触摸颜色变化
     *
     * @return ColorStateList
     */
    private ColorStateList createColorSelector() {
        int[] colors = new int[]{pressedColor, normalColor};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        return new ColorStateList(states, colors);
    }
}
