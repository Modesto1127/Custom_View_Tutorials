package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/13
 */
class PathArcAngleView : View {

    private var centerX: Float = 0F
    private var radius: Float = 0F
    private var offset: Float = 0F
    private val ovalPaint: Paint = Paint()
    private val arcPaint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        ovalPaint.isAntiAlias = true
        ovalPaint.color = Color.GRAY
        arcPaint.isAntiAlias = true
        arcPaint.color = Color.GREEN
        arcPaint.strokeWidth = 10F
        arcPaint.style = Paint.Style.STROKE
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
        offset = centerX / 2F
        radius = dp2px(this, 40F)
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            drawArc(can, centerX - offset, 0F, 90F)
            drawArc(can, centerX, 0F, 180F)
            drawArc(can, centerX + offset, 90F, 180F)
        }
    }

    private fun drawArc(canvas: Canvas, center: Float, startAngle: Float, sweepAngle: Float) {
        val top = dp2px(this, 20F)
        val ovalRect = getRect(center, top)
        canvas.drawOval(ovalRect, ovalPaint)
        val arcPath = Path()
        arcPath.arcTo(ovalRect, startAngle, sweepAngle)
        canvas.drawPath(arcPath, arcPaint)
    }

    private fun getRect(center: Float, top: Float): RectF {
        val left = center - radius
        val right = center + radius
        val bottom = top + 2 * radius
        return RectF(left, top, right, bottom)
    }

}