package com.hanxia.duorougardon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.hanxia.duorougardon.newthings.Send_Write;

public class Others extends Fragment {
	Button btn_send_write;
	OnClickListener listener;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		return inflater.inflate(R.layout.others_xml, container,false);
		
		
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO 自动生成的方法存根
		super.onViewCreated(view, savedInstanceState);
		btn_send_write=(Button)view.findViewById(R.id.btn_write);
		
		btn_send_write.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent send_write_intent=new Intent(getActivity(),Send_Write.class);
				startActivity(send_write_intent);
				
				
			}
		});
	}

	
}
