/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Appointment.AppointmentDirectory;
import Business.Appointment.SlotRangeDirectory;
import Business.Appointment.Test;
import Business.Hospital.DepartmentCatalog;
import Business.Hospital.HospitalContactInfo;
import Business.Role.AdminRole;
import Business.Role.HospitalOperationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class HospitalEnterprise extends Enterprise {
    SlotRangeDirectory slotDirectory;
    DepartmentCatalog deptCatalog;
    AppointmentDirectory appDirectory;
    HospitalContactInfo hospContactInfo;
     private ArrayList<Test> testCatalog;
   
     public HospitalEnterprise(){
        slotDirectory=new SlotRangeDirectory();
        deptCatalog=new DepartmentCatalog();
        testCatalog=new ArrayList();
    }

    public ArrayList<Test> getTestCatalog() {
        return testCatalog;
    }

    public void setTestCatalog(ArrayList<Test> testCatalog) {
        this.testCatalog = testCatalog;
    }
    
     
     public HospitalContactInfo getHospContactInfo() {
        return hospContactInfo;
    }

    public void setHospContactInfo(HospitalContactInfo hospContactInfo) {
        this.hospContactInfo = hospContactInfo;
    }

    public AppointmentDirectory getAppDirectory() {
        return appDirectory;
    }

    public void setAppDirectory(AppointmentDirectory appDirectory) {
        this.appDirectory = appDirectory;
    }

    public SlotRangeDirectory getSlotDirectory() {
        return slotDirectory;
    }

    public void setSlotDirectory(SlotRangeDirectory slotDirectory) {
        this.slotDirectory = slotDirectory;
    }

    public DepartmentCatalog getDeptCatalog() {
        return deptCatalog;
    }

    public void setDeptCatalog(DepartmentCatalog deptCatalog) {
        this.deptCatalog = deptCatalog;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
        
    }
    
}
