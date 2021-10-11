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
class PaintColorView : View {

    private var centerX: Float = 0F
    private val paint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        paint.isAntiAlias = true
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        val offset = dp2px(this, 80F)
        canvas?.let { can ->
            // 红色
            drawCircle(centerX - offset, Color.RED, can)
            // 绿色
            drawCircle(centerX, Color.GREEN, can)
            // 蓝色
            drawCircle(centerX + offset, Color.BLUE, can)
        }
    }

    private fun test(canvas: Canvas) {
        // 创建画笔
        val paint = Paint()
        // 设置画笔颜色
        paint.color = Color.RED
        // 设置画笔样式
        paint.style = Paint.Style.FILL_AND_STROKE
        // 使用画笔
        canvas.drawCircle(100F, 100F, 50F, paint)
    }

    private fun drawCircle(centerX: Float, color: Int, canvas: Canvas) {
        paint.color = color
        val radius = dp2px(this, 30F)
        val centerY = dp2px(this, 50F)
        canvas.drawCircle(centerX, centerY, radius, paint)
    }

}