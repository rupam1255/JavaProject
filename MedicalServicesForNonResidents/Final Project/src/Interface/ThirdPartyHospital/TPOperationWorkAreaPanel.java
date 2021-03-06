/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.ThirdPartyHospital;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Utility.Utility;
import Business.WorkQueue.ConsumerVisitWorkRequest;
import Business.WorkQueue.TestWorkRequest;
import Business.WorkQueue.WorkRequest;
import Interface.SignUp.SignUpJPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rupam Tiwari
 */
public class TPOperationWorkAreaPanel extends javax.swing.JPanel {

    /**
     * Creates new form TPAdmin
     */

    JPanel sequencer;
    Network network;
    Enterprise enterprise;
    Organization organization;
    UserAccount userAccount;
    EcoSystem system;
    
    public TPOperationWorkAreaPanel(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.sequencer = sequencer;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.system = system;
        
        populateOpenWRTable("None");
        populateclosedWRTable();
        
    }

    TPOperationWorkAreaPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        openRequestTable1 = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        btnManageDepartmentCatalog = new javax.swing.JButton();
        btnManageDoctorCatalog = new javax.swing.JButton();
        btnManageAppointments = new javax.swing.JButton();
        btnManageHospInfo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        closedRequestTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        completeJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Hospital Work Area");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "visit", "Test", "bill"}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel4.setText("WorkRequest Type:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Open Work Requests:");

        openRequestTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Receiver", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(openRequestTable1);
        if (openRequestTable1.getColumnModel().getColumnCount() > 0) {
            openRequestTable1.getColumnModel().getColumn(0).setMaxWidth(100);
            openRequestTable1.getColumnModel().getColumn(1).setMaxWidth(100);
            openRequestTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            openRequestTable1.getColumnModel().getColumn(3).setMaxWidth(600);
        }

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnManageDepartmentCatalog.setText("Manage Department Catalog");
        btnManageDepartmentCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDepartmentCatalogActionPerformed(evt);
            }
        });

        btnManageDoctorCatalog.setText("Manage Doctor Catalog");
        btnManageDoctorCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageDoctorCatalogActionPerformed(evt);
            }
        });

        btnManageAppointments.setText("Manage Test Catalog");
        btnManageAppointments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageAppointmentsActionPerformed(evt);
            }
        });

        btnManageHospInfo.setText("Manage Hospital Info");
        btnManageHospInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageHospInfoActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(btnManageDepartmentCatalog, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnManageDoctorCatalog, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnManageAppointments, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(btnManageHospInfo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnManageHospInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageDepartmentCatalog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageDoctorCatalog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnManageAppointments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(btnManageDepartmentCatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageDoctorCatalog, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageAppointments, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnManageHospInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );

        closedRequestTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Receiver", "Status", "Message"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(closedRequestTable);
        if (closedRequestTable.getColumnModel().getColumnCount() > 0) {
            closedRequestTable.getColumnModel().getColumn(0).setMaxWidth(100);
            closedRequestTable.getColumnModel().getColumn(1).setMaxWidth(100);
            closedRequestTable.getColumnModel().getColumn(2).setMaxWidth(100);
            closedRequestTable.getColumnModel().getColumn(3).setMaxWidth(600);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Closed WorkRequest:");

        completeJButton.setText("Complete WorkRequest");
        completeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(677, 677, 677)
                .addComponent(jLabel1)
                .addGap(496, 496, 496))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(completeJButton))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(completeJButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageDepartmentCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDepartmentCatalogActionPerformed
        // TODO add your handling code here:
        ManageDepartmentCatalog panel=new ManageDepartmentCatalog(sequencer,network,enterprise,organization,userAccount,system);
        sequencer.add("ManageDepartmentCatalog",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_btnManageDepartmentCatalogActionPerformed

    private void btnManageDoctorCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageDoctorCatalogActionPerformed
        // TODO add your handling code here:
        ManageDoctorCatalog panel=new ManageDoctorCatalog(sequencer,network,enterprise,organization,userAccount,system);
        sequencer.add("ManageDoctorCatalog",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_btnManageDoctorCatalogActionPerformed

    private void btnManageHospInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageHospInfoActionPerformed
        // TODO add your handling code here:
        ManageHospitalInfo panel=new ManageHospitalInfo(sequencer,network,enterprise,organization,userAccount,system);
        sequencer.add("ManageHospitalInfo",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_btnManageHospInfoActionPerformed

    private void btnManageAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageAppointmentsActionPerformed
        // TODO add your handling code here:
        ManageTest panel=new ManageTest(sequencer,network,enterprise,system);
        sequencer.add("ManageTest",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_btnManageAppointmentsActionPerformed

    private void completeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow=openRequestTable1.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please Select an open Work Request","Error Message",JOptionPane.ERROR_MESSAGE);
            return;
        }
        WorkRequest wr=(WorkRequest)openRequestTable1.getValueAt(selectedRow, 3);
        if((wr instanceof ConsumerVisitWorkRequest) && wr.getMessage().contains("bill")){
            ConsumerVisitWorkRequest cwr=(ConsumerVisitWorkRequest)wr;
            try{
            Double bill=Double.parseDouble(JOptionPane.showInputDialog(null,("Please enter bill Amount for "+cwr.getApp().getAppointmentID())));
            cwr.getApp().setBill(bill);
            cwr.getApp().setReportStatus("Bill Detail Updated");
            cwr.setReceiver(userAccount.getPerson());
            cwr.setMessage("Bill Sent");
            cwr.setStatus("Completed");
            populateOpenWRTable("bill");
           populateclosedWRTable();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Please input Bill in proper number format");
            }
        }
        if((wr instanceof ConsumerVisitWorkRequest) && wr.getMessage().contains("visit")){
            ConsumerVisitWorkRequest cwr=(ConsumerVisitWorkRequest)wr;
            PatientWorkArea panel=new PatientWorkArea(sequencer,network,enterprise,organization,userAccount,system,cwr);
            sequencer.add("PatientWorkArea",panel);
            CardLayout layout=(CardLayout)sequencer.getLayout();
            layout.next(sequencer);
        }
        if((wr instanceof TestWorkRequest) && wr.getMessage().contains("Test")){
            TestWorkRequest twr=(TestWorkRequest)wr;
            String result=JOptionPane.showInputDialog(null, ("Please Enter Test Results for " + twr.getApp().getAppointmentID()+" for test "+twr.getTest().getName()));
            if(result!=null){
            if(!Utility.alphaNumericValidation(result)){
                JOptionPane.showMessageDialog(null,"Please enter valid test results","ErrorMessage",JOptionPane.ERROR_MESSAGE);
                return;
            }
            twr.getTest().setResult(result);
            twr.setReceiver(userAccount.getPerson());
            twr.setMessage("Test Report Sent");
            twr.setStatus("Completed");
            
            populateOpenWRTable("Test");
           populateclosedWRTable();}
            
        }
        
    }//GEN-LAST:event_completeJButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String type=(String)jComboBox1.getSelectedItem();
        populateOpenWRTable(type);
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageAppointments;
    private javax.swing.JButton btnManageDepartmentCatalog;
    private javax.swing.JButton btnManageDoctorCatalog;
    private javax.swing.JButton btnManageHospInfo;
    private javax.swing.JTable closedRequestTable;
    private javax.swing.JButton completeJButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable openRequestTable1;
    // End of variables declaration//GEN-END:variables

    public void populateOpenWRTable(String type) {
        DefaultTableModel model = (DefaultTableModel) openRequestTable1.getModel();
        model.setRowCount(0);
        for(WorkRequest wr:organization.getWorkQueue().getWorkRequestList()){
            if(wr.getStatus().equalsIgnoreCase("Open") && wr.getMessage().contains(type)){
            Object[] row = new Object[4];
            row[0] = wr.getSender().getName();
            if(wr.getReceiver()!=null){
                row[1] = wr.getReceiver().getName();
            }else{
                row[1] ="Not Allocated";
            }
            row[2] = wr.getStatus();
            row[3] = wr;
            model.addRow(row);
            }
        }
    }

    public void populateclosedWRTable() {
        DefaultTableModel model = (DefaultTableModel) closedRequestTable.getModel();
        model.setRowCount(0);
        for(WorkRequest wr:organization.getWorkQueue().getWorkRequestList()){
            if(wr.getStatus().equalsIgnoreCase("Completed")){
            Object[] row = new Object[4];
            row[0] = wr.getSender().getName();
            if(wr.getReceiver()!=null){
                row[1] = wr.getReceiver().getName();
            }else{
                row[1] ="Not Allocated";
            }
            row[2] = wr.getStatus();
            row[3] = wr;
            model.addRow(row);
            }
        }
    }
}
