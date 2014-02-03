package com.example.roamer;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	final String fileName = "CurrentUser.txt";
    	final File currentDir = new File("user_info");
    	final File file = new File (currentDir, fileName);
    	final String chatTable = "ChatTable";
    	final String myRoamersTable = "MyRoamers";
    	try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.intro_screen);
        
        SQLiteDatabase myDB = this.openOrCreateDatabase("RoamerDatabase", MODE_PRIVATE, null);

        /* Create a chat Table in the Database. */
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
          + chatTable
          + " (Field1 VARCHAR,Field2 INT(1));");
        
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + myRoamersTable
                + " (Field1 VARCHAR, Field2 VARCAHR, Field3 VARCHAR);");
        
        
        ImageButton introButton = (ImageButton) findViewById(R.id.StartRoamerButton);
        introButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	           	
            	
            	Intent i=new Intent(IntroActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
