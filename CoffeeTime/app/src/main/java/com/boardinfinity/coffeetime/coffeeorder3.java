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


public class coffeeorder3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffeeorder3);
        final OrderDatabase db2=new OrderDatabase(coffeeorder3.this);
        TextView textView = (TextView) findViewById(R.id.itemname);
        ImageView imageView = (ImageView) findViewById(R.id.capa2);
        Bundle ext = getIntent().getExtras();
        final TextView textViewQ = (TextView) findViewById(R.id.textView9);
        TextView textViewC = (TextView) findViewById(R.id.Cost);
        Button plus =(Button) findViewById(R.id.plus);
        Button minus =(Button) findViewById(R.id.minus);
        textViewQ.setText("1");
        final String itnm = ext.getString("ItemName");
        textView.setText(itnm);
        Toast.makeText(this, itnm, Toast.LENGTH_SHORT).show();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((textViewQ.getText().toString()).matches("[0-9]+") && (textViewQ.getText().toString()).length() > 0 && (textViewQ.getText().toString()).length() <= 2){
                    textViewQ.setText(Integer.toString((Integer.parseInt(textViewQ.getText().toString()))+1),TextView.BufferType.EDITABLE);
                }
                else{
                    Toast.makeText(coffeeorder3.this, "Not a valid input", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(coffeeorder3.this, "Not a valid input", Toast.LENGTH_SHORT).show();
                }
            }
        });


        final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        final boolean bstatus=sharedPreferences.getBoolean("LOGGED_IN_PREF",false);
        ((Button)findViewById(R.id.add3)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bstatus){


                    String emaill=sharedPreferences.getString("Email","nothing");
                    if(emaill!=null){
                        Cursor curs=db2.getalldatarow(emaill);
                        String itm=itnm;
                        if(itnm.equals("Caremel Cake")){
                            itm="Caremel_Cake";
                        }
                        if(itnm.equals("Choko Cake")){
                            itm="Choko_Cake";
                        }
                        if(itnm.equals("Choco Bar")){
                            itm="Choco_Bar";
                        }

                        if(itnm.equals("Milk Shake")){
                            itm="Milk_Shake";
                        }
                        if(itnm.equals("Orange Juice")){
                            itm="Orange_Juice";
                        }
                        if (curs.moveToFirst()) // data?{
                        {
                            Integer id=curs.getInt(curs.getColumnIndex("Id"));
                            String usrnn=curs.getString(curs.getColumnIndex("Email"));
                            db2.updatevalueitembyId(id,itm,textViewQ.getText().toString());
                            Toast.makeText(coffeeorder3.this, "Order updated in list", Toast.LENGTH_SHORT).show();
                        }



                    }
                    else{
                        Toast.makeText(coffeeorder3.this, "Unable to process, Can't get Email from Shared Preferences", Toast.LENGTH_SHORT).show();
                    }




                }




            }
        });


        switch (itnm) {
            case "Cookies":
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.machh2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe2)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;
            case "Caremel Cake":
                ((ImageView)findViewById(R.id.machh2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe2)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;
            case "Choko Cake":
                ((ImageView)findViewById(R.id.latte2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe2)).setVisibility(View.INVISIBLE);
                textViewC.setText("40");
                break;
            case "Choco Bar":
                ((ImageView)findViewById(R.id.amer2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe2)).setVisibility(View.INVISIBLE);
                textViewC.setText("20");
                break;

            case "Milk Shake":
                ((ImageView)findViewById(R.id.cafe2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.frappe2)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;
            case "Orange Juice":
                ((ImageView)findViewById(R.id.frappe2)).setVisibility(View.VISIBLE);
                ((ImageView)findViewById(R.id.capa2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.machh2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.latte2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.amer2)).setVisibility(View.INVISIBLE);
                ((ImageView)findViewById(R.id.cafe2)).setVisibility(View.INVISIBLE);
                textViewC.setText("30");
                break;

        }





    }

}


