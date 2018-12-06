package com.qst.chapter06;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * Created by Adminstrator on 2016/10/8.
 */
public class SDActivity extends AppCompatActivity {
    //声明两个文本框
    private EditText editFileIn, editFileOut;
    //声明两个按钮
    private Button btnRead, btnWrite;
    //指定文件名
    final String FILE_NAME="/qstSD.txt";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_io);
        System.out.println("FileIOActivity");
        //获取两个文本框
        editFileIn= (EditText) findViewById(R.id.editFileIn);
        editFileOut= (EditText) findViewById(R.id.editFileOut);

        //获取两个按钮
        Button btnRead= (Button) findViewById(R.id.btnRead);
        Button btnWrite= (Button) findViewById(R.id.btnWrite);

        //绑定btnRead按钮的事件监听器
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //读取指定文件中的内容，并在editFileIn文本框中显示出来
                editFileIn.setText(read());
            }
        });
        //绑定btnWrite按钮的事件监听器
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //将edit1中得内容写入文件中
                write(editFileOut.getText().toString());
                editFileOut.setText("");
            }
        });
    }
    private  String read(){
        try {
          //如果手机插入了SD卡，而且应用程序具有访问SD卡的权限
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                //获取SD卡对应的储存目录
                File sdCardDir=Environment.getExternalStorageDirectory();
                System.out.println("-----------"+sdCardDir);
                //获取指定文件对应的输入流
                FileInputStream fis =new FileInputStream(sdCardDir.getCanonicalPath() + FILE_NAME);
                //将指定输入流包装成BufferedReader
                BufferedReader br =new BufferedReader(new InputStreamReader(fis));
                StringBuilder sb=new StringBuilder("");
                String line=null;
                //循环读取文件内容
                while((line = br.readLine()) !=null){
                    sb.append(line);
                }
                //关闭资源
                br.close();
                return  sb.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private void write(String content){
        try{
            //如果手机插入了SD卡，而且应用程序具有访问SD卡的权限
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                //获取SD卡的目录
                File sdCardDir = Environment.getExternalStorageDirectory();
                File targetFile=new File(sdCardDir.getCanonicalPath()+ FILE_NAME);
                //以指定文件创建RandomAccessFile对象
                RandomAccessFile raf= new RandomAccessFile(targetFile,"rw");
                //将文件记录指针移动到最后
                raf.seek(targetFile.length());
                //输出文件内容
                raf.write(content.getBytes());
                //关闭RandomAccessFile
                raf.close();
            }
            //使用Toast显示保存成功
            Toast.makeText(SDActivity.this,"保存成功",Toast.LENGTH_LONG);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
