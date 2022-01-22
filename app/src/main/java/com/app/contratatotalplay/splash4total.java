package com.app.contratatotalplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;

public class splash4total extends AppCompatActivity {

    private int change = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash4total);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startoutside(intent);

        final Button introbutton = (Button) findViewById(R.id.introbtn);
        introbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Hola",Snackbar.LENGTH_SHORT);
            }
        });

    }
    private void startoutside(final Intent intentmain){
        Thread background = new Thread() {
            public void run() {
                try {
                    // Thread will sleep for 5 seconds
                    sleep(4*1100);

                    // After 5 seconds redirect to another intent
                    startActivity(intentmain);

                    //Remove activity
                    finish();
                } catch (Exception e) {
                }
            }
        };
        // start thread
        background.start();
    }
}