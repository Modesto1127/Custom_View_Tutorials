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
class TextAlignView : View {

    companion object {
        private const val TEST_STRING = "CUSTOM"
    }

    private val textPaint = Paint()

    private var centerX: Float = 0F

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initPaint()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            drawLine(can)
            drawText(can, Paint.Align.LEFT, 50F)
            drawText(can, Paint.Align.CENTER, 100F)
            drawText(can, Paint.Align.RIGHT, 150F)
        }
    }

    private fun initPaint() {
        textPaint.isAntiAlias = true
        textPaint.color = Color.GRAY
        textPaint.textSize = sp2px(this, 30F)
        textPaint.strokeWidth = 5F
        textPaint.style = Paint.Style.FILL
    }

    private fun drawText(canvas: Canvas, align: Paint.Align, top: Float) {
        val y = dp2px(this, top)
        textPaint.textAlign = align
        canvas.drawText(TEST_STRING, centerX, y, textPaint)
    }

    private fun drawLine(canvas: Canvas) {
        val paint = Paint()
        paint.color = Color.GREEN
        paint.strokeWidth = 5F
        val top = dp2px(this, 20F)
        val bottom = dp2px(this, 160F)
        canvas.drawLine(centerX, top, centerX, bottom, paint)
    }

}