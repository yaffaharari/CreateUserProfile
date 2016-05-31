package com.hello.jbt.test_1102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FamilyStatusActivity extends AppCompatActivity {

    RadioGroup statusGroup ;
    public static final String STATUS_PARAMETER_NAME = "Status";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_status);

        statusGroup = (RadioGroup)findViewById(R.id.statusGroup);
    }

    public void submitStatus(View v)
    {
        int selectedId = statusGroup.getCheckedRadioButtonId();
        RadioButton selectedRadio = (RadioButton)findViewById(selectedId);
        String selectedStatus = selectedRadio.getText().toString();

        Intent theIntent = getIntent();
        theIntent.putExtra(STATUS_PARAMETER_NAME, selectedStatus);
        setResult(RESULT_OK, theIntent);
        finish();
    }

    public void printSelectionToLog(View v)
    {
        // first parameter is the Log Tag name - used for filter, second parameteri is the message
        // method e, d, etc referes to the Log Level that the message is issued at
        Log.e("Test", "Problem in selection");
        Log.d("Test", "debug message");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_family_status, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
