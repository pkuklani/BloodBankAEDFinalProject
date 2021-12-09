/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.RestRole;

import business.Business;
import business.DeliveryMan.DeliveryMan;
import business.DeliveryMan.DeliveryManDirectory;
import business.Employee.Employee;
import business.Organization.Organization;
import business.Organization.CollectionCenterOrganization;
import business.Restaurant.CollectionCenter;
import business.Role.LabTestRole;
import business.UserAccount.UserAccount;
import business.UserAccount.UserAccountDirectory;
import business.WorkQueue.WorkRequest;
import business.order;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.CustRole.CustWorkAreaJPanel;
import business.order;
import java.text.Format;
import java.text.SimpleDateFormat;

/**
 *
 * @author pkuklani
 */
public class NewCollectionJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private CollectionCenterOrganization organization;
    private business.DeliveryMan.DeliveryMan dorganization;
    private business.DeliveryMan.DeliveryManDirectory ddirectory;
    private Business business;
    private UserAccount userAccount;
    //private UserAccount userAccount1;
    private UserAccountDirectory Daccount;
    private DeliveryManDirectory dmanlist;
    private order fileuser;
    String validationMessage;

    public NewCollectionJPanel(JPanel workArea, UserAccount account, CollectionCenterOrganization organization, Business business1) {
        initComponents();
        System.out.println(account);
        this.workArea = workArea;
        this.organization = organization;
        this.business = business1;
        this.userAccount = account;
        //this.userAccount1 = account1;
        this.ddirectory = business1.getDeliveryDirectory();
        //var dmanListed = ddirectory.getDeliverymanList();
        /*for (DeliveryMan dman : ddirectory.getDeliverymanList()) {
            System.out.println("dman= " + dman.getDmanname());
            cmbdelivery.addItem(dman.getDmanname().toString());
        }*/

        for (Organization org : business.getOrganizationDirectory().getOrganizationList()) {
            var organizType = org.getClass();
            if (organizType.getName().equals("business.Organization.DeliveryOrganization")) {
                for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
                    //cmbdelivery.addItem(ua.getEmployee().getName().toString());
                }
            }
        }

        populateRequestTable();
        
        this.validationMessage = null;

