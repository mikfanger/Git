package com.example.roamer;

import com.example.roamer.location.MyLocation;
import com.example.roamer.location.MyLocation.LocationResult;

import android.location.Location;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Toast;

public class SendMessage extends Activity {
	
	public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message);
           
        Button backButton = (Button) findViewById(R.id.SendButton);
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	CheckBox check1 = (CheckBox)findViewById(R.id.checkBox1);
            	CheckBox check2 = (CheckBox)findViewById(R.id.checkBox2);
            	CheckBox check3 = (CheckBox)findViewById(R.id.checkBox3);
            	CheckBox check4 = (CheckBox)findViewById(R.id.checkBox4);
            	
            	 if(check1.isChecked())
                     message = getString(R.string.anyone_around); // you can save this as checked somewhere
                 if(check2.isChecked())
                     message = getString(R.string.grab_a_drink); // you can save this as checked somewhere
                 if(check3.isChecked())
                     message = getString(R.string.out_tonight); // you can save this as checked somewhere
                 if(check4.isChecked())
                     message = getString(R.string.getting_food); // you can save this as checked somewhere
                 
                 Context context = getApplicationContext();
                 CharSequence text = "Message Sent!";
                 int duration = Toast.LENGTH_SHORT;

                 Toast toast = Toast.makeText(context, text, duration);
                 toast.setGravity(Gravity.TOP|Gravity.LEFT, 250, 130);
                 toast.show();
                 
            	Intent i=new Intent(SendMessage.this,HomeScreenActivity.class);
                startActivity(i);
                
            }
        });
        
        Button inboxButton = (Button) findViewById(R.id.inboxButton);
        inboxButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	LocationResult locationResult = new LocationResult(){
            	    @Override
            	    public void gotLocation(Location location){
            	        //Got the location!
            	    }
            	};
            	
            	System.out.println(locationResult.toString());  //Should print current location
            	//MyLocation myLocation = new MyLocation();
            	//myLocation.getLocation(this, locationResult);
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