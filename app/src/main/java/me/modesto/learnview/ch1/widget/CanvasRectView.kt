package me.modesto.learnview.ch1.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/11
 */
class CanvasRectView : View {

    private var centerX: Float = 0F
    private val paint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        paint.isAntiAlias = true
        paint.color = Color.GREEN
        paint.strokeWidth = 20F
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawColor(Color.GRAY)
        val left = dp2px(this, 30F)
        val top = dp2px(this, 20F)
        val right = dp2px(this, 200F)
        val bottom = dp2px(this, 80F)
        val rect1 = RectF(left, top, right, bottom)
        canvas?.let { can ->
            drawRect(can, rect1, Paint.Style.FILL)
        }
    }

    private fun drawRect(canvas: Canvas, rect: RectF, style: Paint.Style) {
        paint.style = style
        canvas.drawRect(rect, paint)
    }

}