package com.qst.chapter04.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.qst.chapter04.R;
import com.qst.chapter04.adapter.TextImageAdapter;

public class ListVewImageDemoActivity extends AppCompatActivity {
    private String[] texts = new String[]{"樱花", "小鸡", "坚果"};
    private int[] images = new int[]{R.mipmap.cherry_blossom, R.mipmap.chicken, R.mipmap.chestnut};
    ListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_image);
        mListView = findViewById(R.id.list_image);
        TextImageAdapter adapter = new TextImageAdapter(this, texts, images);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListVewImageDemoActivity.this, "您选择了" + texts[position], Toast.LENGTH_LONG).show();
            }
        });


    }
}
