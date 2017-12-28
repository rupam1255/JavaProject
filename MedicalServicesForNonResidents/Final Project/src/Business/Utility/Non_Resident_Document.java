/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utility;

/**
 *
 * @author Rupam Tiwari
 */
public class Non_Resident_Document {
    String passportNumber;
    String issuingCountry;
    String visaNumber;
    VisaType visaType;

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public String getVisaNumber() {
        return visaNumber;
    }

    public void setVisaNumber(String visaNumber) {
        this.visaNumber = visaNumber;
    }

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }

    
    public enum VisaType{
        B1ORB2("Tourist or Business Visa"),
        F1ORJ1("Student Visa"),
        H1BORL1("EmploymentVisa");
        
        private String value;
        private VisaType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
            return value;
        }
        
    }
}
