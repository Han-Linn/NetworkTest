package com.qst.chapter02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

public class Assets_ActivityDemo extends AppCompatActivity {
    ImageView iv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assets_layout);
        iv = (ImageView) findViewById(R.id.im1);
        System.out.println(iv);
        try {
            InputStream is = getResources().getAssets().open("android.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(is);
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
