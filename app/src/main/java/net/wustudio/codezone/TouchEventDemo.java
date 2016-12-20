package net.wustudio.codezone;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class TouchEventDemo extends Activity {
    private static String TAG = "TouchEventDemo";

    private TextView tvMsg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        TextView tvMsg = new TextView(this);
        tvMsg.setText("Hi");
        tvMsg.setTextColor(getResources().getColor(R.color.colorAccent));
        RelativeLayout root = (RelativeLayout) findViewById(R.id.rlRoot);
        root.addView(tvMsg);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TAG, String.format("Touch Action : %d  offset[%f , %f]", event.getAction(), event.getX(), event.getY()));
        return super.onTouchEvent(event);
    }
}
