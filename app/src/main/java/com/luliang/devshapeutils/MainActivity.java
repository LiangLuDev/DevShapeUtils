package com.luliang.devshapeutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.luliang.shapeutils.DevShapeKt;
import com.luliang.shapeutils.DevShapeUtils;
import com.luliang.shapeutils.ShapeBuilder;
import com.luliang.shapeutils.shape.DevShape;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }


    private void initView() {
        Button btn_databinding = findViewById(R.id.btn_databinding);
        btn_databinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BindingActivity.class));
            }
        });

        //圆形
        TextView tv_oval_solid = findViewById(R.id.tv_oval_solid);
//        DevShapeUtils.shape(DevShape.OVAL).solid(R.color.colorAccent).into(tv_oval_solid);

        ShapeBuilder builder = new ShapeBuilder();
        DevShapeKt devShapeKt = new DevShapeKt();
        devShapeKt.setBgColor(DevShapeUtils.getContext().getResources().getColor(R.color.colorPrimary));
        devShapeKt.setRadius(8);
        builder.with(devShapeKt);
        builder.createShape();
        builder.into(tv_oval_solid);





        TextView tv_oval_line = findViewById(R.id.tv_oval_line);
        DevShapeUtils.shape(DevShape.OVAL).solid(R.color.colorAccent).line(1, R.color.colorPrimary).into(tv_oval_line);
        TextView tv_oval_dash_line = findViewById(R.id.tv_oval_dash_line);
        DevShapeUtils.shape(DevShape.OVAL).solid(R.color.colorAccent).dashLine(1, R.color.colorPrimary, 5, 5).into(tv_oval_dash_line);
        //矩形
        TextView tv_rect_solid_radius = findViewById(R.id.tv_rect_solid_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).radius(5).into(tv_rect_solid_radius);
        TextView tv_rect_line_radius = findViewById(R.id.tv_rect_line_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).line(1, R.color.colorPrimary).radius(5).into(tv_rect_line_radius);
        TextView tv_rect_dash_line_radius = findViewById(R.id.tv_rect_dash_line_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).dashLine(1, R.color.colorPrimary, 5, 5).radius(5).into(tv_rect_dash_line_radius);
        //圆角（常用）
        TextView tv_rect_solid = findViewById(R.id.tv_rect_solid);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).radius(999).into(tv_rect_solid);
        TextView tv_rect_line = findViewById(R.id.tv_rect_line);
        DevShapeUtils.shape(DevShape.RECTANGLE).line(1, R.color.colorAccent).radius(999).into(tv_rect_line);
        //触摸反馈
        Button btn_selector_background = findViewById(R.id.btn_selector_background);
        DevShapeUtils.selectorPressed(
                DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorPrimary).radius(999).build(),
                DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).radius(999).build())
                .into(btn_selector_background);
        Button btn_selector_background_color = findViewById(R.id.btn_selector_background_color);
        DevShapeUtils.selectorPressed(
                DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorPrimary).radius(999).build(),
                DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).radius(999).build())
                .selectorTextColor("#ffffff", "#000000")
                .into(btn_selector_background_color);

        //点击事件是否可用 默认为true
        Button btn_selector_press = findViewById(R.id.btn_selector_press);
        DevShapeUtils
                .selectorEnable(DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorPrimary).radius(999).build(),
                                DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).radius(999).build())
                .into(btn_selector_press);
        //默认为true
        btn_selector_press.setEnabled(false);
        Button btn_selector_press_color = findViewById(R.id.btn_selector_press_color);
        DevShapeUtils
                .selectorEnable(DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorPrimary).radius(999).build(),
                        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).radius(999).build())
                .selectorTextColor("#ffffff", "#000000")
                .into(btn_selector_press_color);


        //圆角
        TextView tv_rect_top_radius = findViewById(R.id.tv_rect_top_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).tlRadius(10).trRadius(10).into(tv_rect_top_radius);
        TextView tv_rect_bottom_radius = findViewById(R.id.tv_rect_bottom_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).blRadius(10).brRadius(10).into(tv_rect_bottom_radius);
        TextView tv_rect_diagonal1 = findViewById(R.id.tv_rect_diagonal1);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).tlRadius(10).brRadius(10).into(tv_rect_diagonal1);
        TextView tv_rect_diagonal2 = findViewById(R.id.tv_rect_diagonal2);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).trRadius(10).blRadius(10).into(tv_rect_diagonal2);
        TextView tv_rect_tl_radius = findViewById(R.id.tv_rect_tl_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).tlRadius(10).into(tv_rect_tl_radius);
        TextView tv_rect_tr_radius = findViewById(R.id.tv_rect_tr_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).trRadius(10).into(tv_rect_tr_radius);
        TextView tv_rect_bl_radius = findViewById(R.id.tv_rect_bl_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).blRadius(10).into(tv_rect_bl_radius);
        TextView tv_rect_br_radius = findViewById(R.id.tv_rect_br_radius);
        DevShapeUtils.shape(DevShape.RECTANGLE).solid(R.color.colorAccent).brRadius(10).into(tv_rect_br_radius);
        //渐变
        TextView tv_gradient_linear_tb = findViewById(R.id.tv_gradient_linear_tb);
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .gradientLinear(R.color.colorAccent, R.color.colorPrimary)
                .orientation(DevShape.TOP_BOTTOM)
                .into(tv_gradient_linear_tb);
        TextView tv_gradient_linear_bt = findViewById(R.id.tv_gradient_linear_bt);
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .gradientLinear(R.color.colorAccent, R.color.colorPrimary)
                .orientation(DevShape.BOTTOM_TOP)
                .into(tv_gradient_linear_bt);
        TextView tv_gradient_linear_lr = findViewById(R.id.tv_gradient_linear_lr);
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .gradientLinear(R.color.colorAccent, R.color.colorPrimary)
                .orientation(DevShape.LEFT_RIGHT)
                .into(tv_gradient_linear_lr);
        TextView tv_gradient_linear_rl = findViewById(R.id.tv_gradient_linear_rl);
        DevShapeUtils.shape(DevShape.RECTANGLE)
                .gradientLinear(R.color.colorAccent, R.color.colorPrimary)
                .orientation(DevShape.RIGHT_LEFT)
                .into(tv_gradient_linear_rl);
        TextView tv_gradient_sweep = findViewById(R.id.tv_gradient_sweep);
        DevShapeUtils.shape(DevShape.OVAL)
                .gradientSweep(R.color.colorAccent, R.color.colorPrimary).into(tv_gradient_sweep);
        TextView tv_gradient_radial = findViewById(R.id.tv_gradient_radial);
        DevShapeUtils.shape(DevShape.OVAL)
                .gradientRadial(30, R.color.colorAccent, R.color.colorPrimary).into(tv_gradient_radial);

    }
}
