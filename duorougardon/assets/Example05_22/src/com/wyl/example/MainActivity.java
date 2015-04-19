package com.wyl.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//定义了本实例的主要Activity
public class MainActivity extends Activity {
	// 定义布局中的注册Button控件
	private Button btn;
	// 定义布局中的用户名输入框控件
	private EditText EtName;
	// 定义布局中的密码输入框控件
	private EditText EtPwd;
	// 定义布局中的邮箱输入框控件
	private EditText EtEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    //设置当前Activity的布局文件为activity_main
        setContentView(R.layout.activity_main);
        //得到浏览器中的控件对象
        findView();
        //设置对象的监听器
        setListener();
	}

	private void setListener() {
		// 设置btn的点击监听器
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//得到用户输入的用户名
				String name = EtName.getText().toString();
				//得到用户输入的密码
				String pwd = EtPwd.getText().toString();
				//得到用户输入的邮箱
				String email = EtEmail.getText().toString();
				
				//判断用户名密码邮箱是否为空
				if (!"".equals(name)
						&& !"".equals(pwd)
						&& !"".equals(email)) {
					//定义User对象
					User u = new User();
					//设置Email 
					u.setEamil(email);
					//设置用户名
					u.setName(name);
					//设置密码
					u.setPwd(pwd);
					
					//如果合法，程序跳转到欢迎界面
					Intent i = new Intent(MainActivity.this,SecActivity.class);
					//设置传递的参数为用户名
					i.putExtra("USER", u);
					//启动activity
					startActivity(i);
				}
				else{
					//如果用户名密码不合法，显示toast提示用户
					Toast.makeText(MainActivity.this, 
							"输入信息为空",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void findView() {
		// 得到布局中的开始加载的Button的对象
		btn = (Button) findViewById(R.id.Btn);
		// 得到布局中的用户名EditText的对象
		EtName = (EditText) findViewById(R.id.EtName);
		// 得到布局中的密码EditText的对象
		EtPwd = (EditText) findViewById(R.id.EtPwd);
		// 得到布局中的邮箱EditText的对象
		EtEmail = (EditText) findViewById(R.id.EtEmail);
	}
}