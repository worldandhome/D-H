package com.wyl.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//�����˱�ʵ������ҪActivity
public class MainActivity extends Activity {
	// ���岼���е�ע��Button�ؼ�
	private Button btn;
	// ���岼���е��û��������ؼ�
	private EditText EtName;
	// ���岼���е����������ؼ�
	private EditText EtPwd;
	// ���岼���е����������ؼ�
	private EditText EtEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    //���õ�ǰActivity�Ĳ����ļ�Ϊactivity_main
        setContentView(R.layout.activity_main);
        //�õ�������еĿؼ�����
        findView();
        //���ö���ļ�����
        setListener();
	}

	private void setListener() {
		// ����btn�ĵ��������
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//�õ��û�������û���
				String name = EtName.getText().toString();
				//�õ��û����������
				String pwd = EtPwd.getText().toString();
				//�õ��û����������
				String email = EtEmail.getText().toString();
				
				//�ж��û������������Ƿ�Ϊ��
				if (!"".equals(name)
						&& !"".equals(pwd)
						&& !"".equals(email)) {
					//����User����
					User u = new User();
					//����Email 
					u.setEamil(email);
					//�����û���
					u.setName(name);
					//��������
					u.setPwd(pwd);
					
					//����Ϸ���������ת����ӭ����
					Intent i = new Intent(MainActivity.this,SecActivity.class);
					//���ô��ݵĲ���Ϊ�û���
					i.putExtra("USER", u);
					//����activity
					startActivity(i);
				}
				else{
					//����û������벻�Ϸ�����ʾtoast��ʾ�û�
					Toast.makeText(MainActivity.this, 
							"������ϢΪ��",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	private void findView() {
		// �õ������еĿ�ʼ���ص�Button�Ķ���
		btn = (Button) findViewById(R.id.Btn);
		// �õ������е��û���EditText�Ķ���
		EtName = (EditText) findViewById(R.id.EtName);
		// �õ������е�����EditText�Ķ���
		EtPwd = (EditText) findViewById(R.id.EtPwd);
		// �õ������е�����EditText�Ķ���
		EtEmail = (EditText) findViewById(R.id.EtEmail);
	}
}