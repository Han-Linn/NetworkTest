package com.qst.chapter04.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TestFragment extends Fragment {
    public static final String KEY="key";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        TextView textView=new TextView(getActivity());
        textView.setGravity(Gravity.CENTER);
        Bundle bundle=this.getArguments();
        String content=bundle.getString(KEY);
        textView.setText(content);
        textView.setTextSize(30);
        return textView;
    }
}