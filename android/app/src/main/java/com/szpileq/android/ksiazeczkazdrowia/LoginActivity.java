package com.szpileq.android.ksiazeczkazdrowia;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class LoginActivity extends Activity {
    EditText email,password,res_email,code,newpass;
    Button login,cont,cont_code,cancel,cancel1,register,forpass;
    String emailtxt,passwordtxt,email_res_txt,code_txt,npass_txt;
    List<NameValuePair> params;
    SharedPreferences pref;
    Dialog reset;
    ServerRequestPost sr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sr = new ServerRequestPost();

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.loginbtn);
        forpass = (Button)findViewById(R.id.forgotpass);

        pref = getSharedPreferences("AppPref", MODE_PRIVATE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailtxt = email.getText().toString();
                passwordtxt = password.getText().toString();
                params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", emailtxt));
                params.add(new BasicNameValuePair("password", passwordtxt));
                ServerRequestPost sr = new ServerRequestPost();

                JSONObject json = sr.getJSON("http://192.168.0.9:9000/auth/local",params);
                if(json != null){
                    try{
                        String jsonstr = json.getString("message");
                        if(json.getBoolean("isSuccess")){
                            String token = json.getString("token");
                            SharedPreferences.Editor edit = pref.edit();
                            //Storing Data using SharedPreferences
                            edit.putString("token", token);
                            edit.commit();
                            Intent profactivity = new Intent(LoginActivity.this,ProfileActivity.class);

                            startActivity(profactivity);
                            finish();
                        }

                        Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}