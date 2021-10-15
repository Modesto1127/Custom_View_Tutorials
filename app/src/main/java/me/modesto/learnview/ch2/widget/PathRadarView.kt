package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Description.
 * @author Created by Modesto in 2021/10/15
 */
class PathRadarView : View {

    private var radius: Float = 0F
    private var centerX: Float = 0F
    private var centerY: Float = 0F

    private val radarPaint: Paint = Paint()
    private val valuePaint: Paint = Paint()


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initPaint()
    }

    private fun initPaint() {
        initRadarPaint()
        initValuePaint()
    }

    private fun initRadarPaint() {
        radarPaint.style = Paint.Style.STROKE
        radarPaint.color = Color.GRAY
    }

    private fun initValuePaint() {
        valuePaint.color = Color.GREEN
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = minOf(w, h) / 2 * 0.9F
        centerX = w / 2F
        centerY = w / 2F
        postInvalidate()
    }

    private fun drawPolygon(canvas: Canvas) {
        val path = Path()
        val gap = radius / ()
    }

}