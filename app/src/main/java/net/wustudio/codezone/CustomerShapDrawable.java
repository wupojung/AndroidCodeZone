package net.wustudio.codezone;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

public class CustomerShapDrawable extends ShapeDrawable {
    private Paint mPaint;

    public CustomerShapDrawable() {
        super(new RectShape());

        //設定畫筆
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        //設定邊界
        this.setBounds(0, 0, 100, 100);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(this.getBounds(), mPaint);
    }
}
