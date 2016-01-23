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

                JSONObject json = sr.getJSON("http://192.168.43.21:9000/auth/local",params);
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

        forpass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                reset = new Dialog(LoginActivity.this);
                reset.setTitle("Reset Password");
                reset.setContentView(R.layout.reset_pass_init);
                cont = (Button)reset.findViewById(R.id.resbtn);
                cancel = (Button)reset.findViewById(R.id.cancelbtn);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        reset.dismiss();
                    }
                });
                res_email = (EditText)reset.findViewById(R.id.email);

                cont.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        email_res_txt = res_email.getText().toString();

                        params = new ArrayList<NameValuePair>();
                        params.add(new BasicNameValuePair("email", email_res_txt));

                        //  JSONObject json = sr.getJSON("http://192.168.56.1:8080/api/resetpass", params);
                        JSONObject json = sr.getJSON("http://192.168.0.20:8080/api/resetpass", params);

                        if (json != null) {
                            try {
                                String jsonstr = json.getString("response");
                                if(json.getBoolean("res")){
                                    Log.e("JSON", jsonstr);
                                    Toast.makeText(getApplication(), jsonstr, Toast.LENGTH_LONG).show();
                                    reset.setContentView(R.layout.reset_pass_code);
                                    cont_code = (Button)reset.findViewById(R.id.conbtn);
                                    code = (EditText)reset.findViewById(R.id.code);
                                    newpass = (EditText)reset.findViewById(R.id.npass);
                                    cancel1 = (Button)reset.findViewById(R.id.cancel);
                                    cancel1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            reset.dismiss();
                                        }
                                    });
                                    cont_code.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            code_txt = code.getText().toString();
                                            npass_txt = newpass.getText().toString();
                                            Log.e("Code",code_txt);
                                            Log.e("New pass",npass_txt);
                                            params = new ArrayList<NameValuePair>();
                                            params.add(new BasicNameValuePair("email", email_res_txt));
                                            params.add(new BasicNameValuePair("code", code_txt));
                                            params.add(new BasicNameValuePair("newpass", npass_txt));

                                            JSONObject json = sr.getJSON("http://192.168.0.9:8080/api/resetpass/chg", params);
                                            //   JSONObject json = sr.getJSON("http://192.168.56.1:8080/api/resetpass/chg", params);

                                            if (json != null) {
                                                try {

                                                    String jsonstr = json.getString("response");
                                                    if(json.getBoolean("res")){
                                                        reset.dismiss();
                                                        Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();

                                                    }else{
                                                        Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();

                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }

                                        }
                                    });
                                }else{

                                    Toast.makeText(getApplication(),jsonstr,Toast.LENGTH_LONG).show();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                });


                reset.show();
            }
        });

    }
}