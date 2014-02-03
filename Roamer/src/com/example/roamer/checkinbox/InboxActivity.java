package com.example.roamer.checkinbox;


import com.example.roamer.HomeScreenActivity;
import com.example.roamer.R;
import com.example.roamer.profilelist.MyRoamerModel;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;


public class InboxActivity extends Activity {

    ListView listView;
    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.inbox_list);


        MyRoamerModel.LoadModel();
        
        listView = (ListView) findViewById(R.id.listView);
        String[] ids = new String[MyRoamerModel.Items.size()];
        for (int i= 0; i < ids.length; i++){

            ids[i] = Integer.toString(i+1);
        }

        ItemAdapter adapter = new ItemAdapter(this,R.layout.row_message, ids);
        listView.setAdapter(adapter);
        
        listView.setLongClickable(true);
        
        ImageButton inboxButton = (ImageButton) findViewById(R.id.inboxBackButton);
        inboxButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent i=new Intent(InboxActivity.this,HomeScreenActivity.class);
                startActivity(i);
            		  
            }
        });
        
        listView.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int pos, long id) {
                // TODO Auto-generated method stub
            	
            	final Dialog dialog = new Dialog(context);
            	
    			dialog.setContentView(R.layout.dialog_clear_chat);
    			dialog.setTitle("Clear Chat History");
    			
    			dialog.show();
    			
    			Button dialogButton = (Button) dialog.findViewById(R.id.imageClearChat);
    			// if button is clicked, close the custom dialog
    			dialogButton.setOnClickListener(new OnClickListener() {
    				@Override
    				public void onClick(View v) {
    					
    					String name = "None";
    					//name = MyRoamerModel.GetbyId(pos+1).Name;
    					clearChat(name);
    					dialog.dismiss();
    				}
    			});

                Log.v("long clicked","pos: " + pos);

                return true;
            }
        }); 
        
        
        Button messageButton = (Button) findViewById(R.id.newMessageButton);
        messageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	final Dialog dialog = new Dialog(context);
            	
    			dialog.setContentView(R.layout.select_roamer_for_message);
    			dialog.setTitle("Select Roamer");
    			

    			
    			dialog.show();
    			
    			ImageButton dialogButton = (ImageButton) dialog.findViewById(R.id.imageStartMessage);
    			// if button is clicked, close the custom dialog
    			dialogButton.setOnClickListener(new OnClickListener() {
    				@Override
    				public void onClick(View v) {
    					
    					/*
    					int spinnerPos;
    					Spinner position = (Spinner) dialog.findViewById(R.id.spinnerSelectRoamer);
    	            	String spin = position.getSelectedItem().toString();
    	            	*/
    					dialog.dismiss();
    					Intent i=new Intent(InboxActivity.this,DiscussActivity.class);
    	                startActivity(i);
    	            		  
    				}
    			});

            }
        });

    }
    
    class MyData {
        public MyData(String spinnerText, String value) {
            this.spinnerText = spinnerText;
            this.value = value;
        }

        public String getSpinnerText() {
            return spinnerText;
        }

        public String getValue() {
            return value;
        }

        public String toString() {
            return spinnerText;
        }

        String spinnerText;
        String value;
    }
    
    public void clearChat(String name){
    	
    	SQLiteDatabase db = this.openOrCreateDatabase("RoamerDatabase", MODE_PRIVATE, null);
		db.delete("ChatTable", null, null);
		db.close();
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}