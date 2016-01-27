package com.szpileq.android.ksiazeczkazdrowia.Info;

public class PrenatalInfo {
    private Number motherAge;
    private String bloodGroup;
    private String motherRhFactor;
    private Boolean isImmuAntyRhDApplied;
    private Boolean isPreventionDuringPregnancy;
    private Boolean isPreventionAfterChildBrith;
    private Number pregnancyNumber;
    private Boolean isSingle;
    private Boolean isMultiFetal;
    private String caregiver;
    private String date;

    public String getMotherRhFactor() {
        return motherRhFactor;
    }

    public void setMotherRhFactor(String motherRhFactor) {
        this.motherRhFactor = motherRhFactor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(String caregiver) {
        this.caregiver = caregiver;
    }

    public Boolean getIsMultiFetal() {
        return isMultiFetal;
    }

    public void setIsMultiFetal(Boolean isMultiFetal) {
        this.isMultiFetal = isMultiFetal;
    }

    public Boolean getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(Boolean isSingle) {
        this.isSingle = isSingle;
    }

    public Number getPregnancyNumber() {
        return pregnancyNumber;
    }

    public void setPregnancyNumber(Number pregnancyNumber) {
        this.pregnancyNumber = pregnancyNumber;
    }

    public Boolean getIsPreventionAfterChildBrith() {
        return isPreventionAfterChildBrith;
    }

    public void setIsPreventionAfterChildBrith(Boolean isPreventionAfterChildBrith) {
        this.isPreventionAfterChildBrith = isPreventionAfterChildBrith;
    }

    public Boolean getIsPreventionDuringPregnancy() {
        return isPreventionDuringPregnancy;
    }

    public void setIsPreventionDuringPregnancy(Boolean isPreventionDuringPregnancy) {
        this.isPreventionDuringPregnancy = isPreventionDuringPregnancy;
    }

    public Boolean getIsImmuAntyRhDApplied() {
        return isImmuAntyRhDApplied;
    }

    public void setIsImmuAntyRhDApplied(Boolean isImmuAntyRhDApplied) {
        this.isImmuAntyRhDApplied = isImmuAntyRhDApplied;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Number getMotherAge() {
        return motherAge;
    }

    public void setMotherAge(Number motherAge) {
        this.motherAge = motherAge;
    }
}
