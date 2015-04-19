package com.hanxia.duorougardon;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends Activity {

	private EditText registName;
	private EditText registPassWord;
	private EditText registPassrdWoRepeat;
	private EditText mailBox;
	private EditText phone;
	private Button regist2;

	SharedPreferences sharedPreferences;
	List<MemberBaseInfo> memberBaseInfos;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		sharedPreferences = getSharedPreferences("userInfo",
				Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.regist);
		findView();

		regist2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String userName = registName.getText().toString();
				String userPassWord = registPassWord.getText().toString();
				String userPassrdWoRepeat = registPassrdWoRepeat.getText()
						.toString();
				String userMailBox = mailBox.getText().toString();
				String userPhone = phone.getText().toString();
				if (userPassWord.equals(userPassrdWoRepeat)) {
					memberBaseInfos = getSPMembers();
					saveSPMember(userName, userPassWord, userMailBox, userPhone);
					// Log.d("TAG", userPassWord);

					Toast.makeText(getApplicationContext(), "注册成功",
							Toast.LENGTH_LONG).show();

					Intent intent3 = new Intent(RegistActivity.this,
							Login_in.class);
					startActivity(intent3);
				} else {
					Toast.makeText(getApplicationContext(), "密碼不一致，请重新输入",
							Toast.LENGTH_LONG).show();
				}

			}
		});

		// 进来 读取�?后一次保存的 memberBaseInfos Id 列表�?
		// 到memberBaseInfos 取得用户
	}

	// 得到用户信息
	public  List<MemberBaseInfo> getSPMembers() {
		List<MemberBaseInfo> memberBaseInfos = new ArrayList<MemberBaseInfo>();// 用于保存用户列表信息
		String userinfos = sharedPreferences.getString("members", "");// 取得�?有用户信�?
		// 获得用户字串
		if (userinfos != "")// 有数�?
		{
			// name1/pwd1,name2/pwd2
			if (userinfos.contains(","))// 判断有无, 逗号代表用户每个用户分割�?
			{
				String[] users = userinfos.split(",");
				for (String str : users) {
					MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
					String[] user = str.split("/");
					if(user.length>=1){
						memberBaseInfo.setMemberName(user[0]);// 用户�?
					}
					if(user.length>=2){
						memberBaseInfo.setPassword(user[1]);// 密码
					}
					
					
					if (user.length >= 3) {
						memberBaseInfo.setMailbox(user[2]);
					}
					if (user.length >= 4) {
						memberBaseInfo.setPhoneNum(user[3]);
					}
					
					memberBaseInfos.add(memberBaseInfo);
				}
			} else
			// 没有, 代表只有�?个用�?
			{
				MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
				String[] user = userinfos.split("/");
				memberBaseInfo.setMemberName(user[0]);
				memberBaseInfo.setPassword(user[1]);
				memberBaseInfo.setMailbox(user[2]);
				memberBaseInfo.setPhoneNum(user[3]);
				memberBaseInfos.add(memberBaseInfo);
			}
			return memberBaseInfos;
		} else {
			return memberBaseInfos;
		}

	}

	// 保存用户信息
	private void saveSPMember(String memberName, String memberPwd,
			String memberMailBox, String memberPhone) {

		checkUser(memberName, memberPwd, memberMailBox, memberPhone);// �?查是否已存在相同用户信息
		String userinfos = "";
		// �?终保存的用户信息都在list�?
		for (MemberBaseInfo user : memberBaseInfos) {
			String uname = user.getMemberName();
			String pwd = user.getPassword();
			String mmb = user.getMailbox();
			String mp = user.getPhoneNum();
			String userinfo = uname + "/" + pwd + "/" + mmb + "/" + mp;
			if (userinfos == "") {
				userinfos = userinfo;
			} else {
				userinfos += "," + userinfo;
			}
		}
		Editor editor = sharedPreferences.edit();// 编辑器记�?
		editor.putString("members", userinfos);
		editor.commit();// 编辑器提交保�?

	}

	// �?查是否包含此用户�? 没有包含就保存到?
	public void checkUser(String memberName, String memberPwd,
			String memberMailBox, String memberPhone) {
		int position = 0;
		if (memberBaseInfos != null) {
			for (int i = 0; i < memberBaseInfos.size(); i++) {
				if (memberBaseInfos.get(i).getMemberName().equals(memberName)) {

					Toast.makeText(RegistActivity.this, "用户名已被使用，请重新输入！",
							Toast.LENGTH_LONG).show();
					break;
				}
			}
			if (position > 0) {// 已存�?
				memberBaseInfos.remove(position);
			}
		}
		MemberBaseInfo memberBaseInfo = new MemberBaseInfo();
		memberBaseInfo.setMemberName(memberName);
		memberBaseInfo.setPassword(memberPwd);
		memberBaseInfo.setMailbox(memberMailBox);
		memberBaseInfo.setPhoneNum(memberPhone);
		memberBaseInfos.add(memberBaseInfo);

	}

	private void findView() {
		registName = (EditText) findViewById(R.id.registName);
		registPassWord = (EditText) findViewById(R.id.registPassWord);
		registPassrdWoRepeat = (EditText) findViewById(R.id.registPassrdWoRepeat);
		mailBox = (EditText) findViewById(R.id.mailBox);
		phone = (EditText) findViewById(R.id.phone);
		regist2 = (Button) findViewById(R.id.regist2);
	}
}