//        DefaultTableModel model = (DefaultTableModel) jPersonSummary.getModel();
//        Object rowData[] = new Object[9];
//        var personList = healthRepository.getPersonRepository();
//        Format f = new SimpleDateFormat("MM/dd/yy");
//        for (int i = 0; i < personList.size(); i++) {
//            var obj = personList.get(i);
//            rowData[0] = obj.getPersonID();
//            rowData[1] = obj.getfName();
//            rowData[2] = obj.getlName();
//            rowData[3] = obj.getGender();
//            rowData[4] = f.format(obj.getDob());
//            rowData[5] = obj.getCity();
//            rowData[6] = obj.getState();
//            rowData[7] = Integer.toString(obj.getZipCode());
//            model.addRow(rowData);
//        }
    }

    public void populateRequestTable() {
//        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
//
//        model.setRowCount(0);
//        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
//            Object[] row = new Object[7];
//            row[0] = request;
//            row[1] = request.getId();
//            row[2] = request.getMessage();
//            row[3] = request.getCustname();
//            row[4] = request.getRestName();
//            row[5] = request.getStatus();
//            row[6] = request.getDname();
//
//            model.addRow(row);
//        }
//        File yourFile = new File("order.txt");
//        yourFile.delete();
//        order u1 = new order();
//        try {
//            FileOutputStream fs = null;
//            fs = new FileOutputStream("order.txt", true);
//            ObjectOutputStream os = new ObjectOutputStream(fs);
//            MyObjectOutputStream oos = new MyObjectOutputStream(fs);
//            int i = 0;
//            if (yourFile.length() == 0) {
//                i = 0;
//            } else {
//                i = 1;
//            }
//            for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
//                u1.setId(request.getId());
//                u1.setCustname(request.getCustname());
//                u1.setRestName(request.getRestName());
//                u1.setFood(request.getMessage());
//                u1.setRequestDate(request.getRequestDate());
//                u1.setStatus(request.getStatus());
//                u1.setFeedback(request.getFeedback());
//                u1.setDname(request.getDname());
//                u1.setResolveDate(request.getResolveDate());
//                System.out.println("dname in loop" + u1.getDname());
//                System.out.println("feedback in loop" + u1.getFeedback());
//                if (i == 0) {
//                    oos = null;
//                    oos = new MyObjectOutputStream(fs);
//                    oos.writeObject(u1);
//                    i++;
//                } else {
//                    oos = null;
//                    oos = new MyObjectOutputStream(fs);
//                    oos.writeObject(u1);
//                    i++;
//                }
//            }
//            oos.close();
//        }
//        catch (Exception e) {
//            System.out.println("Error Occurred" + e);
//        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jDateTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jDocTxt = new javax.swing.JTextField();
        jCreateButton = new javax.swing.JButton();
        btnassignboy = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblTitle1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFirstNameText = new javax.swing.JTextField();
        jLastNameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jGenderComboBox = new javax.swing.JComboBox<>();
        jSearchButton = new javax.swing.JButton();
        lblTitle2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPersonSummary = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jDateTxt1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jDocTxt1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jBloodGroupComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jLabel10.setText("Date");

        jLabel13.setText("Attending Doctor:");

        jCreateButton.setText("Create");
        jCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateButtonActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(797, 350));

        btnassignboy.setBackground(new java.awt.Color(255, 0, 0));
        btnassignboy.setText("Assign delivery Boy");
        btnassignboy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnassignboyActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Initiate Blood Collection");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Collect");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 0, 0));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle1.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lblTitle1.setText("Search Patient");

        jLabel1.setText("First Name:");

        jLabel3.setText("Gender:");

        jGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Unknown" }));
        jGenderComboBox.setSelectedIndex(-1);

        jSearchButton.setText("Search");
        jSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchButtonActionPerformed(evt);
            }
        });

        lblTitle2.setFont(new java.awt.Font("Lucida Grande", 1, 12)); // NOI18N
        lblTitle2.setText("Search Results");

        jPersonSummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Gender", "DOB", "City", "State", "Blood Group"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jPersonSummary);

        jLabel11.setText("Collection Date: ");

        jLabel14.setText("Quantity (mL):");

        jLabel12.setText("Blood Group:");

        jBloodGroupComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AB-", "B-", "AB+", "A-", "O-", "B+", "A+", "O+" }));
        jBloodGroupComboBox.setSelectedIndex(-1);

        jLabel2.setText("Last Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnassignboy)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDocTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jBloodGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(123, 123, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFirstNameText)
                                    .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(18, 18, 18)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFirstNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLastNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSearchButton)
                .addGap(18, 18, 18)
                .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnassignboy)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBloodGroupComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDocTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnassignboyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnassignboyActionPerformed

//        CardLayout layout = (CardLayout) workArea.getLayout();
//        layout.next(workArea);
//
//        int SelectedRowIndex = tblWorkRequests.getSelectedRow();
//        System.out.println("SelectedRowIndex " + SelectedRowIndex);
//        if (SelectedRowIndex < 0) {
//            JOptionPane.showMessageDialog(this, "Please select an Order");
//            return;
//        }
//        DefaultTableModel model1 = (DefaultTableModel) tblWorkRequests.getModel();
//        WorkRequest selectedvital = (WorkRequest) model1.getValueAt(SelectedRowIndex, 0);
//        var orderStatus = String.valueOf(selectedvital.getStatus());
//        if (orderStatus.equalsIgnoreCase("Delivered")) {
//            JOptionPane.showMessageDialog(this, "Order is already delivered. Cannot be assigned a Delivery Boy");
//            return;
//        }
//        txtid.setText(String.valueOf(selectedvital.getId()));
    }//GEN-LAST:event_btnassignboyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        int l = 0;
//        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
//            int idfound = request.getId();
//            int selectid = 0;
//            if (!txtid.getText().isEmpty()) {
//                System.out.println("inside");
//                selectid = Integer.parseInt(txtid.getText());
//            }
//            System.out.println("idfound" + idfound + "selectfedfe" + selectid);
//            if (idfound == selectid) {
//                request.setDname(cmbdelivery.getItemAt(cmbdelivery.getSelectedIndex()));
//                request.setStatus("Pick Up");
//                userAccount.getWorkQueue().getWorkRequestList().set(l, request);
//                break;
//            }
//            l++;
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        workArea.remove(this);
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.previous(workArea);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchButtonActionPerformed
        // TODO add your handling code here:
