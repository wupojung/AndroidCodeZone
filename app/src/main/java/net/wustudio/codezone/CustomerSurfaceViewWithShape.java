package net.wustudio.codezone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by wupojung on 2016/12/21.
 */

public class CustomerSurfaceViewWithShape extends SurfaceView implements SurfaceHolder.Callback {

    /*
        * 於 CustomerSurfaceView 的差別在於
        * 1)使用implements 直接實作 介面的功能，則設定Callback 時設定自己即可
        * 2)在這個範例中，我們嘗試將用程式產生Shape
         *  */

    private Paint pan2;

    public CustomerSurfaceViewWithShape(Context context) {
        super(context);

        //region //設定筆刷

        pan2 = new Paint();
        pan2.setColor(Color.YELLOW);
        pan2.setTextSize(50);
        //endregion

        getHolder().addCallback(this);// 因為這個類別已經實作介面，所以可以直接使用this 傳遞即可
    }

    private void draw() {
        try {
            Canvas canvas = getHolder().lockCanvas();   //鎖定畫布
            //region // paint somthing
            canvas.drawColor(Color.CYAN); //backgroud

            //產生自定義的圖形
            CustomerShapDrawable  customerShap = new CustomerShapDrawable();
            customerShap.draw(canvas);

            //在套文字也是可以的
            canvas.drawText(" POINTS", 50, 200, pan2);

            //endregion
            getHolder().unlockCanvasAndPost(canvas);  //釋放畫布
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //region // SurfaceHolder.Callback
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
    //endregion
}
