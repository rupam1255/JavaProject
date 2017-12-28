/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Enterprise;

import Business.EcoSystem;
import Business.Enterprise.ConsumerEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.Consumer.AppointmentPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Rupam Tiwari
 */
public class EnterpriseAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form HospitalEnterprise
     */
    
    JPanel sequencer;
    Network network;
    Enterprise enterprise;
   private Organization organization;
    UserAccount userAccount;
    EcoSystem system;
    
    public EnterpriseAdminWorkArea(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.sequencer = sequencer;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
        
        if(enterprise instanceof ConsumerEnterprise){
            btnManagePersonUser.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageOrganization = new javax.swing.JButton();
        btnManagePersonUser = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        btnManageOrganization.setText("Manage Organization");
        btnManageOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrganizationActionPerformed(evt);
            }
        });

        btnManagePersonUser.setText("Manage Person & User");
        btnManagePersonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePersonUserActionPerformed(evt);
            }
        });

        jLabel4.setText("Enterprise Admin Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageOrganization)
                            .addComponent(btnManagePersonUser)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jLabel4)))
                .addContainerGap(371, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addGap(103, 103, 103)
                .addComponent(btnManageOrganization)
                .addGap(28, 28, 28)
                .addComponent(btnManagePersonUser)
                .addContainerGap(300, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrganizationActionPerformed
        // TODO add your handling code here:
        ManageOrganization panel = new ManageOrganization(sequencer,network,enterprise,organization,userAccount,system);
        sequencer.add("ManageOrganization",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_btnManageOrganizationActionPerformed

    private void btnManagePersonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePersonUserActionPerformed
        // TODO add your handling code here:
        ManagePersonUser panel = new ManagePersonUser(sequencer,network,enterprise,userAccount,system);
        sequencer.add("ManagePersonUser",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_btnManagePersonUserActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageOrganization;
    private javax.swing.JButton btnManagePersonUser;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}