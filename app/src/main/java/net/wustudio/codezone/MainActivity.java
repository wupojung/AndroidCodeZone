package net.wustudio.codezone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    enum eButtonAction {
        CUSTOMER_SHAPE_DRAWABLE,
        CUSTOMER_SURFACE_VIEW,
        CUSTOMER_SURFACE_VIEW_WITH_SHAPE,
        TOUCH_EVENT_DEMO,
        SCORE_VIEW,
        OPEN_CAMERA,
        WEB_VIEW_DEMO,
        SHARED_PREFERENCES,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //取得ID
        LinearLayout llMenu = (LinearLayout) findViewById(R.id.llMenu);

        //新增
        // llMenu.addView(getButton(eButtonAction.CUSTOMER_SHAPE_DRAWABLE));
        // llMenu.addView(getButton(eButtonAction.CUSTOMER_SURFACE_VIEW));
        // llMenu.addView(getButton(eButtonAction.CUSTOMER_SURFACE_VIEW_WITH_SHAPE));

        // llMenu.addView(getButton(eButtonAction.TOUCH_EVENT_DEMO));
        // llMenu.addView(getButton(eButtonAction.SCORE_VIEW));
        //llMenu.addView(getButton(eButtonAction.OPEN_CAMERA));
        //llMenu.addView(getButton(eButtonAction.WEB_VIEW_DEMO));
        llMenu.addView(getButton(eButtonAction.SHARED_PREFERENCES));
    }


    private Button getButton(eButtonAction action) {
        Button btn = new Button(getApplicationContext());
        btn.setTag(action); //利用Tag 傳遞資料
        switch (action) {
            case CUSTOMER_SHAPE_DRAWABLE:
                btn.setText("Customer ShapeDrawable");
                btn.setId(R.id.customer_view);  //自ids.xml 中取得
                break;
            case CUSTOMER_SURFACE_VIEW:
                btn.setText("Customer SurfaceView");
                break;
            case CUSTOMER_SURFACE_VIEW_WITH_SHAPE:
                btn.setText("Customer SurfaceView with Shape");
                break;
            case TOUCH_EVENT_DEMO:
                btn.setText("Touch Event Demo");
                break;
            case SCORE_VIEW:
                btn.setText("Score List View Demo");
                break;
            case OPEN_CAMERA:
                btn.setText("Open Camera Demo");
                break;
            case WEB_VIEW_DEMO:
                btn.setText("Web View Demo");
                break;
            case SHARED_PREFERENCES:
                btn.setText("Shared Preferences Demo");
                break;

        }
        btn.setOnClickListener(onClickListener);

        return btn;
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();

            //region //根據不同類別 設定資料，注意必須配合接受端的解析
            eButtonAction action = (eButtonAction) v.getTag();
            switch (action) {
                case CUSTOMER_SHAPE_DRAWABLE:
                    intent.putExtra("type", "shape");
                    break;
                case CUSTOMER_SURFACE_VIEW:
                    intent.putExtra("type", "surface_view");
                    break;
                case CUSTOMER_SURFACE_VIEW_WITH_SHAPE:
                    intent.putExtra("type", "surface_view_shape");
                    break;
                case TOUCH_EVENT_DEMO:
                    intent.setClass(MainActivity.this, TouchEventDemo.class);
                    startActivity(intent);
                    return;
                case SCORE_VIEW:
                    intent.setClass(MainActivity.this, ScoreActivity.class);
                    startActivity(intent);
                    return;
                case OPEN_CAMERA:
                    intent.setClass(MainActivity.this, CameraActivity.class);
                    startActivity(intent);
                    return;
                case WEB_VIEW_DEMO:
                    intent.setClass(MainActivity.this, WebViewActivity.class);
                    startActivity(intent);
                    return;
                case SHARED_PREFERENCES:
                    intent.setClass(MainActivity.this, SharedPreferencesAvtivity.class);
                    startActivity(intent);
                    return;
            }
            //endregion

            intent.setClass(MainActivity.this, CustomerViewDemo.class);
            startActivity(intent);
        }
    };


}
