package com.qst.chapter08;

import android.app.DownloadManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button stopButton;

    private Button bindButton;
    private Button operateButton;
    private Button unbindButton;

    private Button start4Button;
    private Button stop4Button;
    private Button bind4Button;
    private Button unbind4Button;

    private Button start5Button;
    private Button stop5Button;
    private Button bind5Button;
    private Button progress5Button;

    private Button start6Button;
    private Button stop6Button;
    private Button start7Button;

    private Button notificationManagerButton;
    private Button downloadManagerButton;

    private MyService3 myService3;
    private ServiceConnection myService3Connection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MainActivity",
                    "myService3Connection.onServiceDisconnected():name=" + name);
            myService3 = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("MainActivity",
                    "myService3Connection.onServiceConnected():name=" + name);
            myService3 = ((MyService3.MyBinder) service).getService();
        }
    };

    private ServiceConnection myService4Connection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("MainActivity",
                    "myService4Connection.onServiceDisconnected()");
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("MainActivity", "myService4Connection.onServiceConnected()");
        }
    };

    private MyService5 myService5;
    private ServiceConnection myService5Connection = new ServiceConnection() {
        @Override
        public void onServiceDisconnected(ComponentName name) {
            myService5 = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService5 = ((MyService5.MyBinder) service).getService();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        bindButton = (Button) findViewById(R.id.bindButton);
        operateButton = (Button) findViewById(R.id.operateButton);
        unbindButton = (Button) findViewById(R.id.unbindButton);

        start4Button = (Button) findViewById(R.id.start4Button);
        stop4Button = (Button) findViewById(R.id.stop4Button);
        bind4Button = (Button) findViewById(R.id.bind4Button);
        unbind4Button = (Button) findViewById(R.id.unbind4Button);

        start5Button = (Button) findViewById(R.id.start5Button);
        stop5Button = (Button) findViewById(R.id.stop5Button);
        bind5Button = (Button) findViewById(R.id.bind5Button);
        progress5Button = (Button) findViewById(R.id.progress5Button);

        start6Button = (Button) findViewById(R.id.start6Button);
        stop6Button = (Button) findViewById(R.id.stop6Button);
        start7Button = (Button) findViewById(R.id.start7Button);
//
        notificationManagerButton = (Button) findViewById(R.id.notificationManagerButton);
        downloadManagerButton = (Button) findViewById(R.id.downloadManagerButton);

        startButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService2.class);
                intent.putExtra("message", "hello!");
                startService(intent);
            }
        });

        stopButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService2.class);
                stopService(intent);
            }
        });

        bindButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService3.class);
                intent.putExtra("message", "hello!");
                bindService(intent, myService3Connection,
                        Context.BIND_AUTO_CREATE);
            }
        });
        operateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myService3 == null)
                    return;
                String returnValue = myService3.doSomeOperation("test");
                Log.i("MainActivity", "myService3.doSomeOperation:"
                        + returnValue);
            }
        });
        unbindButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(myService3Connection);
            }
        });

        start4Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService4.class);
                startService(intent);
            }
        });
        stop4Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService4.class);
                stopService(intent);
            }
        });
        bind4Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService4.class);
                bindService(intent, myService4Connection,
                        Context.BIND_AUTO_CREATE);
            }
        });
        unbind4Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                unbindService(myService4Connection);
            }
        });

        start5Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService5.class);
                intent.putExtra("notice title", "MyService5通知");
                intent.putExtra("notice text", "MyService5成为前台服务了。");
                startService(intent);
            }
        });

        stop5Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService5.class);
                stopService(intent);
            }
        });
        bind5Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService5.class);
                bindService(intent, myService5Connection,
                        Context.BIND_AUTO_CREATE);
            }
        });
        progress5Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() {
                        for (int i = 0; i <= 100; i++) {
                            final int p = i;
                            runOnUiThread(new Runnable() {
                                public void run() {
                                    myService5.setProgress(p);
                                }
                            });
                            try {
                                sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
            }
        });

        start6Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService6.class);
                startService(intent);
            }
        });
        stop6Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService6.class);
                stopService(intent);
            }
        });

        start7Button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyService7.class);
                startService(intent);
            }
        });

        notificationManagerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                notification();
            }
        });

        downloadManagerButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                download();
            }
        });
    }

    private void notification() {
        Intent intent = new Intent(Settings.ACTION_SETTINGS);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(
                        BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher))
                .setContentTitle("通知标题").setContentText("通知内容。")
                .setContentIntent(pendingIntent).setNumber(1).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }

    private void download() {
        Uri uri = Uri.parse(
                "http://dl.ops.baidu.com/baidusearch_AndroidPhone_757p.apk");

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("下载示例");
        request.setDescription("下载说明");
        request.setDestinationInExternalFilesDir(this,
                Environment.DIRECTORY_DOWNLOADS, "temp.apk");
        request.setNotificationVisibility(
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

        final DownloadManager downloadManager
                = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        final long downloadId = downloadManager.enqueue(request);

        IntentFilter filter = new IntentFilter();
        filter.addAction(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
        filter.addAction(DownloadManager.ACTION_NOTIFICATION_CLICKED);

        final BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                long id = intent.getLongExtra(
                        DownloadManager.EXTRA_DOWNLOAD_ID, -1);
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                    if (id == downloadId) {
                        Uri uri = downloadManager
                                .getUriForDownloadedFile(downloadId);
                        Log.i("MainActivity", "下载完毕：" + uri.toString());
                    }
                } else if (DownloadManager.ACTION_NOTIFICATION_CLICKED
                        .equals(action)) {
                    Log.i("MainActivity", "取消下载");
                    downloadManager.remove(id);
                }
            }
        };
        registerReceiver(receiver, filter);
    }
}
