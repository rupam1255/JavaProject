/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Disease;
import Business.Person.Consumer;
import Business.Person.Person;
import Business.Role.ConsumerRole;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rupam Tiwari
 */
public class ConsumerOrganization extends Organization {
    
    private ConsumerOrganization consumerOrganization;
    public ConsumerOrganization(String name){
        super(name);
    }
 
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles = new ArrayList(); 
     roles.add(new ConsumerRole());
     return roles;
    
    }
    
    public Map<String,Integer> getUniqueCountry(){
        Map<String,Integer> countryList = new HashMap<String, Integer>();
        //ArrayList<String> countryList=new ArrayList();
        for(Person p:this.getPersonDirectory().getPersonList()){
            if(p instanceof Consumer){
            Consumer c=(Consumer)p;
            if(countryList.containsKey(c.getDocument().getIssuingCountry())){
                countryList.put(c.getDocument().getIssuingCountry(), countryList.get(c.getDocument().getIssuingCountry()) + 1);
            }
            else{
                countryList.put(c.getDocument().getIssuingCountry(),0);
            }
        }}
        return countryList;
    }
    public Map<String,Integer> getCountryStatsByDisease(Disease disease){
        Map<String,Integer> countryList = new HashMap<String, Integer>();
        for(Person p:this.getPersonDirectory().getPersonList()){
            Consumer c=(Consumer)p;
            if(c.getAppDir().searchDisease(disease)){
                if(countryList.containsKey(c.getDocument().getIssuingCountry())){
                countryList.put(c.getDocument().getIssuingCountry(), countryList.get(c.getDocument().getIssuingCountry()) + 1);
            }
            else{
                countryList.put(c.getDocument().getIssuingCountry(),1);
            }
            }
        }
        return countryList;
    }
    
    public ArrayList getConsumerByCountry(String country){
        ArrayList<Consumer> con = new ArrayList<>();
        for(Person p: this.getPersonDirectory().getPersonList())
        {
            if(p instanceof Consumer)
            {
                Consumer c = (Consumer)p;
                if(c.getDocument().getIssuingCountry().equalsIgnoreCase(country))
                {
                    con.add(c);
                }
            }
        }
        return con;
    }
}
