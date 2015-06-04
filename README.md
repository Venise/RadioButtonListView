## RadioButtonListView
#### 列表项中带有RadioButton，实现列表项单选效果

### 核心要点

#### 为防止列表在滑动过程中选中效果错乱，以及实现列表单选，需要对选中行进行标记

    holder.selectBtn.setClickable(false);
    holder.layout.setOnClickListener(new OnClickListener(){
	@Override
      public void onClick(View view) {
    	  index = position;
	  notifyDataSetChanged();
    	}
    });
    
    ...
    
    if (index == position) {
      holder.selectBtn.setChecked(true);
    } else {
    	holder.selectBtn.setChecked(false);
    }
