package com.example.voteaplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private  static  final int MY_PERMISSIONS_REQUEST_RECEIVE_SMS = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomMenu);

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(
                MainActivity.this,Manifest
                        .permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]
                    { Manifest.permission.SEND_SMS,},1000);
        }else{
            Toast.makeText(this, "El usuario no ha concedido los permisos", Toast.LENGTH_SHORT).show();
            //System.exit(0);
        };

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentInicio, new HomeFragment()).commit();
        }


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        break;
                    case  R.id.nav_graph:
                        fragment = new GraphFragment();
                        break;
                    case R.id.nav_regist:
                        fragment = new RegisterFragment();
                        break;
                    case R.id.nav_phones:
                        fragment = new PhonesFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentInicio, fragment).commit();
                return true;
            }
        });


        //Permisos del mensaje
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)){

            }else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS}, MY_PERMISSIONS_REQUEST_RECEIVE_SMS);
            }
        }
    }//On create
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // ...
        if (requestCode == MY_PERMISSIONS_REQUEST_RECEIVE_SMS) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "¡Gracias por el permiso, joke!", Toast.LENGTH_SHORT).show();
                // Get SMS message content
                //String message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE);
                // Extract one-time code from the message and complete verification
                // `sms` contains the entire text of the SMS message, so you will need
                // to parse the string.
                //String oneTimeCode = parseOneTimeCode(message); // define this function

                // send one time code to the server
            } else {
                // Consent canceled, handle the error ...
                Toast.makeText(this, "No puedo hacer nada sino tengo permisos.", Toast.LENGTH_SHORT).show();
            }
        }
    }



}
