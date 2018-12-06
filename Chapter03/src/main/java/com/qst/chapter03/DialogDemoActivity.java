package com.qst.chapter03;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DialogDemoActivity extends AppCompatActivity {
    Button normalBtn;
    Button contentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_demo);
        normalBtn = findViewById(R.id.normalBtn);
        contentBtn = findViewById(R.id.contentBtn);
        normalBtn.setOnClickListener(onClickListener);
        contentBtn.setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.normalBtn: {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogDemoActivity.this);
                    builder.setMessage("确认退出吗？")
                            .setTitle("提示");
                    //点击确认按钮后触发事件
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            DialogDemoActivity.this.finish();
                        }
                    });
                    //点击取消后触发事件
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
                    break;
                }

                case R.id.contentBtn: {
                    //处理内容型的对话框
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogDemoActivity.this);
                    builder.setIcon(android.R.drawable.btn_star)
                            .setTitle("喜欢度调查")
                            .setMessage("你喜欢成龙的电影吗？")
                            .setPositiveButton("很喜欢", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(DialogDemoActivity.this, "我很喜欢他的电影。", Toast.LENGTH_LONG).show();
                                }
                            });

                    //不喜欢
                    builder.setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogDemoActivity.this, "我不喜欢他的电影。", Toast.LENGTH_LONG).show();
                        }
                    });

                    builder.setNeutralButton("一般", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(DialogDemoActivity.this, "一般吧，谈不上喜欢。", Toast.LENGTH_LONG).show();
                        }
                    });

                    //显示对话框
                    builder.show();
                }

            }

        }
    };
}
