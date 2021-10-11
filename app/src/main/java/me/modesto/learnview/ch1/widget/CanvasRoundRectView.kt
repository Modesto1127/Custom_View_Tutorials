package me.modesto.learnview.ch1.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px


/**
 * Description.
 * @author Created by Modesto in 2021/10/11
 */
class CanvasRoundRectView : View {

    private var centerX = 0
    private var radius = 0f
    private var rectPaint: Paint = Paint()
    private var circlePaint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    private fun init() {
        // 圆角半径
        radius = dp2px(this, 10F)
        rectPaint.color = Color.parseColor("#484848")
        rectPaint.isAntiAlias = true
        circlePaint.color = Color.GREEN
        circlePaint.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2
    }

    override fun onDraw(canvas: Canvas) {
        val rect = getRect()

        // 绘制圆角矩形
        canvas.drawRoundRect(rect, radius, radius, rectPaint)

        // 绘制四个圆
        drawCircles(canvas, rect)
    }

    private fun getRect(): RectF {
        val halfWidth: Float = dp2px(this, 70F)
        val y: Float = dp2px(this, 10F)
        return RectF(
            centerX - halfWidth, y,
            centerX + halfWidth, y + halfWidth * 2
        )
    }

    private fun drawCircles(canvas: Canvas, rect: RectF) {
        canvas.drawCircle(rect.left + radius, rect.top + radius, radius, circlePaint)
        canvas.drawCircle(rect.right - radius, rect.top + radius, radius, circlePaint)
        canvas.drawCircle(rect.left + radius, rect.bottom - radius, radius, circlePaint)
        canvas.drawCircle(rect.right - radius, rect.bottom - radius, radius, circlePaint)
    }

}