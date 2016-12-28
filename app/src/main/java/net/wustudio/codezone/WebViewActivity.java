package net.wustudio.codezone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class WebViewActivity extends Activity {
    Button btnHomePage;
    WebView wvPage;
    String homepage = "http://www.wustudio.net";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        //綁UI - Button
        btnHomePage = (Button) findViewById(R.id.btnHomePage);
        btnHomePage.setOnClickListener(onHomePageClikc);
        //綁UI - WebView
        wvPage = (WebView) findViewById(R.id.wvPage);
        //regon //設定WebView
        //官方文件:  https://developer.android.com/reference/android/webkit/WebSettings.html
        //其他設定：
        wvPage.getSettings().setBuiltInZoomControls(true);//開啟內建縮放功能
        wvPage.getSettings().setJavaScriptEnabled(true);//允許Javascript 生效

        //cashe
        //官方文件: https://developer.android.com/reference/android/webkit/WebSettings.html#LOAD_CACHE_ELSE_NETWORK
        //wvPage.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //強制使用本地的Cache
        wvPage.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);  //不使用cache
        //wvPage.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ONLY);  //限定使用cache(不使用網路)
        //wvPage.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT); //預設，注意：沒有網路會爆錯 (沒給權限 = 沒有網路)
        //endregion
    }

    View.OnClickListener onHomePageClikc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            wvPage.loadUrl(homepage);  //直接讀取URL
        }
    };


}
