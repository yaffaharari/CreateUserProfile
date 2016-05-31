package com.hello.jbt.test_1102;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static final int HOBBIES_CODE = 1;
    public static final int FAMILY_STATUS_CODE = 2;
    public static final int CAMERA_CODE = 3;


    private TextView hobbiesText ;
    private TextView statusText ;
    private EditText usernameText;
    private ImageButton profileImage;

    ArrayList<String> hobbiesList = new ArrayList<String>();
    String familyStatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();


    }

    public void initComponents()
    {
        hobbiesText =  (TextView)findViewById(R.id.hobbiesText);
        statusText = (TextView)findViewById(R.id.statusText);
        usernameText = (EditText)findViewById(R.id.usernameEdit);
        profileImage = (ImageButton)findViewById(R.id.profileImageButton);
    }

    public void selectHobbies(View v)
    {
        Intent intent = new Intent(this, HobbiesActivity.class);
        startActivityForResult(intent, HOBBIES_CODE);

    }

    public void selectStatus(View v)
    {
        Intent intent = new Intent(this, FamilyStatusActivity.class);
        startActivityForResult(intent, FAMILY_STATUS_CODE);
    }

    public void captureImage(View v)
    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_CODE);
    }

    public void showAlert(View v)
    {
        AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("My app");
        dialog.setMessage("Data saved successfully");

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                       Toast.makeText(MainActivity.this, "Pressed the button", Toast.LENGTH_SHORT).show();
                    }
                });
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if(resultCode == RESULT_OK)
        {
            if(requestCode == HOBBIES_CODE ) {
                hobbiesList = data.getStringArrayListExtra(HobbiesActivity.HobbiesParameterName);
                hobbiesText.setText(hobbiesList.toString());
            }
            else if(requestCode == FAMILY_STATUS_CODE)
            {
                familyStatus = data.getStringExtra(FamilyStatusActivity.STATUS_PARAMETER_NAME);
                statusText.setText(familyStatus);
            }
            else if(requestCode == CAMERA_CODE)
            {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                profileImage.setImageBitmap(imageBitmap);
            }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
