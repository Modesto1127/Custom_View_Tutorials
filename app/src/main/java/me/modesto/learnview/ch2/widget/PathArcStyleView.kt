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
class PathArcStyleView : View {

    private var width: Float = 0F
    private val ovalPaint: Paint = Paint()
    private val arcPaint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        ovalPaint.isAntiAlias = true
        ovalPaint.color = Color.GRAY
        arcPaint.isAntiAlias = true
        arcPaint.color = Color.GREEN
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            var offset = dp2px(this, 100F)
            arcPaint.style = Paint.Style.FILL
            drawGraph(canvas, offset)
            offset = dp2px(this, 180F)
            arcPaint.strokeWidth = 10F
            arcPaint.style = Paint.Style.STROKE
            drawGraph(canvas, width - offset)
        }
    }

    private fun drawGraph(canvas: Canvas, left: Float) {
        val rect = getRect(left)
        canvas.drawOval(rect, ovalPaint)
        drawArc(rect, canvas)
    }

    private fun drawArc(ovalRect: RectF, canvas: Canvas) {
        val path = Path()
        path.arcTo(ovalRect, 0F, 90F)
        canvas.drawPath(path, arcPaint)
    }

    private fun getRect(left: Float): RectF {
        val top = dp2px(this, 30F)
        val width = dp2px(this, 80F)
        val right = left + width
        val bottom = top + width
        return RectF(left, top, right, bottom)
    }

}