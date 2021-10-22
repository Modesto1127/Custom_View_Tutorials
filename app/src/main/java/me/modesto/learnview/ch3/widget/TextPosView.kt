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
class TextPosView : View {

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
        val position: FloatArray = floatArrayOf(
            centerX, dp2px(this, 40F),
            centerX, dp2px(this, 70F),
            centerX, dp2px(this, 100F),
            centerX, dp2px(this, 130F),
            centerX, dp2px(this, 160F),
            centerX, dp2px(this, 190F)
        )
        canvas?.drawPosText("CUSTOM", position, paint)
    }

    private fun initPaint() {
        paint.isAntiAlias = true
        paint.color = Color.GRAY
        paint.textSize = sp2px(this, 30F)
        paint.textAlign = Paint.Align.CENTER
    }

}