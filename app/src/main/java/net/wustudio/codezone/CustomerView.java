package net.wustudio.codezone;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

public class CustomerView extends View {
    private ShapeDrawable shapeDrawable; //自行定義形狀

    public CustomerView(Context context) {
        super(context);

        //新建形狀，可以參考  https://developer.android.com/reference/android/graphics/drawable/shapes/Shape.html
        shapeDrawable = new ShapeDrawable(new RectShape()); //矩形
        //shapeDrawable = new ShapeDrawable(new OvalShape());  //圓形
        //設定邊界
        shapeDrawable.setBounds(0, 0, 100, 100);
        //註:如果要上色，必須藉由 Paint 進行
        //Paint paint = new Paint();  //無法這樣用哦～
        Paint paint = shapeDrawable.getPaint();   //重原本的形狀重取得畫筆
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //super.onDraw(canvas);
        shapeDrawable.draw(canvas);
    }
}

