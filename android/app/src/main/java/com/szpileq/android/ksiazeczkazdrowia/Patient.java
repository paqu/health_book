package com.szpileq.android.ksiazeczkazdrowia;

import com.szpileq.android.ksiazeczkazdrowia.Info.FamilyInfo;

public class Patient extends PatientBasic {
    public FamilyInfo getFamilyInfo() {
        return familyInfo;
    }

    public void setFamilyInfo(FamilyInfo familyInfo) {
        this.familyInfo = familyInfo;
    }

    private FamilyInfo familyInfo;
}
