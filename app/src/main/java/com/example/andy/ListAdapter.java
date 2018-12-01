package com.example.andy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.networktest.R;

import java.util.List;
import java.util.Map;

public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<Map> list;

    public ListAdapter(Context context, List<Map> dataList) {
        this.context = context;
        this.list = dataList;
    }

    @Override//获取适配器中数据集中数据的条目数
    public int getCount() {
        return list.size();
    }

    @Override//获取数据集中与指定索引对应的数据项(不用)
    public Object getItem(int position) {
        return null;
    }

    @Override//获取数据集中指定索引对应的项的id(不用)
    public long getItemId(int position) {
        return 0;
    }


    class ViewHolder {
        private TextView Name_Theme, DateTime1,DateTime2,Name_AppointMan;
    }

    @Override//重点
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder = null;
        if (convertView == null) {
            viewholder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_listview, null);
            viewholder.Name_Theme = convertView.findViewById(R.id.name_theme);
            viewholder.DateTime1 = convertView.findViewById(R.id.datetime1);
            viewholder.DateTime2 = convertView.findViewById(R.id.datetime2);
            viewholder.Name_AppointMan = convertView.findViewById(R.id.name_appointMan);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        String Name = list.get(position).get("addr").toString();
        String DateTime1 = list.get(position).get("startTime").toString();
        String DateTime2 = list.get(position).get("endTime").toString();
        String Name_AppointMan = list.get(position).get("appointMan").toString();
        viewholder.Name_Theme.setText(Name);
        viewholder.DateTime1.setText(DateTime1);
        viewholder.DateTime2.setText(DateTime2);
        viewholder.Name_AppointMan.setText(Name_AppointMan);

        return convertView;
    }
}
