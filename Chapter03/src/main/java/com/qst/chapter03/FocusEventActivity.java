package com.qst.chapter03;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FocusEventActivity extends AppCompatActivity {
    //定义4个button
    FocusButton focusButton1;
    FocusButton focusButton2;
    FocusButton focusButton3;
    FocusButton focusButton4;

    // 声明myButton04的引用
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        focusButton1 = new FocusButton(this);
        focusButton2 = new FocusButton(this);
        focusButton3 = new FocusButton(this);
        focusButton4 = new FocusButton(this);
        focusButton1.setText("focusButton1");
        focusButton2.setText("focusButton2");
        focusButton3.setText("focusButton3");
        focusButton4.setText("focusButton4");
        // 创建一个线性布局
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(focusButton1);
        linearLayout.addView(focusButton2);
        linearLayout.addView(focusButton3);
        linearLayout.addView(focusButton4);
        setContentView(linearLayout);
    }

    class FocusButton extends Button{
        public FocusButton(Context context) {
            super(context);
        }

        protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
            String suffix = "(选中)";
            String text = getText().toString();

            if (focused) {
                //获取焦点时，添加(选中)文字
                if (!text.contains(suffix)) {
                    this.setText(text + suffix);
//					Log.d("点击事件","true");
					Toast.makeText(getContext(), "获取焦点", Toast.LENGTH_SHORT).show();
                }
            } else {
                //去掉(选中)文字
                if (text.contains(suffix)) {
                    text = text.substring(0, text.length() - suffix.length());
                    this.setText(text);
                }
            }
            super.onFocusChanged(focused, direction, previouslyFocusedRect);
        }
    }
}
