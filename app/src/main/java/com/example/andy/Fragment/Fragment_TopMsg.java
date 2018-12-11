package com.example.andy.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andy.JavaBean.Course;
import com.example.andy.JavaBean.SendCourse;
import com.example.andy.Util_Date.getNowTime;
import com.example.andy.Util_Http.HttpUtli2;
import com.example.andy.Util_Http.OnResponseListner;
import com.example.andy.Util_Parse.Utility;
import com.example.networktest.R;

import java.util.List;

public class Fragment_TopMsg extends Fragment {
    private static final int UPDATE_MSG = 1;
    private TextView TopMsg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topmsg, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TopMsg = view.findViewById(R.id.TopMsg);
        new MsgThread().start();
    }

    private class MsgThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Message msg = new Message();
                    msg.what = UPDATE_MSG;
                    handler.sendMessage(msg);
                    Thread.sleep(1000*60);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_MSG:
                    TopMsg.setText(getNowTime.getMsg());
                    break;
                default:
                    break;
            }
        }
    };
}
