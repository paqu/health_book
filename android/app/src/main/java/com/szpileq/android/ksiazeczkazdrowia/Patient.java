package com.szpileq.android.ksiazeczkazdrowia;

import com.szpileq.android.ksiazeczkazdrowia.Info.FamilyInfo;
import com.szpileq.android.ksiazeczkazdrowia.Info.PrenatalInfo;
import com.szpileq.android.ksiazeczkazdrowia.Info.StateAfterChildInfo;
import com.szpileq.android.ksiazeczkazdrowia.Info.VisitInfo;

import java.util.ArrayList;

public class Patient extends PatientBasic {

    private FamilyInfo familyInfo;
    private PrenatalInfo prenatalInfo;
    private StateAfterChildInfo stateAfterChildInfo;
    private ArrayList<VisitInfo> visitsInfo;

    public ArrayList<VisitInfo> getVisitsInfo() {
        return visitsInfo;
    }

    public void setVisitsInfo(ArrayList<VisitInfo> visitsInfo) {
        this.visitsInfo = visitsInfo;
    }

    public StateAfterChildInfo getStateAfterChildInfo() {
        return stateAfterChildInfo;
    }

    public void setStateAfterChildInfo(StateAfterChildInfo stateAfterChildInfo) {
        this.stateAfterChildInfo = stateAfterChildInfo;
    }

    public PrenatalInfo getPrenatalInfo() {
        return prenatalInfo;
    }

    public void setPrenatalInfo(PrenatalInfo prenatalInfo) {
        this.prenatalInfo = prenatalInfo;
    }

    public FamilyInfo getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }
}
