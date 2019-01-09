package com.example.hp.ifit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements View.OnClickListener {
    private Button btnLogin;
    private EditText etEmail, etPassword;

    private String dummyEmail ="test@gmail.com";
    private String dummyPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(this);
        ((Button) findViewById(R.id.btnRegister)).setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                if(checkValidation()) {
                    if (etEmail.getText().toString().equals(dummyEmail) && etPassword.getText().toString().equals(dummyPassword)) {

                        SharedPreferences spLogin = getSharedPreferences("login",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor =  spLogin.edit();
                        editor.putString("email",etEmail.getText().toString());
                        editor.putString("pass",etPassword.getText().toString());
                        editor.putBoolean("isLogedin",true);
                        editor.commit();


                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                        startActivity(intent);

                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid Email/Password.", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.btnRegister:
                Intent intent = new Intent(LoginActivity.this,  SignUpActivity.class);
                startActivity(intent);

        }
    }
    private boolean checkValidation(){
        if(etEmail.getText().toString() == null || etEmail.getText().toString().length() <=0){
            etEmail.setError("Email can not empty.");
            etEmail.requestFocus();
            return  false;
        }
        if(etPassword.getText().toString() == null || etPassword.getText().toString().length()<=0){
            etPassword.setError("Password can not empty.");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }
}
