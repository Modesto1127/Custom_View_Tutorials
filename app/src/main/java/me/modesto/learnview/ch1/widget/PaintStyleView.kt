package me.modesto.learnview.ch1.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/11
 */
class PaintStyleView : View {

    private var centerX: Float = 0F
    private val paint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        paint.strokeWidth = 30F
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        val offset = dp2px(this, 90F)
        canvas?.let { can ->
            // 描边
            drawCircle(centerX - offset, Paint.Style.STROKE, can)
            // 填充
            drawCircle(centerX, Paint.Style.FILL, can)
            // 描边且填充
            drawCircle(centerX + offset, Paint.Style.FILL_AND_STROKE, can)
        }
    }

    private fun drawCircle(centerX: Float, style: Paint.Style, canvas: Canvas) {
        paint.style = style
        val centerY = dp2px(this, 50F)
        val radius = dp2px(this, 30F)
        canvas.drawCircle(centerX, centerY, radius, paint)
    }

}