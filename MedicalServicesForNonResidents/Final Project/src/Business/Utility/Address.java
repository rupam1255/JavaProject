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
public class Address {
   private String line1;
   private String line2;
   private String city;
   private String State;
   private String zipcode;
   private String Country;

    public Address(String line1, String line2, String city, String State, String zipcode, String Country) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.State = State;
        this.zipcode = zipcode;
        this.Country = Country;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }
    
    @Override
    public String toString(){
        String s= line1+"  "+line2+"  "+city+"  "+State;
        return s;
        
    }
    
   
   
}
