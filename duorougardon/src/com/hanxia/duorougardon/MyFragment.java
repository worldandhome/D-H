package com.hanxia.duorougardon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MyFragment extends Fragment {
	String[] data = { "���", "�����û�", "��԰��̳", "����ٿ�","����" };
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.myfragment, container, false);
	}
	@Override
public void onViewCreated(View view, Bundle savedInstanceState) {
		
		super.onViewCreated(view, savedInstanceState);
		 
		ListView listView=(ListView) view.findViewById(R.id.listView1);
		listView.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,data));	
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2,// ������λ��
					long arg3) {
				String s=data[arg2];
				
			}
		});
}
	
}