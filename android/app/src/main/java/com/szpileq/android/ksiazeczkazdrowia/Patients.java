package com.szpileq.android.ksiazeczkazdrowia;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Szpileq on 2016-01-22.
 */

public class Patients {

    private List<Patient> patient = new ArrayList<Patient>();

    public List<Patient> getPatient(){
        return patient;
    }

    public void setPatient(List<Patient> patient){
        this.patient = patient;
    }
}

