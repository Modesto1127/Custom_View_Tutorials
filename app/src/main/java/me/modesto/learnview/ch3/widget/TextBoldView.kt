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
 * @author Created by Modesto in 2021/10/22
 */
class TextBoldView: View {

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
            drawText(canvas = can, top = 50F)
            paint.isFakeBoldText = true
            drawText(canvas = can, top = 100F)
            paint.isFakeBoldText = false
            paint.isUnderlineText = true
            drawText(canvas = can, top = 150F)
            paint.isUnderlineText = false
            paint.isStrikeThruText = true
            drawText(canvas = can, top = 200F)
            paint.isStrikeThruText = false
        }
    }

    private fun initPaint() {
        paint.textSize = sp2px(this, 30F)
        paint.color = Color.GRAY
        paint.textAlign = Paint.Align.CENTER
    }

    private fun drawText(canvas: Canvas, top: Float) {
        val y = dp2px(this, top)
        canvas.drawText("CUSTOM", centerX, y, paint)
    }

}