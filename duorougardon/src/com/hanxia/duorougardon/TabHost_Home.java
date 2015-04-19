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
		
		
		
		TabSpec tSpec=tHost.newTabSpec("Duorou");//添加选项卡
		tHost.setup();
		tSpec.setIndicator("动态", getResources().getDrawable(R.drawable.dongtaiicon));//选项卡标签
		tSpec.setContent(R.id.tab1);//关联内容
		tHost.addTab(tSpec);
		
		tHost.addTab(tHost.newTabSpec("Duorou2")
				.setIndicator("论坛")
						.setContent(R.id.tab2)
						);
						
		tHost.addTab(tHost.newTabSpec("Duorou3")
				.setIndicator("花园")
						.setContent(R.id.tab2)
						);
						
	}

		  
	    
}
