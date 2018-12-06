package com.qst.chapter09;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Adminstrator on 2016/10/19.
 */
public class ClientActivity extends AppCompatActivity implements Runnable {
    //声明文本视图chatmessage，用于显示聊天记录
    private TextView chatmessage=null;
    //声明编辑框sendmessage，用于用户输入短信内容
    private EditText sendmessage=null;
    //声明send_button,用于发送短信
    private Button send_button=null;
    private static final String HOST="192.168.52.17";//服务器的IP地址
    private static final int PORT=9898;//服务器端口号
    private Socket socket=null;//声明套接字类，传输数据
    private BufferedReader bufferedReader=null;
    private PrintWriter printWriter=null;
    private String string="";

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chatmessage= (TextView) findViewById(R.id.chatmessage);
        sendmessage= (EditText) findViewById(R.id.sendmessage);
        send_button= (Button) findViewById(R.id.sendbutton);

        new Thread(){
            @Override
            public void run() {
                try {
                    //指定IP和端口号创建套接字
                    socket=new Socket(HOST,PORT);
                    //使用套接字的输入流构造BufferedReader对象
                    bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //使用套接字的输出流构造PrintWriter对象
                    printWriter=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                } catch (Exception e) {
                    e.printStackTrace();
                    Looper.prepare();
                    CreateDialog(e.getMessage());
                }
                super.run();
            }
        }.start();

        /* 注册send_button的鼠标单击监听器。当单击按钮时，发送指定的信息 */
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入框的内容
                String message = sendmessage.getText().toString();
                //判断socket是否连接
                if(socket.isConnected()){
                    if(!socket.isOutputShutdown()){
                        //将输入框的内容发送到服务器
                        printWriter.println(message);
                        //设置chatmessage的内容
                        chatmessage.setText(chatmessage.getText().toString()+"\n"+"发送："+message);
                        //清空sendmessage的内容，以便下次输入
                        sendmessage.setText("");
                    }
                }
            }
        });
        new Thread(this).start();

    }
    /* CreateDialog产生对话框 */
    public void CreateDialog(String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //首先获取AlertDialog的Builder累，该Builder对象用于构造对话框
        builder.setTitle("异常");//指定对话框的标题
        builder.setMessage(message);//设置现实的信息
        builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //设置NegativeButton的名称以及监听器
        builder.show();//显示对话框
    }
    /* 线程运行的代码 */
    public void run() {
        try {
            while (true) {
                //若套接字同服务器的链接存在且输入流也存在，则发送消息
                if (socket.isConnected()) {
                    if (!socket.isConnected()) {
                        if ((string = bufferedReader.readLine()) != null) {
                            Log.i("TAG","++ "+string);
                            string +="";
                            messegner.sendMessage(messegner.obtainMessage());

                        }else {

                        }
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();//显示异常信息
            Log.w("TAG","--"+ex.toString());//将信息输入到日志里，级别为Warn
        }
    }
    /* 创建Handler对象messegner */

    public Handler messegner=new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.i("TAG","--"+msg);//将消息打印到日志里，级别为Inf
            chatmessage.setText(chatmessage.getText().toString()+"\n"+"来自服务端的消息："+string);
        }
    };
}
