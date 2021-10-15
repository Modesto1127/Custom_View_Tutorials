package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Description.
 * @author Created by Modesto in 2021/10/15
 */
class PathResetPathView: View {

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onDraw(canvas: Canvas?) {
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.RED

        val path = Path()
        path.fillType = Path.FillType.INVERSE_WINDING
        path.addCircle(100F, 100F, 50F, Path.Direction.CW)
        canvas?.drawPath(path, paint)

        // 清除并重绘
        path.reset()
        path.addCircle(300F, 100F, 50F, Path.Direction.CW)
        path.moveTo(300F, 100F)
        canvas?.drawPath(path, paint)

        // 重置并重绘
        path.rewind()
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5F
        path.addRect(RectF(400F, 50F, 450F, 100F), Path.Direction.CCW)

        path.rewind()
        canvas?.drawPath(path, paint)
    }

}