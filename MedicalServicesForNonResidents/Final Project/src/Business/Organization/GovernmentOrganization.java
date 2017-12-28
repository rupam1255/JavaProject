/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.GovernmentOperationRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class GovernmentOrganization extends Organization{

    public GovernmentOrganization(String name){
        super(name);
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles = new ArrayList(); 
     roles.add(new GovernmentOperationRole());
     return roles;
    
    }

 
    
}
