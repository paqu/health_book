package com.szpileq.android.ksiazeczkazdrowia.Activities;

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

import com.google.gson.Gson;
import com.szpileq.android.ksiazeczkazdrowia.PatientAdapter;
import com.szpileq.android.ksiazeczkazdrowia.PatientBasic;
import com.szpileq.android.ksiazeczkazdrowia.R;
import com.szpileq.android.ksiazeczkazdrowia.ServerRequests.ServerRequestGet;

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
        JSONObject jsonUserData = getUserDataRequest.getJSON("http://192.168.1.21:9000/api/users/me", params, token);
        //System.out.println(jsonUserData);

        try {
            //JSONObject jsonUserData = new JSONObject("{\"__v\":0,\"role\":\"user\",\"surname\":\"Test User 1\",\"provider\":\"local\",\"firstname\":\"Julian\",\"_id\":\"56a67d9c27b192640290ec6d\",\"email\":\"test1@example.com\"}");
            //System.out.println(jsonUserData.toString());
            if (jsonUserData != null) {
                try{
                    nametxt.setText("Witaj " + jsonUserData.getString("firstname") + "!");


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            ServerRequestGet getKidsDataRequest = new ServerRequestGet();
            String jsonKidsData = getKidsDataRequest.getJSONArr("http://192.168.1.21:9000/api/patients/mychildren/"+jsonUserData.getString("_id"), params, token);
            //String jsonKidsData = new String("[{\"_id\":\"56a67d9c27b192640290ec72\",\"__v\":0,\"ChildInfo\":{\"surname\":\"Nowak\",\"firstname\":\"Julian\",\"placeOfBirth\":\"Gniezno\",\"address\":\"os. xxx 45/3, 62-200 Gniezno\",\"pesel\":111111111111,\"dateOfBirth\":{\"day\":1,\"month\":12,\"year\":1993}}},{\"_id\":\"56a67d9c27b192640290ec73\",\"__v\":0,\"ChildInfo\":{\"surname\":\"Nowak\",\"firstname\":\"Marek\",\"placeOfBirth\":\"Gniezno\",\"address\":\"os. xxx 45/3, 62-200 Gniezno\",\"pesel\":611111111111,\"dateOfBirth\":{\"day\":1,\"month\":12,\"year\":1993}}},{\"_id\":\"56a67d9c27b192640290ec74\",\"__v\":0,\"ChildInfo\":{\"surname\":\"Perka\",\"firstname\":\"Katarzyna\",\"placeOfBirth\":\"Gniezno\",\"address\":\"os. xxx 45/3, 62-200 Gniezno\",\"pesel\":511111111111,\"dateOfBirth\":{\"day\":1,\"month\":12,\"year\":1993}}},{\"_id\":\"56a67d9c27b192640290ec75\",\"__v\":0,\"ChildInfo\":{\"surname\":\"Lukasik\",\"firstname\":\"Wiktoria\",\"placeOfBirth\":\"Gniezno\",\"address\":\"os. xxx 45/3, 62-200 Gniezno\",\"pesel\":411111111111,\"dateOfBirth\":{\"day\":1,\"month\":12,\"year\":1993}}},{\"_id\":\"56a67d9c27b192640290ec76\",\"__v\":0,\"ChildInfo\":{\"surname\":\"Sobota\",\"firstname\":\"Robert\",\"placeOfBirth\":\"Gniezno\",\"address\":\"os. xxx 45/3, 62-200 Gniezno\",\"pesel\":311111111111,\"dateOfBirth\":{\"day\":1,\"month\":12,\"year\":1993}}},{\"_id\":\"56a67d9c27b192640290ec77\",\"__v\":0,\"ChildInfo\":{\"surname\":\"Wojcik\",\"firstname\":\"Wojciech\",\"placeOfBirth\":\"Gniezno\",\"address\":\"os. xxx 45/3, 62-200 Gniezno\",\"pesel\":211111111111,\"dateOfBirth\":{\"day\":1,\"month\":12,\"year\":1993}}}]");
            try {
                System.out.println(jsonKidsData);
                JSONArray jsonArray = new JSONArray(jsonKidsData);
                // deserialize list of patients into list of PatientBasic objects
                ArrayList<PatientBasic> patientsList= new ArrayList<PatientBasic>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    PatientBasic patientBasic = new Gson().fromJson(jsonArray.getJSONObject(i).toString(), PatientBasic.class);
                    patientsList.add(patientBasic);
                }

                ListView listviewPatientsList = (ListView) findViewById(R.id.kidsListView);

                PatientAdapter adbPatient;
                adbPatient = new PatientAdapter(ProfileActivity.this, 0, patientsList);
                listviewPatientsList.setAdapter(adbPatient);

            }catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
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