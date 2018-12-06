package com.qst.chapter03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ImageViewDemoActivity extends AppCompatActivity {
    ImageView flagImageView;
    TextView flagTxt;
    ImageButton backImageBtn;
    ImageButton forwardImageBtn;
    //国旗数组 中国 德国 英国
    int[] flag = {R.drawable.china, R.drawable.germany, R.drawable.britain};
    String[] flagNames = {"中国", "德国", "英国"};
    //当前页 默认第一页
    int currentPage = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_demo);
        flagImageView = findViewById(R.id.flagImageView);
        flagTxt = findViewById(R.id.flagTxt);
        backImageBtn = findViewById(R.id.backImageBtn);
        forwardImageBtn = findViewById(R.id.forwardImageBtn);
        backImageBtn.setOnClickListener(onClickListener);
        forwardImageBtn.setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.backImageBtn:
                    if (currentPage == 0) {
                        Toast.makeText(ImageViewDemoActivity.this, "第一页，前面没有了", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        currentPage--;
                        flagImageView.setImageResource(flag[currentPage]);
                        flagTxt.setText(flagNames[currentPage]);
                    }
                case R.id.forwardImageBtn:
                    if (currentPage == (flag.length - 1)) {
                        Toast.makeText(ImageViewDemoActivity.this, "最后一页，后面没有了", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        currentPage++;
                        flagImageView.setImageResource(flag[currentPage]);
                        flagTxt.setText(flagNames[currentPage]);
                    }
            }
        }
    };
}
