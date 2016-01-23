package com.szpileq.android.ksiazeczkazdrowia;

import java.util.Date;

/**
 * Created by Szpileq on 2016-01-23.
 */
public class childInfo {

    private String surname;
    private String firstname;
    private String placeOfBirth;
    private String address;
    private String pesel;
    private DateOfBirth dateOfBirth;

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getAddress() {
        return address;
    }

    public void DateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
