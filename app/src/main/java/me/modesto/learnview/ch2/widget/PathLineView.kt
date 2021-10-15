package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/13
 */
class PathLineView : View {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    private fun initPaint(): Paint {
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 10F
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        return paint
    }

    private fun getPoint(x: Float, y: Float): Pair<Float, Float> {
        val xF = dp2px(this, x)
        val yF = dp2px(this, y)
        return Pair(xF, yF)
    }

    override fun onDraw(canvas: Canvas?) {
        val paint = initPaint()
        val path = Path()
        val (x1, y1) = getPoint(80F, 30F)
        path.moveTo(x1, y1)
        val (x2, y2) = getPoint(200F, 80F)
        path.lineTo(x2, y2)
        val (x3, y3) = getPoint(120F, 70F)
        path.lineTo(x3, y3)
        path.close()
        canvas?.drawPath(path, paint)
    }

}