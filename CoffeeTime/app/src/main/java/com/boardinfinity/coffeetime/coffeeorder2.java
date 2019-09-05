package com.boardinfinity.coffeetime;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class coffeeorder2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffeeorder2);
        TextView textView = (TextView) findViewById(R.id.itemname);
        ImageView imageView = (ImageView) findViewById(R.id.capa2);
        Bundle ext = getIntent().getExtras();
        final OrderDatabase db2=new OrderDatabase(coffeeorder2.this);
        final TextView textViewQ = (TextView) findViewById(R.id.textView9);
        TextView textViewC = (TextView) findViewById(R.id.Cost);
        textViewQ.setText("1");
        final String itnm = ext.getString("ItemName");
        Button plus =(Button) findViewById(R.id.plus);
        Button minus =(Button) findViewById(R.id.minus);
        textView.setText(itnm);
        Toast.makeText(this, itnm, Toast.LENGTH_SHORT).show();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((textViewQ.getText().toString()).matches("[0-9]+") && (textViewQ.getText().toString()).length() > 0 && (textViewQ.getText().toString()).length() <= 2){
                    textViewQ.setText(Integer.toString((Integer.parseInt(textViewQ.getText().toString()))+1),TextView.BufferType.EDITABLE);
                }
                else{
                    Toast.makeText(coffeeorder2.this, "Not a valid input", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(coffeeorder2.this, "Not a valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });


        final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        final boolean bstatus=sharedPreferences.getBoolean("LOGGED_IN_PREF",false);
        ((Button)findViewById(R.id.add2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bstatus){


                    String emaill=sharedPreferences.getString("Email","nothing");
                    if(emaill!=null){
                        Cursor curs=db2.getalldatarow(emaill);
                        if (curs.moveToFirst()) // data?{
                        {
                            String itm=itnm;
                            if(itnm.equals("Indonesian Coffee")){
                                 itm="Indonesian_Coffee";
                            }
                            if(itnm.equals("Ethopian Coffee")){
                                itm="Ethopian_Coffee";
                            }
                            if(itnm.equals("Viennese Coffee")){
                                itm="Viennese_Coffee";
                            }

                            if(itnm.equals("Turkish Coffee")){
                                itm="Turkish_Coffee";
                            }
                            if(itnm.equals("Portugal Coffee")){
                                itm="Portugal_Coffee";
                            }
                            Integer id=curs.getInt(curs.getColumnIndex("Id"));
                            String usrnn=curs.getString(curs.getColumnIndex("Email"));

                            db2.updatevalueitembyId(id,itm,textViewQ.getText().toString());
                            Toast.makeText(coffeeorder2.this, "Order updated in list", Toast.LENGTH_SHORT).show();
                        }



                    }
                    else{
                        Toast.makeText(coffeeorder2.this, "Unable to process, Can't get Email from Shared Preferences", Toast.LENGTH_SHORT).show();
                    }




                }




            }
        });


        switch (itnm) {
            case "Indonesian Coffee":
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.machh1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe1)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;
            case "Ethopian Coffee":
                ((ImageView)findViewById(R.id.machh1)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe1)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;
            case "Viennese Coffee":
                ((ImageView)findViewById(R.id.latte1)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe1)).setVisibility(View.INVISIBLE);
                textViewC.setText("40");
                break;
            case "Turkish Coffee":
                ((ImageView)findViewById(R.id.amer1)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe1)).setVisibility(View.INVISIBLE);
                textViewC.setText("40");
                break;

            case "Vietnamese":
                ((ImageView)findViewById(R.id.cafe1)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe1)).setVisibility(View.INVISIBLE);
                textViewC.setText("40");
                break;
            case "Portugal Coffee":
                ((ImageView)findViewById(R.id.frappe1)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer1)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe1)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;

        }

    }

}


