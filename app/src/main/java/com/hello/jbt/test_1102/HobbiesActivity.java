package com.hello.jbt.test_1102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class HobbiesActivity extends AppCompatActivity {


    public static final String HobbiesParameterName = "hobbiesList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
    }

    public void submithobbies(View v)
    {
        ArrayList<String> hobbiesList = new ArrayList<String>();

        CheckBox sport = (CheckBox)findViewById(R.id.sportCB);
        if(sport.isChecked())
            hobbiesList.add(sport.getText().toString());
        CheckBox tv = (CheckBox)findViewById(R.id.tvCB);
        if(tv.isChecked())
            hobbiesList.add(tv.getText().toString());
        CheckBox music = (CheckBox)findViewById(R.id.musicCB);
        if(music.isChecked())
            hobbiesList.add(music.getText().toString());

        // put the data on the intent - to be passed back to the calling activity
        Intent myIntent = getIntent();
        myIntent.putExtra(HobbiesParameterName, hobbiesList);

        // set the result - the status and the data
        setResult(RESULT_OK, myIntent);

        // this closes the screen and actually returns the the previous one
        finish();

    }


    // currently no need to override since it automatically sends status of Cancelled which is what we want
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Toast.makeText(this, "Going back", Toast.LENGTH_SHORT).show();
        setResult(RESULT_CANCELED);
        finish();
    }

    public void cancelHobbies(View v)
    {
        setResult(RESULT_CANCELED);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hobbies, menu);
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
