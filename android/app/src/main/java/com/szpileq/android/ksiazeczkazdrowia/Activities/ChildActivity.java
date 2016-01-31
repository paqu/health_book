package com.szpileq.android.ksiazeczkazdrowia.Activities;

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
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChildActivity extends AppCompatActivity {

    RelativeLayout childInfoPanel, familyInfoPanel, prenatalInfoPanel, visitInfoPanel;

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
        JSONObject jsonKidData = getChildDataRequest.getJSON("http://192.168.1.21:9000/api/patients/"+childID, params, token);

        Patient kid = new Gson().fromJson(jsonKidData.toString(), Patient.class);

        System.out.println(kid.getBirthInfo().getBodyLength());

        childInfoPanel = (RelativeLayout) findViewById(R.id.childInfoPanel);
        familyInfoPanel = (RelativeLayout) findViewById(R.id.familyInfoPanel);
        prenatalInfoPanel = (RelativeLayout) findViewById(R.id.prenatalInfoPanel);
        visitInfoPanel = (RelativeLayout) findViewById(R.id.visitInfoPanel);

        childInfoPanel.setVisibility(View.GONE);
        familyInfoPanel.setVisibility(View.GONE);
        prenatalInfoPanel.setVisibility(View.GONE);
        visitInfoPanel.setVisibility(View.GONE);

        /*  filling up the health book    */

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
        childProfileNameText.setText(kid.getChildInfo().getFirstname());
        childProfileSurnameText.setText(kid.getChildInfo().getSurname());
        childProfileAddressText.setText(kid.getChildInfo().getAddress());
        childProfilePlaceOfBirthText.setText(kid.getChildInfo().getPlaceOfBirth());
        childProfileDateOfBirthText.setText(kid.getChildInfo().getDateOfBirth());
        childProfilePeselText.setText(kid.getChildInfo().getPesel());

        //Family info
        childProfileMotherNameText.setText(kid.getFamilyInfo().getMotherName());
        childProfileFatherNameText.setText(kid.getFamilyInfo().getFatherName());
        childProfileContactPhoneText.setText(kid.getFamilyInfo().getContactPhone());

        //Prenatal info
        childProfileMotherAgeText.setText(kid.getPrenatalInfo().getMotherAge().toString());
        childProfileBloodGroupText.setText(kid.getPrenatalInfo().getBloodGroup());
        childProfileMothersRHText.setText(kid.getPrenatalInfo().getMotherRhFactor());
        childProfileImmuAntyRHDText.setText(kid.getPrenatalInfo().getIsImmuAntyRhDApplied()?"Tak":"Nie");
        childProfilePregnancyPreventionText.setText(kid.getPrenatalInfo().getIsPreventionDuringPregnancy()?"Tak":"Nie");
        childProfilePreventionAfterBirthText.setText(kid.getPrenatalInfo().getIsPreventionAfterChildBrith()?"Tak":"Nie");
        childProfilePregnancyNumberText.setText(kid.getPrenatalInfo().getPregnancyNumber().toString());
        childProfileIsSingleText.setText(kid.getPrenatalInfo().getIsSingle()?"Tak":"Nie");
        childProfileIsMultifetalText.setText(kid.getPrenatalInfo().getIsMultiFetal()?"Tak":"Nie");
        childProfileCaregiverText.setText(kid.getPrenatalInfo().getCaregiver());
        childProfileDateText.setText(kid.getPrenatalInfo().getDate());
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
