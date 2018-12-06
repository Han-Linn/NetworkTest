package com.qst.chapter04.activity;

import com.qst.chapter04.R;
import com.qst.chapter04.R.id;
import com.qst.chapter04.R.layout;
import com.qst.chapter04.fragment.RightFragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 用于演示Fragment的使用
 */
public class FragmentDemoActivity extends AppCompatActivity {
    Button displayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
        displayBtn = findViewById(R.id.displayBtn);
        displayBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // 步骤1：添加一个FragmentTransaction的实例
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                // 步骤2：用add()方法加上Fragment的对象rightFragment
                RightFragment rightFragment = new RightFragment();
                transaction.add(R.id.right, rightFragment);
                // 步骤3：调用commit()方法使得FragmentTransaction实例的改变生效
                transaction.commit();
            }
        });
    }

}
