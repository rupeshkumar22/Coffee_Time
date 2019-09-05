package com.boardinfinity.coffeetime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class Share extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        ((ImageButton)findViewById(R.id.imageButton3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
