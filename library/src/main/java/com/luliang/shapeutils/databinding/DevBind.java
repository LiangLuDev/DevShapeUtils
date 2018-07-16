package com.luliang.shapeutils.databinding;

import android.databinding.BindingAdapter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.R;
import com.luliang.shapeutils.shape.DevShape;

/**
 * 利用databinding在xml文件中设置样式
 */
public class DevBind {

    private static final String TAG = "DevBind";


    /**
     * Shape设置-#FFFFFF 类型颜色
     */
//    @BindingAdapter(value = {"shape", "solid", "line_width", "line_color",
//            "dash_line_width", "dash_line_color", "dash_width", "dash_gap",
//            "radius", "tr_radius", "tl_radius", "br_radius", "bl_radius",
//            "gradient_linear_orientation", "gradient_linear_start_color", "gradient_linear_end_color",
//            "gradient_sweep_colors", "gradient_radial_radius", "gradient_radial_colors"},
//            requireAll = false)
//    public static void bindShape(View view, String shape, String solidColor, int lineWidth, String lineColor,
//                                 int dashLineWidth, String dashLineColor, float dashWidth, float dashGap,
//                                 float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
//                                 String gradientLinearOrientation, String gradientLinearStartColor, String gradientLinearEndColor,
//                                 String gradientSweepColors, float gradientRadialRadius, String gradientRadialColors) {
//
//        Drawable shapeDrawable = createShape(shape, solidColor, lineWidth, lineColor,
//                dashLineWidth, dashLineColor, dashWidth, dashGap,
//                radius, trRadius, tlRadius, brRadius, blRadius,
//                gradientLinearOrientation, gradientLinearStartColor, gradientLinearEndColor,
//                gradientSweepColors, gradientRadialRadius, gradientRadialColors);
//        //设置样式背景
//        view.setBackground(shapeDrawable);
//    }

    /**
     * Shape设置-@color/color 类型颜色
     */
    @BindingAdapter(value = {"shape", "solid", "line_width", "line_color",
            "dash_line_width", "dash_line_color", "dash_width", "dash_gap",
            "radius", "tr_radius", "tl_radius", "br_radius", "bl_radius",
            "gradient_linear_orientation", "gradient_linear_start_color", "gradient_linear_end_color",
            "gradient_sweep_colors", "gradient_radial_radius", "gradient_radial_colors"},
            requireAll = false)
    public static void bindShape(View view, String shape, int solidColor, int lineWidth, int lineColor,
                                 int dashLineWidth, int dashLineColor, float dashWidth, float dashGap,
                                 float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                 String gradientLinearOrientation, int gradientLinearStartColor, int gradientLinearEndColor,
                                 String gradientSweepColors, float gradientRadialRadius, String gradientRadialColors) {


        Drawable shapeDrawable = buildShape(shape, solidColor, lineWidth, lineColor,
                dashLineWidth, dashLineColor, dashWidth, dashGap,
                radius, trRadius, tlRadius, brRadius, blRadius,
                gradientLinearOrientation, gradientLinearStartColor, gradientLinearEndColor,
                gradientSweepColors, gradientRadialRadius, gradientRadialColors);

//        Drawable drawable = DevShapeUtils.shape(DevShape.OVAL).bindSolid(solidColor).build();
//        view.setBackground(drawable);

        //样式设置（圆形或者矩形）
//        int shapeModel;
//        if (shape == null) {
//            shapeModel = DevShape.OVAL;
//        } else {
//            switch (shape) {
//                case "RECTANGLE":
//                    shapeModel = DevShape.RECTANGLE;
//                    break;
//                case "OVAL":
//                default:
//                    shapeModel = DevShape.OVAL;
//                    break;
//            }
//        }
//
//        DevShape devShape = DevShapeUtils.shape(shapeModel);
//
//        //背景颜色
//        if (solidColor != 0) {
//            devShape.bindSolid(solidColor);
//        }
//        //边框宽度和颜色
//        if (lineColor != 0 && lineWidth > 0) {
//            devShape.bindLine(lineWidth, lineColor);
//        }
//
//        //虚线边框
//        if (dashLineWidth > 0 && dashLineColor != 0 && dashWidth > 0 && dashGap > 0) {
//            devShape.bindDashLine(dashLineWidth, dashLineColor, dashWidth, dashGap);
//        }
//
//        //圆角设置-4个方向圆角弧度
//        if (radius > 0) {
//            devShape.radius(radius);
//        }
//        //右上圆角
//        if (trRadius > 0) {
//            devShape.trRadius(trRadius);
//        }
//
//        //左上圆角
//        if (tlRadius > 0) {
//            devShape.tlRadius(tlRadius);
//        }
//
//        //右下圆角
//        if (brRadius > 0) {
//            devShape.brRadius(brRadius);
//        }
//        //左下圆角
//        if (blRadius > 0) {
//            devShape.blRadius(blRadius);
//        }
//
//        //线性渐变方向设置
//        if (gradientLinearOrientation == null) {
//            gradientLinearOrientation = "TOP_BOTTOM";
//        }
//        //线性渐变颜色设置
//        if (gradientLinearStartColor != 0 && gradientLinearEndColor != 0) {
//            devShape.orientation(gradientLinearOrientation);
//            devShape.bindGradientLinear(gradientLinearStartColor, gradientLinearEndColor);
//        }
//
//        //扫描渐变（仅支持 #FFFFFFF 类格式颜色设置）
//        if (gradientSweepColors != null) {
//            if (gradientSweepColors.contains("|")) {
//                String[] colors = "|".split(gradientSweepColors);
//                for (String color : colors) {
//                    if (!color.contains("#"))
//                        throw new ExceptionInInitializerError("错误的颜色格式,仅支持 #FFFFFFF 类格式颜色设置");
//                }
//                devShape.gradientSweep(colors);
//            } else {
//                throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
//            }
//        }
//
//        //辐射渐变（仅支持 #FFFFFFF 类格式颜色设置）
//        if (gradientRadialRadius > 0 && gradientRadialColors != null) {
//            if (gradientRadialColors.contains("|")) {
//                String[] colors = "|".split(gradientRadialColors);
//                for (String color : colors) {
//                    if (!color.contains("#"))
//                        throw new ExceptionInInitializerError("错误的颜色格式,仅支持 #FFFFFFF 类格式颜色设置");
//                }
//                devShape.gradientRadial(gradientRadialRadius, colors);
//            } else {
//                throw new ExceptionInInitializerError("渐变颜色数组至少需要两个颜色");
//            }
//        }

        //设置样式背景
        view.setBackground(shapeDrawable);
    }


//    @BindingAdapter(value = {"selector_pressed_color", "selector_pressed_normal_color"}, requireAll = false)
//    public static void bindSelector(View view) {
//
//    }

