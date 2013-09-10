package com.example.roamer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class CreateAccountActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_create_account);
        
        Button introButton = (Button) findViewById(R.id.submitInfo);
        introButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
            	
            	Intent i=new Intent(CreateAccountActivity.this,CreateAccountActivity2.class);
                startActivity(i);
            }
        });
        
        Spinner s = (Spinner) findViewById(R.id.spinner1);
        //Prepar adapter 
        //HERE YOU CAN ADD ITEMS WHICH COMES FROM SERVER.
        final MyData items[] = new MyData[5];
        items[0] = new MyData("Northeast", "value1");
        items[1] = new MyData("Northwest", "value2");
        items[2] = new MyData("Southeast", "value3");
        items[3] = new MyData("Southwest", "value2");
        items[4] = new MyData("Midwest", "value3");
        ArrayAdapter<MyData> adapter = new ArrayAdapter<MyData>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                MyData d = items[position];

                //Get selected value of key 
                String value = d.getValue();
                String key = d.getSpinnerText();
            }

            public void onNothingSelected(AdapterView<?> parent) {
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
    
    public void importPicture(){
    	
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
}
