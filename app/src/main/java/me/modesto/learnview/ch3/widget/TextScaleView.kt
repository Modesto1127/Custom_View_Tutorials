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
class TextScaleView : View {

    private val paint = Paint()

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
            drawText(can, 2F, 50F)
            drawText(can, 0.25F, 100F)
        }
    }

    private fun initPaint() {
        paint.isAntiAlias = true
        paint.color = Color.GRAY
        paint.textSize = sp2px(this, 30F)
        paint.strokeWidth = 5F
        paint.textAlign = Paint.Align.CENTER
    }

    private fun drawText(canvas: Canvas, scaleX: Float, top: Float) {
        val string = "CUSTOM"
        paint.textScaleX = scaleX
        val y = dp2px(this, top)
        canvas.drawText(string, centerX, y, paint)
    }

}