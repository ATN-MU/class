---
typora-root-url: readme_img
---

`Android Activity`
# 正常情况下的生命周期 #
- onCreate：与onDestroy配对，表示Activity正在被创建，这是生命周期的第一个方法。在这个方法中可以做一些初始化的工作（加载布局资源、初始化Activity所需要的数据等），耗时的工作在异步线程上完成。
- onRestart：表示Activity正在重新启动。一般情况下，在当前Activity从不可见重新变为可见的状态时onRestart就会被调用。这种情形一般是由于用户的行为所导致的，比如用户按下Home键切换到桌面或者打开了一个新的Activity（这时当前Activity会暂停，也就是onPause和onStop被执行），接着用户有回到了这个Activity，就会出现这种情况。
- onStart：与onStop配对，表示Activity正在被启动，并且即将开始。但是这个时候要注意它与onResume的区别。两者都表示Activity可见，但是onStart时Activity还正在加载其他内容，正在向我们展示，用户还无法看到，即无法交互。
- onResume：与onPause配对，表示Activity已经创建完成，并且可以开始活动了，这个时候用户已经可以看到界面了，并且即将与用户交互（完成该周期之后便可以响应用户的交互事件了）。
- onPause：与onResume配对，表示Activity正在暂停，正常情况下，onStop接着就会被调用。在特殊情况下，如果这个时候用户快速地再回到当前的Activity,那么onResume会被调用（极端情况）。一般来说，在这个生命周期状态下，可以做一些存储数据、停止动画的工作，但是不能太耗时，如果是由于启动新的Activity而唤醒的该状态，那会影响到新Activity的显示，原因是onPause必须执行完，新的Activity的onResume才会执行。
- onStop：与onStart配对，表示Activity即将停止，可以做一些稍微重量级的回收工作，同样也不能太耗时（可以比onPause稍微好一点）。
- onDestroy：与onCreate配对，表示Activity即将被销毁，这是Activity生命周期的最后一个回调，我们可以做一些回收工作和最终的资源释放（如Service、BroadReceiver、Map等）。

**正常情况下，Activity的常用生命周期就是上面的7个，下图更加详细的描述的各种生命周期的切换过程：**

![Activity](/Activity.png)

查看 `Logcat`

```
03-28 09:34:23.149 5415-5415/com.example.administrator.activity E/MainActivity: onStart() is invoked！
03-28 09:34:23.151 5415-5415/com.example.administrator.activity E/MainActivity: onResume() is invoked！
03-28 09:34:26.264 5415-5415/com.example.administrator.activity E/MainActivity: onPause() is invoked！
03-28 09:34:30.170 5415-5415/com.example.administrator.activity E/MainActivity: onRestart() is invoked！
03-28 09:34:30.170 5415-5415/com.example.administrator.activity E/MainActivity: onStart() is invoked！
03-28 09:34:30.171 5415-5415/com.example.administrator.activity E/MainActivity: onResume() is invoked！
03-28 09:35:10.094 5415-5415/com.example.administrator.activity E/MainActivity: onPause() is invoked！
```

[参考网址](https://blog.csdn.net/woshimalingyi/article/details/50961380) https://blog.csdn.net/woshimalingyi/article/details/50961380