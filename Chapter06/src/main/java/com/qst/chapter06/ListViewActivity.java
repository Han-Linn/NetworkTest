package com.qst.chapter06;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminstrator on 2016/10/9.
 */
public class ListViewActivity extends AppCompatActivity implements AbsListView.OnScrollListener{
    List<String> items=new ArrayList<String>();
    private ListView listView;
    private int visibleLastIndex = 0;  //最后的可视项索引
    private int visibleItemCount;  //当前窗口可见项总数
    private ListViewAdapter adapter;
    private View loadMoreView;
    private Button loadMoreButton;
    private Handler handler= new Handler();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        loadMoreView =getLayoutInflater().inflate(R.layout.load_more,null);
        loadMoreButton= (Button) loadMoreView.findViewById(R.id.loadMoreButton);
        loadMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadMoreButton.setText("正在加载...");  //设置按钮文字loading
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        adapter.notifyDataSetChanged(); //数据集变化后，通知adapter
                        listView.setSelection(visibleLastIndex-visibleItemCount+1); //设置选中项

                        loadMoreButton.setText("加载更多"); //恢复按钮文字
                    }
                },3000);
            }
        });
        listView= (ListView) this.findViewById(R.id.listView1);
        listView.addFooterView(loadMoreView); //设置列表顶部视图
        initAdapter();
        listView.setAdapter(adapter);   //自动为id是list的ListView设置适配器

        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>arg0, View view, int position, long arg3) {
                Toast.makeText(getApplicationContext(),items.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *初始化适配器
     */
    private void initAdapter(){
        for (int i=0;i<12;i++){
            items.add("用户编号："+String.valueOf(i+1));
        }
        adapter=new ListViewAdapter(items,this);
    }
    /**
     *滑动时被调用
     */

    @Override
    public void onScroll(AbsListView view, int firstVisivleItem, int visibleItemCount, int totalItemCount) {
        this.visibleItemCount=visibleItemCount;
        visibleLastIndex=firstVisivleItem+visibleItemCount-1;
    }
    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        int itemLastIndex = adapter.getCount() - 1;  //数据集最后一项的索引
        int lastIndex = itemLastIndex + 1;    //加上底部的loadMoreView项
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_FLING && visibleLastIndex == lastIndex) {
            //如果是自动加载，可以再这里防止异步加载数据的代码
            Log.i("LOADMORE","loading");
        }
    }

    /**
     * 模拟加载数据
     */
    private void loadData(){
        int count=adapter.getCount();
        for(int i =count;i<count+10;i++){
            adapter.addItem("用户编号："+String.valueOf(i+1));
        }
    }
}
