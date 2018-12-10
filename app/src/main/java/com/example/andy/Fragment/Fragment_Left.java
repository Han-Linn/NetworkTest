package com.example.andy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.andy.Activity.Activity_Appointment;
import com.example.andy.JavaBean.SendCourse;
import com.example.andy.Util_Date.getNowTime;
import com.example.networktest.R;

public class Fragment_Left extends Fragment implements View.OnClickListener {
    private Button appointment;
    private TextView date, classroom;
    private SendCourse sc;
    private static final int UPDATE_MSG = 2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setOnclick();
        new MsgThread().start();
    }

    private void setOnclick() {
        appointment.setOnClickListener(this);
    }

    private class MsgThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = UPDATE_MSG;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.oppointment:
                Intent intent = new Intent(getActivity(), Activity_Appointment.class);
                startActivity(intent);
                break;
        }
    }

    private void init(View view) {
        appointment = view.findViewById(R.id.oppointment);
        date = view.findViewById(R.id.date);
        classroom = view.findViewById(R.id.classroom);
    }

    private void showText_Msg() {
        sc = new SendCourse();
        date.setText(getNowTime.getTime2());
        classroom.setText(sc.getClassroom());
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_MSG:
                    showText_Msg();
                    break;
                default:
                    break;
            }
        }
    };
}
