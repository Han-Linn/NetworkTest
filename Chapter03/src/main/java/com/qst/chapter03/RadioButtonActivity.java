package com.qst.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

/**
 * RadioButton和RadioGroup的使用
 */
public class RadioButtonActivity extends AppCompatActivity {
    private TextView chooseTxt;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private Button radioClearBtn;
    private Button radioAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobutton_demo);
        chooseTxt = findViewById(R.id.chooseTxt);
        radioGroup = findViewById(R.id.radioGroup);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioClearBtn = findViewById(R.id.radio_clearBtn);
        radioAddBtn = findViewById(R.id.radio_addBtn);

        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        radioClearBtn.setOnClickListener(onClickListener);
        radioAddBtn.setOnClickListener(onClickListener);
    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            int id = group.getCheckedRadioButtonId();
            switch (id) {
                case R.id.radioButton1:
                    chooseTxt.setText("我选择的是:" + radioButton1.getText());
                    break;
                case R.id.radioButton2:
                    chooseTxt.setText("我选择的是:" + radioButton2.getText());
                    break;
                default:
                    chooseTxt.setText("我选择的是:新增");
                    break;
            }
        }
    };

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.radio_clearBtn:
                    radioGroup.check(-1);
                    chooseTxt.setText("我选择的是...?");
                    break;
                case R.id.radio_addBtn:
                    RadioButton newRadio = new RadioButton(RadioButtonActivity.this);
                    newRadio.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                    newRadio.setText("新增");
                    radioGroup.addView(newRadio, radioGroup.getChildCount());
                    break;
            }
        }
    };
} 