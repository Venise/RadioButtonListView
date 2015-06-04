package com.example.radiobuttonlisttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class RadioAdapter extends BaseAdapter {

	private LayoutInflater inflater;
	private String[] authors;
	private ViewHolder holder;
	private int index = -1;// 标记用户当前选择的那一个作家
	
	public RadioAdapter(Context c, String[] authors) {
		super();
		this.authors = authors;
		inflater = LayoutInflater.from(c);
	}

	@Override
	public int getCount() {
		return authors.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public void setSelectedIndex(int position) {  
		this.index = position;  
		notifyDataSetChanged();  
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		holder = new ViewHolder();
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_list, null);
			holder.layout = (RelativeLayout) convertView.findViewById(R.id.layout);
			holder.nameTxt = (TextView) convertView.findViewById(R.id.author);
			holder.selectBtn = (RadioButton) convertView.findViewById(R.id.radio);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.nameTxt.setText(authors[position]);
		
		/* 方法一：使用radiobutton的setOnCheckedChangeListener监听
		holder.selectBtn.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					if (isChecked) {
						Toast.makeText(c, "您选择的作家是：" + authors[position],
								Toast.LENGTH_LONG).show();
						index = position;
						notifyDataSetChanged();
					}
				}
			});
		*/
		
		/* 方法二：设置radiobutton不可点击，为holder.layout设置点击响应事件*/
		holder.selectBtn.setClickable(false);
		holder.layout.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				index = position;
				notifyDataSetChanged();
			}});
		
		// 选中的条目和当前的条目是否相等;若相同则为选中状态，不相同则其他的全部为未选中状态，实现了单选的效果；
		// 通过setChecked设置选中与否状态
		if (index == position) {
			holder.selectBtn.setChecked(true);
		} else {
			holder.selectBtn.setChecked(false);
		}
		return convertView;
	}

	class ViewHolder {
		public TextView nameTxt;
		public RadioButton selectBtn;
		public RelativeLayout layout;
	}
}
