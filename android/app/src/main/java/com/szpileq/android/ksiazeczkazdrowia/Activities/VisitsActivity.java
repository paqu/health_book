package com.szpileq.android.ksiazeczkazdrowia.Activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.szpileq.android.ksiazeczkazdrowia.Fx;
import com.szpileq.android.ksiazeczkazdrowia.Info.VisitInfo;
import com.szpileq.android.ksiazeczkazdrowia.Patient;
import com.szpileq.android.ksiazeczkazdrowia.R;
import com.szpileq.android.ksiazeczkazdrowia.ServerRequests.ServerRequestGet;
import com.szpileq.android.ksiazeczkazdrowia.VisitsAdapter;

import org.apache.http.NameValuePair;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class VisitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visits);

        Bundle bundle = getIntent().getExtras();
        String jsonKidData = bundle.getString("kidInfo");

        Patient kid = new Gson().fromJson(jsonKidData, Patient.class);

        ListView listviewVisitsInfo = (ListView) findViewById(R.id.visitsListView);
        VisitsAdapter adbVisits;
        adbVisits = new VisitsAdapter(VisitsActivity.this, 0, kid.getVisitsInfo());
        listviewVisitsInfo.setAdapter(adbVisits);

    }

}
