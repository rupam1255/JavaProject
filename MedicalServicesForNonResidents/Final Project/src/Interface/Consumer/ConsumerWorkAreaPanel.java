/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Consumer;

import Business.Appointment.Appointment;
import Business.Appointment.Test;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Hospital.Department;
import Business.Hospital.Doctor;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.Consumer;
import Business.UserAccount.UserAccount;
import Business.Utility.Non_Resident_Document;
import Business.Utility.Insurance;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.CardLayout;
import java.awt.Font;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rupam Tiwari
 */
public class ConsumerWorkAreaPanel extends javax.swing.JPanel {

    JPanel sequencer;
     Network network;
     Enterprise enterprise;
     Organization organization;
     UserAccount userAccount;
     EcoSystem system;
     Consumer consumer;
     HospitalEnterprise selectedHosp;
     Doctor selectedDoc;
    /**
     * Creates new form UserLandingPage
     */

    public ConsumerWorkAreaPanel(JPanel sequencer, Network network, Enterprise enterprise, Organization organization, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.sequencer= sequencer;
        this.network = network;
        this.enterprise = enterprise;
        this.organization = organization;
        this.userAccount = userAccount;
        this.consumer = (Consumer)userAccount.getPerson();
        this.system = system;
        
        populateHomePage();
        populateStateCombo();
        populateAppointmentDate();
        //populateMedicalHistoryPage();
        populateShowBillsPage();
        populateAppointmentHistoryPage();
    }

    public void populateStateCombo(){
       comboState.removeAllItems();
        for(Network network: system.getNetworkDirectory()){
           comboState.addItem(network);
        }
    }
    
    public void populateDepartments(HospitalEnterprise selectedHosp){
        comboDepartment.removeAllItems();
        for(Department dept: selectedHosp.getDeptCatalog().getDepatmentList()  ){
           comboDepartment.addItem(dept);
        }
    }
    
    public void populateAppointmentDate(){
        comboAppointmentDate.removeAllItems();
        Consumer c = (Consumer)userAccount.getPerson();
        
        for(Appointment app: c.getAppDir().getAppointmentList()){
            comboAppointmentDate.addItem(app);
        }
    }
    
    public void populateHomePage(){
        Non_Resident_Document doc = consumer.getDocument();
        Insurance ins=null;
        
        if(consumer.getInsurance()!=null){
            ins = consumer.getInsurance();
        }
        
        SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        String dob = df.format(consumer.getDob());
        textAge.setText(dob);
        textFirstName.setText(userAccount.getPerson().getName());
        textUserType.setText(doc.getVisaType().getValue());
        if(ins!=null){
            textInsuranceCompany.setText(String.valueOf(ins.getCompany()));
        textInsuranceNumber.setText(String.valueOf(ins.getInsuranceID()));
        }else{
            textInsuranceCompany.setText("NA");
        textInsuranceNumber.setText("NA");
        }
        
        ArrayList<Appointment> tempList;
        
        Consumer con = (Consumer)userAccount.getPerson();
        tempList = con.getAppDir().getAppointmentList();
        
        Collections.sort(tempList, new Comparator<Appointment>(){
            @Override
            public int compare(Appointment o1, Appointment o2){
                if(o1.getStartDt()== null || o2.getStartDt()== null){
                 return 0;
                }else{
                return o1.getStartDt().compareTo(o2.getStartDt());
                }
            }});
            
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        if(tempList.size()>0){
        Appointment app1 = tempList.get(0);

        textDate.setText(sdf.format(app1.getStartDt()));
        textHospitalName.setText(app1.getEnterprise().getName());
        textDepartmentName.setText(app1.getDoctor().getDept().getName());
        textDoctorName.setText(app1.getDoctor().getName());
        if(app1.getEnterprise().getHospContactInfo()!=null){
            textHospitalAddress.setText(app1.getEnterprise().getHospContactInfo().getAddress().toString());
            textHospitalContact.setText(app1.getEnterprise().getHospContactInfo().getPhoneNo());
            textEmailID.setText(app1.getEnterprise().getHospContactInfo().getHospitalEmailID());
        }
         else
            {
            textHospitalAddress.setText("NA");
            textHospitalContact.setText("NA");
            textEmailID.setText("NA");
            }
        }

        else{
            textDate.setText("NA");
            textHospitalName.setText("NA");
            textDepartmentName.setText("NA");
            textHospitalAddress.setText("NA");
            textDoctorName.setText("NA");
            textHospitalContact.setText("NA");
            textEmailID.setText("NA");
        }
            
        
    }

