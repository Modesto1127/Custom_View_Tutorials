package me.modesto.learnview.ch3.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px
import me.modesto.learnview.utils.sp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/20
 */
class TextWidthView : View {

    companion object {
        private const val TEST_STRING = "CUSTOM自定义custom"
    }

    private val paint = Paint()
    private var centerX: Float = 0F
    private var centerY: Float = 0F

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initPaint()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
        centerY = h / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            var top = dp2px(this, 40F)
            can.drawText(TEST_STRING, centerX, top, paint)

            val textWidth = paint.measureText(TEST_STRING)

            top += dp2px(this, 20F)
            val linePaint = Paint()
            linePaint.isAntiAlias = true
            linePaint.style = Paint.Style.STROKE
            linePaint.strokeWidth = 5F
            linePaint.color = Color.GRAY
            val startX = centerX - textWidth / 2
            can.drawLine(startX, top, startX + textWidth, top, linePaint)
        }
    }

    private fun initPaint() {
        paint.color = Color.GRAY
        paint.isAntiAlias = true
        paint.textSize = sp2px(this, 20F)
        paint.textAlign = Paint.Align.CENTER
    }

    private fun drawText(canvas: Canvas, offset: Float) {

    }

}