### XML设置Shape、Selector
> 在xml布局中设置样式我使用Databinding进行关联设置，现在MVVM架构的已经很流行，Databinding作为Android端MVVM架构的主力军，如果你还不了解，就有点落后。[Databinding了解一下？](https://blog.csdn.net/u013005791/article/details/78905401#studio_support) 
>
> xml设置样式示例代码，使用套路基本差不多，这里我只展示一部分示例，具体示例可查看[xml布局文件](https://github.com/LiangLuDev/DevShapeUtils/blob/master/app/src/main/res/layout/activity_binding.xml)


#### 启用Databinding
在项目`build.gradle`文件中添加
```
android{
    
    ...

     dataBinding {
        enabled = true
    }
}
```


#### 关联布局设置

> 因为我们利用Databinding设置布局，所以在关联布局的时候会有一些不（sao）一（cao）样（zuo），当然慌不要慌，只是多加一行代码的事情。


- `Activity` 关联布局示例代码

```
public class BindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewDataBinding viewDataBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_binding);
        setContentView(viewDataBinding.getRoot());

    }
}
```

- `Fragment` 关联布局示例代码
```
public class BindingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewDataBinding dataBinding = 
                DataBindingUtil.inflate(inflater, R.layout.fragment_binding, container, false);
        return dataBinding.getRoot();
    }
}
```

- `RecyclerView.Adapter` 关联布局示例代码
```
public class BindingAdapter extends RecyclerView.Adapter{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ViewDataBinding binding = 
               DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.adapter_binding, parent, false);
        return new ViewHolder(binding.getRoot());
    }
}
```

有的朋友很着急，说我用的是[`BaseRecyclerViewAdapterHelper`](https://github.com/CymChad/BaseRecyclerViewAdapterHelpe)怎么办？慌不要慌，官方提供了关于`Databinding`关联布局的代码，[查看代码](https://github.com/CymChad/BaseRecyclerViewAdapterHelper/blob/master/app/src/main/java/com/chad/baserecyclerviewadapterhelper/adapter/DataBindingUseAdapter.java)



#### 布局文件设置
在我们正常使用的xml布局文件最外层添加一层`layout`就完成了所有工作，可以看示例。
```
<layout 
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <!--正常布局-->
    <LinearLayout>
    </LinearLayout>
</layout>

```

#### 布局使用示例代码
> 设置完上面的操作，就可以开始美美的写样式了。


设置`shape`部分属性

```
<TextView
    ...
    android:text="圆形-填充"
    app:solid="@{@color/colorPrimary}"
    app:line_color="@{@color/colorAccent}"
    app:line_width="@{1}"
    app:shape="@{`OVAL`}"  />

<TextView
    ...
    android:text="半圆角-边框"
    app:solid="@{@color/colorPrimary}"
    app:line_color="@{@color/colorAccent}"
    app:line_width="@{1}"
    app:radius="@{999}"  />
```
设置`selector`部分属性（预览）

![DevShapeUtils-Selector](./DevShapeUtils-Selector.gif)

```

<Button
    ...
    android:text="触摸背景变色"
    app:radius="@{999}"
    app:selector_pressed_color="@{@color/colorPrimary}"
    app:selector_pressed_normal_color="@{@color/colorAccent}" />
    
<Button
    ...
    android:text="触摸背景和字体变色"
    app:radius="@{999}"
    app:selector_select_text_color="@{@color/colorWhite}"
    app:selector_normal_text_color="@{@color/colorBlack}"
    app:selector_pressed_color="@{@color/colorPrimary}"
    app:selector_pressed_normal_color="@{@color/colorAccent}" />
    
    
    
```

#### 方法属性详解
>上面只示例了几个属性展示给大家看，下面的会针对具体的属性进行解释用处。


- **`Shape`** 属性详解

属性名| 类型 | 描述
----|------|----
shape | string  | 样式类型 `OVAL`圆形和`RECTANGLE`矩形 <br>默认`RECTANGLE`
solid | string &#124; int  | 背景颜色
line_width | int  | 边框线宽度
line_color | string &#124; int  | 边框线颜色
dash_line_width | int  | 虚线边框宽度
dash_line_color | string &#124; int  | 虚线边框颜色
dash_width | float  | 虚线边框实线长度
dash_gap | float  | 虚线边框间隙长度
radius | float  | 圆角弧度 设置4个圆角  
tr_radius | float  | 右上角圆角弧度
tl_radius | float  | 左上角圆角弧度
br_radius | float  | 右下角圆角弧度
bl_radius | float  | 左下角圆角弧度
gradient_linear_orientation | string  | 线性渐变方向 默认`TOP_BOTTOM（上下）` <br> `BOTTOM_TOP（下上）`<br> `RIGHT_LEFT（右左）`<br> `LEFT_RIGHT（左右）`<br> `TR_BL（右上到左下）`<br> `BR_TL（右下到左上）`<br> `BL_TR（左下到右上）`<br> `TL_BR（左上到右下）`
gradient_linear_start_color | string &#124; int  | 线性渐变起始颜色
gradient_linear_gravity_color | string &#124; int  | 线性渐变中间颜色
gradient_linear_end_color | strinstring &#124; intg或int  | 线性渐变结尾颜色
gradient_sweep_colors | string  | 扫描渐变颜色  <br>**PS.** 最少设置两个颜色，多个颜色使用 &#124; 分割<br>设置颜色值例如：#FFFFFF &#124; #000000
gradient_radial_radius | float  | 辐射渐变范围
gradient_radial_colors | string  | 辐射渐变颜色  <br>**PS.** 最少设置两个颜色，多个颜色使用 &#124; 分割<br>设置颜色值例如：#FFFFFF&#124; #000000



- **`Selector`** 属性详解


属性名| 类型 | 描述
----|------|----
shape | string  | 样式类型 `OVAL`圆形和`RECTANGLE`矩形 <br>默认`RECTANGLE`
radius | float  | 圆角弧度 设置4个圆角  
tr_radius | float  | 右上角圆角弧度
tl_radius | float  | 左上角圆角弧度
br_radius | float  | 右下角圆角弧度
bl_radius | float  | 左下角圆角弧度
selector_pressed_color | string &#124; int  | 触摸按下背景颜色
selector_pressed_normal_color | string &#124; int  | 触摸抬起背景颜色
selector_enable_color | string &#124; int  | 可点击背景颜色
selector_enable_normal_color | string &#124; int  | 不可点击背景颜色
selector_color | string &#124; int  | 选中背景颜色（需要设置selector状态）
selector_normal_color | string &#124; int  | 未选中背景颜色（需要设置selector状态）
selector_state | string  | selector状态<br>`PRESSED`是否按压状态<br>`ENABLED`触摸或点击事件是否可用状态<br>`SELECTED`是否选中状态<br>`CHECKED`是否勾选状态<br>`CHECKABLE`勾选是否可用状态<br>`FOCUSED`是否获得焦点状态<br>`WINDOW_FOCUSED`当前窗口是否获得焦点状态<br>`ACTIVATED`是否被激活状态<br>`HOVERED`是否勾选状态<br>具体可查看[`Selector`状态详解](https://github.com/LiangLuDev/DevShapeUtils/blob/master/Selector%E7%8A%B6%E6%80%81%E8%AF%A6%E8%A7%A3.md)
selector_text_color | string &#124; int  | 选中字体颜色（仅支持TextView及其子类）
selector_normal_text_color | string &#124; int  | 未选中字体颜色（仅支持TextView及其子类）


**PS:** 以上类型为 **`string | int`** ，颜色值可以用 **#FFFFFF 或者 @color/color**两种方式设置颜色，但是为了兼容其他属性API，如果对一个`View`使用 **#FFFFFF** 方式设置颜色值，那么对于这个View设置其他属性包含颜色设置，也必须使用 **#FFFFFF** 设置，同理 **@color/color** 也是这样。`gradient_sweep_colors和gradient_radial_colors`属性例外，始终使用`#FFFFFF|#FFFFFF`。举个例子，看代码：
```
<!--使用#FFFFFF类型-->
<TextView
    ...
    <!--使用#FFFFFF类型设置背景颜色-->
    app:solid="@{`#FFFFFF`}"
    <!--因为上面一个使用#FFFFFF类型设置颜色，所以此处也必须使用#FFFFFF类型-->
    app:line_color="@{`#FFFFFF`}"
/>

<!--使用@color/color类型-->
<TextView
    ...
    <!--使用@color/color类型设置背景颜色-->
    app:solid="@{@color/color`}"
    <!--因为上面一个使用@color/color类型设置颜色，所以此处也必须使用@color/color类型-->
    app:line_color="@{@color/color}"
/>

<!--辐射/扫描渐变颜色设置-->
<TextView
    ...
    <!--辐射/扫描渐变颜色设置例外，不会受其他颜色的影响，设置颜色类型始终不变-->
    app:gradient_radial_colors="@{`#FF4081|#3F51B5|#CCCCCC`}"
/>


```



#### 使用时容易出错的几个点

- `xml`设置`string`属性参数
```
 <TextView
    ...
    //单引号是Tab上面那个键位的单引号 
    app:line_color="@{`#000000`}"/>
```

- 渐变颜色和背景颜色不可同时设置

> 设置背景颜色同时设置渐变颜色，背景颜色会被渐变颜色所覆盖。


#### 啰嗦
由于使用`Databinding`关联布局，所以还是会有些限制（别骂我，技术太菜啦），可能使用起来并不是那么如意，遇到问题请及时反馈，我会第一时间回应，我会继续努力完善。