package com.szpileq.android.ksiazeczkazdrowia.Activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.szpileq.android.ksiazeczkazdrowia.Patient;
import com.szpileq.android.ksiazeczkazdrowia.R;
import com.szpileq.android.ksiazeczkazdrowia.ServerRequests.ServerRequestGet;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        Bundle bundle = getIntent().getExtras();
        String childID = bundle.getString("childID");
        SharedPreferences pref = getSharedPreferences("AppPref", MODE_PRIVATE);
        String token = pref.getString("token", "");

        ArrayList params = new ArrayList<NameValuePair>();
        ServerRequestGet getChildDataRequest = new ServerRequestGet();
        JSONObject jsonKidData = getChildDataRequest.getJSON("http://192.168.0.9:9000/api/patients/"+childID, params, token);

        Patient kid = new Gson().fromJson(jsonKidData.toString(), Patient.class);

        System.out.println(kid.getBirthInfo().getBodyLength());


        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
