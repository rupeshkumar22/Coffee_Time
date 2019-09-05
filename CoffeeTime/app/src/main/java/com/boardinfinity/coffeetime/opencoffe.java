package com.boardinfinity.coffeetime;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class opencoffe extends AppCompatActivity {

    final MyDatabase myDatabase= new MyDatabase(opencoffe.this);


ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opencoffe);
        final OrderDatabase db2=new OrderDatabase(opencoffe.this);
        final TextView textView = (TextView) findViewById(R.id.itemname);
        final EditText textViewQ = (EditText) findViewById(R.id.textView9);
        Button plus =(Button) findViewById(R.id.plus);
        Button minus =(Button) findViewById(R.id.minus);
        Button add =(Button) findViewById(R.id.add);
        TextView textViewC = (TextView) findViewById(R.id.Cost);
        textViewQ.setText("1");
        Bundle ext = getIntent().getExtras();
        final String itnm = ext.getString("ItemName");
        textView.setText(itnm);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((textViewQ.getText().toString()).matches("[0-9]+") && (textViewQ.getText().toString()).length() > 0 && (textViewQ.getText().toString()).length() <= 2){
                    textViewQ.setText(Integer.toString((Integer.parseInt(textViewQ.getText().toString()))+1),TextView.BufferType.EDITABLE);
                    }
                else{
                    Toast.makeText(opencoffe.this, "Not a valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((textViewQ.getText().toString()).matches("[0-9]+") && (textViewQ.getText().toString()).length() > 0 && (textViewQ.getText().toString()).length() <= 2 && (!(Integer.parseInt(textViewQ.getText().toString())<2))){
                    textViewQ.setText(Integer.toString((Integer.parseInt(textViewQ.getText().toString()))-1),TextView.BufferType.EDITABLE);
                }
                else{
                    Toast.makeText(opencoffe.this, "Not a valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });
        final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        final boolean bstatus=sharedPreferences.getBoolean("LOGGED_IN_PREF",false);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bstatus){


                        String emaill=sharedPreferences.getString("Email","nothing");
                        if(emaill!=null){
                            Cursor curs=db2.getalldatarow(emaill);
                            if (curs.moveToFirst()) // data?{
                            {
                                Integer id=curs.getInt(curs.getColumnIndex("Id"));
                                String usrnn=curs.getString(curs.getColumnIndex("Email"));
                                db2.updatevalueitembyId(id,itnm,textViewQ.getText().toString());
                                Toast.makeText(opencoffe.this, "Order updated in list", Toast.LENGTH_SHORT).show();
                            }



                        }
                        else{
                            Toast.makeText(opencoffe.this, "Unable to process, Can't get Email from Shared Preferences", Toast.LENGTH_SHORT).show();
                        }







                    }




            }
        });




        Toast.makeText(this, itnm, Toast.LENGTH_SHORT).show();

                switch (itnm) {
                    case "Cappuccino":
                        ((ImageView)findViewById(R.id.capa)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.machh)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.latte)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.amer)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.cafe)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.frappe)).setVisibility(View.INVISIBLE);
                        textViewC.setText("40");

                        break;
                    case "Macchiato":
                        ((ImageView)findViewById(R.id.machh)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.capa)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.latte)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.amer)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.cafe)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.frappe)).setVisibility(View.INVISIBLE);
                        textViewC.setText("30");
                        break;
                    case "Latte":
                        ((ImageView)findViewById(R.id.latte)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.capa)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.machh)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.amer)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.cafe)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.frappe)).setVisibility(View.INVISIBLE);
                        textViewC.setText("40");
                        break;
                    case "Americano":
                        ((ImageView)findViewById(R.id.amer)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.capa)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.machh)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.latte)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.cafe)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.frappe)).setVisibility(View.INVISIBLE);
                        textViewC.setText("30");
                        break;

                    case "Cafemocha":
                        ((ImageView)findViewById(R.id.cafe)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.capa)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.machh)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.latte)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.amer)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.frappe)).setVisibility(View.INVISIBLE);
                        textViewC.setText("50");
                        break;
                    case "Frappe":
                        ((ImageView)findViewById(R.id.frappe)).setVisibility(View.VISIBLE);
                        ((ImageView)findViewById(R.id.capa)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.machh)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.latte)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.amer)).setVisibility(View.INVISIBLE);
                        ((ImageView)findViewById(R.id.cafe)).setVisibility(View.INVISIBLE);
                        textViewC.setText("50");
                        break;

                }

    }

}


