
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.Doctor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Rupam Tiwari
 */
public class Appointment {
    Date startDt;
    Date endDt;
    Doctor doctor;
    String AppointmentID;
    SlotRange slotRange;
    HospitalEnterprise enterprise;
    
    Encounter encounter;
    ArrayList<Test> recommendedTests;
    double bill;
    
    String appAvailStatus;// to show whether this slot is available or occupied
    String reportStatus; //shows if third party operation has sent details on all three component i.e Encounter,Referral,Bill
    
    SimpleDateFormat sdf=new SimpleDateFormat("MM-dd-YYYY h:mm a");
    SimpleDateFormat sdf1=new SimpleDateFormat("h:mm a");

    public Appointment(){
        recommendedTests=new ArrayList();
    }
    
    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

   public ArrayList<Test> getRecommendedTests() {
        return recommendedTests;
    }

    public HospitalEnterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(HospitalEnterprise enterprise) {
        this.enterprise = enterprise;
    }

    public void setRecommendedTests(ArrayList<Test> recommendedTests) {
        this.recommendedTests = recommendedTests;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public String getAppAvailStatus() {
        return appAvailStatus;
    }

    public void setAppAvailStatus(String appAvailStatus) {
        this.appAvailStatus = appAvailStatus;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }
    
    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(String AppointmentID) {
        this.AppointmentID = AppointmentID;
    }

    public SlotRange getSlotRange() {
        return slotRange;
    }

    public void setSlotRange(SlotRange slotRange) {
        this.slotRange = slotRange;
    }
 
    @Override
    public String toString(){
        
        return AppointmentID;
    }
}
