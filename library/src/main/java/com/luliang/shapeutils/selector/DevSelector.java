package com.luliang.shapeutils.selector;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorRes;
import android.support.annotation.IntDef;
import android.view.View;
import android.widget.TextView;

import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.interfaces.IDevUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by LuLiang on 2018/2/10.
 * <p>
 * 背景状态选择器（颜色背景、图片背景）
 *
 * @author LuLiang
 * @github https://github.com/LiangLuDev
 */

public class DevSelector implements IDevUtils<Drawable, View> {
    static DevSelector mDevSelector;
    //选中背景颜色
    private Drawable mSelectDrawable;
    //正常背景颜色
    private Drawable mNormalDrawable;


    //选中字体颜色
    private int mSelectTextColor;
    //正常字体颜色
    private int mNormalTextColor;


    //是否设置TextView颜色选择器
    private boolean isSelectorTextColor;


    //SelectorState选中状态  默认按压状态
    @SelectorState
    private int state = STATE_PRESSED;


    /*SelectorState选中状态定义*/
    //是否按压状态
    public static final int STATE_PRESSED = android.R.attr.state_pressed;
    //触摸或点击事件是否可用状态
    public static final int STATE_ENABLED = android.R.attr.state_enabled;
    //是否选中状态
    public static final int STATE_SELECTED = android.R.attr.state_selected;
    //是否勾选状态 主要用于CheckBox和RadioButton
    public static final int STATE_CHECKED = android.R.attr.state_checked;
    //勾选是否可用状态
    public static final int STATE_CHECKABLE = android.R.attr.state_checkable;
    //是否获得焦点状态
    public static final int STATE_FOCUSED = android.R.attr.state_focused;
    //当前窗口是否获得焦点状态 例如拉下通知栏或弹出对话框时，当前界面就会失去焦点；
    public static final int STATE_WINDOW_FOCUSED = android.R.attr.state_window_focused;
    //是否被激活状态 API Level 11及以上才支持，可通过代码调用控件的setActivated(boolean)方法设置是否激活该控件
    public static final int STATE_ACTIVATED = android.R.attr.state_activated;
    //是否鼠标在上面滑动的状态 API Level 14及以上才支持
    public static final int STATE_HOVERED = android.R.attr.state_hovered;


    @IntDef({STATE_PRESSED, STATE_ENABLED, STATE_SELECTED, STATE_CHECKED
            , STATE_CHECKABLE, STATE_FOCUSED, STATE_WINDOW_FOCUSED, STATE_ACTIVATED, STATE_HOVERED})
    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectorState {
    }


    public static DevSelector getInstance() {
        mDevSelector = new DevSelector();
        return mDevSelector;
    }


    public DevSelector selector(@SelectorState int selectorState, Drawable selectDrawable, Drawable normalDrawable) {
        this.state = selectorState;
        this.mSelectDrawable = selectDrawable;
        this.mNormalDrawable = normalDrawable;
        return this;
    }

    /**
     * .
     * 背景状态选择器（背景Drawable）
     *
     * @param pressedDrawable 触摸颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @param normalDrawable  正常颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @return DevSelector
     */
    public DevSelector selectorPressed(Drawable pressedDrawable, Drawable normalDrawable) {
        this.state = STATE_PRESSED;
        this.mSelectDrawable = pressedDrawable;
        this.mNormalDrawable = normalDrawable;
        return this;
    }

    /**
     * .
     * 背景状态选择器（背景Drawable）
     *
     * @param enableDrawable  可点击(可用)颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @param disableDrawable 不可点击(可用)颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @return DevSelector
     */
    public DevSelector selectorEnable(Drawable enableDrawable, Drawable disableDrawable) {
        this.state = STATE_ENABLED;
        this.mSelectDrawable = enableDrawable;
        this.mNormalDrawable = disableDrawable;
        return this;
    }


    /**
     * 设置背景选择器同时设置字体颜色颜色器
     *
     * @param selectColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId 正常颜色 例：R.color.colorPrimary
     * @return DevSelector
     */
    public DevSelector selectorTextColor(@ColorRes int selectColorResId, @ColorRes int normalColorResId) {
        this.isSelectorTextColor = true;
        this.mSelectTextColor = DevShapeUtils.getContext().getResources().getColor(selectColorResId);
        this.mNormalTextColor = DevShapeUtils.getContext().getResources().getColor(normalColorResId);
        return this;
    }


    /**
     * 设置背景选择器同时设置字体颜色颜色器
     *
     * @param selectColor 触摸颜色 例：#ffffff
     * @param normalColor 正常颜色 例：#ffffff
     * @return DevSelector
     */
    public DevSelector selectorTextColor(String selectColor, String normalColor) {
        this.isSelectorTextColor = true;
        this.mSelectTextColor = Color.parseColor(selectColor);
        this.mNormalTextColor = Color.parseColor(normalColor);
        return this;
    }


    /**
     * 设置背景选择器同时设置字体颜色颜色器-仅供databinding使用
     *
     * @param selectColorResId 触摸颜色 例：databinding获取的资源文件色值
     * @param normalColorResId 正常颜色 例：databinding获取的资源文件色值
     * @return DevSelector
     */
    public DevSelector bindSelectorTextColor(int selectColorResId, int normalColorResId) {
        this.isSelectorTextColor = true;
        this.mSelectTextColor = selectColorResId;
        this.mNormalTextColor = normalColorResId;
        return this;
    }


    @Override
    public void into(View view) {
        //TextView等view默认没有点击事件，所以针对view初始化点击事件
        view.setOnClickListener(null);
        view.setBackground(createDrawableSelector());
        if (isSelectorTextColor) {
            try {
                int[] colors = new int[]{mSelectTextColor, mNormalTextColor};
                int[][] states = new int[2][];
                states[0] = new int[]{state};
                states[1] = new int[]{-state};
                ((TextView) view).setTextColor(new ColorStateList(states, colors));
            } catch (Exception e) {
                e.printStackTrace();
                throw new ExceptionInInitializerError("设置字体颜色选择器（Selector）请传入TextView（或者TextView的子类，比如Button）！！！");
            }
        }
    }

    /**
     * @return 返回背景Drawable   ps：如果同时设置字体颜色选择器，此处不生效，直接into就行。
     */
    @Override
    public Drawable build() {
        return createDrawableSelector();
    }

    /**
     * 创建选中颜色变化
     *
     * @return StateListDrawable
     */
    private StateListDrawable createDrawableSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{state}, mSelectDrawable);// 状态为true的背景
        stateListDrawable.addState(new int[]{-state}, mNormalDrawable);// 状态为false的背景
        return stateListDrawable;
    }

}
