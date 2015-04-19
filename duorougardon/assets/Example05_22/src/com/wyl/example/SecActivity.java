package com.wyl.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

//定义了本实例的主要Activity
public class SecActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sec);
		
		//得到传递过来的intent
		Intent i = getIntent();
		//取得传递过来的intent中携带的USERNAME数据
		User u = (User) i.getSerializableExtra("USER");
		//得到布局中的TextView控件
		TextView tv = (TextView)findViewById(R.id.Tv);
		//设置TextView控件的显示文字
		tv.setText("用户的注册信息为："+u.toString());
	}
}