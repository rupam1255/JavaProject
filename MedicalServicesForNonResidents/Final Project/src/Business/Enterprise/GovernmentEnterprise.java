/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Rupam Tiwari
 */
public class GovernmentEnterprise extends Enterprise{

    @Override
    public ArrayList<Role> getSupportedRole() {
     ArrayList<Role> roles = new ArrayList(); 
     roles.add(new AdminRole());
     return roles;
    }

    
}
