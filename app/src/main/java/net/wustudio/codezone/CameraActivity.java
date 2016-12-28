package net.wustudio.codezone;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends Activity {

    static int CAMER_ID = 100;  //這裡可以才用xml 來定義。
    Button btnGet;
    ImageView ivCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        //綁定資料
        btnGet = (Button) findViewById(R.id.btnGet);
        btnGet.setOnClickListener(onGetClick);

        //綁定ImageView
        ivCamera = (ImageView) findViewById(R.id.ivCamera);

    }

    View.OnClickListener onGetClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMER_ID);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == CAMER_ID) {
            Bundle extras = data.getExtras();   //提取資料
            Bitmap bmp = (Bitmap) extras.get("data"); //轉換bitmap
            ivCamera.setImageBitmap(bmp); //設定UI
        } else {
            Toast.makeText(this, "沒有拍到東西喔~", Toast.LENGTH_SHORT).show();
        }

    }
}
