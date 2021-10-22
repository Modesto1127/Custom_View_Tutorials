package me.modesto.learnview.ch3.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px
import me.modesto.learnview.utils.sp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/22
 */
class TextPathView : View {

    private val textPaint = Paint()
    private val circlePaint = Paint()

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
            drawText(can, 100F, 0F, 0F)
            drawText(can, 225F, 100F, 0F)
            drawText(can, 350F, -100F, 0F)
            drawText(can, 475F, 0F, 100F)
            drawText(can, 600F, 0F, -100f)
        }
    }

    private fun initPaint() {
        textPaint.isAntiAlias = true
        textPaint.color = Color.GRAY
        textPaint.textSize = sp2px(this, 20F)
        circlePaint.isAntiAlias = true
        circlePaint.color = Color.GRAY
        circlePaint.style = Paint.Style.STROKE
        circlePaint.strokeWidth = 5F
    }

    private fun drawText(canvas: Canvas, top: Float, horizontalOffset: Float, verticalOffset: Float) {
        val path = Path()
        val y = dp2px(this, top)
        val radius = dp2px(this, 50F)
        path.rewind()
        path.addCircle(centerX, y, radius, Path.Direction.CW)
        canvas.drawPath(path, circlePaint)
        canvas.drawTextOnPath("CUSTOM", path, horizontalOffset, verticalOffset, textPaint)
    }

}