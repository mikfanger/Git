package com.example.roamer.checkinbox;

import java.io.IOException;

import com.example.roamer.HomeScreenActivity;
import com.example.roamer.R;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;

public class InboxActivity extends Activity {

    ListView listView;
    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.inbox_list);

        try {
			Model.LoadModel();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        listView = (ListView) findViewById(R.id.listView);
        String[] ids = new String[Model.Items.size()];
        for (int i= 0; i < ids.length; i++){

            ids[i] = Integer.toString(i+1);
        }

        ItemAdapter adapter = new ItemAdapter(this,R.layout.row_message, ids);
        listView.setAdapter(adapter);
        
        ImageButton inboxButton = (ImageButton) findViewById(R.id.inboxBackButton);
        inboxButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent i=new Intent(InboxActivity.this,HomeScreenActivity.class);
                startActivity(i);
            		  
            }
        });
      /*  
		//Region
        Spinner position = (Spinner) findViewById(R.id.spinnerSelectRoamer);
        //Prepare adapter 
        //HERE YOU CAN ADD ITEMS WHICH COMES FROM SERVER.
        final MyData items1[] = new MyData[5];
        
        for(int i = 0; i < MyRoamerModel.Items.size()-1; i++)
        {
        	String roamerName = MyRoamerModel.GetbyId(i).Name;
        	System.out.println("Item name is: " + roamerName);
	        items1[i] = new MyData(roamerName, "");
        }
      
        items1[0] = new MyData("Steve", "value1");
        items1[1] = new MyData("Joe", "value2");
        items1[2] = new MyData("Bart", "value3");
        items1[3] = new MyData("Mike", "value2");
        items1[4] = new MyData("Forest", "value3");
        ArrayAdapter<MyData> adapter1 = new ArrayAdapter<MyData>(this,
                android.R.layout.simple_spinner_item, items1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        position.setAdapter(adapter1);
        position.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                MyData d = items1[position];

                //Get selected value of key 
                String value = d.getValue();
                String key = d.getSpinnerText();
            }

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
        });
        */
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
    
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}