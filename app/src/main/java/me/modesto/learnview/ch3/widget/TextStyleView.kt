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
class TextStyleView : View {

    companion object {
        private const val TEST_STRING = "CUSTOM"
    }

    private val textPaint = Paint()

    private var centerX: Float = 0F
    private var offset: Float = 0F

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initPaint()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
        offset = centerX / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            drawText(can, 50F, Paint.Style.STROKE)
            drawText(can, 100F, Paint.Style.FILL)
            drawText(can, 150F, Paint.Style.FILL_AND_STROKE)
        }
    }

    private fun initPaint() {
        textPaint.isAntiAlias = true
        textPaint.color = Color.GRAY
        textPaint.textSize = sp2px(this, 30F)
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.strokeWidth = 3F
    }

    private fun drawText(canvas: Canvas, top: Float, style: Paint.Style) {
        val y = dp2px(this, top)
        textPaint.style = style
        canvas.drawText(TEST_STRING, centerX, y, textPaint)
    }

}