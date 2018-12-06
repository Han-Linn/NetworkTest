package com.qst.chapter07;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Adminstrator on 2016/10/10.
 */
public class FirstProvideActivity extends AppCompatActivity {
    ContentResolver contentResolver;
    Uri uri=Uri.parse("content://com.qst.chapter07.firstprovider/tablename");
    Button insert,delete,update,query;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取系统的ContentResolver对象
        contentResolver=getContentResolver();
        insert= (Button) findViewById(R.id.insert);
        delete= (Button) findViewById(R.id.delete);
        update= (Button) findViewById(R.id.update);
        query= (Button) findViewById(R.id.find);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(view);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete(view);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update(view);
            }
        });

        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                query(view);
            }
        });
    }
    public void query(View source){
        //调用ContentReslver的query()方法
        //实际返回的是该Uri对应的ContentProvider的query()的返回值
        Cursor c=contentResolver.query(uri,null,"query_where",null,null);
        Toast.makeText(this,"远程ContentProvide返回的Cursor为："+c,Toast.LENGTH_SHORT).show();
    }

    public void insert(View source){
        ContentValues values=new ContentValues();
        values.put("name","QST青软实训");
        //调用ContentResolver的insert()方法。
        //实际返回的是该Uri对应的ContentProvider的insert()的返回值
        Uri newUri=contentResolver.insert(uri,values);
        Toast.makeText(this,"远程ContentProvide新插入记录的Uri为："+newUri,Toast.LENGTH_SHORT).show();
    }

    public void update(View source){
        ContentValues values=new ContentValues();
        values.put("name","QST青软实训");
        //调用ContentResolver的update()方法。
        //实际返回的是该Uri对应的ContentProvider的update()的返回值
        int count=contentResolver.update(uri,values,"update_where",null);
        Toast.makeText(this,"远程ContentProvide更新记录数为："+count,Toast.LENGTH_SHORT).show();
    }

    public void delete(View source){
        //调用ContentResolver的delete()方法。
        //实际返回的是该Uri对应的ContentProvider的delete()的返回值
        int count=contentResolver.delete(uri,"delete_where",null);
        Toast.makeText(this,"远程ContentProvide删除记录数为："+count,Toast.LENGTH_SHORT).show();
    }
}
