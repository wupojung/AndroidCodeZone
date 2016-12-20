package net.wustudio.codezone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //取得ID
        LinearLayout llMenu = (LinearLayout) findViewById(R.id.llMenu);

        //按鈕
        Button btn = new Button(this);
        btn.setText("Test");//指定文字
        btn.setOnClickListener(new View.OnClickListener() {//指定OnClick Event
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Test On Click", Toast.LENGTH_SHORT).show();
            }
        });

        //新增
        llMenu.addView(btn);
    }


}
