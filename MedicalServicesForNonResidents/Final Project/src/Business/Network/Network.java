/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class Network {
    
   
    private String name;
    private String stateName;
    private NetworkType networkType;
    
    EnterpriseDirectory enterpriseDirectory;
    
    public enum NetworkType{
      
        Country("Country"),
        State("State");
        
        private String value;
        private NetworkType(String value) {
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
    public Network(String name, String state) {
        this.name=name;
        this.stateName = state;
        
        
        enterpriseDirectory=new EnterpriseDirectory();
    }

    public NetworkType getNetworkType() {
        return this.networkType;
    }

    public void setNetworkType(NetworkType networkType) {
        this.networkType = networkType;
    }
    
    
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
 
}
