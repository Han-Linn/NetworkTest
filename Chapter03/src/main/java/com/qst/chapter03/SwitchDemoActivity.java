package com.qst.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.Switch;

public class SwitchDemoActivity extends AppCompatActivity {
    Switch switcher;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switch_demo);
        switcher = findViewById(R.id.switcher);
        final LinearLayout test = findViewById(R.id.test);

        OnCheckedChangeListener listener = new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton button, boolean isChecked) {
                if (isChecked) {
                    test.setOrientation(LinearLayout.VERTICAL);
                    switcher.setChecked(true);
                } else {
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    switcher.setChecked(false);
                }
            }
        };

        switcher.setOnCheckedChangeListener(listener);
    }
}
