package com.luliang.shapeutils

import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.util.LruCache
import android.view.View

/**
 * Created by zohar on 2018/6/7.
 * desc:
 */
class ShapeBuilder : IDevShape {


    private var devShapeKt = DevShapeKt()
    val stateListDrawable = StateListDrawable()
    private val stateListDrawableCache = LruCache<Int, StateListDrawable>(10)

    fun with(devShape: DevShapeKt) {
        this.devShapeKt = devShape
    }

    override fun createShape() {
        devShapeKt.apply {
            for (color in colors) {
                addState(color.key, devShapeKt)
            }
        }
    }

    override fun addState(attr: Int, devShape: DevShapeKt) {
        val drawable = GradientDrawable()
        drawable.shape = GradientDrawable.RECTANGLE

        if (devShape.isHaveRadius) {
            val radii = floatArrayOf(dip2px(devShape.radius[0]).toFloat()
                    , dip2px(devShape.radius[0]).toFloat()
                    , dip2px(devShape.radius[1]).toFloat(), dip2px(devShape.radius[1]).toFloat()
                    , dip2px(devShape.radius[2]).toFloat(), dip2px(devShape.radius[2]).toFloat()
                    , dip2px(devShape.radius[3]).toFloat(), dip2px(devShape.radius[3]).toFloat())
            drawable.cornerRadii = radii//设置圆角
        }

        devShape.colors[attr]?.apply {
            drawable.setColor(this)
        }
        if (attr != -1) {
            stateListDrawable.addState(arrayOf(attr).toIntArray(), drawable)
        } else {
            stateListDrawable.addState(emptyArray<Int>().toIntArray(), drawable)
        }

    }


    override fun into(v: View) {
        if (v.id != View.NO_ID) {
            stateListDrawableCache.put(v.id, stateListDrawable)
        }
        v.background = stateListDrawable
    }


    /**
     * 单位转换工具类
     *
     * @param dipValue 值
     * @return 返回值
     */
    private fun dip2px(dipValue: Float): Int {
        val scale = DevShapeUtils.getContext().resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

}