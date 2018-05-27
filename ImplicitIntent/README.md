
## 隐式Intent使用--打开Android默认浏览器

使用隐式Intent，在AndroidManifest.xml通过在<activity>标签下配置<intent-filter>的内容，可以指定当前活动能够响应的action和category，我们不仅可以启动自己程序内的活动，还可以启动其他程序的活动，比如调用系统的浏览器来打开某网页

```
Intent intent = new Intent(Intent.ACTION_VIEW);    //为Intent设置Action属性
intent.setData(Uri.parse("http://www.baidu.com")); //为Intent设置DATA属性
startActivity(intent);
```

Intent.ACTION_VIEW，这是一个Android系统内置的动作，其常量值为android.intent.action.VIEW。然后通过Uri.parse()方法，将一个网址字符串解析成一个Uri对象，再调用Intent的setData()方法将这个Uri对象传递进去。

 在AndroidManifest.xml中为Activity进行注册。

```
<intent-filter>
　　<action android:name="android.intent.action.VIEW" />
　　<category android:name="android.intent.category.DEFAULT" />
　　<data android:scheme="http" />       <!--响应所有的http协议的Intent-->
</intent-filter>
```

运行后就可以看到打开了系统浏览器。

## WebViewClient中函数概述

在WebViewClient中除了上面我们列举出的onPageStarted、onPageFinished还有很多其它函数，分别是：

```
/** 
 * 在开始加载网页时会回调 
 */  
public void onPageStarted(WebView view, String url, Bitmap favicon)   
/** 
 * 在结束加载网页时会回调 
 */  
public void onPageFinished(WebView view, String url)  
/** 
 * 拦截 url 跳转,在里边添加点击链接跳转或者操作 
 */  
public boolean shouldOverrideUrlLoading(WebView view, String url)  
/** 
 * 加载错误的时候会回调，在其中可做错误处理，比如再请求加载一次，或者提示404的错误页面 
 */  
public void onReceivedError(WebView view, int errorCode,String description, String failingUrl)  
/** 
 * 当接收到https错误时，会回调此函数，在其中可以做错误处理 
 */  
public void onReceivedSslError(WebView view, SslErrorHandler handler,SslError error)  
/** 
 * 在每一次请求资源时，都会通过这个函数来回调 
 */  
public WebResourceResponse shouldInterceptRequest(WebView view,  
        String url) {  
    return null;  
}  
```

隐形Intent参考链接：https://www.cnblogs.com/qyping/p/4923518.html

WebView参考链接：https://blog.csdn.net/harvic880925/article/details/51523983

Google参考文献：https://developer.android.google.cn/guide/components/intents-filters



## 实验结果截图

![1](https://github.com/ATN-MU/class/blob/master/ImplicitIntent/image/1.png)

![2](https://github.com/ATN-MU/class/blob/master/ImplicitIntent/image/2.png)
