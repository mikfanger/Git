package com.example.roamer;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;


public class HomeScreenActivity extends Activity {
	
	Point p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	

        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        
        ImageButton backButton = (ImageButton) findViewById(R.id.BackIntroButton);
        backButton.setOnClickListener(new OnClickListener() {
        	
            @Override
            
            public void onClick(View v) {
            	
            	Intent i=new Intent(HomeScreenActivity.this,IntroActivity.class);
                startActivity(i);
            }
        });

        
        ImageButton sendButton = (ImageButton) findViewById(R.id.sendMessageButton);
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent i=new Intent(HomeScreenActivity.this,SendMessage.class);
                startActivity(i);
            		  
            }
        });
        
        ImageButton findButton = (ImageButton) findViewById(R.id.findRoamers);
        findButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent i=new Intent(HomeScreenActivity.this,PersonListActivity.class);
                startActivity(i);
            		  
            }
        });
        
        ImageButton settingsButton = (ImageButton) findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent i=new Intent(HomeScreenActivity.this,SettingsActivity.class);
                startActivity(i);
            		  
            }
        });
        
        
        ImageButton exitMainButton = (ImageButton) findViewById(R.id.ExitButtonMain);
        exitMainButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent startMain = new Intent(Intent.ACTION_MAIN);
            	startMain.addCategory(Intent.CATEGORY_HOME);
            	startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            	startActivity(startMain);
            	finish();
                System.exit(0);
            }
        }); 

    }
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
   
}