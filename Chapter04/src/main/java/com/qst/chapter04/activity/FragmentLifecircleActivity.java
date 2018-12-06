package com.qst.chapter04.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.qst.chapter04.R;
import com.qst.chapter04.fragment.FragmentA;
import com.qst.chapter04.fragment.FragmentB;

public class FragmentLifecircleActivity extends AppCompatActivity implements View.OnClickListener {
    //声明Fragment管理器
    private FragmentManager fragmentManager;
    //声明变量
    private Button fragABtn;
    private Button fragBBtn;
    //Fragments
    private FragmentA fragmentA;
    private FragmentB fragmentB;
    //Fragment名称列表
    private String[] fragNames = {"FragmentA", "FragmentB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frg_life);
        //初始化Fragment管理器
        fragmentManager = getFragmentManager();
        //初始化组件
        fragABtn = findViewById(R.id.fragABtn);
        fragBBtn = findViewById(R.id.fragBBtn);
        //设置事件监听器
        fragABtn.setOnClickListener(this);
        fragBBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.fragABtn:

                if (fragmentA == null) {
                    fragmentA = new FragmentA();
                    fragmentTransaction.replace(R.id.frag_container, fragmentA, fragNames[0]);
                    //把Fragment对象添加到Back栈中
                    fragmentTransaction.addToBackStack(fragNames[0]);
                } else {
                    Fragment fragment = fragmentManager.findFragmentByTag(fragNames[0]);
                    fragmentTransaction.replace(R.id.frag_container, fragment, fragNames[0]);
                }
                break;
            case R.id.fragBBtn:
                if (fragmentB == null) {
                    fragmentB = new FragmentB();
                    fragmentTransaction.replace(R.id.frag_container, fragmentB, fragNames[1]);
                    //把Fragment对象添加到Back栈中
                    fragmentTransaction.addToBackStack(fragNames[1]);
                } else {
                    Fragment fragment = fragmentManager.findFragmentByTag(fragNames[1]);
                    fragmentTransaction.replace(R.id.frag_container, fragment, fragNames[1]);
                }
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }

}

