# FragmentLazyLoad
Fragment懒加载
基本用法就是使用 `setUserVisibleHint` 方法然后判断`View`是否创建,否则会报空指针


**注意事项**
`setUserVisibleHint`方法，在`onCreateView`之前调用
如果在`setUserVisibleHint`,操作`View`（显示Loading）可能会出现空指针，因为还没有创建View所以要考虑在onCreateView之后
![setUserVisibleHint 生命周期关系](http://ww4.sinaimg.cn/large/65e4f1e6jw1fabkfu02joj20gk0fe79l.jpg)

还有一个问题是第一个 `Fragment` 的问题，因为第一个 `Fragment` 是 默认显示的，但是生命周期是
`setUserVisibleHint(false)` -> `setUserVisibleHint(true)` -> `onViewCreate` 导致第一个不会显示

`解决办法` 在 `onViewCreated` 或者 `onCreateView` 调用 `getUserVisibleHint` 判断是否显示
