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