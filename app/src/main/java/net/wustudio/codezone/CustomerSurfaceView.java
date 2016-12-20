package net.wustudio.codezone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomerSurfaceView extends SurfaceView {
    /* * * * *
        *  NOTE:  Surface 必須有SurfaceHolder.Callback 才會更新資料
        * 且Surface 有 HolderView 的概念，利用getHolder可以取得。
        * */

    private Paint pan1;
    private Paint pan2;

    public CustomerSurfaceView(Context context) {
        super(context);

        //region //設定筆刷
        pan1 = new Paint();
        pan1.setColor(Color.RED);

        pan2 = new Paint();
        pan2.setColor(Color.BLUE);
        pan2.setTextSize(25);
        //endregion

        getHolder().addCallback(callback);  //設定Call back
    }

    private void draw() {
        try {
            Canvas canvas = getHolder().lockCanvas();   //鎖定畫布
            //region // paint somthing
            canvas.drawColor(Color.BLUE);
            canvas.drawRect(0, 0, 300, 400, pan1);
            canvas.drawText(" POINTS", 0, 25, pan2);
            //endregion
            getHolder().unlockCanvasAndPost(canvas);  //釋放畫布
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            draw();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    };

}
