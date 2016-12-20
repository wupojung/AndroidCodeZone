package net.wustudio.codezone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    enum eButtonAction {
        CUSTOMER_SHAPE_DRAWABLE,
        CUSTOMER_SURFACE_VIEW,
        CUSTOMER_SURFACE_VIEW_WITH_SHAPE,
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //取得ID
        LinearLayout llMenu = (LinearLayout) findViewById(R.id.llMenu);

        //新增
        llMenu.addView(getButton(eButtonAction.CUSTOMER_SHAPE_DRAWABLE));
        llMenu.addView(getButton(eButtonAction.CUSTOMER_SURFACE_VIEW));
        llMenu.addView(getButton(eButtonAction.CUSTOMER_SURFACE_VIEW_WITH_SHAPE));
    }


    private Button getButton(eButtonAction action) {
        Button btn = new Button(getApplicationContext());
        btn.setTag(action); //利用Tag 傳遞資料
        switch (action) {
            case CUSTOMER_SHAPE_DRAWABLE:
                btn.setText("Customer ShapeDrawable");
                break;
            case CUSTOMER_SURFACE_VIEW:
                btn.setText("Customer SurfaceView");
                break;
            case CUSTOMER_SURFACE_VIEW_WITH_SHAPE:
                btn.setText("Customer SurfaceView with Shape");
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
            }
            //endregion

            intent.setClass(MainActivity.this, CustomerViewDemo.class);
            startActivity(intent);
        }
    };


}
