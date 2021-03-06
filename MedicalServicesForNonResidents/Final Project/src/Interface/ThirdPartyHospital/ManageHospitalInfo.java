/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ThirdPartyHospital;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.HospitalContactInfo;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Utility.Address;
import Business.Utility.Utility;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Rupam Tiwari
 */
public class ManageHospitalInfo extends javax.swing.JPanel {

    /**
     * Creates new form ManageHospitalInfo
     */
    
    JPanel sequencer;
    Network network;
    Enterprise enterprise;
    Organization organization;
    UserAccount userAccount;
    EcoSystem system;

    ManageHospitalInfo(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.sequencer = sequencer;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
        
        populateHospitalNameCombo();
        populateCountryCombo();
        textHospitalName.setText(enterprise.getName());
    }
    
    
    public void populateHospitalNameCombo(){
        
    }
    
    public void populateCountryCombo(){
        String[] countryArr=Utility.getAllCountries();
        countryComboBox.removeAllItems();
        
        for(String country:countryArr){
           countryComboBox.addItem(country); 
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        textAddressLine1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        textAddressLine2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textCity = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        textState = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        textZipcode = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        textPhoneNumber = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnSaveHospitalInfo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        textEmailID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textHospitalName = new javax.swing.JLabel();

        jLabel1.setText("Manage Hospital Information");

        jLabel3.setText("Hospital Address:");

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Address Line1:");

        jLabel6.setText("Address Line2:");

        jLabel16.setText("City");

        jLabel17.setText("State");

        jLabel20.setText("Country");

        jLabel18.setText("Zip Code");

        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textAddressLine1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textAddressLine2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textCity, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textState, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(countryComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textZipcode, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20)
                    .addComponent(jLabel18)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textState, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(textCity)
                        .addComponent(textZipcode)
                        .addComponent(countryComboBox, 0, 163, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textAddressLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textAddressLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(textZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel7.setText("Phone Number");

        textPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPhoneNumberActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSaveHospitalInfo.setText("Save");
        btnSaveHospitalInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHospitalInfoActionPerformed(evt);
            }
        });

        jLabel4.setText("Email ID");

        jLabel2.setText("Hospital Name");

        textHospitalName.setText("HN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textHospitalName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(255, 255, 255)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSaveHospitalInfo)
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textPhoneNumber)
                            .addComponent(textEmailID, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))))
                .addGap(388, 388, 388))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textHospitalName))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveHospitalInfo)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveHospitalInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHospitalInfoActionPerformed
        // TODO add your handling code here:
        String line1Text=textAddressLine1.getText();
            if(!Utility.AddressValidation(line1Text)){
                JOptionPane.showMessageDialog(null,"Enter proper address line1. Only alphanumeric and characters like',' and '#' allowed ", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String line2Text=textAddressLine2.getText();
            if(!Utility.AddressValidation(line2Text)){
                JOptionPane.showMessageDialog(null,"Enter proper address line2. Only alphanumeric and characters like',' and '#' allowed ", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String city=textCity.getText();
            if(!Utility.charValidation(city)){
                JOptionPane.showMessageDialog(null,"please enter proper city Name", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String state=textState.getText();
            if(!Utility.charValidation(state)){
                JOptionPane.showMessageDialog(null,"please enter proper state Name", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String zipcode=textZipcode.getText();
            if(!Utility.intValidation(zipcode) && zipcode.length()!=5 ){
                JOptionPane.showMessageDialog(null,"please enter proper Zip Code", "Error Message", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String country=(String)countryComboBox.getSelectedItem();
            if(country==null){
               JOptionPane.showMessageDialog(null,"Please select Country", "Error Message", JOptionPane.ERROR_MESSAGE);
                return; 
            }

            Address a = new Address(line1Text, line2Text, city, state, zipcode, country);
            String contact = textPhoneNumber.getText();
            if(!Utility.intValidation(contact)){
               JOptionPane.showMessageDialog(null,"Please enter valid phone number", "Error Message",JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            String emailID = textEmailID.getText();
            if(!Utility.emailValidation(emailID)){
               JOptionPane.showMessageDialog(null,"Please enter valid email", "Error Message",JOptionPane.ERROR_MESSAGE);
                return; 
            }
            
            
            
            HospitalContactInfo hci = new HospitalContactInfo();
            hci.setAddress(a);
            hci.setPhoneNo(contact);
            hci.setHospitalEmailID(emailID);
            HospitalEnterprise he=(HospitalEnterprise)enterprise;
            he.setHospContactInfo(hci);
            
            JOptionPane.showMessageDialog(null,"Contact Info Saved Successfully", "Successful",JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnSaveHospitalInfoActionPerformed

    private void textPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textPhoneNumberActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        sequencer.remove(this);
            CardLayout layout = (CardLayout) sequencer.getLayout();
            layout.previous(sequencer);
        
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSaveHospitalInfo;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textAddressLine1;
    private javax.swing.JTextField textAddressLine2;
    private javax.swing.JTextField textCity;
    private javax.swing.JTextField textEmailID;
    private javax.swing.JLabel textHospitalName;
    private javax.swing.JTextField textPhoneNumber;
    private javax.swing.JTextField textState;
    private javax.swing.JTextField textZipcode;
    // End of variables declaration//GEN-END:variables
}
