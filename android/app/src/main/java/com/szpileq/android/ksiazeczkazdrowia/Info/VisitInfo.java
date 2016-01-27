package com.szpileq.android.ksiazeczkazdrowia.Info;

/**
 * Created by Szpileq on 2016-01-27.
 */
public class VisitInfo {
    private String Date;
    private String kindOfVisit;
    private String doctorSignature;
    private String _id;

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getKindOfVisit() {
        return kindOfVisit;
    }

    public void setKindOfVisit(String kindOfVisit) {
        this.kindOfVisit = kindOfVisit;
    }

    public String getDoctorSignature() {
        return doctorSignature;
    }

    public void setDoctorSignature(String doctorSignature) {
        this.doctorSignature = doctorSignature;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
