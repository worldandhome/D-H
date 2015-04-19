package com.hanxia.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hanxia.duorougardon.LunTan;
import com.hanxia.duorougardon.MyGarden;
import com.hanxia.duorougardon.Others;

public class MyFragmentAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();

	public MyFragmentAdapter(FragmentManager fm) {
		super(fm);
		fragments.add(new Others());
		fragments.add(new LunTan());
		fragments.add(new MyGarden());
	}

	@Override
	public Fragment getItem(int arg0) {
		return fragments.get(arg0);
	}

	@Override
	public int getCount() {

		return fragments.size();
	}


}
