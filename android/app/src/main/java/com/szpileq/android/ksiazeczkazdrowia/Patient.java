package com.szpileq.android.ksiazeczkazdrowia;

import com.szpileq.android.ksiazeczkazdrowia.Info.FamilyInfo;
import com.szpileq.android.ksiazeczkazdrowia.Info.PrenatalInfo;

public class Patient extends PatientBasic {

    private FamilyInfo familyInfo;
    private PrenatalInfo prenatalInfo;

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
