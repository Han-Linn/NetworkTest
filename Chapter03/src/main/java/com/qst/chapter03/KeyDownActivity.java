package com.qst.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.EditText;

public class KeyDownActivity extends AppCompatActivity {
    EditText showText;

    public void onCreate(Bundle savedInstanceState) { // 重写的onCreate方法
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keydown_btn);
        showText = findViewById(R.id.showTxt);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                showText.setText("点击了【回退键】");
                break;
            case KeyEvent.KEYCODE_A:
                showText.setText("点击了【 A键】");
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                showText.setText("点击了【 音量-】");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                showText.setText("点击了【 音量+】");
                break;
        }
        return true;
    }
}
