package caiyi.com.library_databinding

import android.databinding.BindingAdapter
import android.graphics.drawable.StateListDrawable
import android.view.View
import com.luliang.shapeutils.DevShapeUtils
import com.luliang.shapeutils.shape.DevShape


/**
 * Created by guo on 2018/6/6.
 * desc:
 */

@BindingAdapter(value = ["android:bindGradient", "android:bindGradientOrientation", "android:bindRadius"
    , "android:bindSelectorNormal", "android:bindSelectorEnable"], requireAll = false)
fun View.setDevShape(bindGradient: String?, bindGradientOrientation: String?, bindRadius: Float = 0f
                     , bindSelectorNormal: String?, bindSelectorEnable: String?) {
    var _bindGradientOrientation = DevShape.TL_BR;
    if (bindGradientOrientation != null) {
        _bindGradientOrientation = bindGradientOrientation
    }


    val stateListDrawable = StateListDrawable()
    val shape = DevShapeUtils
            .shape(DevShape.RECTANGLE)
            .radius(bindRadius);
    if (bindGradient != null && bindGradient.isNotEmpty()) {
        val gradients = bindGradient.split("|")
        shape.gradient(gradients[0], gradients[1])
                .orientation(_bindGradientOrientation)
        stateListDrawable.addState(emptyArray<Int>().toIntArray(), shape.build())
    }
    if (!bindSelectorEnable.isNullOrEmpty()) {
        stateListDrawable.addState(IntArray(1, { android.R.attr.state_enabled }), shape.solid(bindSelectorEnable).build())
    }

    if (!bindSelectorNormal.isNullOrEmpty()) {
        stateListDrawable.addState(IntArray(0), shape.solid(bindSelectorNormal).build())
    }

    this.background = stateListDrawable

}

