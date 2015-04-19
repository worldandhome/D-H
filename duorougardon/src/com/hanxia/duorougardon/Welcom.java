package com.hanxia.duorougardon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;

public class Welcom extends Activity {
	Button btn;
@Override
	protected void onCreate(Bundle savedInstanceState) {
	requestWindowFeature(Window.FEATURE_NO_TITLE);              //移除actionbar
	    View view=View.inflate(this, R.layout.welcom, null);
		setContentView(view);
		//渐变启动展示
		AlphaAnimation aa=new AlphaAnimation(0.3f, 1.0f);
		aa.setDuration(2000);
		view.startAnimation(aa);
		aa.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			@Override
			public void onAnimationRepeat(Animation animation) {	
			}
			@Override
			public void onAnimationEnd(Animation animation) {
				redirecto();	
			}
			private void redirecto() {	
				Intent intent=new Intent(Welcom.this,Login_in.class);
				startActivity(intent);
			}
			
		});
		
		super.onCreate(savedInstanceState);
}
}
