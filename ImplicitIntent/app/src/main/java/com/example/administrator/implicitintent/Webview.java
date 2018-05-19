package com.example.administrator.implicitintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;

public class Webview extends AppCompatActivity {
    private WebView webview;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        String url = getIntent().getExtras().toString();
        webview = (WebView)findViewById(R.id.view);
        //开启 localStorage
        webview.getSettings().setDomStorageEnabled(true);
        // 设置支持javascript
        webview.getSettings().setJavaScriptEnabled(false);
        // 启动缓存
        webview.getSettings().setAppCacheEnabled(true);
        // 设置缓存模式
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webview.loadUrl(url);
        //使用自定义的WebViewClient
        webview.setWebViewClient(new WebViewClient()
        {
            //覆盖shouldOverrideUrlLoading 方法
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url)
            {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
