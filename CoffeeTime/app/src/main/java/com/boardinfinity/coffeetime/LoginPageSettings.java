package com.boardinfinity.coffeetime;

import android.database.Cursor;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class LoginPageSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page_settings);

        ((ImageButton)findViewById(R.id.back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((Button)findViewById(R.id.udata)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyDatabase myDatabase= new MyDatabase(LoginPageSettings.this);
                Cursor res =myDatabase.getalldata();
                StringBuffer bfr=new StringBuffer();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                while(res.moveToNext()){
                    bfr.append("Id : "+res.getInt(0)+"\n");
                    bfr.append("Username : "+res.getString(1)+"\n");
                    bfr.append("Email : "+res.getString(2)+"\n");
                    bfr.append("Password : "+res.getString(3)+"\n\n");



                }
                showMessage("User Data",bfr.toString());
            }
        });
        ((Button)findViewById(R.id.odata)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final OrderDatabase dbji=new OrderDatabase(LoginPageSettings.this);
                Cursor res =dbji.getalldata();
                StringBuffer bfr=new StringBuffer();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Found");
                    return;
                }
                while(res.moveToNext()){
                    bfr.append("Id : "+res.getInt(0)+"\n");
                    bfr.append("Email : "+res.getString(1)+"\n");
                    bfr.append("Cappuccino: "+res.getString(2)+"\n");
                    bfr.append("Macchiato: "+res.getString(3)+"\n");
                    bfr.append("Latte: "+res.getString(4)+"\n");
                    bfr.append("Americano: "+res.getString(5)+"\n");
                    bfr.append("Cafemocha: "+res.getString(6)+"\n");
                    bfr.append("Frappe: "+res.getString(7)+"\n");
                    bfr.append("Indonesian Coffee: "+res.getString(8)+"\n");
                    bfr.append("Ethopian Coffee: "+res.getString(9)+"\n");
                    bfr.append("Viennese Coffee: "+res.getString(10)+"\n");
                    bfr.append("Turkish Coffee: "+res.getString(11)+"\n");
                    bfr.append("Vietnamese: "+res.getString(12)+"\n");
                    bfr.append("Portugal Coffee: "+res.getString(13)+"\n");
                    bfr.append("Cookies: "+res.getString(14)+"\n");
                    bfr.append("Caremel Cake: "+res.getString(15)+"\n");
                    bfr.append("Choko Cake: "+res.getString(16)+"\n");
                    bfr.append("Choco Bar: "+res.getString(17)+"\n");
                    bfr.append("Milk Shake: "+res.getString(18)+"\n");
                    bfr.append("Orange Juice: "+res.getString(19)+"\n\n");

                }
                showMessage("Order Data",bfr.toString());
            }
        });
    }
    public void showMessage(String Title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(message);
        builder.show();
    }
}
