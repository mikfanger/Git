package com.example.roamer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class CreateAccountActivity extends Activity {

	private EditText newEmailAddress;
	private EditText newUsername;
	private EditText newPassword;
	private EditText newConfirmPassword;
	
	private String mEmailAddress;
	private String mUsername;
	private String mPassword;
	private String mConfirmPassword;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_create_account);
        
        ImageButton introButton = (ImageButton) findViewById(R.id.submitInfo);
        introButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	submitInfo();
            }
        });
        
        TextView myTextView=(TextView)findViewById(R.id.textStepTwo);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"fonts/Eurostile.ttf");
        myTextView.setTypeface(typeFace);
        
        TextView t2 = (TextView) findViewById(R.id.textWhereFrom);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }
    

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void submitInfo()
    {
    	newPassword = (EditText) findViewById(R.id.newPassword);
    	newUsername = (EditText) findViewById(R.id.newUsername);
    	newConfirmPassword = (EditText) findViewById(R.id.newConfirmPassword);
    	newEmailAddress = (EditText) findViewById(R.id.newEmail);
    	
    	mEmailAddress = newEmailAddress.getText().toString();
    	mPassword = newPassword.getText().toString();
    	mUsername = newUsername.getText().toString();
    	mConfirmPassword = newConfirmPassword.getText().toString();
    	
    	boolean cancel = false;
    	
    	if (TextUtils.isEmpty(mEmailAddress)) {
			cancel = true;
		}
    	if (TextUtils.isEmpty(mPassword)) {
			cancel = true;
		}
    	if (TextUtils.isEmpty(mConfirmPassword)) {
			cancel = true;
		}
    	if (TextUtils.isEmpty(mUsername)) {
			cancel = true;
		}
		
    	//Check that all fields are filled out
    	if (cancel == false)
    	{
    		//Commit user preferences to database
    		SharedPreferences settings = getSharedPreferences("UserInfo", 0);
    		SharedPreferences.Editor editor = settings.edit();
    		editor.putString("Username",mUsername);
    		editor.putString("Password",mPassword);
    		editor.commit();
    		
    		Intent i=new Intent(CreateAccountActivity.this,CreateAccountActivity2.class);
            startActivity(i);
    	}
    	else
    	{
    		Context context = getApplicationContext();
            CharSequence text = "Please fill out all fields!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.TOP|Gravity.LEFT, 250, 130);
            toast.show();
    	}
    	
    }
    
    
    
}
