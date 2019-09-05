package com.boardinfinity.coffeetime;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class LoginScreen extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    ImageButton imgbst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        final EditText editText=(EditText)findViewById(R.id.editText);
        EditText editText1=(EditText)findViewById(R.id.editText2);
        Button login=(Button)findViewById(R.id.button);
        Button register=(Button)findViewById(R.id.button2);
        imgbst=findViewById(R.id.imageButton);

        String Email= editText.getText().toString();
        String Password=editText1.getText().toString();
        final MyDatabase myDatabase= new MyDatabase(LoginScreen.this);
        String emaill=sharedPreferences.getString("Email","nothing");
        String passs=sharedPreferences.getString("Password","null");
        if(getLoggedStatus()){
            Intent intent=new Intent(LoginScreen.this,Main2Activity.class);
            intent.putExtra("Username",emaill );
            intent.putExtra("Password",passs );
            startActivity(intent);
            finish();
        }
        if(getRememberMeStatus()){

            String email=sharedPreferences.getString("Email","nothing");
            String pass=sharedPreferences.getString("Password","null");
            editText.setText(email,TextView.BufferType.EDITABLE);
            editText1.setText(pass,TextView.BufferType.EDITABLE);

        }

        imgbst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inte=new Intent(LoginScreen.this,LoginPageSettings.class);
                startActivity(inte);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText=(EditText) findViewById(R.id.editText);
                EditText editText1 = (EditText) findViewById(R.id.editText2);
                String Email= editText.getText().toString();
                String Password = editText1.getText().toString();
                if((myDatabase.checkUser(Email,Password))) {
                    if (((CheckBox) findViewById(R.id.checkBox)).isChecked()) {

                        editor.putBoolean("RememberMe", true);

                        editor.commit();


                    } else {
                        editor.putBoolean("RememberMe", false);

                        editor.commit();
                    }




                    editor.putString("Email", Email);
                    editor.putString("Password", Password);
                    editor.putBoolean("LOGGED_IN_PREF", true);
                    editor.commit();
                    Intent intent = new Intent(LoginScreen.this, Main2Activity.class);
                    intent.putExtra("Email",Email);
                    intent.putExtra("Password",Password);


                    startActivity(intent);
                    finish();

                }
                else{
                    Toast.makeText(LoginScreen.this,"Wrong Email or Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginScreen.this, Register.class);

                startActivity(i);

                finish();
            }
        });



    }

    public boolean getLoggedStatus() {
        SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        boolean bstatus=sharedPreferences.getBoolean("LOGGED_IN_PREF",false);
        return bstatus;
    }

    public boolean getRememberMeStatus() {
        SharedPreferences sharedPreferences=getSharedPreferences("Data",Context.MODE_PRIVATE);
        boolean rememberme=sharedPreferences.getBoolean("RememberMe",false);
        return rememberme;
    }



}
