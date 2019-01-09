package com.example.hp.ifit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {
    private EditText name, mail, password;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name=( EditText)findViewById(R.id.name);
        mail=( EditText)findViewById(R.id.mail);
        password=( EditText)findViewById(R.id.password);
        register=(Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkValidation()){
                    Intent i=new Intent (SignUpActivity.this,LoginActivity.class);
                    startActivity(i);
                }


            }
        });



    }

    private boolean checkValidation(){
        if(name.getText().toString() == null || name.getText().toString().length() <=0){
            name.setError("Name can not empty.");
            name.requestFocus();
            return  false;
        }
        if(mail.getText().toString() == null || mail.getText().toString().length() <=0){
            mail.setError("Mail can not empty.");
            mail.requestFocus();
            return  false;
        }
        if(password.getText().toString() == null || password.getText().toString().length()<=0){
            password.setError("Password can not empty.");
            password.requestFocus();
            return false;
        }


        return true;
    }



}