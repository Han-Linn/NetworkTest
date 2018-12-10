package com.example.andy.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.andy.Activity.Activity_Appointment;
import com.example.andy.Util_Date.getDate;
import com.example.networktest.R;

public class Fragment_Left extends Fragment implements View.OnClickListener {
    private Button appointment;
    private TextView date;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setOnclick();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    showResponse();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private void setOnclick() {
        appointment.setOnClickListener(this);
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


    private void showResponse() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showText_Msg();
            }
        });
    }

    private void init(View view) {
        appointment = view.findViewById(R.id.oppointment);
        date = view.findViewById(R.id.date);
    }

    private void showText_Msg() {
        date.setText(getDate.getTime2());
    }
}
