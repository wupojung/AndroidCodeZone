package net.wustudio.codezone;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class SharedPreferencesAvtivity extends Activity {

    TextView tvTimes;
    private static SharedPreferences sPreference;

    private static final String SHARED_KEY = "last_active";
    private static final String SHARED_NAME = "time_track";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        tvTimes = (TextView) findViewById(R.id.tvTimes);

        sPreference = getSharedPreferences(SHARED_NAME, MODE_PRIVATE);

        saveTimeStamp();
    }

    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        tvTimes.setText("" + getDiff()); //取得是差別
        saveTimeStamp();  //存時間戳記
    }

    private void saveTimeStamp() {
        sPreference.edit().putLong(SHARED_KEY, getNow()).commit();
    }

    private long getNow() {
        return Calendar.getInstance().getTimeInMillis();
    }

    private long getDiff() {
        return getNow() - sPreference.getLong(SHARED_KEY, 0);
    }

}
