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
    }

    private void showText_Msg() {
    }


}
