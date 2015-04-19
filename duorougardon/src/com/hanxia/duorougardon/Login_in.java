package com.hanxia.duorougardon;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_in extends Activity {
	private EditText etName;
	private EditText etPwd;
	Button btnOk;
	Button btnSign;
	SharedPreferences sharedPreferences;
	List<MemberBaseInfo> memberBaseInfos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE); // 移除actionbar
		setContentView(R.layout.login_in);
		super.onCreate(savedInstanceState);
		sharedPreferences = getSharedPreferences("userInfo",
				Context.MODE_WORLD_READABLE);
		findview();

		btnSign.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent register = new Intent(Login_in.this,
						RegistActivity.class);
				startActivity(register);

			}
		});
		btnOk.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = etName.getText().toString();
				String pwd = etPwd.getText().toString();

				// �ж��û����Ƿ�Ϸ�

				if (isUser(name, pwd)) {

					Intent intent = new Intent(Login_in.this,
							MainActivity.class);

					startActivity(intent);

				} else {
					Toast.makeText(Login_in.this, "�û����������", Toast.LENGTH_LONG)
							.show();
				}
			}
		});
	}

	protected boolean isUser(String name, String pwd) {

		memberBaseInfos = getSpmembers();
		if (memberBaseInfos != null) {
			for (int i = 0; i < memberBaseInfos.size(); i++) {
				// Log.d("tag", memberBaseInfos.get(i).getMemberName());
				if (memberBaseInfos.get(i).getMemberName().equals(name)
						&& memberBaseInfos.get(i).getPassword().equals(pwd)) {
					return true;
				}

			}
			return false;
		}
		return false;

	}

	public List<MemberBaseInfo> getSpmembers() {

		List<MemberBaseInfo> memberBaseInfos = new ArrayList<MemberBaseInfo>();

		String getuserinfos = sharedPreferences.getString("members", "");
		Log.d("Login_in", getuserinfos);

		if (getuserinfos != "") {
			// name1/pwd1,name2/pwd2
			if (getuserinfos.contains(",")) {
				String[] users = getuserinfos.split(",");
				for (String str : users) {
					MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
					String[] user = str.split("/");
					memberBaseInfo.setMemberName(user[0]);
					memberBaseInfo.setPassword(user[1]);
					memberBaseInfos.add(memberBaseInfo);

				}
			} else

			{
				MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
				String[] user = getuserinfos.split("/");
				memberBaseInfo.setMemberName(user[0]);
				memberBaseInfo.setPassword(user[1]);
				memberBaseInfos.add(memberBaseInfo);
			}
			return memberBaseInfos;
		} else {
			return memberBaseInfos;
		}
	}

	private void findview() {
		btnOk = (Button) findViewById(R.id.btnok);
		etName = (EditText) findViewById(R.id.etName);
		etPwd = (EditText) findViewById(R.id.etPwd);
		btnSign = (Button) findViewById(R.id.btnsign);
	}

}
