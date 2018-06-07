package com.luliang.shapeutils

/**
 * Created by zohar on 2018/6/7.
 * desc:
 */
class DevShapeKt {

    //样式-矩形
    val RECTANGLE = 0
    var shape = RECTANGLE

    // 圆角
    var radius = FloatArray(4)
    var isHaveRadius = true

    //背景颜色
    var colors: MutableMap<Int, Int> = mutableMapOf()

    fun setBgColor(color: Int) {
        colors.put(-1, color)
    }

    fun setRadius(r: Float) {
        radius = arrayOf(r, r, r, r).toFloatArray()
    }

}