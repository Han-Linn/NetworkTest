package com.qst.chapter08;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;

public class MyService5 extends Service {
    private MyBinder myBinder = new MyBinder();
    private Notification.Builder builder;

    @Override
    public IBinder onBind(Intent intent) {
        builder = new Notification.Builder(this);
        builder.setSmallIcon(R.drawable.btn_star_big_on_pressed);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher));
        builder.setContentTitle("MyService5");
        return myBinder;
    }

    public void setProgress(int progress) {
        builder.setContentText("进度：" + progress + "%");
        builder.setProgress(100, progress, false);
        Notification notification = builder.build();
        startForeground(1, notification);
    }

    public class MyBinder extends Binder {
        public MyService5 getService() {
            return MyService5.this;
        }
    }

//    public void onCreate() {
//        Notification.Builder builder=new Notification.Builder(this);
//        builder.setSmallIcon(R.drawable.btn_star_big_on_pressed);
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
//        builder.setContentTitle("MyService5");
//        builder.setContentText("MyService5正在运行...");
//
//        Notification notification=builder.build();
//        notification.flags =Notification.FLAG_AUTO_CANCEL;
//        startForeground(1,notification);
//        super.onCreate();
//    }


//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Notification.Builder builder=new Notification.Builder(this);
//        builder.setSmallIcon(R.drawable.btn_star_big_on_pressed);
//        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
//        builder.setContentTitle(intent.getStringExtra("notice title"));
//        builder.setContentText(intent.getStringExtra("notice text"));
//
//        Notification notification=builder.build();
//        notification.flags =Notification.FLAG_AUTO_CANCEL;
//        startForeground(1,notification);
//
//        return super.onStartCommand(intent, flags, startId);
//    }

//    public IBinder onBind(Intent intent){
//        return null;
//    }
}
