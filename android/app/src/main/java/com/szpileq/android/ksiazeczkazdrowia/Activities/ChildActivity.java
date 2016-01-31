package com.szpileq.android.ksiazeczkazdrowia.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.szpileq.android.ksiazeczkazdrowia.Fx;
import com.szpileq.android.ksiazeczkazdrowia.R;

public class ChildActivity extends AppCompatActivity {

    RelativeLayout childInfoPanel, familyInfoPanel, prenatalInfoPanel, visitInfoPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
/*
        Bundle bundle = getIntent().getExtras();
        String childID = bundle.getString("childID");
        SharedPreferences pref = getSharedPreferences("AppPref", MODE_PRIVATE);
        String token = pref.getString("token", "");

        ArrayList params = new ArrayList<NameValuePair>();
        ServerRequestGet getChildDataRequest = new ServerRequestGet();
        JSONObject jsonKidData = getChildDataRequest.getJSON("http://192.168.1.21:9000/api/patients/"+childID, params, token);

        Patient kid = new Gson().fromJson(jsonKidData.toString(), Patient.class);

        System.out.println(kid.getBirthInfo().getBodyLength()); */

        childInfoPanel = (RelativeLayout) findViewById(R.id.childInfoPanel);
        familyInfoPanel = (RelativeLayout) findViewById(R.id.familyInfoPanel);
        prenatalInfoPanel = (RelativeLayout) findViewById(R.id.prenatalInfoPanel);
        visitInfoPanel = (RelativeLayout) findViewById(R.id.visitInfoPanel);

        childInfoPanel.setVisibility(View.GONE);
        familyInfoPanel.setVisibility(View.GONE);
        prenatalInfoPanel.setVisibility(View.GONE);
        visitInfoPanel.setVisibility(View.GONE);

    }

    /**
     * onClick handler
     */
    public void toggle_contents(View v){
        RelativeLayout panel = null;
        switch(v.getId()) {
            case R.id.childInfoPanelText:
                panel = childInfoPanel;
                break;
            case R.id.familyInfoPanelText:
                panel = familyInfoPanel;
                break;
            case R.id.prenatalInfoPanelText:
                panel = prenatalInfoPanel;
                break;
            case R.id.visitInfoPanelText:
                panel = visitInfoPanel;
                break;
        }

        if(panel.isShown()){
            Fx.slide_up(this, panel);
            panel.setVisibility(View.GONE);
        }
        else{
            panel.setVisibility(View.VISIBLE);
            Fx.slide_down(this, panel);
        }
    }
}
