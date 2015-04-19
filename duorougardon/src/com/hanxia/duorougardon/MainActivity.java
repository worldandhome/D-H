package com.hanxia.duorougardon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;

import com.hanxia.adapter.MyFragmentAdapter;

public class MainActivity extends FragmentActivity implements
		OnTabChangeListener, OnPageChangeListener {
	private TabHost mTabHost;
	private ViewPager mViewPager;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//requestWindowFeature(Window.FEATURE_NO_TITLE); // 移除actionbar

		super.onCreate(savedInstanceState);
		  
		setContentView(R.layout.activity_main);
		// ActionBar acrionBar=getActionBar();

		mTabHost = (TabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup();
		mTabHost.addTab(mTabHost.newTabSpec("others").setIndicator("肉友动态")
				.setContent(tf));
		mTabHost.addTab(mTabHost.newTabSpec("luntan").setIndicator("论坛")
				.setContent(tf));
		mTabHost.addTab(mTabHost.newTabSpec("mygarden").setIndicator("我的花园")
				.setContent(tf));
		mTabHost.setOnTabChangedListener(this);

		mViewPager = (ViewPager) findViewById(R.id.pager);
		
		mViewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
		
		mViewPager.setOnPageChangeListener(this);

	}

	TabContentFactory tf = new TabContentFactory() {

		@Override
		public View createTabContent(String tag) {
			View ret = new View(getApplicationContext());
			ret.setMinimumHeight(0);
			ret.setMinimumWidth(0);
			return ret;
		}

	};


	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO �Զ����ɵķ������

	}

	@Override
	public void onPageSelected(int arg0) {
		mTabHost.setCurrentTab(arg0);

	}

	@Override
	public void onTabChanged(String tabId) {
		if (tabId.equals("others")) {
			mViewPager.setCurrentItem(0);
		} else if (tabId.equals("luntan")) {
			mViewPager.setCurrentItem(1);
		} else {
			mViewPager.setCurrentItem(2);

		}

	}

}
