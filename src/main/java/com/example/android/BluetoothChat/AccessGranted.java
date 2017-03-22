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

public class AccessGranted extends Activity
{
    private static final String TAG = "Access Granted -  ";

    TextView access;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.granted);
        initialize();
    }

    private void initialize()
    {
        access = (TextView) findViewById(R.id.agranted);
        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    process();
                }
            }
        };
        timer.start();
    }

    private void process()
    {
        try
        {
            String url = "http://thugcode.com/embedded/upload.php?command=request&response=1";
            httpGetData(url);
            Intent intent = new Intent();
            Bundle messages = new Bundle();
            messages.putString("message", "1");
            intent.putExtras(messages);
            setResult(RESULT_OK, intent);
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error sending data. Check connection.", Toast.LENGTH_SHORT).show();
        }
        finally
        {
            Log.e(TAG, "- ON Process Finally -");
            Intent openStartingPoint = new Intent("com.example.android.BluetoothChat.BLUETOOTHMAIN");
            startActivity(openStartingPoint);
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
