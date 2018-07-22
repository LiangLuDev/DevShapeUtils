package com.luliang.shapeutils.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.R;
import com.luliang.shapeutils.selector.DevSelector;
import com.luliang.shapeutils.shape.DevShape;

import java.util.Arrays;

/**
 * 利用databinding在xml文件中设置样式
 */
public class DevBind {

    private static final String TAG = "DevBind";


    /**
     * Shape设置-#FFFFFF 类型颜色
     */
    @BindingAdapter(value = {"shape", "solid", "line_width", "line_color",
            "dash_line_width", "dash_line_color", "dash_width", "dash_gap",
            "radius", "tr_radius", "tl_radius", "br_radius", "bl_radius",
            "gradient_linear_orientation", "gradient_linear_start_color", "gradient_linear_gravity_color","gradient_linear_end_color",
            "gradient_sweep_colors", "gradient_radial_radius", "gradient_radial_colors"},
            requireAll = false)
    public static void bindShape(View view, String shape, String solidColor, int lineWidth, String lineColor,
                                 int dashLineWidth, String dashLineColor, float dashWidth, float dashGap,
                                 float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                 String gradientLinearOrientation, String gradientLinearStartColor,String gradientLinearGravityColor, String gradientLinearEndColor,
                                 String gradientSweepColors, float gradientRadialRadius, String gradientRadialColors) {

        Drawable shapeDrawable = buildShape(shape, solidColor, lineWidth, lineColor,
                dashLineWidth, dashLineColor, dashWidth, dashGap,
                radius, trRadius, tlRadius, brRadius, blRadius,
                gradientLinearOrientation, gradientLinearStartColor,gradientLinearGravityColor, gradientLinearEndColor,
                gradientSweepColors, gradientRadialRadius, gradientRadialColors);
        //设置样式背景
        view.setBackground(shapeDrawable);
    }

    /**
     * Shape设置-@color/color 类型颜色
     */
    @BindingAdapter(value = {"shape", "solid", "line_width", "line_color",
            "dash_line_width", "dash_line_color", "dash_width", "dash_gap",
            "radius", "tr_radius", "tl_radius", "br_radius", "bl_radius",
            "gradient_linear_orientation", "gradient_linear_start_color", "gradient_linear_gravity_color","gradient_linear_end_color",
            "gradient_sweep_colors", "gradient_radial_radius", "gradient_radial_colors"},
            requireAll = false)
    public static void bindShape(View view, String shape, int solidColor, int lineWidth, int lineColor,
                                 int dashLineWidth, int dashLineColor, float dashWidth, float dashGap,
                                 float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                 String gradientLinearOrientation, int gradientLinearStartColor,int gradientLinearGravityColor, int gradientLinearEndColor,
                                 String gradientSweepColors, float gradientRadialRadius, String gradientRadialColors) {


        Drawable shapeDrawable = buildShape(shape, solidColor, lineWidth, lineColor,
                dashLineWidth, dashLineColor, dashWidth, dashGap,
                radius, trRadius, tlRadius, brRadius, blRadius,
                gradientLinearOrientation, gradientLinearStartColor, gradientLinearGravityColor,gradientLinearEndColor,
                gradientSweepColors, gradientRadialRadius, gradientRadialColors);

        //设置样式背景
        view.setBackground(shapeDrawable);
    }

