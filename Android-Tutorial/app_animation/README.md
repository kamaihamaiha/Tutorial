# 动画

- 视图动画 = 补间动画 + 逐帧动画
- 属性动画

## 1. 视图动画(View Animation)
### 1.1 补间动画(Tween Animation)
#### 1.1.1 作用对象
视图空间 (View)
```
不能作用于 View 的属性，如： 颜色、背景、长度   
```

#### 1.1.2. 原理
确定开始视图样式和结束视图样式，中间动画变化过程有系统补全。

#### 1.1.3. 分类
- 平移 (Translate)
- 缩放 (scale)
- 旋转 (rotate)
- 渐进 (alpha)

#### 1.1.4. 具体使用
分为 2 种： 在 XML / Java 都可以

---
#### 1.1.5. 组合动画
...
#### 1.1.6. 监听动画

- 为了简洁，不用 AnimatorListener, 用 AnimatorListenerAdapter
不过没有找到这个 api

#### 1.1.7. 插值器(Interpolator)
- 作用： 设置 属性值 从初始值过滤到结束值 的变化规律
```
1. 匀速、加速、减速
2. 确定了动画效果变化的模式
```
2 种方式： XML / Java

#### 1.1.8. Activity 切换动画
- 有系统自带的动画效果

#### 1.1.9. Fragment 切换动画

#### 1.1.10. 视图组(ViewGroup) 中子元素的出场效果

### 1.2 逐帧动画(Frame Animation)
- 可实现复杂的个性化动画效果
- 容易引起 OOM

---
## 2. 属性动画(Property Animation)
### 2.1 简介
- 作用对象： 任意 Java 对象
- 动画效果： 可以自定义

### 2.2 工作原理
- 在一定时间间隔内，不断对值进行改变，同时把该变化的值赋值给对象的属性，从而实现该对象在该属性上的动画效果
- 2 个重要的类： ValueAnimator, ObjectAnimator

### 2.3 练习
自定义 对象属性实现动画效果。见：MyCircle , MyCircle2

### 2.4 ViewPropertyAnimator 
这是个 view 对象的自带属性，直接调用即可.不需要 start(),直接就能生效
```
view.animator().alpha().setDuration().setInterpolator
view.animator().translationX().setDuration().setInterpolator
...
```
### 2.5 animation listener
- addListener()
```
# kind1
AnimatorListener()
# kind2
AnimatorListenerAdapter()

```
























