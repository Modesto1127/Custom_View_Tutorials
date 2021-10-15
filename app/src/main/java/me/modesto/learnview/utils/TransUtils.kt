package me.modesto.learnview.utils

import android.content.Context
import android.view.View

/**
 * Description.
 * @author Created by Modesto in 2021/10/11
 */
fun dp2px(view: View, dp: Float): Float {
    return dp2px(view.context, dp)
}

fun dp2px(context: Context, dp: Float): Float {
    val scaledDensity = context.resources.displayMetrics.density
    return dp * scaledDensity + 0.5F
}

fun sp2px(view: View, sp: Float): Float {
    return sp2px(view.context, sp)
}

fun sp2px(context: Context, sp: Float): Float {
    val scaledDensity = context.resources.displayMetrics.scaledDensity
    return sp * scaledDensity + 0.5F
}