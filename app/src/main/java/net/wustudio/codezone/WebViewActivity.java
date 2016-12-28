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
    }

    View.OnClickListener onHomePageClikc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            wvPage.loadUrl(homepage);  //直接讀取URL
        }
    };


}
