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
class CanvasColorView : View {

    private var centerX: Float = 0F
    private val paint: Paint = Paint()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        paint.isAntiAlias = true
        paint.color = Color.GREEN
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            can.drawColor(Color.GRAY)
            can.drawARGB(255, 255, 255, 255)
            can.drawRGB(255, 255, 255)
            val radius = dp2px(this, 30F)
            val centerY = dp2px(this, 50F)
            can.drawCircle(centerX, centerY, radius, paint)
        }
    }

}