package com.hanxia.duorougardon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHost_Home extends Activity {
	
	TabHost tHost;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.tabhost_home);
		super.onCreate(savedInstanceState);
		tHost=(TabHost)findViewById(R.id .tabhost);
		
		
		
		TabSpec tSpec=tHost.newTabSpec("Duorou");//���ѡ�
		tHost.setup();
		tSpec.setIndicator("��̬", getResources().getDrawable(R.drawable.dongtaiicon));//ѡ���ǩ
		tSpec.setContent(R.id.tab1);//��������
		tHost.addTab(tSpec);
		
		tHost.addTab(tHost.newTabSpec("Duorou2")
				.setIndicator("��̳")
						.setContent(R.id.tab2)
						);
						
		tHost.addTab(tHost.newTabSpec("Duorou3")
				.setIndicator("��԰")
						.setContent(R.id.tab2)
						);
						
	}

		  
	    
}