    public void populateMedicalHistoryPage(){
        Appointment appointment = (Appointment)comboAppointmentDate.getSelectedItem();
        
        if(appointment.getEncounter()==null){
            textAreaPrescriptions.setText("Not Received");
            textAreaHealthIssues.setText("Not Received");
            textAreaEncounteredDisease.setText("Not Received");
            textAreaAllergies.setText("Not Received");
            textAreaDoctorsNote.setText("Not Received");
        }
        else{
        textAreaPrescriptions.setText(appointment.getEncounter().getPrescription());
        textAreaHealthIssues.setText(appointment.getEncounter().getHealthIssues());
        textAreaAllergies.setText(appointment.getEncounter().getAllergies());
        if(appointment.getEncounter().getDisease()!=null){
        textAreaEncounteredDisease.setText(appointment.getEncounter().getDisease().getName());}
        else{
            textAreaEncounteredDisease.setText("NA");
        }
        textAreaDoctorsNote.setText(appointment.getEncounter().getDiagnosisNotes());
        populateTestTable();
        }
    }
    
    public void populateTestTable(){
        Appointment appointment = (Appointment)comboAppointmentDate.getSelectedItem();
        DefaultTableModel model = (DefaultTableModel) tableTestHistory.getModel();
        model.setRowCount(0);

        for(Test test : appointment.getRecommendedTests()){

            Object[] row = new Object[2];
            row[0] = test;
            row[1] = test.getResult();
            model.addRow(row);
            }
        
    }
    
    public void populateShowBillsPage(){
        Consumer c = (Consumer)userAccount.getPerson();
        textAccountNo.setText(c.getAccountID());

        if(c.getInsurance() != null)
            textInsuranceName.setText(c.getInsurance().getCompany());
        else
            textInsuranceName.setText("NA");
        
        DefaultTableModel model = (DefaultTableModel) tableBills.getModel();
        model.setRowCount(0);

        for(Appointment ap: c.getAppDir().getAppointmentList()){

            Object[] row = new Object[3];
            row[0] = ap;
            row[1] = ap.getEnterprise().getName();
            row[2] = ap.getBill();
            model.addRow(row);
            }
    }
    
