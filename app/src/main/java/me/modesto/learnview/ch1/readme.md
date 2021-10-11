# 绘图基础

主要学习画笔、画布的用法即颜色构造

***

## 画笔用法

```kotlin
// 创建画笔
val paint = Paint()
// 开启抗锯齿
paint.isAntiAlias = true
// 设置画笔颜色
paint.color = Color.RED
// 设置画笔样式
paint.style = Paint.Style.FILL_AND_STROKE
// 使用画笔
canvas.drawCircle(100F, 100F, 50F, paint)
```

### 设置画笔颜色

我们可以使用 ``setColor(int color)`` 来设置画笔颜色

每种颜色都有三原色构成，所以 color 的格式为 ``0xAARRGGBB``

- AA：**透明度**，取值范围为：0 ~ 255，值越小，图像越透明
- RR：**红色**，取值范围为：0 ~ 255，值越小，红色越少
- GG：**绿色**，取值范围为：0 ~ 255，值越小，绿色越少
- BB：**蓝色**，取值范围为：0 ~ 255，值越小，蓝色越少

除了手动设置颜色之外，系统还提供了 ``Color`` 类

### 设置画笔样式

我们可以使用 ``setStyle(Style style)`` 来设置画笔格式

- STROKE：**描边**
- FILL：**填充**，默认样式
- FILL_AND_STROKE：**描边且填充**，描边和填充结合，最终图形的大小与填充相比多了一个描边的宽度

### 设置画笔宽度

我们可以使用 ``setStrokeWidth(float width)`` 来设置描边宽度，单位为 ``px``

> 注意：画笔宽度只有当样式为 ``STROKE`` 或者 ``FILL_AND_STROKE`` 时才有意义

### 设置画笔抗锯齿

画笔默认不开启抗锯齿，这样画出来的图像的边缘会有小毛刺

我们可以使用 ``setAntiAlias(boolean aa)`` 方法来设置是否开启抗锯齿

***

## 画布用法

### 设置背景

画布提供了三种方法来设置背景

- drawColor(int color)
- drawARGB(int a, int r, int g, int b)
- drawRGB(int r, int g, int b)

设置画布背景要在其他图形绘制前设置，否则设置好的背景色就会遮盖住绘制好的图形

```kotlin
can.drawColor(Color.GRAY)
can.drawARGB(255, 255, 255, 255)
can.drawRGB(255, 255, 255)
```

### 绘制直线

我们可以使用 ``drawLine(float startX, float starY, float stopX, float stopY, Paint paint)`` 在画布上绘制直线，直线的粗细取决于传入画笔的宽度，只有当画笔样式为 STROKE 或 FILL_AND_STROKE 时才有效

```kotlin
val paint = Paint()
paint.color = Color.GREEN
paint.strokeWidth = 10F
canvas.drawLine(100, 20, 200, 20, paint)
```

### 绘制点

我们可以使用 ``drawPoint(float x, float y, Paint paint)`` 在画布上绘制点，点的大小取决于传入的画笔的宽度

```kotlin
val paint = Paint()
paint.color = Color.GREEN
paint.strokeWidth = 10F
canvas.drawPoint(100, 100, paint)
```

### 绘制矩形

Android 提供了 Rect 和 RectF 用于存储矩形数据结构

- Rect 用于存储 int 类型数值的矩形结构
- RectF 用于存储 float 类型数值的矩形结构

我们可以使用 ``drawPoint()`` 或者 ``drawRect()`` 来在画布上绘制矩形

- drawPoint 只能指定矩形的中心点位置，且只能画正方形；只能是填充样式
- drawRect 需要执行矩形**左上**和**右下**两个点的位置；可以是描边，也可以是填充

Canvas 提供的三个用于绘制矩形的方法

- drawRect(float left, float top, float right, float bottom, Paint paint)
- drawRect(RectF rect, Paint paint)
- drawRect(Rect r, Paint paint)

```kotlin
val left = dp2px(this, 30F)
val top = dp2px(this, 20F)
val right = dp2px(this, 200F)
val bottom = dp2px(this, 80F)
val rect1 = RectF(left, top, right, bottom)
canvas?.let { can ->
    drawRect(can, rect1, Paint.Style.FILL)
}
```

### 绘制圆角矩形

我们可以使用 ``drawRoundRect()`` 在画布上绘制圆角矩形

```kotlin
val radius = 5F
val rect = RectF(0, 0, 100, 100)
val paint = Paint()
paint.color = Color.GRAY
canvas.drawRoundRect(rect, radius, radius, paint)
```