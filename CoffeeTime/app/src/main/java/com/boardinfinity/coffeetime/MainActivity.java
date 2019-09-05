package com.boardinfinity.coffeetime;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h1=new Handler();
        h1.postDelayed(new Runnable() {

            @Override

            public void run() {

                ((ImageView)findViewById(R.id.imageView2)).setVisibility(View.VISIBLE);


            }

        }, 2*1000);// wait for 5 seconds

        Handler h2 =new Handler();
        h2.postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(MainActivity.this, LoginScreen.class);

                startActivity(i);

                finish();

            }

        }, 5*1000);

    }
}
