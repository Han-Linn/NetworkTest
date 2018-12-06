package com.qst.chapter03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Main extends AppCompatActivity {
    private Button button1, button2, button3, button4, button5, button6, button7, button8,
            button9, button10, button11, button12, button13, button14, button15, button16, button17, button18, button19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter03);
        findViewById();
        setListeners();
    }

    private void findViewById() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button13 = findViewById(R.id.button13);
        button14 = findViewById(R.id.button14);
        button15 = findViewById(R.id.button15);
        button16 = findViewById(R.id.button16);
        button17 = findViewById(R.id.button17);
        button18 = findViewById(R.id.button18);
        button19 = findViewById(R.id.button19);
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.button1:
                    intent = new Intent(Activity_Main.this, AnonymousBtnActivity.class);
                    break;
                case R.id.button2:
                    intent = new Intent(Activity_Main.this, BindTagActivity.class);
                    break;
                case R.id.button3:
                    intent = new Intent(Activity_Main.this, CheckBoxDemoActivity.class);
                    break;
                case R.id.button4:
                    intent = new Intent(Activity_Main.this, DialogDemoActivity.class);
                    break;
                case R.id.button5:
                    intent = new Intent(Activity_Main.this, EditTextDemoActivity.class);
                    break;
                case R.id.button6:
                    intent = new Intent(Activity_Main.this, EventBtnActivity.class);
                    break;
                case R.id.button7:
                    intent = new Intent(Activity_Main.this, FocusEventActivity.class);
                    break;
                case R.id.button8:
                    intent = new Intent(Activity_Main.this, ImageViewDemoActivity.class);
                    break;
                case R.id.button9:
                    intent = new Intent(Activity_Main.this, InnerClassBtnActivity.class);
                    break;
                case R.id.button10:
                    intent = new Intent(Activity_Main.this, KeyDownActivity.class);
                    break;
                case R.id.button11:
                    intent = new Intent(Activity_Main.this, KeyTouchActivity.class);
                    break;
                case R.id.button12:
                    intent = new Intent(Activity_Main.this, LayoutActivity.class);
                    break;
                case R.id.button13:
                    intent = new Intent(Activity_Main.this, MainActivity.class);
                    break;
                case R.id.button14:
                    intent = new Intent(Activity_Main.this, LoginActivity.class);
                    break;
                case R.id.button15:
                    intent = new Intent(Activity_Main.this, ProgressDemoActivity.class);
                    break;
                case R.id.button16:
                    intent = new Intent(Activity_Main.this, RadioButtonActivity.class);
                    break;
                case R.id.button17:
                    intent = new Intent(Activity_Main.this, SwitchDemoActivity.class);
                    break;
                case R.id.button18:
                    intent = new Intent(Activity_Main.this, TextViewDemoActivity.class);
                    break;
                case R.id.button19:
                    intent = new Intent(Activity_Main.this, ToggleButtonDemoActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        button1.setOnClickListener(onClick);
        button2.setOnClickListener(onClick);
        button3.setOnClickListener(onClick);
        button4.setOnClickListener(onClick);
        button5.setOnClickListener(onClick);
        button6.setOnClickListener(onClick);
        button7.setOnClickListener(onClick);
        button8.setOnClickListener(onClick);
        button9.setOnClickListener(onClick);
        button10.setOnClickListener(onClick);
        button11.setOnClickListener(onClick);
        button12.setOnClickListener(onClick);
        button13.setOnClickListener(onClick);
        button14.setOnClickListener(onClick);
        button15.setOnClickListener(onClick);
        button16.setOnClickListener(onClick);
        button17.setOnClickListener(onClick);
        button18.setOnClickListener(onClick);
        button19.setOnClickListener(onClick);

    }
}
