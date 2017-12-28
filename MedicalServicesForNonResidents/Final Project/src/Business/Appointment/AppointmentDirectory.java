/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Disease;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.Department;
import Business.Hospital.Department.CareType;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Rupam Tiwari
 */
public class AppointmentDirectory {
    private ArrayList<Appointment> appointmentList;
    private HospitalEnterprise hospitalEnterprise;
    private static long serialId=1;
    
    public AppointmentDirectory(){
        this.appointmentList=new ArrayList();
    }
    public AppointmentDirectory(HospitalEnterprise enterprise){
        this.appointmentList=new ArrayList();
        this.hospitalEnterprise=enterprise;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    

    public HospitalEnterprise getHospitalEnterprise() {
        return hospitalEnterprise;
    }

    public void setHospitalEnterprise(HospitalEnterprise hospitalEnterprise) {
        this.hospitalEnterprise = hospitalEnterprise;
    }

    public boolean createAndAddAppointments(SlotRange slot) {
        boolean flag=false;
        Date appStartDate=slot.getStartDt();
        Calendar c=Calendar.getInstance();
        Appointment apt=null;
        if(slot.getDoctor().getDept().getCareType()==CareType.PrimaryCare){
            c.setTime(slot.startDt);
            c.add(Calendar.MINUTE,60);
            while(slot.getEndDt().after(c.getTime())||slot.getEndDt().equals(c.getTime()) ){
                apt=new Appointment();
                apt.setAppointmentID("APP00"+serialId);
                this.serialId++;
                apt.setAppAvailStatus("Available");
                apt.setDoctor(slot.getDoctor());
                apt.setStartDt(appStartDate);
                apt.setEndDt(c.getTime());
                appStartDate=c.getTime();
                long difference=((slot.getEndDt().getTime())-c.getTime().getTime())/60000;
                //One additional appointment slot will be created when remaining time is more than 30 min but less than 60 min
                if(difference<60 && difference>=30){
                    Appointment apt1=new Appointment();
                    apt1.setAppointmentID("APP00"+serialId);
                    this.serialId++;
                    apt1.setAppAvailStatus("Available");
                    apt1.setDoctor(slot.getDoctor());
                    apt1.setSlotRange(slot);
                    apt1.setEnterprise(hospitalEnterprise);
                    apt1.setStartDt(c.getTime());
                    apt1.setEndDt(slot.getEndDt());
                    this.appointmentList.add(apt1);
                    System.out.println(apt1.getStartDt()+"  "+apt1.getEndDt());
                    flag=true;
                }
                //if remaining time is less than 30 mins then reset end time for created appointment Slot
                if(difference<30){
                    apt.setEndDt(slot.getEndDt());
                }
                apt.setSlotRange(slot);
                apt.setEnterprise(hospitalEnterprise);
                this.getAppointmentList().add(apt);
                flag=true;
                c.add(Calendar.MINUTE,60);
            }   
        }
        if(slot.getDoctor().getDept().getCareType()==CareType.Speciality){
            c.setTime(slot.startDt);
            c.add(Calendar.MINUTE,30);
            while(slot.getEndDt().after(c.getTime())||slot.getEndDt().equals(c.getTime())){
                apt=new Appointment();
                apt.setAppointmentID("APP00"+serialId);
                this.serialId++;
                apt.setAppAvailStatus("Available");
                apt.setDoctor(slot.getDoctor());
                apt.setStartDt(appStartDate);
                apt.setEndDt(c.getTime());
                appStartDate=c.getTime();
                long difference=((slot.getEndDt().getTime())-c.getTime().getTime())/60000;
                //One additional appointment slot will be created when remaining time is more than 30 min but less than 60 min
                if(difference<30 && difference>=20){
                    Appointment apt1=new Appointment();
                    apt1.setAppointmentID("APP00"+serialId);
                    this.serialId++;
                    apt1.setAppAvailStatus("Available");
                    apt1.setDoctor(slot.getDoctor());
                    apt1.setSlotRange(slot);
                    apt1.setStartDt(c.getTime());
                    apt1.setEndDt(slot.getEndDt());
                    apt1.setEnterprise(hospitalEnterprise);
                    this.appointmentList.add(apt1);
                    flag=true;
                    System.out.println(apt1.getStartDt()+" to "+apt1.getEndDt());
                }
                //if remaining time is less than 30 mins then reset end time for created appointment Slot
                if(difference<20){
                    apt.setEndDt(slot.getEndDt());
                }
                apt.setSlotRange(slot);
                apt.setEnterprise(hospitalEnterprise);
                System.out.println(apt.getStartDt()+"  to "+apt.getEndDt());
                this.getAppointmentList().add(apt);
                flag=true;
                c.add(Calendar.MINUTE,30);
            }   
        }
        return flag;
    }
    
    public double getAvgCost(){
        double sum =0.0;
        for(Appointment ap : this.appointmentList)
            sum = sum + ap.getBill();
        double avg = sum/this.appointmentList.size();
        return avg;
    }
    
    public boolean searchDisease(Disease disease) {
        Boolean flag=false;
        for(Appointment app:this.appointmentList){
            if(app.getEncounter()!=null){
            if(app.getEncounter().getDisease()!=null){
                if(app.getEncounter().getDisease().equals(disease)){
                    flag=true;
                    break;
                }
            }
            }
        }
        return flag;
    }
}
