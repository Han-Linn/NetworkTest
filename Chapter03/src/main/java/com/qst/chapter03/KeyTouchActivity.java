package com.qst.chapter03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

/**
 * 该类用于演示OnTouchEvent的使用
 */
public class KeyTouchActivity extends AppCompatActivity {
    TouchView touchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        touchView = new TouchView(this);
        setContentView(touchView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) { // 重写的onTouchEvent回调方法
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN://手指按下
                touchView.x = (int) event.getX();
                touchView.y = (int) event.getY() - 52;
                touchView.postInvalidate();
                break;
            case MotionEvent.ACTION_MOVE: //手指移动
                touchView.x = (int) event.getX();
                touchView.y = (int) event.getY() - 52;
                touchView.postInvalidate();
                break;
            case MotionEvent.ACTION_UP://手指抬起
                touchView.x = -100;
                touchView.y = -100;
                touchView.postInvalidate();
                break;
        }
        return super.onTouchEvent(event);
    }

    class TouchView extends View {
        Paint paint;
        int x = 300;
        int y = 300;
        int width = 100;

        public TouchView(Context context) {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.LTGRAY);
            canvas.drawRect(x, y, x + width, y + width, paint);
            super.onDraw(canvas);
        }
    }
}
