/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Interface.Consumer.ConsumerWorkAreaPanel;
import Interface.SignUp.SignUpJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Rupam Tiwari
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame1
     */
    private EcoSystem system;
    private Boolean ifUserNameExist = false;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public MainJFrame() {
        initComponents();
        this.system = dB4OUtil.retrieveSystem();
        logoutJButton.setEnabled(false);
        unameLabel.setVisible(false);
        entLabel.setVisible(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        logoutJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        unameLabel = new javax.swing.JLabel();
        entLabel = new javax.swing.JLabel();
        unameText = new javax.swing.JLabel();
        enterpriseText = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sequencer = new javax.swing.JPanel();
        LoginJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loginJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        signUPJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        logoutJButton.setText("Logout");
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Healthcare For Non-Residents");

        unameLabel.setText("Person  Name:");

        entLabel.setText("Enterprise:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(unameLabel)
                    .addComponent(entLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unameText, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                    .addComponent(enterpriseText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(286, 286, 286)
                .addComponent(logoutJButton)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unameLabel)
                    .addComponent(unameText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(logoutJButton)
                    .addComponent(enterpriseText, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entLabel))
                .addContainerGap())
        );

        jSplitPane1.setTopComponent(jPanel1);

        sequencer.setLayout(new java.awt.CardLayout());

        LoginJPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("UserName");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        loginJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("new user? Sign Up");

        signUPJButton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        signUPJButton.setText("SignUp");
        signUPJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUPJButtonActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interface/USA.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Login");

        javax.swing.GroupLayout LoginJPanelLayout = new javax.swing.GroupLayout(LoginJPanel);
        LoginJPanel.setLayout(LoginJPanelLayout);
        LoginJPanelLayout.setHorizontalGroup(
            LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginJPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(signUPJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                    .addComponent(loginJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addContainerGap(472, Short.MAX_VALUE))
        );
        LoginJPanelLayout.setVerticalGroup(
            LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginJPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(LoginJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(loginJButton)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUPJButton)
                .addContainerGap(507, Short.MAX_VALUE))
        );

        sequencer.add(LoginJPanel, "card2");

        jScrollPane2.setViewportView(sequencer);

        jSplitPane1.setRightComponent(jScrollPane2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // TODO add your handling code here:
        UserAccount userAccount = null;
        Enterprise inEnterprise = null;
        Organization inOrganization = null;
        Network inNetwork = null;
        
        String userName = txtUserName.getText();
        String password = String.valueOf(txtPassword.getPassword());
        if (userName.trim().equals("")
            || password.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Kindly enter proper User Name and Password!");
        }

        userAccount = system.getUserAccountDirectory().authenticateUserAccount(userName, password);
        
        //User Account not found at the System level then go to Network level  and Enterprise level
        if (userAccount == null) {
            for (Network network : system.getNetworkDirectory()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    userAccount = enterprise.getUserAccountDirectory().authenticateUserAccount(userName, password);
                    if (userAccount == null) {
                        //User Account not found at enterprise level then check at organization level
                       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            userAccount = organization.getUserAccountDirectory().authenticateUserAccount(userName, password);
                            if (userAccount != null) {
                                inOrganization = organization;
                                inEnterprise = enterprise;
                                inNetwork = network;
                                break;
                            }
                        }
                    } else {
                        inEnterprise = enterprise;
                        inNetwork = network;
                        break;
                    }
                    if (inOrganization != null) {
                        break;
                    }
                }
                if (inEnterprise != null) {
                    break;
                }
            }
        }

        if (userAccount == null) {
            JOptionPane.showMessageDialog(null, "Invalid Credentials!");
            return;
        }
        
       sequencer.add("WorkAreaPanel", userAccount.getRole().createWorkArea(sequencer, inNetwork, inEnterprise, inOrganization,
            userAccount, system));
    CardLayout layout = (CardLayout) sequencer.getLayout();
    layout.next(sequencer);
    
    logoutJButton.setEnabled(true);
    unameLabel.setVisible(true);
    entLabel.setVisible(true);
    unameText.setVisible(true);
    enterpriseText.setVisible(true);
    unameText.setText(userAccount.getPerson().getName());
    if(inEnterprise!=null){
        enterpriseText.setText(inEnterprise.getName());
    }else{
        enterpriseText.setText("Ecosystem");
    }
        
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void signUPJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUPJButtonActionPerformed
        // TODO add your handling code here:
        SignUpJPanel panel=new SignUpJPanel(sequencer, system);
        sequencer.add("SignUpJPanel",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_signUPJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        // TODO add your handling code here:
      Component component[] = sequencer.getComponents();
       for(int i = component.length-1;i>=1;i--){
          sequencer.remove(component[i]);
       }
    CardLayout layout = (CardLayout)sequencer.getLayout();
       layout.first(sequencer);
       
      txtUserName.setText("");
      txtPassword.setText("");
      unameText.setText("");
      enterpriseText.setText("");
      unameLabel.setVisible(false);
        entLabel.setVisible(false);
       unameText.setVisible(false);
       enterpriseText.setVisible(false);
       
       dB4OUtil.storeSystem(system);
                             
    }//GEN-LAST:event_logoutJButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LoginJPanel;
    private javax.swing.JLabel entLabel;
    private javax.swing.JLabel enterpriseText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton loginJButton;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPanel sequencer;
    private javax.swing.JButton signUPJButton;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JLabel unameLabel;
    private javax.swing.JLabel unameText;
    // End of variables declaration//GEN-END:variables
}
