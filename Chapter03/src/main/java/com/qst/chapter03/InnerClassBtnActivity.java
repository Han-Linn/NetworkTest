package com.qst.chapter03;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

//实现事件监听器接口
public class InnerClassBtnActivity extends AppCompatActivity {
    //点击Button
    private Button clickBtn;
    //文字显示
    private TextView showTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_btn);
        showTxt = findViewById(R.id.showTxt);
        clickBtn = findViewById(R.id.clickBtn);
        clickBtn.setOnClickListener(new ClickListener());
    }

    class ClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            showTxt.setText("btn按钮被单击了！");
        }
    }
}
