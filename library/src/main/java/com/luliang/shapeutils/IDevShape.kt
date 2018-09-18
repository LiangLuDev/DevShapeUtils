package com.luliang.shapeutils

import android.view.View

/**
 * Created by zohar on 2018/6/7.
 * desc:
 */
interface IDevShape {

    fun createShape()

    fun addState(attr: Int, devShape: DevShapeKt)

    fun into(v: View)
}