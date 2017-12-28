/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;


import Business.EcoSystem;
import Business.Organization.Organization;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author Rupam Tiwari
 */
public abstract class Role {


    public enum TypeOfRole {

        HospitalOperationRole("Hospital Operation"),
        HospitalAppointmentRole("Hospital Appointment Scheduler"),
        SystemAdmin("EchoSystemAdmin"),
        ConsumerRole("Consumer"),   
        GovernmentOperationRole("Government Operation"),
        EmbassyOperationRole("EmbassyOperation"),
        
        Admin("Admin");
        

        private String value;

        private TypeOfRole(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public abstract JPanel createWorkArea(JPanel sequencer, Network network, Enterprise enterprise, Organization organization,
                    UserAccount userAccount, EcoSystem system);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();

    }
}



