package com.example.roamer;

import com.example.roamer.location.MyLocation.LocationResult;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
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
import android.widget.EditText;
import android.widget.Toast;

public class SetLocationActivity extends Activity {
	
public Location	newLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.set_location);
           
        Button backButton = (Button) findViewById(R.id.setLocationButton);
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	CheckBox check2 = (CheckBox)findViewById(R.id.gpsLocation);
            	CheckBox check1 = (CheckBox)findViewById(R.id.zipLocation);
            	EditText zip = (EditText)findViewById(R.id.customZip);
            	Context context =  null;
            	CharSequence text = null;
            	int duration = 0;
            	
            	
                 if(check1.isChecked())
                     {
                	 check2.setSelected(false);
                	 context = getApplicationContext();
                     text = "Location set to ZIP code!  Current zip is: " + zip.getText().toString();
                     duration = Toast.LENGTH_SHORT;
                     }
                 
                 if(check2.isChecked())
                 	{
                	 context = getApplicationContext();
                	 text = "Location set to GPS!";
                	 duration = Toast.LENGTH_SHORT;
                 	}
                
                 Toast toast = Toast.makeText(context, text, duration);
                 toast.setGravity(Gravity.TOP|Gravity.LEFT, 250, 130);
                 toast.show();
                 
            	Intent i=new Intent(SetLocationActivity.this,HomeScreenActivity.class);
                startActivity(i);
                
            }
        });
        

    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void getRoamerLocation(){
    	// Acquire a reference to the system Location Manager
    	LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

    	// Define a listener that responds to location updates
    	LocationListener locationListener = new LocationListener() {
    	    public void onLocationChanged(Location location) {
    	      // Called when a new location is found by the network location provider.
    	      newLocation = location;
    	    }

    	    public void onStatusChanged(String provider, int status, Bundle extras) {}

    	    public void onProviderEnabled(String provider) {}

    	    public void onProviderDisabled(String provider) {}
    	  };

    	// Register the listener with the Location Manager to receive location updates
    	locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
    }
    
}