    public void populateAppointmentHistoryPage(){
        Consumer c = (Consumer)userAccount.getPerson();
        DefaultTableModel model = (DefaultTableModel) tableHistory.getModel();
        model.setRowCount(0);

        for(Appointment ap: c.getAppDir().getAppointmentList()){

            Object[] row = new Object[4];
            row[0] = ap;
            row[1] = ap.getEnterprise().getName();
            row[2] = ap.getDoctor();
            row[3] = ap.getReportStatus();
            model.addRow(row);
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

        titledBorder1 = javax.swing.BorderFactory.createTitledBorder("");
        titledBorder2 = javax.swing.BorderFactory.createTitledBorder("");
        Gender = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        UserDetails = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        textUserType = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textFirstName = new javax.swing.JLabel();
        textInsuranceCompany = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textInsuranceNumber = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textAge = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        textDate = new javax.swing.JLabel();
        textHospitalName = new javax.swing.JLabel();
        textDepartmentName = new javax.swing.JLabel();
        textDoctorName = new javax.swing.JLabel();
        textHospitalContact = new javax.swing.JLabel();
        textHospitalAddress = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        textEmailID = new javax.swing.JLabel();
        btnBookNewAppointment = new javax.swing.JButton();
        AppointmentHistory = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        Search = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableHospital = new javax.swing.JTable();
        btnSearchDoctors = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableDoctors = new javax.swing.JTable();
        btnBookAppointment = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        comboState = new javax.swing.JComboBox();
        comboDepartment = new javax.swing.JComboBox();
        btnSearchHospitals = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        radioMale = new javax.swing.JRadioButton();
        radioFemale = new javax.swing.JRadioButton();
        btnEnableFilter = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        checkDepartment = new javax.swing.JCheckBox();
        checkGender = new javax.swing.JCheckBox();
        MedicaLHistory = new javax.swing.JPanel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel21 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textAreaHealthIssues = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaPrescriptions = new javax.swing.JTextArea();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textAreaEncounteredDisease = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        textAreaAllergies = new javax.swing.JTextArea();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableTestHistory = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        comboAppointmentDate = new javax.swing.JComboBox<>();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        textAreaDoctorsNote = new javax.swing.JTextArea();
        btnDownloadPDF = new javax.swing.JButton();
        ShowBills = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        textAccountNo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        textInsuranceName = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableBills = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Personal Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        jLayeredPane1.setToolTipText("");

        textUserType.setText("S/E/T");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Insurance Number");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Age");

        textFirstName.setText("FN");

        textInsuranceCompany.setText("Company Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("First Name");

        textInsuranceNumber.setText("Insurance Number");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("User Type");

        textAge.setText("age");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Insurance Company");

        jLayeredPane1.setLayer(textUserType, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textFirstName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textInsuranceCompany, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textInsuranceNumber, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(textAge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(35, 35, 35)
                .addComponent(textAge, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textUserType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textInsuranceNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textInsuranceCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel3)
                    .addGap(74, 74, 74)
                    .addComponent(textFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(389, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textAge))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textUserType))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textInsuranceCompany))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textInsuranceNumber))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(textFirstName))
                    .addContainerGap(186, Short.MAX_VALUE)))
        );

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Next Appointment Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setText("Date");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel16.setText("Hospital Name");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setText("Department Name");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel18.setText("Doctor Name");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel19.setText("Hospital Contact");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel20.setText("Hospital Address");

        textDate.setText("date");

        textHospitalName.setText("HN");

        textDepartmentName.setText("DN");

        textDoctorName.setText("DocN");

        textHospitalContact.setText("HC");

        textHospitalAddress.setText("HA");

        jLabel27.setText("Hospital Email-ID");

        textEmailID.setText("email");

        jLayeredPane2.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel19, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textDate, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textHospitalName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textDepartmentName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textDoctorName, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textHospitalContact, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textHospitalAddress, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel27, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(textEmailID, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textHospitalName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDepartmentName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textHospitalAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDate, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel27))
                .addGap(25, 25, 25)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEmailID)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textDoctorName, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addComponent(textHospitalContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(28, 28, 28))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addComponent(textDate)
                    .addComponent(textDoctorName))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(textHospitalName)
                    .addComponent(textHospitalContact))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(textDepartmentName)
                    .addComponent(jLabel27)
                    .addComponent(textEmailID))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(textHospitalAddress))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        btnBookNewAppointment.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBookNewAppointment.setText("Book New Appointment >>");
        btnBookNewAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookNewAppointmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserDetailsLayout = new javax.swing.GroupLayout(UserDetails);
        UserDetails.setLayout(UserDetailsLayout);
        UserDetailsLayout.setHorizontalGroup(
            UserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserDetailsLayout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addGroup(UserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLayeredPane2)
                    .addComponent(jLayeredPane1))
                .addGap(359, 359, 359))
            .addGroup(UserDetailsLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(btnBookNewAppointment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserDetailsLayout.setVerticalGroup(
            UserDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserDetailsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnBookNewAppointment)
                .addContainerGap(731, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home Page", UserDetails);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("History"));

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Appointment Date", "Hospital Name", "Doctor Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableHistory);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AppointmentHistoryLayout = new javax.swing.GroupLayout(AppointmentHistory);
        AppointmentHistory.setLayout(AppointmentHistoryLayout);
        AppointmentHistoryLayout.setHorizontalGroup(
            AppointmentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentHistoryLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        AppointmentHistoryLayout.setVerticalGroup(
            AppointmentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentHistoryLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(971, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Appointment History", AppointmentHistory);

        tableHospital.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hospital Name", "Hospital Address", "Hospital Contact", "Average Visit Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableHospital);

        btnSearchDoctors.setText("Search Doctors");
        btnSearchDoctors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDoctorsActionPerformed(evt);
            }
        });

        jLabel1.setText("Filters:");

        tableDoctors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Doctors Name", "Department Name", "Qualification", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableDoctors);

        btnBookAppointment.setText("Book Appointment");
        btnBookAppointment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookAppointmentActionPerformed(evt);
            }
        });

        jLabel10.setText("Departments");

        comboState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStateActionPerformed(evt);
            }
        });

        comboDepartment.setEnabled(false);
        comboDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboDepartmentActionPerformed(evt);
            }
        });

        btnSearchHospitals.setText("Search Hospitals");
        btnSearchHospitals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHospitalsActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Required Doctor Gender");

        Gender.add(radioMale);
        radioMale.setText("Male");
        radioMale.setContentAreaFilled(false);
        radioMale.setEnabled(false);

        Gender.add(radioFemale);
        radioFemale.setText("Female");
        radioFemale.setContentAreaFilled(false);
        radioFemale.setEnabled(false);
        radioFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFemaleActionPerformed(evt);
            }
        });

        btnEnableFilter.setText("Select Filter");
        btnEnableFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnableFilterActionPerformed(evt);
            }
        });

        jLabel2.setText("Please select State");

        checkDepartment.setText("Department");
        checkDepartment.setEnabled(false);
        checkDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDepartmentActionPerformed(evt);
            }
        });

        checkGender.setText("Gender");
        checkGender.setEnabled(false);
        checkGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGenderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchLayout = new javax.swing.GroupLayout(Search);
        Search.setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SearchLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboState, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(btnSearchHospitals))
                            .addComponent(jLabel1)))
                    .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBookAppointment)
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioMale, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(radioFemale)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearchDoctors))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)
                            .addGroup(SearchLayout.createSequentialGroup()
                                .addComponent(btnEnableFilter)
                                .addGap(18, 18, 18)
                                .addComponent(checkDepartment)
                                .addGap(18, 18, 18)
                                .addComponent(checkGender)))))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSearchHospitals))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEnableFilter)
                            .addComponent(checkDepartment)
                            .addComponent(checkGender))
                        .addGap(17, 17, 17))
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)))
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(comboDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(radioMale)
                        .addComponent(radioFemale)
                        .addComponent(btnSearchDoctors)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBookAppointment)
                .addContainerGap(474, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Search", Search);

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setText("Medications: ");

        jLabel8.setText("Prescriptions");

        textAreaHealthIssues.setColumns(20);
        textAreaHealthIssues.setRows(5);
        jScrollPane5.setViewportView(textAreaHealthIssues);

        jLabel13.setText("Health Isuues");

        textAreaPrescriptions.setColumns(20);
        textAreaPrescriptions.setRows(5);
        jScrollPane7.setViewportView(textAreaPrescriptions);

        jLayeredPane4.setLayer(jLabel21, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jLabel13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jLayeredPane4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel21)
                .addGap(31, 31, 31)
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jLayeredPane5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setText("Disease: ");

        jLabel24.setText("Encountered Disease");

        textAreaEncounteredDisease.setColumns(20);
        textAreaEncounteredDisease.setRows(5);
        jScrollPane8.setViewportView(textAreaEncounteredDisease);

        jLabel25.setText("Allergies");

        textAreaAllergies.setColumns(20);
        textAreaAllergies.setRows(5);
        jScrollPane9.setViewportView(textAreaAllergies);

        jLayeredPane5.setLayer(jLabel22, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jLabel25, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane5Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel22)
                .addGap(36, 36, 36)
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jLayeredPane6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setText("Test History: ");

        tableTestHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Test Performed", "Result"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tableTestHistory);

        jLayeredPane6.setLayer(jLabel23, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel23))
                    .addGroup(jLayeredPane6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 911, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel23)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jLabel12.setText("Appointment ID:");

        comboAppointmentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAppointmentDateActionPerformed(evt);
            }
        });

        jLayeredPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setText("Doctor Nores:");

        textAreaDoctorsNote.setColumns(20);
        textAreaDoctorsNote.setRows(5);
        jScrollPane10.setViewportView(textAreaDoctorsNote);

        jLayeredPane3.setLayer(jLabel26, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(jScrollPane10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel26)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnDownloadPDF.setText("Download PDF");
        btnDownloadPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MedicaLHistoryLayout = new javax.swing.GroupLayout(MedicaLHistory);
        MedicaLHistory.setLayout(MedicaLHistoryLayout);
        MedicaLHistoryLayout.setHorizontalGroup(
            MedicaLHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicaLHistoryLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(MedicaLHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLayeredPane3)
                    .addGroup(MedicaLHistoryLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(comboAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDownloadPDF)
                        .addGap(10, 10, 10))
                    .addComponent(jLayeredPane6)
                    .addComponent(jLayeredPane5)
                    .addComponent(jLayeredPane4))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        MedicaLHistoryLayout.setVerticalGroup(
            MedicaLHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MedicaLHistoryLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(MedicaLHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboAppointmentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDownloadPDF))
                .addGap(27, 27, 27)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLayeredPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Medical History", MedicaLHistory);

        jLabel11.setText("Account Number");

        textAccountNo.setText("AC No.");

        jLabel14.setText("Insurance");

        textInsuranceName.setText("ins Company");

        tableBills.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Appointment Date", "Hospital Name", "Amount"
            }
        ));
        jScrollPane4.setViewportView(tableBills);

        javax.swing.GroupLayout ShowBillsLayout = new javax.swing.GroupLayout(ShowBills);
        ShowBills.setLayout(ShowBillsLayout);
        ShowBillsLayout.setHorizontalGroup(
            ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShowBillsLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 933, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ShowBillsLayout.createSequentialGroup()
                        .addGroup(ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel14))
                        .addGap(75, 75, 75)
                        .addGroup(ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textAccountNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textInsuranceName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        ShowBillsLayout.setVerticalGroup(
            ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ShowBillsLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textAccountNo))
                .addGap(18, 18, 18)
                .addGroup(ShowBillsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textInsuranceName))
                .addGap(73, 73, 73)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1012, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Show Bills", ShowBills);

        add(jTabbedPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookNewAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookNewAppointmentActionPerformed
        // TODO add your handling code here: 

           jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_btnBookNewAppointmentActionPerformed

    private void comboStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStateActionPerformed

    private void comboDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboDepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboDepartmentActionPerformed

    private void btnSearchHospitalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHospitalsActionPerformed
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) tableHospital.getModel();
        model.setRowCount(0);
        Network selectedNetwork = (Network) comboState.getSelectedItem();

        for(Enterprise ent: selectedNetwork.getEnterpriseDirectory().getEnterpriseList()){
            if(ent instanceof HospitalEnterprise){
                HospitalEnterprise enth = (HospitalEnterprise)ent;
            Object[] row = new Object[4];
            row[0] = enth;
            
            if(enth.getHospContactInfo() != null){
                row[1] = enth.getHospContactInfo().getAddress();
                row[2] = enth.getHospContactInfo().getPhoneNo();
            }else{
                row[1] = "NA";
                row[2] = "NA";
            }
            row[3] = String.format( "%.2f",enth.getAppDirectory().getAvgCost());          
           
            
            model.addRow(row);
        }
            
        } 
    }//GEN-LAST:event_btnSearchHospitalsActionPerformed

    private void btnBookAppointmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookAppointmentActionPerformed
        // TODO add your handling code here:
         int selectedRow=tableDoctors.getSelectedRow();
         //int hospSelectedRow = tableHospital.getSelectedRow();
         if(selectedRow < 0)
         {
             JOptionPane.showMessageDialog(null, "Select the row from the table to view details","Warning",JOptionPane.WARNING_MESSAGE);
         }
         else {
        selectedDoc = (Doctor)tableDoctors.getValueAt(selectedRow,0);

        AppointmentPanel panel = new AppointmentPanel(sequencer,selectedHosp,selectedDoc,userAccount,system);
        sequencer.add("UserLandingPage",panel);
        CardLayout layout=(CardLayout)sequencer.getLayout();
        layout.next(sequencer); 
         }
    }//GEN-LAST:event_btnBookAppointmentActionPerformed

    private void radioFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioFemaleActionPerformed

    private void btnEnableFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnableFilterActionPerformed
        // TODO add your handling code here:
        int selectedRow=tableHospital.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a row from Hospital table");
            return;
        }
        selectedHosp=(HospitalEnterprise)tableHospital.getValueAt(selectedRow,0);
        populateDepartments(selectedHosp);
        checkDepartment.setEnabled(true);
        checkGender.setEnabled(true);
    }//GEN-LAST:event_btnEnableFilterActionPerformed

    private void btnSearchDoctorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDoctorsActionPerformed
        // TODO add your handling code here:
                int hospselectedRow=tableHospital.getSelectedRow();
               
         if(hospselectedRow < 0)
         {
             JOptionPane.showMessageDialog(null, "Select the row from the table to view details","Warning",JOptionPane.WARNING_MESSAGE);
         }
         else{
        selectedHosp = (HospitalEnterprise)tableHospital.getValueAt(hospselectedRow,0);
        
        
        String gender = null;
        Department d=null;
        
        if(checkDepartment.isSelected() && checkGender.isSelected()){
            if(comboDepartment.isEnabled() && (radioFemale.isSelected() || radioMale.isSelected())){
                d = (Department)comboDepartment.getSelectedItem();
                if(radioFemale.isSelected())
                    gender = "Female";
                if(radioMale.isSelected())
                    gender = "Male";
                displayBoth(gender, d);
            }}
        else if(checkDepartment.isSelected()){
            if(comboDepartment.isEnabled()){
                d = (Department)comboDepartment.getSelectedItem();
                displayTableWithDept(d);
            }
        }
        else if(checkGender.isSelected()){
            if(radioFemale.isSelected() || radioMale.isSelected()){
                if(radioFemale.isSelected())
                    gender = "Female";
                if(radioMale.isSelected())
                    gender = "Male";
                displayTableWithGender(gender);
            }
        }
        
        else{
        DefaultTableModel model = (DefaultTableModel) tableDoctors.getModel();
        model.setRowCount(0);
        
        for(Department dept : selectedHosp.getDeptCatalog().getDepatmentList()){
            for(Doctor doc : dept.getDoctorList()){
                    Object[] row = new Object[4];
                    row[0] = doc;
                    row[1] = doc.getDept();
                    row[2] = doc.getQualification();
                    row[3] = doc.getGender();
                    model.addRow(row);
            }
        } }          
        }     
    }//GEN-LAST:event_btnSearchDoctorsActionPerformed

    private void checkDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDepartmentActionPerformed
        // TODO add your handling code here:
        if(checkDepartment.isSelected())
            comboDepartment.setEnabled(true);
        else
            comboDepartment.setEnabled(false);
    }//GEN-LAST:event_checkDepartmentActionPerformed

    private void checkGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGenderActionPerformed
        // TODO add your handling code here:
        if(checkGender.isSelected()){
            radioFemale.setEnabled(true);
            radioMale.setEnabled(true);
        }
            
        else{
            radioFemale.setEnabled(false);
            radioMale.setEnabled(false);
        }
    }//GEN-LAST:event_checkGenderActionPerformed

    private void comboAppointmentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAppointmentDateActionPerformed
        // TODO add your handling code here:
         populateMedicalHistoryPage();
    }//GEN-LAST:event_comboAppointmentDateActionPerformed

    private void btnDownloadPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadPDFActionPerformed
        // TODO add your handling code here:
        try {
        Consumer c= (Consumer)userAccount.getPerson();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Document document = new com.itextpdf.text.Document(PageSize.A4, 50, 50, 50, 50);

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\"+c.getName()+".pdf"));
        document.open();
          
        Anchor anchorTarget = new Anchor(c.getName() +" Medical Record \n");
        anchorTarget.setName("Medical Records");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
        paragraph1.add(anchorTarget);
        document.add(paragraph1);

        
        if(c.getAppDir().getAppointmentList().size() > 0){
        for(Appointment app : c.getAppDir().getAppointmentList()){
            if(app.getEncounter()!=null){
        document.add(new Paragraph("Appointment Date:"+ sdf.format(app.getStartDt()) ,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 300))));        
        document.add(new Paragraph("Medications:",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        document.add(new Paragraph("Prescriptions:"+ app.getEncounter().getPrescription() ,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        document.add(new Paragraph("Health Issues:"+ app.getEncounter().getHealthIssues() ,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        if(app.getEncounter().getDisease()!=null){
        document.add(new Paragraph("Encountered Disease:"+ app.getEncounter().getDisease().getName(),FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        }else{
            document.add(new Paragraph("Encountered Disease: NA",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        }
        document.add(new Paragraph("Allergies:"+ app.getEncounter().getAllergies() ,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        document.add(new Paragraph("Doctors Note:"+ app.getEncounter().getDiagnosisNotes() ,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        document.add(new Paragraph("\n",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        
        if(app.getRecommendedTests().size()>0){
        document.add(new Paragraph("Tests:",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));    
        for(Test test : app.getRecommendedTests()){
            document.add(new Paragraph("Test Name:"+ test.getName(),FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));    
            document.add(new Paragraph("Test Result:"+ test.getResult(),FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));    
            document.add(new Paragraph("\n",FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 0, 0, 200))));
        }
        }
            }
        
        }
        
        }
        else
            JOptionPane.showMessageDialog(null, "No record existes");
        
        JOptionPane.showMessageDialog(null, "File Downloaded");
        
        document.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ConsumerWorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }catch (DocumentException ex) {
            Logger.getLogger(ConsumerWorkAreaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_btnDownloadPDFActionPerformed

    public void displayTableWithGender(String gender){

        DefaultTableModel model = (DefaultTableModel) tableDoctors.getModel();
        model.setRowCount(0);
        
        for(Department dept : selectedHosp.getDeptCatalog().getDepatmentList()){
            for(Doctor doc : dept.getDoctorList()){
                if(doc.getGender().equals(gender)){
                    Object[] row = new Object[4];
                    row[0] = doc;
                    row[1] = doc.getDept();
                    row[2] = doc.getQualification();
                    row[3] = doc.getGender();
                    model.addRow(row);
            }
        }           
        }
        
    }
    
        public void displayTableWithDept(Department selectedDepartment){
        
        DefaultTableModel model = (DefaultTableModel) tableDoctors.getModel();
        model.setRowCount(0);
        
        for(Department dept : selectedHosp.getDeptCatalog().getDepatmentList()){
            for(Doctor doc : dept.getDoctorList()){
                if(doc.getDept().equals(selectedDepartment)){
                    Object[] row = new Object[4];
                    row[0] = doc;
                    row[1] = doc.getDept();
                    row[2] = doc.getQualification();
                    row[3] = doc.getGender();
                    model.addRow(row);
                }
            }
        }
    }
    
    public void displayBoth(String gender, Department selectedDepartment){
        DefaultTableModel model = (DefaultTableModel) tableDoctors.getModel();
        model.setRowCount(0);
        
        for(Department dept : selectedHosp.getDeptCatalog().getDepatmentList()){
            for(Doctor doc : dept.getDoctorList()){
                if(doc.getDept().equals(selectedDepartment) && doc.getGender().equals(gender)){
                    Object[] row = new Object[4];
                    row[0] = doc;
                    row[1] = doc.getDept();
                    row[2] = doc.getQualification();
                    row[3] = doc.getGender();
                    model.addRow(row);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppointmentHistory;
    private javax.swing.ButtonGroup Gender;
    private javax.swing.JPanel MedicaLHistory;
    private javax.swing.JPanel Search;
    private javax.swing.JPanel ShowBills;
    private javax.swing.JPanel UserDetails;
    private javax.swing.JButton btnBookAppointment;
    private javax.swing.JButton btnBookNewAppointment;
    private javax.swing.JButton btnDownloadPDF;
    private javax.swing.JButton btnEnableFilter;
    private javax.swing.JButton btnSearchDoctors;
    private javax.swing.JButton btnSearchHospitals;
    private javax.swing.JCheckBox checkDepartment;
    private javax.swing.JCheckBox checkGender;
    private javax.swing.JComboBox<Appointment> comboAppointmentDate;
    private javax.swing.JComboBox comboDepartment;
    private javax.swing.JComboBox comboState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton radioFemale;
    private javax.swing.JRadioButton radioMale;
    private javax.swing.JTable tableBills;
    private javax.swing.JTable tableDoctors;
    private javax.swing.JTable tableHistory;
    private javax.swing.JTable tableHospital;
    private javax.swing.JTable tableTestHistory;
    private javax.swing.JLabel textAccountNo;
    private javax.swing.JLabel textAge;
    private javax.swing.JTextArea textAreaAllergies;
    private javax.swing.JTextArea textAreaDoctorsNote;
    private javax.swing.JTextArea textAreaEncounteredDisease;
    private javax.swing.JTextArea textAreaHealthIssues;
    private javax.swing.JTextArea textAreaPrescriptions;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textDepartmentName;
    private javax.swing.JLabel textDoctorName;
    private javax.swing.JLabel textEmailID;
    private javax.swing.JLabel textFirstName;
    private javax.swing.JLabel textHospitalAddress;
    private javax.swing.JLabel textHospitalContact;
    private javax.swing.JLabel textHospitalName;
    private javax.swing.JLabel textInsuranceCompany;
    private javax.swing.JLabel textInsuranceName;
    private javax.swing.JLabel textInsuranceNumber;
    private javax.swing.JLabel textUserType;
    private javax.swing.border.TitledBorder titledBorder1;
    private javax.swing.border.TitledBorder titledBorder2;
    // End of variables declaration//GEN-END:variables
}
