package com.example.android.BluetoothChat;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class AccessDenied extends Activity
{

    private static final String TAG = "Access Denied -  ";

    TextView adenied;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.denied);
        initialize();
    }

    private void initialize()
    {
        adenied = (TextView) findViewById(R.id.adenied);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    process();
                    finish();
                }
            }
        };
        timer.start();
    }

    private void process()
    {
        try
        {
            String url = "http://thugcode.com/embedded/pages/upload.php?command=request&response=2";
            httpGetData(url);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error sending data. Check connection.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        finish();
    }

    public String httpGetData(String mURL)
    {
        String response="";
        mURL=mURL.replace(" ", "%20");

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httppost = new HttpGet(mURL);

        try
        {
            // Execute HTTP Post Request
            ResponseHandler<String> responseHandler=new BasicResponseHandler();
            httpclient.execute(httppost,responseHandler);
        }
        catch (ClientProtocolException e)
        {
            // TODO Auto-generated catch block
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
        }
        return response;
    }
}
