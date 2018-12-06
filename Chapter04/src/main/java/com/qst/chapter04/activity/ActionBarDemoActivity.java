package com.qst.chapter04.activity;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ActionBarDemoActivity extends Activity implements OnNavigationListener {
    //下拉菜单的数组
    final String[] data = new String[]{"Java", "Android", "Oracle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建普通的ArrayAdapter对象
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, data);
        //获取ActionBar对象
        ActionBar actionBar = this.getActionBar();
        //设置导航风格
//		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//		actionBar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP);
        //设置回调方法
//		actionBar.setListNavigationCallbacks(adapter,this);

    }

    //定义导航监听器
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        String tmp = data[itemPosition];
        Toast.makeText(ActionBarDemoActivity.this, "你选择了：" + tmp, Toast.LENGTH_SHORT).show();
        return true;
    }
}
