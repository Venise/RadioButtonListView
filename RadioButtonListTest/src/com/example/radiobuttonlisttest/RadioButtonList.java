package com.example.radiobuttonlisttest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class RadioButtonList extends Activity {

	private ListView radioButtonList;
	private RadioAdapter adapter;
	// ģ�⼸�����ݣ���ΪList����Ŀ
	private String[] authors = { "�洨��֮��", "�����ɼͷ�", "���˿���", "���ϴ���", "��Ұ����",
			"�Ű���", "��ӹ", "Ǯ����", "����", "��ʵ��", "��������", "������", "���Ƚ�����", "��³�ǿ�",
			"�ܿ��׶�", "С����", "����˹", "��¥��", "���", "�Ͷ�����", "ɯʿ����", "����˹", "ëķ",
			"���ϵ���", "�Ѹ�" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_radio_button_list);

		radioButtonList = (ListView) findViewById(R.id.list);
		adapter = new RadioAdapter(this, authors);
		radioButtonList.setAdapter(adapter);
		
	}
}
