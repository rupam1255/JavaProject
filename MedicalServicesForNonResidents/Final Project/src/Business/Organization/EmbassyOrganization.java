/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.EmbassyOperationRole;
import Business.Role.HospitalAppointmentSchedulerRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class EmbassyOrganization extends Organization {
    public EmbassyOrganization(String name){
        super(name);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles = new ArrayList(); 
     roles.add(new EmbassyOperationRole());
     return roles;
    
    }
}
