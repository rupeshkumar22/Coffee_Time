package com.boardinfinity.coffeetime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
Created By- Rupesh Kumar at July 2019
A part of open source project GitHub Link
https://github.com/rupesh-kumar-lpu/Coffee_Time
 */


public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btn=(Button)findViewById(R.id.button4);
        Button register=(Button)findViewById(R.id.button3);
        final MyDatabase myDatabase= new MyDatabase(Register.this);
        final EditText EditTextemail=(EditText) findViewById(R.id.editText4);
        final EditText EditUsername=(EditText) findViewById(R.id.editText3);
        final EditText EditPassword=(EditText) findViewById(R.id.editText5);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, LoginScreen.class);

                startActivity(i);

                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emaile = EditTextemail.getText().toString();
                String unamee = EditUsername.getText().toString();
                String passe = EditPassword.getText().toString();
                if (!(emaile.matches("")||unamee.matches("")||passe.matches(""))){
                    if(emaile.length()>5&&unamee.length()>5&&passe.length()>5) {
                        if ((!TextUtils.isEmpty(emaile) && Patterns.EMAIL_ADDRESS.matcher(emaile).matches())) {
                            if (!(myDatabase.checkEmailAlready(emaile))) {
                                long id = myDatabase.insertRegisterDataInTable(unamee, emaile, passe);
                                Toast.makeText(Register.this, "Account Created Sucessfully! Login Please!  id:" + String.format("%d", id), Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Register.this, LoginScreen.class);

                                startActivity(i);

                                finish();
                            } else {
                                Toast.makeText(Register.this, "Registeration Unsuccessfull! Email alredy exists!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Register.this, "Enter a valid Email Address!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Register.this, "Fields Input Length can't be less than 5", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Register.this, "Fields Can't be Empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
