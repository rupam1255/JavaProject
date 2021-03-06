/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ThirdPartyHospital;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.Department;
import Business.Hospital.Doctor;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rupam Tiwari
 */
public class ManageDoctorCatalog extends javax.swing.JPanel {

    /**
     * Creates new form ManageDoctor
     */
    JPanel sequencer;
    Network network;
    HospitalEnterprise enterprise;
    Organization organization;
    UserAccount userAccount;
    EcoSystem system;
    
    public ManageDoctorCatalog(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.sequencer = sequencer;
        this.sequencer = sequencer;
        this.network = network;
        this.enterprise = (HospitalEnterprise)enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;

        
        populateDeptCombo();
        populateDoctorTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Gender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDoctor = new javax.swing.JTable();
        btnAddDoctor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboDepartment = new javax.swing.JComboBox<>();
        textDoctorName = new javax.swing.JTextField();
        textQualification = new javax.swing.JTextField();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        btnRemoveDoctor = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("Manage Doctor Catalog");

        tableDoctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Doctor Name", "Qualification", "Department", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDoctor);

        btnAddDoctor.setText("Add Doctor");
        btnAddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDoctorActionPerformed(evt);
            }
        });

        jLabel2.setText("Doctor Name");

        jLabel3.setText("Qualification");

        jLabel4.setText("Department");

        jLabel5.setText("Gender");

        comboDepartment.setEnabled(false);

        textDoctorName.setEnabled(false);

        textQualification.setEnabled(false);

        Gender.add(radioMale);
        radioMale.setText("Male");
        radioMale.setEnabled(false);

        Gender.add(radioFemale);
        radioFemale.setText("Female");
        radioFemale.setEnabled(false);

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnRemoveDoctor.setText("Remove Doctor");
        btnRemoveDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDoctorActionPerformed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(359, 359, 359)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMale)
                                .addGap(18, 18, 18)
                                .addComponent(radioFemale))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboDepartment, 0, 177, Short.MAX_VALUE)
                                        .addComponent(textDoctorName)
                                        .addComponent(textQualification)
                                        .addComponent(btnAddDoctor, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addGap(148, 148, 148)
                                .addComponent(btnRemoveDoctor)))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDoctor)
                    .addComponent(btnRemoveDoctor))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(textQualification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioMale)
                    .addComponent(radioFemale))
                .addGap(26, 26, 26)
                .addComponent(btnSave)
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void populateDeptCombo(){
        for(Department dept: enterprise.getDeptCatalog().getDepatmentList())
            comboDepartment.addItem(dept);
    }
    
    public void populateDoctorTable(){
        DefaultTableModel model = (DefaultTableModel) tableDoctor.getModel();
        model.setRowCount(0);
        
        for(Department dept : enterprise.getDeptCatalog().getDepatmentList()){
            for(Doctor doc : dept.getDoctorList()){
            Object[] row = new Object[4];
            row[0] = doc;
            row[1] = doc.getQualification();
            row[2] = doc.getDept();
            row[3] = doc.getGender();
            model.addRow(row);
            }
        }
   

        
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        String docName = textDoctorName.getText();
        String qualification = textQualification.getText();
        String gender = null;
        Department department = (Department)comboDepartment.getSelectedItem();
        
        
        if (docName.trim().equals("") || qualification.trim().equals("")){// || radioFemale.isSelected() || radioMale.isSelected()) {
            JOptionPane.showMessageDialog(null, "Kindly fill proper inputs!");
            return;
        }
        if(!radioFemale.isSelected() && !radioMale.isSelected()){
            JOptionPane.showMessageDialog(null,"Please select gender for Doctor");
            return;
        }
        if(radioFemale.isSelected())
            gender = "Female";
        if(radioMale.isSelected())
            gender = "Male";
        Department dept = (Department)comboDepartment.getSelectedItem();
        dept.createAndAddDoctor(docName, gender, department, qualification);
        
        reset();
        JOptionPane.showMessageDialog(null, "Doctor created!");
        populateDoctorTable();
    }  
    
        public void reset() {
        textDoctorName.setText("");
        textQualification.setText("");
        comboDepartment.setSelectedIndex(0);

    }
    
    private void btnRemovePersonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        sequencer.remove(this);
        CardLayout layout = (CardLayout) sequencer.getLayout();
        layout.previous(sequencer);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDoctorActionPerformed
        // TODO add your handling code here:
        textDoctorName.setEnabled(true);
        textQualification.setEnabled(true);
        radioFemale.setEnabled(true);
        comboDepartment.setEnabled(true);
        radioMale.setEnabled(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnAddDoctorActionPerformed

    private void btnRemoveDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDoctorActionPerformed
        // TODO add your handling code here:
        int selectedRow = tableDoctor.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Select a row to be deleted!");
            return;
        }

        Doctor doctor = (Doctor) tableDoctor.getValueAt(selectedRow, 0);
        Department d = null;
        for(Department dept : enterprise.getDeptCatalog().getDepatmentList())
        {
            if(dept.equals(doctor.getDept()))
                d=dept;
        }
        
        d.getDoctorList().remove(doctor);
        
        JOptionPane.showMessageDialog(null, "Doctor removed!");
        populateDoctorTable();
        
    }//GEN-LAST:event_btnRemoveDoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnRemoveDoctor;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Department> comboDepartment;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tableDoctor;
    private javax.swing.JTextField textDoctorName;
    private javax.swing.JTextField textQualification;
    // End of variables declaration//GEN-END:variables
}
