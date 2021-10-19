package me.modesto.learnview.ch2.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * Description.
 * @author Created by Modesto in 2021/10/15
 */
class PathRadarView : View {

    // 网格最大半径
    private var radius: Float = 0F

    // 网格中心横坐标
    private var centerX: Float = 0F

    // 网格中心纵坐标
    private var centerY: Float = 0F

    // 雷达网格画笔
    private val radarPaint: Paint = Paint()

    // 数据画笔
    private val valuePaint: Paint = Paint()

    // 数据个数
    private val count: Int = 6

    // 数值层级
    private val maxLevel: Int = 5

    private val angle: Float = (2 * PI / count).toFloat()

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        initPaint()
    }

    private fun initPaint() {
        initRadarPaint()
        initValuePaint()
    }

    private fun initRadarPaint() {
        radarPaint.isAntiAlias = true
        radarPaint.color = Color.GRAY
        radarPaint.style = Paint.Style.STROKE
        radarPaint.strokeWidth = 1F
    }

    private fun initValuePaint() {
        valuePaint.isAntiAlias = true
        valuePaint.color = Color.GREEN
        valuePaint.style = Paint.Style.FILL
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        radius = minOf(w, h) / 2 * 0.9F
        centerX = w / 2F
        centerY = h / 2F
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        val data: IntArray = intArrayOf(3, 2, 5, 6, 1, 4)
        canvas?.let {
            drawPolygon(canvas)
            drawLines(canvas)
            drawData(data, canvas)
        }
    }

    private fun drawLines(canvas: Canvas) {
        val path = Path()
        (0..count).forEach { index ->
            path.reset()
            path.moveTo(centerX, centerY)
            val x = centerX + radius * cos(angle * index)
            val y = centerY + radius * sin(angle * index)
            path.lineTo(x, y)
            canvas.drawPath(path, radarPaint)
        }
    }

    private fun drawData(data: IntArray, canvas: Canvas) {
        val path = Path()

        val gap = radius / (maxLevel + 1)

        (0 until count).forEach { index ->
            val len = gap * data[index]
            val x = centerX + len * cos(angle * index)
            val y = centerY + len * sin(angle * index)
            if (0 == index) {
                path.moveTo(x, centerY)
            } else {
                path.lineTo(x, y)
            }
            valuePaint.alpha = 255
            canvas.drawCircle(x, y, 10F, valuePaint)
        }

        valuePaint.alpha = 172
        valuePaint.style = Paint.Style.FILL_AND_STROKE
        canvas.drawPath(path, valuePaint)
    }

    /**
     * 绘制网格
     *
     * @author Created by Modesto in 2021/10/19
     */
    private fun drawPolygon(canvas: Canvas) {
        val path = Path()
        // 每圈网格之间的间距
        val gap = radius / (maxLevel + 1)
        (1..maxLevel + 1).forEach { tier ->
            val curR = gap * tier
            path.reset()
            (0 until count).forEach { index ->
                if (0 == index) {
                    path.moveTo(centerX + curR, centerY)
                } else {
                    val x = centerX + curR * cos(angle * index)
                    val y = centerY + curR * sin(angle * index)
                    path.lineTo(x, y)
                }
            }
            path.close()
            canvas.drawPath(path, radarPaint)
        }
    }

}