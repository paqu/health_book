package com.szpileq.android.ksiazeczkazdrowia;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.gesture.*;

import com.google.gson.Gson;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends Activity {
    TextView nametxt, pesel;
    SharedPreferences pref;
    String token, grav, oldpasstxt, newpasstxt;
    WebView web;
    Button chgpass, chgpassfr, cancel, logout;
    Dialog dlg;
    EditText oldpass, newpass;
    List<NameValuePair> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        pref = getSharedPreferences("AppPref", MODE_PRIVATE);
        token = pref.getString("token", "");
        nametxt = (TextView) findViewById(R.id.nameProfileText);

        params = new ArrayList<NameValuePair>();
        ServerRequestGet getUserDataRequest = new ServerRequestGet();
        JSONObject jsonUserData = getUserDataRequest.getJSON("http://192.168.43.21:9000/api/users/me", params, token);
        if (jsonUserData != null) {
            try {
                nametxt.setText("Witaj " + jsonUserData.getString("name") + "!");


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        jsonUserData = null;

        ServerRequestGet getKidsDataRequest = new ServerRequestGet();
        String jsonKidsData = getKidsDataRequest.getJSONArr("http://192.168.43.21:9000/api/patients", params, token);

        try {
            System.out.println(jsonKidsData);
            JSONArray jsonArray = new JSONArray(jsonKidsData);

            ArrayList<Patient> patientsList= new ArrayList<Patient>();

            for (int i = 0; i < jsonArray.length(); i++) {
                Patient patient = new Gson().fromJson(jsonArray.getJSONObject(i).toString(), Patient.class);
                patientsList.add(patient);
                patientsList.add(patient);
                patientsList.add(patient);
                patientsList.add(patient);
                patientsList.add(patient);
            }

            ListView listview = (ListView) findViewById(R.id.kidsListView);

            PatientAdapter adbPatient;
            adbPatient = new PatientAdapter(ProfileActivity.this, 0, patientsList);
            listview.setAdapter(adbPatient);
        }catch (JSONException e) {
            e.printStackTrace();
        }



        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = pref.edit();
                //Storing Data using SharedPreferences
                edit.putString("token", "");
                edit.commit();
                Intent loginactivity = new Intent(ProfileActivity.this, LoginActivity.class);

                startActivity(loginactivity);
                finish();
            }
        });

        pref = getSharedPreferences("AppPref", MODE_PRIVATE);
        token = pref.getString("token", "");

    }
}