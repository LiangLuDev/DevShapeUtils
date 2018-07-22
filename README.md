# DevShapeUtils开源库

> **项目初衷：** 公司项目样式文件n+1个，多人开发文件命名各种各样，每次都要搜索半天，我也在网上看了很多类似样式设置库，大多数都是自定义View，我想View还是原生的好，如果以后要针对View做一些骚操作，可能会有些影响，所以我一直秉承着不自定义View。起初我想代码直接设置样式，比较方便一点，就在闲暇时间写了这个项目，代码直接设置样式，没有太多的属性需要设置，使用简单、为了更方便、快捷、省时的项目开发。



### 公告
> 最开始的代码设置样式的雏形虽然很简便，然而还是会有些不方便的地方，有朋友也反馈这个问题。经过一段时间的整理和朋友的建议，终于支持XML设置样式了。可能会存在一下问题，请大家及时反馈。[XML设置文档]()

### 1、功能介绍
-------------------
- **Shape样式：** 圆形、圆角、边框、虚线边框、颜色渐变
- **Selector样式：** 触摸背景变化、触摸字体颜色变化


### 2、如何使用
-------------------
#### 2.1 Android Studio导入方法，添加Gradle依赖
在项目的 ``` build.gradle ``` 添加:
``` java
android {
    defaultConfig {
        ...
        minSdkVersion 16
        ...
    }
}

dependencies {
        ...
        implementation 'cn.luliangdev:DevShapeUtils:1.1.0'
        }
```
**PS:项目中minSdkVersion设置为16（Android4.1），不然编译通不过。（现在的手机版本基本都在4.4以上）**

#### 2.2 在项目`Application`中初始化
``` java
public class DevApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DevShapeUtils.init(this);
    }
}
```
#### 2.3 颜色设置
- **`R.color.xxx`** `color`资源文件
- **`#FFFFFF`** 16进制`RGB`色值
- **`#33000000`** 16进制`ARGB`色值（`33`表示`80%`透明度，具体可查看[透明度参照表](https://blog.csdn.net/hewuzhao/article/details/78821954)）
#### 2.4 单位设置
> 项目中所有的数值单位为 **`dp`**


#### 2.5 样式设置使用文档
- [代码设置文档]()
- [XML设置文档]()


### 3、更多功能
[**更新日志**]()

> 由于用户反馈，后面该库会持续更新、完善、增加新的功能，尽量支持日常使用的所有场景，欢迎反馈。

- 支持XML设置样式
- 增加Shape的另外两种类型Line和Ring
- 背景支持图片
- 样式支持阴影（阴影颜色根据背景颜色）


### 4、意见反馈
此库目前适用于大部分常用场景，如果遇到问题或者好的建议，请反馈到：issue、927195249@qq.com 或者LiangLuDev@gmail.com

如果觉得对你有用的话，点一下右上的星星赞一下吧!


## License
-------------------
> Copyright 2018 Liang_Lu

> Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

> http://www.apache.org/licenses/LICENSE-2.0

> Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

