/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Enterprise.HospitalEnterprise;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class MasterAppointmentCatelog {
    public ArrayList<AppointmentDirectory> appointmentDirectoryList;
    
    public MasterAppointmentCatelog(){
        appointmentDirectoryList=new ArrayList();
    }

    public ArrayList<AppointmentDirectory> getAppointmentDirectoryList() {
        return appointmentDirectoryList;
    }

    public void setAppointmentDirectoryList(ArrayList<AppointmentDirectory> appointmentDirectoryList) {
        this.appointmentDirectoryList = appointmentDirectoryList;
    }
    public AppointmentDirectory createandAddAppointmentDirectory(HospitalEnterprise enterprise){
        AppointmentDirectory appDirectory=new AppointmentDirectory(enterprise);
        appointmentDirectoryList.add(appDirectory);
        return appDirectory;
    }
    
}
