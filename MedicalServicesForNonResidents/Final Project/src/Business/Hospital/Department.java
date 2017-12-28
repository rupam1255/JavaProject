/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class Department {
   private String name;
   private static int serialDoctor=1000;
   private ArrayList<Doctor> doctorList;
   private CareType careType;
   public enum CareType{
       PrimaryCare,
       Speciality;
   }
   
  
    public Department(String name) {
        this.name = name;
        doctorList=new ArrayList();
    }

    public CareType getCareType() {
        return careType;
    }

    public void setCareType(CareType careType) {
        this.careType = careType;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Doctor createAndAddDoctor(String name,String gender,Department dept,String qualification){
        //there is no sense in checking if same name doctor exist or notas a department can have multiple doctor with same name
        Doctor doc=new Doctor();
        this.doctorList.add(doc);
        doc.setDoctorID("DOC"+String.valueOf(serialDoctor));
        serialDoctor++;
        doc.setName(name);
        doc.setGender(gender);
        doc.setDept(this);
        doc.setQualification(qualification);
       return doc;
    }
    

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
    
   @Override
    public String toString() {
        return name;
    }
   
}
