/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Hospital;

import Business.Utility.Address;

/**
 *
 * @author Rupam Tiwari
 */
public class HospitalContactInfo {
    
    private String hospitalEmailID;
    Address address;

    public String getHospitalEmailID() {
        return hospitalEmailID;
    }

    public void setHospitalEmailID(String hospitalEmailID) {
        this.hospitalEmailID = hospitalEmailID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    private String phoneNo;
    
    
    
}
