package com.example.roamer;

import com.example.roamer.location.MyLocation.LocationResult;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SendMessage extends Activity {
	
	public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.send_message);
           

    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}