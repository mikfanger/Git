package com.example.roamer;

import com.appenginetest.messageEndpoint.MessageEndpoint;
import com.example.roamer.appengine.CloudEndpointUtils;
import com.example.roamer.appengine.GCMIntentService;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;

public class IntroActivity extends Activity { 

	enum State {
	    REGISTERED, REGISTERING, UNREGISTERED, UNREGISTERING
	  }

	  private State curState = State.UNREGISTERED;
	  private OnTouchListener registerListener = null;
	  private OnTouchListener unregisterListener = null;
	  private MessageEndpoint messageEndpoint = null;
	  
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
    	
    	final String chatTable = "ChatTable";
    	final String myRoamersTable = "MyRoamers";
    	final String myCredTable = "MyCred";
    	final String myLocationTable = "MyLocation";
    	final String myEventsTable = "MyEvents";
    	
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.intro_screen);
        
        SQLiteDatabase myDB = this.openOrCreateDatabase("RoamerDatabase", MODE_PRIVATE, null);
        myDB.delete(myCredTable, null, null);
        /* Create a chat Table in the Database. */
        //myDB.delete(myRoamersTable, null, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
          + chatTable
          + " (Field1 VARCHAR,Field2 INT(1));");
        
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + myRoamersTable
                + " (Field1 VARCHAR, Field2 VARCHAR, Field3 VARCHAR);");
        
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + myLocationTable
                + " (Field1 VARCHAR, Field2 VARCHAR, Field3 VARCHAR);");
        
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + myCredTable
                + " (Field1 VARCHAR, Field2 VARCHAR, Field3 VARCHAR, Field4 INT(1));");
        
        myDB.execSQL("CREATE TABLE IF NOT EXISTS "
                + myEventsTable
                + " (rowid INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , Type VARCHAR, Location VARCHAR, Time VARCHAR, Host VARCHAR, HostPic VARCHAR, Blurb VARCHAR, Attend VARCHAR);");
        /*
        myDB.execSQL("INSERT INTO "
			       + "MyCred "
			       + "(Field1,Field2,Field3,Field4) "
			       + "VALUES ('null','null','null',"+0+");");
		*/
        
        
        
       myDB.close();
        
        
        
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
    
    public void registerWithEngine(){
    	GCMIntentService.register(getApplicationContext());
    	
    	/*
         * build the messaging endpoint so we can access old messages via an endpoint call
         */
    	MessageEndpoint.Builder endpointBuilder = new MessageEndpoint.Builder(
    	        AndroidHttp.newCompatibleTransport(),
    	        new JacksonFactory(),
    	        new HttpRequestInitializer() {
    	          public void initialize(HttpRequest httpRequest) { }
    	        });
    	
    	 messageEndpoint = CloudEndpointUtils.updateBuilder(endpointBuilder).build();
    }
    
    
}
