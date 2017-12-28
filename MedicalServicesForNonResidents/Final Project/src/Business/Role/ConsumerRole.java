/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.Consumer.ConsumerWorkAreaPanel;
import javax.swing.JPanel;

/**
 *
 * @author Rupam Tiwari
 */
public class ConsumerRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        return new ConsumerWorkAreaPanel(sequencer,network,enterprise,organization,userAccount,system);
    }
    
}
