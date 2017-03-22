package com.example.android.BluetoothChat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alexf on 3/15/2017.
 */
public class DogRequest extends Activity implements View.OnClickListener
{
    TextView requestview;
    Button byes, bno;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
     super.onCreate(savedInstanceState);
        
        setContentView(R.layout.dogrequest);
        initialize();
    }

    private void initialize()
    {
        requestview = (TextView) findViewById(R.id.textViewOpenDoor);
        byes = (Button)findViewById(R.id.bYes);
        bno = (Button)findViewById(R.id.bNo);
        byes.setOnClickListener(this);
        bno.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            //Logic for access granted
            case R.id.bYes:
                Intent i = new Intent(DogRequest.this, AccessGranted.class);
                startActivityForResult(i, 0);
                break;
            //Logic for access denied
            case R.id.bNo:
                Intent j = new Intent(DogRequest.this, AccessDenied.class);
                startActivityForResult(j, 0);
                break;
        }

    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }
}
