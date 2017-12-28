/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Appointment.AppointmentDirectory;
import Business.EcoSystem;
import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        this.enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(Enterprise.TypeOfEnterprise type,String name, Network network, EcoSystem system){
        Enterprise enterprise=null;
        for(Network n:system.getNetworkDirectory()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                if(e.getName().equalsIgnoreCase(name)){
                    return null;
                }
            }
        }
        if(type.equals(Enterprise.TypeOfEnterprise.HospitalEnterprise)){
            
            HospitalEnterprise e=new HospitalEnterprise();
            AppointmentDirectory appDir=system.getMac().createandAddAppointmentDirectory(e);
            e.setAppDirectory(appDir);
            e.setName(name);
            e.setTypeOfEnterprise(type);
            enterprise=e;
        }
        if(type.equals(Enterprise.TypeOfEnterprise.GovernmentEnterprise)){
           
                  enterprise=new GovernmentEnterprise();
                  enterprise.setName(name);
                  enterprise.setTypeOfEnterprise(type);
        }
        if(type.equals(Enterprise.TypeOfEnterprise.ConsumerEnterprise)){
            enterprise=new ConsumerEnterprise();
            enterprise.setName(name);
                  enterprise.setTypeOfEnterprise(type);
        }
        network.getEnterpriseDirectory().getEnterpriseList().add(enterprise);
        return enterprise;
    }
    
        public Boolean removeEnterprise(String name) {
        for (Enterprise enterprise : enterpriseList) {
            if (enterprise.getName().equals(name)) {
                enterpriseList.remove(enterprise);
                return true;
            }
        }
        return null;
    }
}
