package com.qst.chapter04.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	//一组Image的Id
	private int[] mThumbIds;

	public ImageAdapter(Context context,int[] mThumbIds) {
		this.mContext = context;
		this.mThumbIds = mThumbIds;
	}

	@Override
	public int getCount() {
		return mThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		return mThumbIds[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// 定义一个ImageView,显示在GridView里
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		imageView.setImageResource(mThumbIds[position]);
		return imageView;
	}
}
