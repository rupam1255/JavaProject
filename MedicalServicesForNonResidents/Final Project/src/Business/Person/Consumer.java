/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Utility.Address;
import Business.Utility.Non_Resident_Document;
import Business.Utility.Insurance;
import java.util.Date;
import Business.Appointment.AppointmentDirectory;

/**
 *
 * @author Rupam Tiwari
 */
public class Consumer extends Person{
    AppointmentDirectory appDir;

    public AppointmentDirectory getAppDir() {
        return appDir;
    }

    public void setAppDir(AppointmentDirectory appDir) {
        this.appDir = appDir;
    }
    Address address;
    Insurance insurance;
    Non_Resident_Document document;
    Date dob;
    String AccountID;
    
    public Consumer(String fname,String lName) {
        super((fname+" "+lName));
        appDir=new AppointmentDirectory();
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Non_Resident_Document getDocument() {
        return document;
    }

    public void setDocument(Non_Resident_Document document) {
        this.document = document;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
}