//        validateFormData();
//        if (this.validationMessage != null) {
//            String validationMessage = "One or more issues found. Please resolve and click Save again.\n\n";
//            JOptionPane.showMessageDialog(this, validationMessage + this.validationMessage);
//        } else {
//            String fName = jFirstNameText.getText();
//            String lName = jLastNameText.getText();
//            String gender = jGenderComboBox.getSelectedItem() != null ? jGenderComboBox.getSelectedItem().toString() : "";
//
//            var personList = this.healthRepository.getPersonRepository();
//            DefaultTableModel model = (DefaultTableModel) jPersonSummary.getModel();
//            model.setRowCount(0);
//            Object rowData[] = new Object[9];
//            Format f = new SimpleDateFormat("MM/dd/yy");
//            for (int i = 0; i < personList.size(); i++) {
//                var obj = personList.get(i);
//                if (fName != null && !fName.trim().isEmpty() && !fName.trim().toUpperCase().equals(obj.getfName().toUpperCase())) {
//                    continue;
//                }
//                if (lName != null && !lName.trim().isEmpty() && !lName.trim().toUpperCase().equals(obj.getlName().toUpperCase())) {
//                    continue;
//                }
//                if (gender != null && !gender.trim().isEmpty() && !gender.trim().toUpperCase().equals(obj.getGender().toUpperCase())) {
//                    continue;
//                }
//                rowData[0] = obj.getPersonID();
//                rowData[1] = obj.getfName();
//                rowData[2] = obj.getlName();
//                rowData[3] = obj.getGender();
//                rowData[4] = f.format(obj.getDob());
//                rowData[5] = obj.getCity();
//                rowData[6] = obj.getState();
//                rowData[7] = Integer.toString(obj.getZipCode());
//                if (healthRepository.searchPatient(obj.getPersonID()) != null) {
//                    rowData[8] = "Yes";
//                } else {
//                    rowData[8] = "No";
//                }
//                model.addRow(rowData);
//            }
//        }
    }//GEN-LAST:event_jSearchButtonActionPerformed

    private void jCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateButtonActionPerformed
        // TODO add your handling code here:
//        validateFormData();
//        if (this.validationMessage != null) {
//            String validationMessage = "One or more issues found. Please resolve and click Save again.\n\n";
//            JOptionPane.showMessageDialog(this, validationMessage + this.validationMessage);
//        } else {
//            Encounter eObj = new Encounter();
//            eObj.setDate(convertStringToDate(jDateTxt.getText()));
//            eObj.setDoctor(jDocTxt.getText());
//            eObj.setHosp(jLocTxt.getText());
//            eObj.setPulse(Integer.parseInt(jPulseTxt.getText()));
//            eObj.setTemp(Double.parseDouble(jTempTxt.getText()));
//            eObj.setBp(Double.parseDouble(jBPText.getText()));
//            this.healthRepository.addEncounter(eObj, personID);
//
//            JOptionPane.showMessageDialog(this, "Encounter Details have been Saved Successfully.");
//
//            jDateTxt.setText("");
//            jDocTxt.setText("");
//            jLocTxt.setText("");
//            jPulseTxt.setText("");
//            jTempTxt.setText("");
//            jBPText.setText("");
//        }
    }//GEN-LAST:event_jCreateButtonActionPerformed

    //overriding by akhil
    class MyObjectOutputStream extends ObjectOutputStream {

        // Constructor of ths class
        // 1. Default
        MyObjectOutputStream() throws IOException {

            // Super keyword refers to parent class instance
            super();
        }

        // Constructor of ths class
        // 1. Parameterized constructor
        MyObjectOutputStream(OutputStream o) throws IOException {
            super(o);
        }

        // Method of this class
        public void writeStreamHeader() throws IOException {
            return;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnassignboy;
    private javax.swing.JComboBox<String> jBloodGroupComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jCreateButton;
    private javax.swing.JTextField jDateTxt;
    private javax.swing.JTextField jDateTxt1;
    private javax.swing.JTextField jDocTxt;
    private javax.swing.JTextField jDocTxt1;
    private javax.swing.JTextField jFirstNameText;
    private javax.swing.JComboBox<String> jGenderComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jLastNameText;
    private javax.swing.JTable jPersonSummary;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jSearchButton;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    // End of variables declaration//GEN-END:variables
}
