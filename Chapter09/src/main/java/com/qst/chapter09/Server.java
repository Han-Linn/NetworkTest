package com.qst.chapter09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Adminstrator on 2016/10/19.
 */
public class Server {
    private int ServerPort = 9898;//定义端口
    private ServerSocket serverSocket=null;//生命服务器套接字
    private OutputStream outputStream=null;//声明输出流
    private InputStream inputStream=null;//声明输入流
    private PrintWriter printWriter=null;//声明打印流，用于将数据发送给对方
    private Socket socket=null;//声明套接字，注意同服务器套接字不同
    private BufferedReader reader=null;//声明缓冲流，用于读取接收的数据

    /* Server类的构造函数 */
    public Server(){
        try {
            //根据指定的端口号，创建套接字
            serverSocket=new ServerSocket(ServerPort);
            System.out.println("服务启动中...");
            socket=serverSocket.accept();//用accept方法等待客户端的连接
            System.out.println("客户端已连接...\n");
        } catch (IOException e) {
            e.printStackTrace();//打印异常信息
        }

        try {
            //获取套接字输出流
            outputStream=socket.getOutputStream();
            //获取套接字输入流
            inputStream=socket.getInputStream();
            //根据outputStream创建PrintWriter对象
            printWriter=new PrintWriter(outputStream,true);
            //根据inputStream创建BufferedReader对象
            reader=new BufferedReader(new InputStreamReader(inputStream));
            //根据System.in创建BufferedReader对象
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            while(true){
                //读客户端的传输信息
                String message=reader.readLine();
                //将接受的信息打印出来
                System.out.println("来自客户端的信息："+message);
                //若消息为Bye或者bye，则结束通信
                if(message.equals("Bye")||message.equals("bye"))
                    break;
                message=in.readLine();//接收键盘输入
                printWriter.println(message);//将输入的信息向客户端输出
            }
            outputStream.close();//关闭输出流
            inputStream.close();//关闭输入流
            socket.close();//关闭套接字
            serverSocket.close();//关闭服务器套接字
            System.out.println("客户端关闭连接");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }
    /* 程序入口，程序从main函数开始执行 */
    public static void main(String[] args){
        new Server();
    }

}
