package com.qst.chapter07;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by Adminstrator on 2016/10/11.
 */
public class MediaStoreActivity extends AppCompatActivity {
    Button add;
    Button view;
    ListView show;
    ArrayList<String> ids = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> filePaths = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media);
        add = (Button) findViewById(R.id.add);
        view = (Button) findViewById(R.id.view);
        show = (ListView) findViewById(R.id.show);

        //为view按钮的单击事件绑定监听器
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //清空ids、names、fileName集合里原有的数据
                ids.clear();
                names.clear();
                fileNames.clear();
                filePaths.clear();
                //通过ContentResolver查询所有图片信息
                Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
                while (cursor.moveToNext()) {
                    //获取图片的ID
                    String id = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media._ID));
                    //获取图片的DISPLAY_NAME
                    String name = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME));
                    //获取图片的TITLE
                    String title=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.TITLE));
                    //获取图片的保存位置的数据
                    byte[] data = cursor.getBlob(cursor.getColumnIndex(MediaStore.Images.Media.DATA)
                    );
                    //将图片名添加到ids集合中
                    ids.add(id);
                    //将图片DISPLAY_NAME添加到names集合中
                    names.add(name);
                    //将图片TITLE添加到flieNames集合中
                    fileNames.add(title);
                    //将图片保存路径添加到filePaths集合中
                    filePaths.add(new String(data, 0, data.length - 1));
                }
                //创建一个List集合，List集合的元是Map
                List<Map<String, Object>> listItems = new ArrayList<>();
                //将ids、names、fileNames三个集合对象的数据转换到Map集合中
                for (int i = 0; i < names.size(); i++) {
                    Map<String, Object> listItem = new HashMap<>();
                    listItem.put("id", ids.get(i));
                    listItem.put("name", names.get(i));
                    listItem.put("title",fileNames.get(i)+".jpg");
                    listItems.add(listItem);
                }
                //创建一个SimpleAdapter
                SimpleAdapter simpleAdapter = new SimpleAdapter(MediaStoreActivity.this, listItems, R.layout.line, new String[]{"id", "name","title"}, new int[]{R.id.pic_id, R.id.name,R.id.title});
                //为show ListView组件设置Adapter
                show.setAdapter(simpleAdapter);
            }
        });
        //为show ListView的列表项单击事件添加监听器
        show.setOnItemClickListener(new MyOnItemClickListener());

        //为add按钮的单击事件绑定监听器
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建ContentValues对象，准备插入数据
                ContentValues values=new ContentValues();
                values.put(MediaStore.Images.Media.DISPLAY_NAME,"金字塔");
                //设置多媒体类型为image/jpeg
                values.put(MediaStore.Images.Media.MIME_TYPE,"image/jpeg");
                //插入数据，返回所插入数据对应的uri
                Uri uri=getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                out.print(uri);
                //加载应用程序下的jinzita图片
                Bitmap bitmap=BitmapFactory.decodeResource(MediaStoreActivity.this.getResources(),R.drawable.jinzita);
                OutputStream os=null;
                try{
                    //获取刚插入的数据的Uri对应的输出流
                    os=getContentResolver().openOutputStream(uri);
                    //将Bitmap图片保存到Uri对应的数据节点中
                    bitmap.compress(Bitmap.CompressFormat.JPEG,100,os);
                    os.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private class MyOnItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View source, int position, long id) {
            //加载view.xml界面布局代表的视图
            View viewDialog=getLayoutInflater().inflate(R.layout.view,null);
            //获取viewDialog中ID为image的组件
            ImageView image= (ImageView) viewDialog.findViewById(R.id.image);
            //设置image显示指定图片
            image.setImageBitmap(BitmapFactory.decodeFile(filePaths.get(position)));
            //使用对话框显示用户单击的图片
            new AlertDialog.Builder(MediaStoreActivity.this).setView(viewDialog).setPositiveButton("确定",null).show();
        }
    }
}
