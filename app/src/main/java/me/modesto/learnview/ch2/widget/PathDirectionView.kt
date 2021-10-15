package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px
import me.modesto.learnview.utils.sp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/15
 */
class PathDirectionView : View {

    private var width: Float = 0F
    private val textPaint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        textPaint.color = Color.RED
        textPaint.isAntiAlias = true
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = sp2px(this, 12F)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            var left = dp2px(this, 100F)
            drawPath(can, Path.Direction.CW, left)
            left = width - dp2px(this, 150F)
            drawPath(can, Path.Direction.CCW, left)
        }
    }

    private fun drawPath(canvas: Canvas, direction: Path.Direction, left: Float) {
        val path = getOvalPath(direction, left)
        val paint = getPaint()
        canvas.drawPath(path, paint)
        canvas.drawTextOnPath("one two three", path, 0F, 0F, textPaint)
    }

    private fun getOvalPath(direction: Path.Direction, left: Float): Path {
        val path = Path()
        val top = dp2px(this, 10F)
        val right = left + dp2px(this, 50F)
        val bottom = top + dp2px(this, 100F)
        val rect = RectF(left, top, right, bottom)
        path.addOval(rect, direction)
        return path
    }

    private fun getPaint(): Paint {
        val paint = Paint()
        paint.color = Color.GREEN
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5F
        return paint
    }

}