    /**
     * 生成样式
     */
    private static Drawable buildShape(String shape, Object solidColor, int lineWidth, Object lineColor,
                                        int dashLineWidth, Object dashLineColor, float dashWidth, float dashGap,
                                        float radius, float trRadius, float tlRadius, float brRadius, float blRadius,
                                        String gradientLinearOrientation, Object gradientLinearStartColor, Object gradientLinearEndColor,
                                        String gradientSweepColors, float gradientRadialRadius, String gradientRadialColors) {
        //样式设置（圆形或者矩形）
        int shapeModel;
        if (shape == null) {
            shapeModel = DevShape.OVAL;
        } else {
            switch (shape) {
                case "RECTANGLE":
                    shapeModel = DevShape.RECTANGLE;
                    break;
                case "OVAL":
                default:
                    shapeModel = DevShape.OVAL;
                    break;
            }
        }

        DevShape devShape = DevShapeUtils.shape(shapeModel);

        //背景颜色
        if (solidColor != null) {
            if (isStrColor(solidColor)) {
                devShape.solid(solidColor.toString());
            } else {
                devShape.bindSolid((Integer) solidColor);
            }
        }
        //边框宽度和颜色
        if (lineColor != null && lineWidth > 0) {
            if (isStrColor(lineColor)) {
                devShape.line(lineWidth, lineColor.toString());
            } else {
                devShape.bindLine(lineWidth, (Integer) lineColor);
            }
        }

        //虚线边框
        if (dashLineWidth > 0 && dashLineColor != null && dashWidth > 0 && dashGap > 0) {
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
        if (gradientLinearStartColor != null && gradientLinearEndColor != null) {
            devShape.orientation(gradientLinearOrientation);
            if (isStrColor(gradientLinearStartColor) && isStrColor(gradientLinearEndColor)) {
                devShape.gradientLinear(gradientLinearStartColor.toString(), gradientLinearEndColor.toString());
            } else {
                devShape.bindGradientLinear((Integer) gradientLinearStartColor, (Integer) gradientLinearEndColor);
            }
        }

        //扫描渐变（仅支持 #FFFFFFF 类格式颜色设置）
        if (gradientSweepColors != null) {
            if (gradientSweepColors.contains("|")) {
                String[] colors = "|".split(gradientSweepColors);
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
                String[] colors = "|".split(gradientRadialColors);
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
     * 判断是string色值还是资源文件色值
     *
     * @param strColor 色值
     */
    private static boolean isStrColor(Object strColor) {
        return strColor.toString().contains("#");
    }

    /**
     * Android色值（例：-16777216）转换为16进制
     *
     * @param color
     * @return
     */
    private static String toHexEncoding(int color) {
        String R, G, B;
        StringBuffer sb = new StringBuffer();
        R = Integer.toHexString(Color.red(color));
        G = Integer.toHexString(Color.green(color));
        B = Integer.toHexString(Color.blue(color));
        R = R.length() == 1 ? "0" + R : R;
        G = G.length() == 1 ? "0" + G : G;
        B = B.length() == 1 ? "0" + B : B;
        sb.append("#");
        sb.append(R.toUpperCase());
        sb.append(G.toUpperCase());
        sb.append(B.toUpperCase());
        return sb.toString();
    }

}
