package com.qst.chapter03;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * 演示ToggleButton的用法
 */
public class ToggleButtonDemoActivity extends AppCompatActivity {
    private ToggleButton mToggleButton;
    private TextView tvSound;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.togglebutton_demo);
        mToggleButton = findViewById(R.id.tglSound);
        tvSound = findViewById(R.id.tvSound);
        initView();
    }

    private void initView() {
        mToggleButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tvSound.setText("已开启");
                } else {
                    tvSound.setText("已关闭");
                }
            }
        });
    }
}
