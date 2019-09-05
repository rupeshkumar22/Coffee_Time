package com.boardinfinity.coffeetime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class Orders extends AppCompatActivity {
    int Total;
    String phoneNo,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        final String orderfinal;

        ((TextView)findViewById(R.id.textView7)).setMovementMethod(new ScrollingMovementMethod());
        final SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        final boolean bstatus=sharedPreferences.getBoolean("LOGGED_IN_PREF",false);
        final OrderDatabase db2=new OrderDatabase(Orders.this);
        ((ImageButton)findViewById(R.id.imgbtbk)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Orders.this.finish();
            }
        });






        ((Button)findViewById(R.id.clrdb)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bstatus){


                    String emaill=sharedPreferences.getString("Email","nothing");
                    if(emaill!=null){
                        Cursor curs=db2.getalldatarow(emaill);
                        if (curs.moveToFirst()) // data?{
                        {
                            Integer iddd=curs.getInt(curs.getColumnIndex("Id"));
                            String emmm=curs.getString(curs.getColumnIndex("Email"));
                            db2.clearall(iddd);
                            ((TextView)findViewById(R.id.textView7)).setText("\n\n Total = 0");
                        }



                    }
                    else{
                        Toast.makeText(Orders.this, "Unable to process, Can't get Email from Shared Preferences", Toast.LENGTH_SHORT).show();
                    }







                }
            }
        });

        if(bstatus){



            final String emaill=sharedPreferences.getString("Email","nothing");
            if(emaill!=null){
                Cursor curs=db2.getalldatarow(emaill);
                if (curs.moveToFirst()) // data?{
                {
                    final Integer id=curs.getInt(curs.getColumnIndex("Id"));
                    final String emm=curs.getString(curs.getColumnIndex("Email"));
                    final String Capp=curs.getString(curs.getColumnIndex("Cappuccino"));
                    String Mach=curs.getString(curs.getColumnIndex("Macchiato"));
                    String Latt=curs.getString(curs.getColumnIndex("Latte"));
                    String Amer=curs.getString(curs.getColumnIndex("Americano"));
                    String Cafe=curs.getString(curs.getColumnIndex("Cafemocha"));
                    String Frap=curs.getString(curs.getColumnIndex("Frappe"));


                    String Indo=curs.getString(curs.getColumnIndex("Indonesian_Coffee"));
                    String Etho=curs.getString(curs.getColumnIndex("Ethopian_Coffee"));
                    String Vien=curs.getString(curs.getColumnIndex("Viennese_Coffee"));
                    String Turk=curs.getString(curs.getColumnIndex("Turkish_Coffee"));
                    String Viet=curs.getString(curs.getColumnIndex("Vietnamese"));
                    String Port=curs.getString(curs.getColumnIndex("Portugal_Coffee"));


                    String Cook=curs.getString(curs.getColumnIndex("Cookies"));
                    String Care=curs.getString(curs.getColumnIndex("Caremel_Cake"));
                    String Chok=curs.getString(curs.getColumnIndex("Choko_Cake"));
                    String Choc=curs.getString(curs.getColumnIndex("Choco_Bar"));
                    String Milk=curs.getString(curs.getColumnIndex("Milk_Shake"));
                    String Oran=curs.getString(curs.getColumnIndex("Orange_Juice"));


                    ((TextView)findViewById(R.id.textView7)).setText("");


                    if(Capp!=null){
                        Total+=+40*Integer.parseInt(Capp);
                        ((TextView)findViewById(R.id.textView7)).append(" Cappuccino x"+Capp+" = "+"40*"+Capp+" = "+40*Integer.parseInt(Capp)+"\n");
                    }
                    if(Mach!=null){
                        Total+=+30*Integer.parseInt(Mach);
                        ((TextView)findViewById(R.id.textView7)).append(" Macchiatoo x"+Mach+" = "+"30*"+Mach+" = "+30*Integer.parseInt(Mach)+"\n");
                    }
                    if(Latt!=null){
                        Total+=+40*Integer.parseInt(Latt);
                        ((TextView)findViewById(R.id.textView7)).append(" Latte x"+Latt+" = "+"40*"+Latt+" = "+40*Integer.parseInt(Latt)+"\n");
                    }
                    if(Amer!=null){
                        Total+=+30*Integer.parseInt(Amer);
                        ((TextView)findViewById(R.id.textView7)).append(" Americano x"+Amer+" = "+"30*"+Amer+" = "+30*Integer.parseInt(Amer)+"\n");
                    }
                    if(Cafe!=null){
                        Total+=+50*Integer.parseInt(Cafe);
                        ((TextView)findViewById(R.id.textView7)).append(" Cafemocha x"+Cafe+" = "+"50*"+Cafe+" = "+50*Integer.parseInt(Cafe)+"\n");
                    }
                    if(Frap!=null){
                        Total+=+50*Integer.parseInt(Frap);
                        ((TextView)findViewById(R.id.textView7)).append(" Frappe x"+Frap+" = "+"50*"+Frap+" = "+50*Integer.parseInt(Frap)+"\n");
                    }


                    if(Indo!=null){
                        Total+=+30*Integer.parseInt(Indo);
                        ((TextView)findViewById(R.id.textView7)).append(" Indonesian Coffee x"+Indo+" = "+"30*"+Indo+" = "+30*Integer.parseInt(Indo)+"\n");
                    }
                    if(Etho!=null){
                        Total+=+30*Integer.parseInt(Etho);
                        ((TextView)findViewById(R.id.textView7)).append(" Ethopian Coffee x"+Etho+" = "+"30*"+Etho+" = "+30*Integer.parseInt(Etho)+"\n");
                    }
                    if(Vien!=null){
                        Total+=+40*Integer.parseInt(Vien);
                        ((TextView)findViewById(R.id.textView7)).append(" Viennese Coffee x"+Vien+" = "+"40*"+Vien+" = "+40*Integer.parseInt(Vien)+"\n");
                    }
                    if(Turk!=null){
                        Total+=+40*Integer.parseInt(Turk);
                        ((TextView)findViewById(R.id.textView7)).append(" Turkish Coffee x"+Turk+" = "+"40*"+Turk+" = "+40*Integer.parseInt(Turk)+"\n");
                    }
                    if(Viet!=null){
                        Total+=+40*Integer.parseInt(Viet);
                        ((TextView)findViewById(R.id.textView7)).append(" Vietnamese x"+Viet+" = "+"40*"+Viet+" = "+40*Integer.parseInt(Viet)+"\n");
                    }
                    if(Port!=null){
                        Total+=+30*Integer.parseInt(Port);
                        ((TextView)findViewById(R.id.textView7)).append(" Portugal Coffee x"+Port+" = "+"30*"+Port+" = "+30*Integer.parseInt(Port)+"\n");
                    }

                    if(Cook!=null){
                        Total+=+30*Integer.parseInt(Cook);
                        ((TextView)findViewById(R.id.textView7)).append(" Cookies x"+Cook+" = "+"30*"+Cook+" = "+30*Integer.parseInt(Cook)+"\n");
                    }
                    if(Care!=null){
                        Total+=+30*Integer.parseInt(Care);
                        ((TextView)findViewById(R.id.textView7)).append(" Caremel Cake x"+Care+" = "+"30*"+Care+" = "+30*Integer.parseInt(Care)+"\n");
                    }
                    if(Chok!=null){
                        Total+=+40*Integer.parseInt(Chok);
                        ((TextView)findViewById(R.id.textView7)).append(" Choko Cake x"+Chok+" = "+"40*"+Chok+" = "+40*Integer.parseInt(Chok)+"\n");
                    }
                    if(Choc!=null){
                        Total+=+20*Integer.parseInt(Choc);
                        ((TextView)findViewById(R.id.textView7)).append(" Choco Bar x"+Choc+" = "+"20*"+Choc+" = "+20*Integer.parseInt(Choc)+"\n");
                    }
                    if(Milk!=null){
                        Total+=+30*Integer.parseInt(Milk);
                        ((TextView)findViewById(R.id.textView7)).append(" Milk Shake x"+Milk+" = "+"30*"+Milk+" = "+30*Integer.parseInt(Milk)+"\n");
                    }
                    if(Oran!=null){
                        Total+=+30*Integer.parseInt(Oran);
                        ((TextView)findViewById(R.id.textView7)).append(" Orange Juice x"+Oran+" = "+"30*"+Oran+" = "+30*Integer.parseInt(Oran)+"\n");
                    }

                    ((TextView)findViewById(R.id.textView7)).append("\n\n Total = "+Integer.toString(Total));

                    orderfinal= ((TextView)findViewById(R.id.textView7)).getText().toString();
                    ((Button)findViewById(R.id.placeorder)).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                if (((EditText) findViewById(R.id.tbledit)).getText().toString().matches("")) {
                                    Toast.makeText(Orders.this, "Please enter Table No. to proceed.", Toast.LENGTH_LONG).show();
                                } else {
                                        sendEmail((orderfinal+"\n"+"App Signed Email "+"= "+emm+"\nOrder Id = "+id+"\n"+"Table No. = "+((EditText) findViewById(R.id.tbledit)).getText().toString()));

                                }

                        }
                    });

                }



            }
            else{
                Toast.makeText(Orders.this, "Unable to process, Can't get Email from Shared Preferences", Toast.LENGTH_SHORT).show();
            }


        }


    }

    protected void sendEmail(String orderfinal) {
        Toast.makeText(Orders.this, orderfinal, Toast.LENGTH_SHORT).show();
        Log.i("Send email", "");
        String[] TO = {"coffee.time.app.andro@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order (Coffee Time)");
        emailIntent.putExtra(Intent.EXTRA_TEXT,orderfinal);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Orders.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }


}
