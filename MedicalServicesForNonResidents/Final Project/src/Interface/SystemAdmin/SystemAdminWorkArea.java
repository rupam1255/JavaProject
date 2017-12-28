
package Interface.SystemAdmin;

import Business.EcoSystem;
import Business.Enterprise.ConsumerEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Network.Network.NetworkType;
import Business.Network.StateEnum;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Rupam Tiwari
 */
public class SystemAdminWorkArea extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkArea
     */
    private JPanel sequencer;
    private EcoSystem system;
    private Organization organization;
    private DefaultMutableTreeNode networkNode;

    public SystemAdminWorkArea(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.sequencer = sequencer;
        this.system = system;
        this.organization = organization;
        
        populateNetworkType();
        populateJTree();
        //populateEnterpriseComboBox();
        //populateNetwork();
        populateCreatedNetwork();
    }
    
    
    private void populateNetworkType() {
        
        netTypeComboBox.removeAll();
        for (Network.NetworkType type : Network.NetworkType.values()) {
            netTypeComboBox.addItem(type);
        }
    }

    public void populateNetwork() {
        networkListJComboBox.removeAllItems();
        //for(Network network:system.getNetworkDirectory()){
          for(StateEnum state: StateEnum.values()){  
           networkListJComboBox.addItem(state);
        }
    }
    
    public void populateCreatedNetwork()
    {
       comboNetworkName.removeAllItems();
        for(Network network: system.getNetworkDirectory()){
           comboNetworkName.addItem(network);
        }
    }

    public void populateJTree() {
        ArrayList<Network> networkList = system.getNetworkDirectory();
        ArrayList<Enterprise> enterpriseList;
        ArrayList<Organization> organizationList;
        Network network;
        Enterprise enterprise;
        Organization organization;

        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        root.removeAllChildren();
        networkNode = new DefaultMutableTreeNode("Networks");
        root.insert(networkNode, 0);

        DefaultMutableTreeNode networkNodes;
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        for (int i = 0; i < networkList.size(); i++) {
            network = networkList.get(i);
            networkNodes = new DefaultMutableTreeNode(network.getName());
            networkNode.insert(networkNodes, i);

            enterpriseList = network.getEnterpriseDirectory().getEnterpriseList();

            for (int j = 0; j < enterpriseList.size(); j++) {
                enterprise = enterpriseList.get(j);
                enterpriseNode = new DefaultMutableTreeNode(enterprise.getName());
                networkNodes.insert(enterpriseNode, j);

                organizationList = enterprise.getOrganizationDirectory().getOrganizationList();
                for (int k = 0; k < organizationList.size(); k++) {
                    organization = organizationList.get(k);
                    organizationNode = new DefaultMutableTreeNode(organization.getName());
                    enterpriseNode.insert(organizationNode, k);
                }
            }
        }

        model.reload();
    }

    public void populateEnterpriseComboBox() {
        enterpriseJComboBox.removeAllItems();
        Network selectedNetwork=(Network)comboNetworkName.getSelectedItem();
        if(selectedNetwork.getName().equals("USA")){
            enterpriseJComboBox.addItem(Enterprise.TypeOfEnterprise.GovernmentEnterprise);
        }
        else{
        for (Enterprise.TypeOfEnterprise type : Enterprise.TypeOfEnterprise.values()) {
            if(type!=Enterprise.TypeOfEnterprise.GovernmentEnterprise)
                enterpriseJComboBox.addItem(type);
        }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        panelDescriptionJLabel = new javax.swing.JLabel();
        manageEnterpriseAdminJButton = new javax.swing.JButton();
        networkJInternalFrame = new javax.swing.JInternalFrame();
        instructionJLabel = new javax.swing.JLabel();
        networkNameJLabel = new javax.swing.JLabel();
        networkListJComboBox = new javax.swing.JComboBox();
        removeNetworkJButton = new javax.swing.JButton();
        addNetworkJButton = new javax.swing.JButton();
        netTypeComboBox = new javax.swing.JComboBox<>();
        networkNameJLabel1 = new javax.swing.JLabel();
        enterpriseJInternalFrame = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        enterpriseTypeJLabel = new javax.swing.JLabel();
        enterpriseNameJLabel = new javax.swing.JLabel();
        enterpriseNameJTextField = new javax.swing.JTextField();
        enterpriseJComboBox = new javax.swing.JComboBox();
        addEnterpriseJButton = new javax.swing.JButton();
        removeEnterpriseJButton = new javax.swing.JButton();
        networkNameJLabel2 = new javax.swing.JLabel();
        comboNetworkName = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        manageDiseaseCatalogJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(new javax.swing.border.MatteBorder(null));

        jTree.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTree.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("System");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree);

        panelDescriptionJLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelDescriptionJLabel.setText("System Administration Work Area");

        manageEnterpriseAdminJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageEnterpriseAdminJButton.setText("Manage Enterprise Admin");
        manageEnterpriseAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseAdminJButtonActionPerformed(evt);
            }
        });

        networkJInternalFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        networkJInternalFrame.setVisible(true);

        instructionJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        instructionJLabel.setText("Enter the name of Network");

        networkNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        networkNameJLabel.setText("Network Type");

        networkListJComboBox.setEditable(true);
        networkListJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>());

        removeNetworkJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeNetworkJButton.setText("Remove Network");
        removeNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeNetworkJButtonActionPerformed(evt);
            }
        });

        addNetworkJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addNetworkJButton.setText("Add Network");
        addNetworkJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNetworkJButtonActionPerformed(evt);
            }
        });

        netTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netTypeComboBoxActionPerformed(evt);
            }
        });

        networkNameJLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        networkNameJLabel1.setText("Network Name");

        javax.swing.GroupLayout networkJInternalFrameLayout = new javax.swing.GroupLayout(networkJInternalFrame.getContentPane());
        networkJInternalFrame.getContentPane().setLayout(networkJInternalFrameLayout);
        networkJInternalFrameLayout.setHorizontalGroup(
            networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkJInternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, networkJInternalFrameLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(networkJInternalFrameLayout.createSequentialGroup()
                                .addComponent(addNetworkJButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeNetworkJButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(networkJInternalFrameLayout.createSequentialGroup()
                                .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(networkNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(networkNameJLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(netTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(networkListJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(136, 136, 136))
                    .addGroup(networkJInternalFrameLayout.createSequentialGroup()
                        .addComponent(instructionJLabel)
                        .addGap(64, 64, 64))))
        );
        networkJInternalFrameLayout.setVerticalGroup(
            networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(networkJInternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionJLabel)
                .addGap(26, 26, 26)
                .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkNameJLabel)
                    .addComponent(netTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(networkNameJLabel1)
                    .addComponent(networkListJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(networkJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeNetworkJButton)
                    .addComponent(addNetworkJButton))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        enterpriseJInternalFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        enterpriseJInternalFrame.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Enter the name of the Enterprise");

        enterpriseTypeJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enterpriseTypeJLabel.setText("Enterprise Type");

        enterpriseNameJLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        enterpriseNameJLabel.setText("Enterprise Name");

        enterpriseNameJTextField.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N

        addEnterpriseJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addEnterpriseJButton.setText("Add Enterprise");
        addEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnterpriseJButtonActionPerformed(evt);
            }
        });

        removeEnterpriseJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removeEnterpriseJButton.setText("Remove Enterprise");
        removeEnterpriseJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEnterpriseJButtonActionPerformed(evt);
            }
        });

        networkNameJLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        networkNameJLabel2.setText("Network Name");

        comboNetworkName.setEditable(true);
        comboNetworkName.setModel(new javax.swing.DefaultComboBoxModel<>());
        comboNetworkName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNetworkNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout enterpriseJInternalFrameLayout = new javax.swing.GroupLayout(enterpriseJInternalFrame.getContentPane());
        enterpriseJInternalFrame.getContentPane().setLayout(enterpriseJInternalFrameLayout);
        enterpriseJInternalFrameLayout.setHorizontalGroup(
            enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                .addGroup(enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                                .addComponent(addEnterpriseJButton)
                                .addGap(18, 18, 18)
                                .addComponent(removeEnterpriseJButton))
                            .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                                .addGroup(enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(enterpriseTypeJLabel)
                                    .addComponent(enterpriseNameJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(networkNameJLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(enterpriseJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(enterpriseNameJTextField)
                                    .addComponent(comboNetworkName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        enterpriseJInternalFrameLayout.setVerticalGroup(
            enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                        .addComponent(networkNameJLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(enterpriseTypeJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(enterpriseNameJLabel))
                    .addGroup(enterpriseJInternalFrameLayout.createSequentialGroup()
                        .addComponent(comboNetworkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(enterpriseJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(enterpriseNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(enterpriseJInternalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEnterpriseJButton)
                    .addComponent(removeEnterpriseJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("System Hierarchy");

        manageDiseaseCatalogJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        manageDiseaseCatalogJButton.setText("Manage Disease Catalog");
        manageDiseaseCatalogJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDiseaseCatalogJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDescriptionJLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(networkJInternalFrame)
                            .addComponent(enterpriseJInternalFrame))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(manageDiseaseCatalogJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(manageEnterpriseAdminJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDescriptionJLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(manageEnterpriseAdminJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(manageDiseaseCatalogJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(networkJInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enterpriseJInternalFrame)))
                .addGap(0, 227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNetworkJButtonActionPerformed
       

        String networkName = String.valueOf(networkListJComboBox.getSelectedItem());
        String stateName = String.valueOf(netTypeComboBox.getSelectedItem());
        if(networkName.trim().equals("")){
            JOptionPane.showMessageDialog(null, "Enter some valid name!");
            return;
        }
        for(Network n:system.getNetworkDirectory()){
            if(n.getName().equals(networkName)){
                JOptionPane.showMessageDialog(null, "This network Name already exists please select other","ErrorMessage",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        //String networkName = networkNameJTextField.getText();
            Network network=system.createAndAddNetwork(networkName,stateName);
            
            if(network!=null){
            JOptionPane.showMessageDialog(null, "Network added!");
            populateJTree();
            populateNetwork();
            }else{
                JOptionPane.showMessageDialog(null, "Network already exist");
            }
        
        populateCreatedNetwork();
    }//GEN-LAST:event_addNetworkJButtonActionPerformed

    private void addEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnterpriseJButtonActionPerformed
     
        Network network = (Network)comboNetworkName.getSelectedItem();
        Enterprise.TypeOfEnterprise type = (Enterprise.TypeOfEnterprise) enterpriseJComboBox.getSelectedItem();
        String enterpriseName = enterpriseNameJTextField.getText();

        if (type == null || enterpriseName.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Select Type of enterprise and Enter a valid name of enterprise to be added");
            return;
        }
        Enterprise enterprise=null;
        if(type==Enterprise.TypeOfEnterprise.ConsumerEnterprise){
            for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
                if(e.getTypeOfEnterprise()==Enterprise.TypeOfEnterprise.ConsumerEnterprise){
                   JOptionPane.showMessageDialog(null, "Consumer Enterprise already added in this network");
                    return; 
                }
                
            }
            
            Boolean flag=false;
            for(Network n:system.getNetworkDirectory()){
                for(Enterprise e:n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e instanceof ConsumerEnterprise){
                        enterprise=e;
                        network.getEnterpriseDirectory().getEnterpriseList().add(enterprise);
                        flag=true;
                    }
                    if(flag){
                        break;
                    }
                }
                if(flag){
                        break;
                }
            }
            if(!flag){
                enterprise=network.getEnterpriseDirectory().createAndAddEnterprise(type, enterpriseName, network, system);
            }
        }
        if(type==Enterprise.TypeOfEnterprise.GovernmentEnterprise){
            
              for(Enterprise e:network.getEnterpriseDirectory().getEnterpriseList()){
                
                if(e.getTypeOfEnterprise()==Enterprise.TypeOfEnterprise.GovernmentEnterprise){
                   JOptionPane.showMessageDialog(null, "Government Enterprise already added in this network");
                    return; 
                }
            }  
            
            enterprise=network.getEnterpriseDirectory().createAndAddEnterprise(type, enterpriseName, network, system);
        }
        if(type==Enterprise.TypeOfEnterprise.HospitalEnterprise){
            enterprise=network.getEnterpriseDirectory().createAndAddEnterprise(type, enterpriseName, network, system);
        }
//        if(type==Enterprise.TypeOfEnterprise.PHD){
//            enterprise=network.getEnterpriseDirectory().addAndCreatePHDEnterprise(type, enterpriseName, network, enterpriseName);
//        }
//        if(type==Enterprise.TypeOfEnterprise.Provider){
//            enterprise=network.getEnterpriseDirectory().addAndCreateProviderEnterprise(type, enterpriseName, network, enterpriseName);
//        }
//        if(type==Enterprise.TypeOfEnterprise.VaccineManufacturer){
//            enterprise=network.getEnterpriseDirectory().addAndCreateVaccineManufacturerEnterprise(enterpriseName, type, network);
//        }
        
        if(enterprise!=null){
            JOptionPane.showMessageDialog(null,"Enterprise added successfully");
            populateJTree();
        }else{
            JOptionPane.showMessageDialog(null,"Something Wrong! You can add only one Enterprise per Netowrk");
        }
        
    }//GEN-LAST:event_addEnterpriseJButtonActionPerformed

    private void removeNetworkJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeNetworkJButtonActionPerformed
       // TODO add your handling code here:
        DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();

        if (selectedNode == null
                || selectedNode.isRoot() == true
                //|| selectedNode != networkNode //|| selectedNode.isNodeAncestor(networkNode.getRoot()) == true
                ) {
            JOptionPane.showMessageDialog(null, "Select a node to be removed and root node cannot be deleted");
        } else {
            String networkName = selectedNode.toString();
            Boolean isNetworkFoundAndRemoved = system.removeNetwork(networkName);
            if (isNetworkFoundAndRemoved == null
                    || isNetworkFoundAndRemoved == false) {
                JOptionPane.showMessageDialog(null, "Network not found!");
            } else {
                model.removeNodeFromParent(selectedNode);
                JOptionPane.showMessageDialog(null, "Network removed!");
            }
            model.reload();
            populateCreatedNetwork();
        }  
      /*  Network network=(Network)networkListJComboBox.getSelectedItem();
        if(network==null){
            JOptionPane.showMessageDialog(null,"Please select a network");
            return;
        }
        system.getNetworkDirectory().remove(network);
        populateNetwork();
        populateJTree();*/
    }//GEN-LAST:event_removeNetworkJButtonActionPerformed

    private void removeEnterpriseJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEnterpriseJButtonActionPerformed
        // TODO add your handling code here:
       DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();

        if (selectedNode == null
                || selectedNode.isRoot() == true
                || selectedNode == networkNode) {
            JOptionPane.showMessageDialog(null, "Select a node to be removed and root node or network node cannot be deleted");
        } else {
            try{
            String enterpriseName = selectedNode.toString();
            String networkName = selectedNode.getParent().toString();
            if (!networkName.equals(networkNode.toString())) {
                Network network = system.getNetworkInstance(networkName);
               
                Boolean isEnterpriseFoundAndRemoved = network.getEnterpriseDirectory().removeEnterprise(enterpriseName);
                
                if (isEnterpriseFoundAndRemoved == true) {
                    model.removeNodeFromParent(selectedNode);
                    JOptionPane.showMessageDialog(null, "Enterprise removed!");
                } else {
                    JOptionPane.showMessageDialog(null, "Enterprise not found!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Select an enterprise!");
            }
            model.reload();
            }catch(NullPointerException e){
                JOptionPane.showMessageDialog(null, "Please select enterprise Node to remove!");
            }
        }
    }//GEN-LAST:event_removeEnterpriseJButtonActionPerformed

    private void manageEnterpriseAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseAdminJButtonActionPerformed
        // TODO add your handling code here:
      ManageEnterpriseJPanel panel = new ManageEnterpriseJPanel(sequencer,organization, system);
        sequencer.add("ManageEnterpriseAdmin", panel);
        CardLayout layout = (CardLayout) sequencer.getLayout();
        layout.next(sequencer); 
    }//GEN-LAST:event_manageEnterpriseAdminJButtonActionPerformed

    private void netTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netTypeComboBoxActionPerformed
        // TODO add your handling code here:
        networkListJComboBox.removeAllItems();
        Network.NetworkType selectedItem=(Network.NetworkType)netTypeComboBox.getSelectedItem();
        if(selectedItem.equals(Network.NetworkType.Country)){
            
            networkListJComboBox.addItem("USA");
        }
        if(selectedItem.equals(Network.NetworkType.State)){
            for(StateEnum state: StateEnum.values()){  
           networkListJComboBox.addItem(state);
        }
        }
    }//GEN-LAST:event_netTypeComboBoxActionPerformed

    private void manageDiseaseCatalogJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDiseaseCatalogJButtonActionPerformed
        // TODO add your handling code here:
        ManageDiseaseCatalog panel = new ManageDiseaseCatalog(sequencer, system);
        sequencer.add("ManageDiseaseCatalog", panel);
        CardLayout layout = (CardLayout) sequencer.getLayout();
        layout.next(sequencer);
    }//GEN-LAST:event_manageDiseaseCatalogJButtonActionPerformed

    private void comboNetworkNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNetworkNameActionPerformed
        // TODO add your handling code here:
        populateEnterpriseComboBox();
    }//GEN-LAST:event_comboNetworkNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEnterpriseJButton;
    private javax.swing.JButton addNetworkJButton;
    private javax.swing.JComboBox comboNetworkName;
    private javax.swing.JComboBox enterpriseJComboBox;
    private javax.swing.JInternalFrame enterpriseJInternalFrame;
    private javax.swing.JLabel enterpriseNameJLabel;
    private javax.swing.JTextField enterpriseNameJTextField;
    private javax.swing.JLabel enterpriseTypeJLabel;
    private javax.swing.JLabel instructionJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree;
    private javax.swing.JButton manageDiseaseCatalogJButton;
    private javax.swing.JButton manageEnterpriseAdminJButton;
    private javax.swing.JComboBox<NetworkType> netTypeComboBox;
    private javax.swing.JInternalFrame networkJInternalFrame;
    private javax.swing.JComboBox networkListJComboBox;
    private javax.swing.JLabel networkNameJLabel;
    private javax.swing.JLabel networkNameJLabel1;
    private javax.swing.JLabel networkNameJLabel2;
    private javax.swing.JLabel panelDescriptionJLabel;
    private javax.swing.JButton removeEnterpriseJButton;
    private javax.swing.JButton removeNetworkJButton;
    // End of variables declaration//GEN-END:variables

   
}
