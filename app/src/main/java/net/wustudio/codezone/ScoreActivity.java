package net.wustudio.codezone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ScoreActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //模擬資料
        List<ScoreData> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new ScoreData("" + (i+1), "username" + i, 9999999-i * 1000));
        }

        //讀取ListView, 並利用 Adapter 填資料
        ListView lvScore = (ListView) findViewById(R.id.lvScore);
        ScoreAdapter adapter = new ScoreAdapter(this, list);
        lvScore.setAdapter(adapter);

        //直接設定Back 按鈕的功能
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
