package net.wustudio.codezone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class CustomerViewDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取得傳遞過來的數據
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        //嘗試解析
        switch (type.toLowerCase().trim()) {
            case "shape"://full view
                setContentView(new CustomerView(this));
                break;
            case "surface_view":
                setContentView(new CustomerSurfaceView(this));
                break;
            case "surface_view_shape":
                setContentView(new CustomerSurfaceViewWithShape(this));
                break;
        }


    }
}
