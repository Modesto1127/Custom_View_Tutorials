package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px

/**
 * Description.
 * @author Created by Modesto in 2021/10/13
 */
class PathArcStartView : View {

    private var centerX: Float = 0F

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        val paint = getPaint()
        val path = Path()
        var x = centerX - dp2px(this, 80F)
        var y = dp2px(this, 10F)
        path.moveTo(x, y)
        x += dp2px(this, 80F)
        y = dp2px(this, 60F)
        path.lineTo(x, y)
        val width = dp2px(this, 30F)
        val rect: RectF = RectF(x, y, x + width, y + width)
        path.addArc(rect, 0F, 90F)
        canvas?.drawPath(path, paint)
    }

    private fun getPaint(): Paint {
        val paint = Paint()
        paint.color = Color.GRAY
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10F
        return paint
    }

}