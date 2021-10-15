package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import me.modesto.learnview.utils.dp2px


/**
 * Description.
 * @author Created by Modesto in 2021/10/15
 */
class PathFillModeView : View {

    private var centerX: Float = 0F
    private var offset: Float = 0F

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2F
        offset = (w - centerX) / 2F
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.let { can ->
            drawPath(can, Path.FillType.WINDING, 80F, 30F)
            drawPath(can, Path.FillType.INVERSE_WINDING, 200F, 30F)
            drawPath(can, Path.FillType.EVEN_ODD, 80F, 150F)
            drawPath(can, Path.FillType.INVERSE_EVEN_ODD, 200F, 150F)
        }
    }

    private fun drawPath(canvas: Canvas, fillType: Path.FillType, left: Float, top: Float) {
        val leftF = dp2px(this, left)
        val topF = dp2px(this, top)
        clipPath(leftF, topF, canvas)
        val paint = getPaint()
        val path = Path()
        path.addRect(getRect(leftF, topF), Path.Direction.CW)
        addCircle(path, leftF, topF)
        path.fillType = fillType
        canvas.drawPath(path, paint)
        canvas.restore()
    }

    /**
     * 对 Canvas 进行裁剪
     * @author Created by Modesto in 2021/10/15
     */
    private fun clipPath(left: Float, top: Float, canvas: Canvas) {
        canvas.save()
        val rectPath = Path()
        val leftF = left - dp2px(this, 1F)
        val topF = top - dp2px(this, 1F)
        val right = leftF + dp2px(this, 70F)
        val bottom = topF + dp2px(this, 70F)
        rectPath.addRect(leftF, topF, right, bottom, Path.Direction.CW)
        canvas.clipPath(rectPath)
    }

    private fun getRect(left: Float, top: Float): RectF {
        val right = left + dp2px(this, 40F)
        val bottom = top + dp2px(this, 40F)
        return RectF(left, top, right, bottom)
    }

    private fun addCircle(path: Path, left: Float, top: Float) {
        val x = left + dp2px(this, 40F)
        val y = top + dp2px(this, 40F)
        val radius = dp2px(this, 25F)
        path.addCircle(x, y, radius, Path.Direction.CW)
    }

    private fun getPaint(): Paint {
        val paint = Paint()
        paint.color = Color.GRAY
        paint.isAntiAlias = true
        return paint
    }

}