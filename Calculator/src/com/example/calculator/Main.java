package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Main extends Activity {
	
	// Object Declaration
	Processor processor;

		
	/**
	 * This 'onCreate' method is the first method that is launched upon initialization of this Activity.
	 * All initialization required for this view to function is placed here.
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	
        processor = new Processor();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    /**
     * This method is called when a element from the 'Menu' list is selected.
     * There is no associated android:onClick attribute in the activity_main.xml file
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    		Intent intent = new Intent(this, About.class);
    		
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_settings:
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    
    
    public void pressButton(View view){
    	/**
    	 * This method will be called whenever a 'View' in the 'Activity_Main.xml' 
    	 * which has an attribute of android:onClick="pressButton" is activated.
    	 */
    	
    	// We use 'findViewById' to find the specific view upon which this Button is called.
    	TextView button = (TextView) findViewById(view.getId()); // view is the specific Button which called this method.
    	TextView output = (TextView) findViewById(R.id.textView1); // R.id.textView1 is the text field at the top of the application
    	
    	String number = (String) button.getText(); // 'button' is the TextView object which is found initialized above, the Text is extracted from the button in the XML file
    	
    	// Inserting number associated with Button object into processor
    	processor.insert(number);
    	
    	// Viewing the result from our processor onto our output
    	output.setText(processor.getResult());
    	
    }
    
}