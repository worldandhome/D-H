package com.wyl.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//�����˱�ʵ������ҪActivity
public class SecActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec);
		
		//�õ����ݹ�����intent
		Intent i = getIntent();
		//ȡ�ô��ݹ�����intent��Я����USERNAME����
		User u = (User) i.getSerializableExtra("USER");
		//�õ������е�TextView�ؼ�
		TextView tv = (TextView)findViewById(R.id.Tv);
		//����TextView�ؼ�����ʾ����
		tv.setText("�û���ע����ϢΪ��"+u.toString());
	}
}