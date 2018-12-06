package com.qst.chapter06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adminstrator on 2016/10/9.
 */
public class ListViewAdapter extends BaseAdapter{
    private static Map<Integer,View> m=new HashMap<Integer, View>();
    private List<String> items;
    private LayoutInflater inflater;

    public  ListViewAdapter(List<String> items, Context context){
        super();
        this.items=items;
        this.inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View contextView, ViewGroup arg2) {
        contextView=m.get(position);
        if(contextView==null){
            contextView=inflater.inflate(R.layout.listview_item,null);
            TextView text= (TextView) contextView.findViewById(R.id.list_item_text);
            text.setText(items.get(position));
        }
        m.put(position,contextView);
        return contextView;
    }
    public void addItem(String item){
        items.add(item);
    }
}
