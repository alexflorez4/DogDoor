package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Fau_Picture extends Activity{

	@Override
	protected void onCreate(Bundle fauPicture) {
		// TODO Auto-generated method stub
		super.onCreate(fauPicture);
		setContentView(R.layout.activity_baby_fau);
		Thread timer = new Thread(){
			
			@Override
			public void run(){
				try{
					sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("com.example.android.BluetoothChat.BLUETOOTHMAIN");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
