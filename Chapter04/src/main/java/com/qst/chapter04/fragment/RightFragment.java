package com.qst.chapter04.fragment;

import com.qst.chapter04.R;
import com.qst.chapter04.R.id;
import com.qst.chapter04.R.layout;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class RightFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, null);
        Button button = view.findViewById(R.id.frgBtn);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "我是Fragment", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}