    /**
     * Selector设置-String色值 例：#FFFFFF
     */
    @BindingAdapter(value = {"shape", "radius", "tr_radius", "tl_radius", "br_radius", "bl_radius",
            "selector_pressed_color", "selector_pressed_normal_color", "selector_enable_color", "selector_enable_normal_color",
            "selector_color", "selector_normal_color", "selector_state", "selector_text_color", "selector_normal_text_color"}, requireAll = false)
    public static void bindSelector(View view, String shape, float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                    String pressedColor, String pressedNormalColor, String enableColor, String enableNormalColor,
                                    String selectColor, String normalColor, String selectorState, String selectTextColor, String normalTextColor) {
        Drawable selectDrawable = null;
        Drawable normalDrawable = null;


        if (pressedColor != null && pressedNormalColor != null) {
            selectDrawable = buildShape(shape, pressedColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            normalDrawable = buildShape(shape, pressedNormalColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            selectorState = "PRESSED";
        }

        if (enableColor != null && enableNormalColor != null) {
            selectDrawable = buildShape(shape, enableColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null, null,null, null, 0, null);

            normalDrawable = buildShape(shape, enableNormalColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            selectorState = "ENABLED";
        }

        if (selectColor != null && normalColor != null) {
            selectDrawable = buildShape(shape, selectColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            normalDrawable = buildShape(shape, normalColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null, null,null, null, 0, null);

        }

        if (selectorState != null) {
            //TextView等view默认没有点击事件，所以针对view初始化点击事件
            view.setOnClickListener(null);
            //设置触摸字体颜色变化
            if (selectTextColor != null && normalTextColor != null) {
                DevShapeUtils.selector(getSelectorState(selectorState), selectDrawable, normalDrawable).selectorTextColor(selectTextColor, normalTextColor).into(view);
            } else {
                DevShapeUtils.selector(getSelectorState(selectorState), selectDrawable, normalDrawable).into(view);
            }
        } else {
            throw new ExceptionInInitializerError("请先设置SelectorState！！！");
        }
    }


    /**
     * Selector设置-int色值 例：@color/color 类型颜色
     */
    @BindingAdapter(value = {"shape", "radius", "tr_radius", "tl_radius", "br_radius", "bl_radius",
            "selector_pressed_color", "selector_pressed_normal_color", "selector_enable_color", "selector_enable_normal_color",
            "selector_color", "selector_normal_color", "selector_state", "selector_select_text_color", "selector_normal_text_color"}, requireAll = false)
    public static void bindSelector(View view, String shape, float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                    int pressedColor, int pressedNormalColor, int enableColor, int enableNormalColor,
                                    int selectColor, int normalColor, String selectorState, int selectTextColor, int normalTextColor) {
        Drawable selectDrawable = null;
        Drawable normalDrawable = null;


        if (pressedColor != 0 && pressedNormalColor != 0) {
            selectDrawable = buildShape(shape, pressedColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            normalDrawable = buildShape(shape, pressedNormalColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            selectorState = "PRESSED";
        }

        if (enableColor != 0 && enableNormalColor != 0) {
            selectDrawable = buildShape(shape, enableColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null, null,null, null, 0, null);

            normalDrawable = buildShape(shape, enableNormalColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            selectorState = "ENABLED";
        }

        if (selectColor != 0 && normalColor != 0) {
            selectDrawable = buildShape(shape, selectColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null,null, null, null, 0, null);

            normalDrawable = buildShape(shape, normalColor, 0, null, 0, null, 0, 0,
                    radius, trRadius, tlRadius, brRadius, blRadius, null, null, null,null, null, 0, null);

        }

        if (selectorState != null) {
            //TextView等view默认没有点击事件，所以针对view初始化点击事件
            view.setOnClickListener(null);
            //设置触摸字体颜色变化
            if (selectTextColor != 0 && normalTextColor != 0) {
                DevShapeUtils.selector(getSelectorState(selectorState), selectDrawable, normalDrawable).bindSelectorTextColor(selectTextColor, normalTextColor).into(view);
            } else {
                DevShapeUtils.selector(getSelectorState(selectorState), selectDrawable, normalDrawable).into(view);
            }
        } else {
            throw new ExceptionInInitializerError("请先设置SelectorState！！！");
        }
    }


    /**
     * 生成样式
     *
     * @return Drawable样式
     */
    private static Drawable buildShape(String shape, Object solidColor, int lineWidth, Object lineColor,
                                       int dashLineWidth, Object dashLineColor, float dashWidth, float dashGap,
                                       float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                       String gradientLinearOrientation, Object gradientLinearStartColor,Object gradientLinearGravityColor, Object gradientLinearEndColor,
                                       String gradientSweepColors, float gradientRadialRadius, String gradientRadialColors) {
        //样式设置（圆形或者矩形）
        int shapeModel;
        if (shape == null) {
            shapeModel = DevShape.RECTANGLE;
        } else {
            switch (shape) {
                case "OVAL":
                    shapeModel = DevShape.OVAL;
                    break;
                case "RECTANGLE":
                default:
                    shapeModel = DevShape.RECTANGLE;
                    break;
            }
        }

        DevShape devShape = DevShapeUtils.shape(shapeModel);

        //背景颜色
        if (isEmpty(solidColor)) {
            if (isStrColor(solidColor)) {
                devShape.solid(solidColor.toString());
            } else {
                devShape.bindSolid((Integer) solidColor);
            }
        }
        //边框宽度和颜色
        if (isEmpty(lineColor) && lineWidth > 0) {
            if (isStrColor(lineColor)) {
                devShape.line(lineWidth, lineColor.toString());
            } else {
                devShape.bindLine(lineWidth, (Integer) lineColor);
            }
        }

        //虚线边框
        if (dashLineWidth > 0 && isEmpty(dashLineColor) && dashWidth > 0 && dashGap > 0) {
            if (isStrColor(dashLineColor)) {
                devShape.dashLine(dashLineWidth, dashLineColor.toString(), dashWidth, dashGap);
            } else {
                devShape.bindDashLine(dashLineWidth, (Integer) dashLineColor, dashWidth, dashGap);
            }
        }

        //圆角设置-4个方向圆角弧度
        if (radius > 0) {
            devShape.radius(radius);
        }
        //右上圆角
        if (trRadius > 0) {
            devShape.trRadius(trRadius);
        }

        //左上圆角
        if (tlRadius > 0) {
            devShape.tlRadius(tlRadius);
        }

        //右下圆角
        if (brRadius > 0) {
            devShape.brRadius(brRadius);
        }
        //左下圆角
        if (blRadius > 0) {
            devShape.blRadius(blRadius);
        }

        //线性渐变方向设置
        if (gradientLinearOrientation == null) {
            gradientLinearOrientation = "TOP_BOTTOM";
        }


        //线性渐变颜色设置
        if (isEmpty(gradientLinearStartColor) && isEmpty(gradientLinearEndColor)) {
            devShape.orientation(gradientLinearOrientation);
            if (isStrColor(gradientLinearStartColor) && isStrColor(gradientLinearEndColor)) {
                if (isEmpty(gradientLinearGravityColor)) {
                    devShape.gradientLinear(gradientLinearStartColor.toString(),gradientLinearGravityColor.toString(), gradientLinearEndColor.toString());
                }else {
                    devShape.gradientLinear(gradientLinearStartColor.toString(), gradientLinearEndColor.toString());
                }
            } else {
                if (isEmpty(gradientLinearGravityColor)) {
                    devShape.bindGradientLinear((Integer) gradientLinearStartColor, (Integer) gradientLinearGravityColor, (Integer) gradientLinearEndColor);
                }else {
                    devShape.bindGradientLinear((Integer) gradientLinearStartColor, (Integer) gradientLinearEndColor);
                }
            }
        }

        //扫描渐变（仅支持 #FFFFFFF 类格式颜色设置）
        if (gradientSweepColors != null) {
            if (gradientSweepColors.contains("|")) {
                String[] colors = gradientSweepColors.split("\\|");
                for (String color : colors) {
                    if (!color.contains("#"))
                        throw new ExceptionInInitializerError("错误的颜色格式,仅支持 #FFFFFFF 类格式颜色设置");
                }
                devShape.gradientSweep(colors);
            } else {
                throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
            }
        }

        //辐射渐变（仅支持 #FFFFFFF 类格式颜色设置）
        if (gradientRadialRadius > 0 && gradientRadialColors != null) {
            if (gradientRadialColors.contains("|")) {
                String[] colors = gradientRadialColors.split("\\|");
                for (String color : colors) {
                    if (!color.contains("#"))
                        throw new ExceptionInInitializerError("错误的颜色格式,仅支持 #FFFFFFF 类格式颜色设置");
                }
                devShape.gradientRadial(gradientRadialRadius, colors);
            } else {
                throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
            }
        }

        return devShape.build();
    }


    /**
     * 设置颜色选择器状态
     *
     * @param selectState
     * @return
     */
    private static @DevSelector.SelectorState
    int getSelectorState(String selectState) {
        int state = 0;
        switch (selectState) {
            case "PRESSED":
                state = DevSelector.STATE_PRESSED;
                break;
            case "ENABLED":
                state = DevSelector.STATE_ENABLED;
                break;
            case "SELECTED":
                state = DevSelector.STATE_SELECTED;
                break;
            case "CHECKED":
                state = DevSelector.STATE_CHECKED;
                break;
            case "CHECKABLE":
                state = DevSelector.STATE_CHECKABLE;
                break;
            case "FOCUSED":
                state = DevSelector.STATE_FOCUSED;
                break;
            case "WINDOW_FOCUSED":
                state = DevSelector.STATE_WINDOW_FOCUSED;
                break;
            case "ACTIVATED":
                state = DevSelector.STATE_ACTIVATED;
                break;
            case "HOVERED":
                state = DevSelector.STATE_HOVERED;
                break;
        }
        return state;
    }

    /**
     * 判断颜色不为空
     *
     * @param color
     * @return
     */
    private static boolean isEmpty(Object color) {
        return color != null && !color.toString().equals("0");
    }

    /**
     * 判断是string色值还是资源文件色值
     *
     * @param color 色值
     */
    private static boolean isStrColor(Object color) {
        return color.toString().contains("#");
    }

}
