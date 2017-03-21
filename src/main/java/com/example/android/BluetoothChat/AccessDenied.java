package com.example.android.BluetoothChat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AccessDenied extends Activity
{
    TextView adenied;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denied);
        initialize();

        Thread timer = new Thread()
        {
            public void run()
            {
                try{
                    sleep(10000);
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
        adenied = (TextView) findViewById(R.id.adenied);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}
