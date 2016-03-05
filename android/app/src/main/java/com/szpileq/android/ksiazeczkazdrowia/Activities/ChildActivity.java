package com.szpileq.android.ksiazeczkazdrowia.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.szpileq.android.ksiazeczkazdrowia.Fx;
import com.szpileq.android.ksiazeczkazdrowia.Patient;
import com.szpileq.android.ksiazeczkazdrowia.R;
import com.szpileq.android.ksiazeczkazdrowia.ServerRequests.ServerRequestGet;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChildActivity extends AppCompatActivity {

    RelativeLayout childInfoPanel, familyInfoPanel, prenatalInfoPanel;
    TextView visitsInfoText;

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
        final JSONObject jsonKidData = getChildDataRequest.getJSON("http://192.168.0.20:9000/api/patients/"+childID, params, token);

        Patient kid = new Gson().fromJson(jsonKidData.toString(), Patient.class);

        System.out.println(kid.getBirthInfo().getBodyLength());

        childInfoPanel = (RelativeLayout) findViewById(R.id.childInfoPanel);
        familyInfoPanel = (RelativeLayout) findViewById(R.id.familyInfoPanel);
        prenatalInfoPanel = (RelativeLayout) findViewById(R.id.prenatalInfoPanel);

        childInfoPanel.setVisibility(View.GONE);
        familyInfoPanel.setVisibility(View.GONE);
        prenatalInfoPanel.setVisibility(View.GONE);

        /*  filling up the health book    */

        TextView childTitle = (TextView) findViewById(R.id.childNameSurnameText);

        TextView childProfileNameText = (TextView) findViewById(R.id.childProfileNameText);
        TextView childProfileSurnameText = (TextView) findViewById(R.id.childProfileSurnameText);
        TextView childProfileAddressText = (TextView) findViewById(R.id.childProfileAddressText);
        TextView childProfilePlaceOfBirthText = (TextView) findViewById(R.id.childProfilePlaceOfBirthText);
        TextView childProfileDateOfBirthText = (TextView) findViewById(R.id.childProfileDateOfBirthText);
        TextView childProfilePeselText = (TextView) findViewById(R.id.childProfilePeselText);
        TextView childProfileMotherNameText = (TextView) findViewById(R.id.childProfileMotherNameText);
        TextView childProfileFatherNameText = (TextView) findViewById(R.id.childProfileFatherNameText);
        TextView childProfileContactPhoneText = (TextView) findViewById(R.id.childProfileContactPhoneText);
        TextView childProfileMotherAgeText = (TextView) findViewById(R.id.childProfileMotherAgeText);
        TextView childProfileBloodGroupText = (TextView) findViewById(R.id.childProfileBloodGroupText);
        TextView childProfileMothersRHText = (TextView) findViewById(R.id.childProfileMothersRHText);
        TextView childProfileImmuAntyRHDText = (TextView) findViewById(R.id.childProfileImmuAntyRHDText);
        TextView childProfilePregnancyPreventionText = (TextView) findViewById(R.id.childProfilePregnancyPreventionText);
        TextView childProfilePreventionAfterBirthText = (TextView) findViewById(R.id.childProfilePreventionAfterBirthText);
        TextView childProfilePregnancyNumberText = (TextView) findViewById(R.id.childProfilePregnancyNumberText);
        TextView childProfileIsSingleText = (TextView) findViewById(R.id.childProfileIsSingleText);
        TextView childProfileIsMultifetalText = (TextView) findViewById(R.id.childProfileIsMultifetalText);
        TextView childProfileCaregiverText = (TextView) findViewById(R.id.childProfileCaregiverText);
        TextView childProfileDateText = (TextView) findViewById(R.id.childProfileDateText);

        //Child Info
        if(null != kid.getChildInfo().getFirstname() && null != kid.getChildInfo().getSurname())
            childTitle.setText(kid.getChildInfo().getFirstname() + kid.getChildInfo().getSurname());
        if(null != kid.getChildInfo().getFirstname())
            childProfileNameText.setText(kid.getChildInfo().getFirstname());
        if(null != kid.getChildInfo().getSurname())
            childProfileSurnameText.setText(kid.getChildInfo().getSurname());
        if(null != kid.getChildInfo().getAddress())
            childProfileAddressText.setText(kid.getChildInfo().getAddress());
        if(null != kid.getChildInfo().getPlaceOfBirth())
            childProfilePlaceOfBirthText.setText(kid.getChildInfo().getPlaceOfBirth());
        if(null != kid.getChildInfo().getDateOfBirth())
            childProfileDateOfBirthText.setText(kid.getChildInfo().getDateOfBirth());
        if(null != kid.getChildInfo().getPesel())
            childProfilePeselText.setText(kid.getChildInfo().getPesel());

        //Family info
        if(null != kid.getFamilyInfo()) {
            if (null != kid.getFamilyInfo().getMotherName())
                childProfileMotherNameText.setText(kid.getFamilyInfo().getMotherName());
            if (null != kid.getFamilyInfo().getFatherName())
                childProfileFatherNameText.setText(kid.getFamilyInfo().getFatherName());
            if (null != kid.getFamilyInfo().getContactPhone())
                childProfileContactPhoneText.setText(kid.getFamilyInfo().getContactPhone());
        }

        //Prenatal info
        if(null != kid.getPrenatalInfo()) {
            if (null != kid.getPrenatalInfo().getMotherAge())
                childProfileMotherAgeText.setText(kid.getPrenatalInfo().getMotherAge().toString());
            if (null != kid.getPrenatalInfo().getBloodGroup())
                childProfileBloodGroupText.setText(kid.getPrenatalInfo().getBloodGroup());
            if (null != kid.getPrenatalInfo().getMotherRhFactor())
                childProfileMothersRHText.setText(kid.getPrenatalInfo().getMotherRhFactor());
            if (null != kid.getPrenatalInfo().getIsImmuAntyRhDApplied())
                childProfileImmuAntyRHDText.setText(kid.getPrenatalInfo().getIsImmuAntyRhDApplied() ? "Tak" : "Nie");
            if (null != kid.getPrenatalInfo().getIsPreventionDuringPregnancy())
                childProfilePregnancyPreventionText.setText(kid.getPrenatalInfo().getIsPreventionDuringPregnancy() ? "Tak" : "Nie");
            if (null != kid.getPrenatalInfo().getIsPreventionAfterChildBirth())
                childProfilePreventionAfterBirthText.setText(kid.getPrenatalInfo().getIsPreventionAfterChildBirth() ? "Tak" : "Nie");
            if (null != kid.getPrenatalInfo().getPregnancyNumber())
                childProfilePregnancyNumberText.setText(kid.getPrenatalInfo().getPregnancyNumber().toString());
            if (null != kid.getPrenatalInfo().getIsSingle())
                childProfileIsSingleText.setText(kid.getPrenatalInfo().getIsSingle() ? "Tak" : "Nie");
            if (null != kid.getPrenatalInfo().getIsMultiFetal())
                childProfileIsMultifetalText.setText(kid.getPrenatalInfo().getIsMultiFetal() ? "Tak" : "Nie");
            if (null != kid.getPrenatalInfo().getCaregiver())
                childProfileCaregiverText.setText(kid.getPrenatalInfo().getCaregiver());
            if (null != kid.getPrenatalInfo().getDate())
                childProfileDateText.setText(kid.getPrenatalInfo().getDate());
        }

        visitsInfoText = (TextView) findViewById(R.id.visitInfoPanelText);
        visitsInfoText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Bundle bundle = new Bundle();
                bundle.putString("kidInfo", jsonKidData.toString());
                Intent i = new Intent(ChildActivity.this, VisitsActivity.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

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
