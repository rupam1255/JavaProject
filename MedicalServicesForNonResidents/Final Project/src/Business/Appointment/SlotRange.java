/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Hospital.Doctor;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Rupam Tiwari
 */
public class SlotRange {
    Date startDt;
    Date endDt;
    Doctor doctor;
    String SlotRangeID;
    String offer;
    SimpleDateFormat sdf1;

    public SlotRange(Date date1, Date date2, Doctor doctor) {
        this.startDt = date1;
        this.endDt = date2;
        this.doctor = doctor;
        sdf1=new SimpleDateFormat("MM-dd-yyyy");
    }

    public String getSlotRangeID() {
        return SlotRangeID;
    }

    public void setSlotRangeID(String SlotRangeID) {
        this.SlotRangeID = SlotRangeID;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public SimpleDateFormat getSdf1() {
        return sdf1;
    }

    public void setSdf1(SimpleDateFormat sdf1) {
        this.sdf1 = sdf1;
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
    @Override
    public String toString(){
           
        return this.doctor.getName();//sdf1.format(this.startDt);
    }
    
}
