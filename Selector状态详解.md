### Selector状态详解
> `Selector`状态使用方式和效果解释
- **`DevSelector.STATE_PRESSED`：** 对应`android:state_pressed`,设置是否按压状态，一般在true时设置该属性，表示已按压状态，默认为false
- **`DevSelector.STATE_ENABLED`：** 对应`android:state_enabled`,设置触摸或点击事件是否可用状态，一般只在false时设置该属性，表示不可用状态
- **`DevSelector.STATE_SELECTED`：** 对应`android:state_selected`,设置是否选中状态，true表示已选中，false表示未选中
- **`DevSelector.STATE_CHECKED`：** 对应`android:state_checked`,设置是否勾选状态，主要用于CheckBox和RadioButton，true表示已被勾选，false表示未被勾选
- **`DevSelector.STATE_CHECKABLE`：** 对应`android:state_checkable`,设置勾选是否可用状态，类似state_enabled，只是state_enabled会影响触摸或点击事件，而state_checkable影响勾选事件
- **`DevSelector.STATE_FOCUSED`：** 对应`android:state_focused`,设置是否获得焦点状态，true表示获得焦点，默认为false，表示未获得焦点
- **`DevSelector.STATE_WINDOW_FOCUSED`：** 对应`android:state_window_focused`,设置当前窗口是否获得焦点状态，true表示获得焦点，false表示未获得焦点，例如拉下通知栏或弹出对话框时，当前界面就会失去焦点
- **`DevSelector.STATE_ACTIVATED`：** 对应`android:state_activated`,设置是否被激活状态，true表示被激活，false表示未激活，API Level 11及以上才支持，可通过代码调用控件的setActivated(boolean)方法设置是否激活该控件
- **`DevSelector.STATE_HOVERED`：** 对应`android:android:state_hovered`,设置是否勾选状态，主要用于CheckBox和RadioButton，true表示已被勾选，false表示未被勾选