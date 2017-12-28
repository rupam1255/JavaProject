/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class OrganizationDirectory {
    ArrayList<Organization> organizationList;
    public OrganizationDirectory(){
        organizationList=new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public Organization createAndAddOrganization(Organization.OrganizationType type,String name,Enterprise enterprise, Network network, EcoSystem system){
        Organization organization=null;
        
        for(Network n:system.getNetworkDirectory()){
            for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
                    if(o.getName().equalsIgnoreCase(name)){
                    return null;
                    }
                }
            }
        }
        if(type.equals(Organization.OrganizationType.TPHospitalOperation)){
            organization=new TPHospitalOperation(name);
        }
        if(type.equals(Organization.OrganizationType.GovernmentOrganization)){
           organization=new GovernmentOrganization(name); 
        }
        if(type.equals(Organization.OrganizationType.TPHospitalAppintmentScheduler)){
            organization=new TPHospitalAppintmentScheduler(name);
        }
        if(type.equals(Organization.OrganizationType.EmbassyOrganization)){
            organization=new EmbassyOrganization(name);
        }
        if(type.equals(Organization.OrganizationType.ConsumerOrganization)){
            organization=new ConsumerOrganization(name);
        }
        
        enterprise.getOrganizationDirectory().getOrganizationList().add(organization);
        organization.setName(name);
        organization.setType(type);
        return enterprise;
    
    }
    
        public Boolean removeOrganization(String name) {
        for (Organization organization : organizationList) {
            if (organization.getName().equals(name)) {
                organizationList.remove(organization);
                return true;
            }
        }
        return null;
    }
    
}

