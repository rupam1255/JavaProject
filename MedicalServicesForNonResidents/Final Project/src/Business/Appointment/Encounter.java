/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Disease;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class Encounter {
    
    String prescription;
    String healthIssues;
    Disease disease;
    String diagnosisNotes;
    String Allergies;
    
    public Encounter(){
        
    }

    

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getHealthIssues() {
        return healthIssues;
    }

    public void setHealthIssues(String healthIssues) {
        this.healthIssues = healthIssues;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    public String getDiagnosisNotes() {
        return diagnosisNotes;
    }

    public void setDiagnosisNotes(String diagnosisNotes) {
        this.diagnosisNotes = diagnosisNotes;
    }

    public String getAllergies() {
        return Allergies;
    }

    public void setAllergies(String Allergies) {
        this.Allergies = Allergies;
    }
    
    
}
