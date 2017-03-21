package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class AccessGranted extends Activity
{
    TextView access;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.granted);
        initialize();

        Thread timer = new Thread()
        {
            public void run()
            {
                try{
                    sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openStartingPoint = new Intent("com.example.android.BluetoothChat.BLUETOOTHMAIN");
                    startActivity(openStartingPoint);
                }
            }
        };
        timer.start();

    }

    private void initialize()
    {
        access = (TextView) findViewById(R.id.agranted);
    }
}
