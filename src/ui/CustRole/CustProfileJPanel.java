/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.CustRole;

import business.Business;
import business.order;
import business.Employee.Employee;
import business.Organization.CustOrganization;
import business.Organization.Organization;
import business.Restaurant.CollectionCenter;
import business.Role.ManagerRole;
import business.Role.Role;
import business.UserAccount.UserAccount;
//import business.WorkQueue.LabTestWorkRequest;
import business.WorkQueue.WorkRequest;
import business.WorkQueue.WorkQueue;
import business.user;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.AdministrativeRole.ManageUserAccountJPanel;

/**
 *
 * @author pkuklani
 */
public class CustProfileJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private CustOrganization organization;
    private Business business;
    private UserAccount userAccount;
    private WorkQueue workqueue;
    private Organization org;
    private order fileuser;

    String validationMessage;
    String dateFormat = "MM/dd/yyyy";
    DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Creates new form CustWorkAreaJPanel
     */
    public CustProfileJPanel(JPanel workArea, UserAccount account, CustOrganization organization, Business business) throws IOException {
        try {
            initComponents();
            this.workArea = workArea;
            this.organization = organization;
            this.business = business;
            this.userAccount = account;
            this.business = business;
            this.validationMessage = null;
            setPersonDetails(account);
            //populateOrganizationComboBox();
            populateRequestTable();

        } catch (Exception ex) {
            throw ex;
        }
    }

    private void setPersonDetails(UserAccount account) {
        var employee = account.getEmployee();
        var pObj = employee.getCustomer();
        
        jStateComboBox.setSelectedItem(pObj.getState());
        txtFName.setText(pObj.getfName());
        txtLName.setText(pObj.getlName());
        txtDob.setText(dateFormatter.format(pObj.getDob()));
        txtMobile.setText(pObj.getTelNo());
        txtZip.setText(pObj.getZipCode());
        txtCity.setText(pObj.getCity());
        jGenderComboBox.setSelectedItem(pObj.getGender());
//        jStateComboBox.setSelectedIndex(-1);
//        txtFName.setText("");
//        txtLName.setText("");
//        txtDob.setText("");
//        txtMobile.setText("");
//        txtZip.setText("");
//        txtCity.setText("");
//        jGenderComboBox.setSelectedIndex(-1);

    }

//    public void populateOrganizationComboBox() {
//        cmbOrganizationList.removeAllItems();
//
//        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
//            var organizType = organization.getClass();
//            if (organizType.getName().equals("business.Organization.RestOrganization")) {
//                cmbOrganizationList.addItem(organization);
//            }
//        }
//    }

    public void populateRequestTable() throws IOException {
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();

        model.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request.getCustname().equalsIgnoreCase(this.userAccount.getEmployee().getName())) {
                Object[] row = new Object[7];
                row[0] = request;
                row[1] = request.getId();
                row[2] = request.getMessage();
                row[3] = request.getRestName();
                row[4] = request.getStatus();
                row[5] = request.getRequestDate();
                row[6] = request.getFeedback();
                model.addRow(row);
            }
        }
        File yourFile = new File("order.txt");
        yourFile.delete();
        order u1 = new order();
        try {

            FileOutputStream fs = null;
            fs = new FileOutputStream("order.txt", true);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            int i = 0;
            if (yourFile.length() == 0) {
                i = 0;
            } else {
                i = 1;
            }
            for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
                u1.setId(request.getId());
                u1.setCustname(request.getCustname());
                u1.setRestName(request.getRestName());
                u1.setFood(request.getMessage());
                u1.setRequestDate(request.getRequestDate());
                u1.setStatus(request.getStatus());
                u1.setFeedback(request.getFeedback());
                u1.setResolveDate(request.getResolveDate());
                System.out.println("food in loop" + u1.getFood());
                System.out.println("feedback in loop" + u1.getFeedback());
                if (i == 0) {
                    MyObjectOutputStream oos = null;
                    oos = new MyObjectOutputStream(fs);
                    oos.writeObject(u1);
                    i++;
                } else {
                    MyObjectOutputStream oos = null;
                    oos = new MyObjectOutputStream(fs);
                    oos.writeObject(u1);
                    i++;
                }
            }
            os.close();
        } catch (Exception e) {
            System.out.println("Error Occurred" + e);
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequests = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnorder = new javax.swing.JButton();
        lblimage = new javax.swing.JLabel();
        btnfback = new javax.swing.JButton();
        jCostLabel = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        txtDob = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jGenderComboBox = new javax.swing.JComboBox<>();
        txtFName = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtZip = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jStateComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jGenderComboBox1 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(738, 372));

        tblWorkRequests.setBackground(new java.awt.Color(255, 0, 0));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Order ID", "Food Ordered", "Restaurant", "Status", "Request Date", "Feedback"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkRequests);
        if (tblWorkRequests.getColumnModel().getColumnCount() > 0) {
            tblWorkRequests.getColumnModel().getColumn(0).setMinWidth(0);
            tblWorkRequests.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblWorkRequests.getColumnModel().getColumn(0).setMaxWidth(0);
            tblWorkRequests.getColumnModel().getColumn(1).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Customer Profile");

        btnorder.setBackground(new java.awt.Color(255, 0, 0));
        btnorder.setText("Reset");
        btnorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnorderActionPerformed(evt);
            }
        });

        btnfback.setBackground(new java.awt.Color(255, 0, 0));
        btnfback.setText("Update Profile");
        btnfback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfbackActionPerformed(evt);
            }
        });

        jLabel1.setText("First Name:");

        jLabel10.setText("Last Name:");

        jLabel11.setText("Gender:");

        jLabel12.setText("Date of Birth:");

        jGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Unknown" }));
        jGenderComboBox.setSelectedIndex(-1);

        jLabel13.setText("City:");

        jLabel14.setText("Mobile No:");

        jLabel15.setText("State:");

        jLabel16.setText("Zip Code:");

        jStateComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" }));
        jStateComboBox.setSelectedIndex(-1);
        jStateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStateComboBoxActionPerformed(evt);
            }
        });

        jLabel17.setText("Blood Group:");

        jGenderComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Unknown" }));
        jGenderComboBox1.setSelectedIndex(-1);

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setText("Blood Donation History");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel19.setText("Personal Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(298, 298, 298)
                                        .addComponent(jCostLabel))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(txtZip))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(txtCity))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(txtMobile))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(txtFName))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(65, 65, 65)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(45, 45, 45)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jGenderComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(45, 45, 45)
                                                    .addComponent(jStateComboBox, 0, 1, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(45, 45, 45)
                                                    .addComponent(jGenderComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(262, 262, 262))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(244, 244, 244)))
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(btnorder, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnfback)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGenderComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jGenderComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jStateComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jCostLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfback)
                    .addComponent(btnorder))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnorderActionPerformed
        // TODO add your handling code here:
        user fileuser = null;
        String foodname = "";//cmbfood.getItemAt(cmbfood.getSelectedIndex());

        Date now = new Date();

        String custname = userAccount.getEmployee().getName();
        String restName = "";//cmbOrganizationList.getSelectedItem().toString();
        int size = userAccount.getWorkQueue().getWorkRequestList().size();
        if (size == 0) {
            size = 1;
        } else {
            size++;
        }
        System.out.println("size= " + size);
        WorkRequest request = new WorkRequest();
        request.setMessage(foodname);
        request.setSender(userAccount);
        request.setStatus("Pending");
        request.setRequestDate(now);
        request.setId(size);
        request.setCustname(custname);
        request.setRestName(restName);
        request.setUsertype(1);
        System.out.println(userAccount);

        userAccount.getWorkQueue().getWorkRequestList().add(request);

        JOptionPane.showMessageDialog(this, "Food Order Placed");

        order u1 = new order();
        u1.setId(size);
        u1.setCustname(custname);
        u1.setRestName(restName);
        u1.setFood(foodname);
        u1.setRequestDate(now);
        u1.setStatus("Pending");

        //writing to file
        File yourFile = new File("order.txt");
        try {

//yourFile.createNewFile(); // if file already exists will do nothing 
            FileOutputStream fs = null;
            fs = new FileOutputStream("order.txt", true);
            //  FileOutputStream fs =new FileOutputStream("users.dat") ;
            if (yourFile.length() == 0) {
                ObjectOutputStream os = new ObjectOutputStream(fs);
                os.writeObject(u1);
                os.close();
            } else {
                MyObjectOutputStream oos = null;
                oos = new MyObjectOutputStream(fs);
                oos.writeObject(u1);

                // Closing the FileOutputStream object
                // to release memory resources
                oos.close();
            }
            System.out.print("added to file");
        } catch (Exception e) {

            // Print the exception along with the
            // display message
            System.out.println("Error Occurred" + e);
        }

        // reading back
        try {

            // Creating new file using File object above
            yourFile.createNewFile();
        } // Catch block to handle the exception
        catch (Exception e) {
        }
        ////////////
        // If the file is empty
        if (yourFile.length() != 0) {

            try {

                // If file doesn't exists
                FileInputStream fis = null;

                fis = new FileInputStream(
                        "order.txt");
                ObjectInputStream ois
                        = new ObjectInputStream(fis);

                order u2 = null;

                while (fis.available() != 0) {
                    u2 = (order) ois.readObject();
                    String name = u2.getCustname();
                    System.out.println("id ==" + u2.getId());
                    System.out.println("name ==" + name);
                    System.out.println("food ==" + u2.getFood());
                    System.out.println("date ==" + u2.getRequestDate());
                    //  System.out.println("role =="+u2.getRole());
                }

                // Closing the connection to release memory
                // resources using close() method
                ois.close();
                fis.close();

                // Once all connection are closed after the
                // desired action change the flag state
            } // Catch block to handle the exception
            catch (Exception e) {

                // Print the exception on the console
                // along with display message
                System.out.println("Error Occurred" + e);

                // Exception encountered line is also
                // displayed on console using the
                // printStackTrace() method
                e.printStackTrace();
            }
        }
        try {
            ////////////
///working with text file
            populateRequestTable();
        } catch (IOException ex) {
            Logger.getLogger(CustProfileJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        //jOrderID.setText("");
        //jOrderDetailsLabel.setText("");
    }//GEN-LAST:event_btnorderActionPerformed

    private void btnfbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfbackActionPerformed
        // TODO add your handling code here:
//        int l = 0;
//        if (jOrderID.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please select an order for feedback");
//            return;
//        }
//        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
//            int idfound = request.getId();
//            int selectid = 0;
//            if (!jOrderID.getText().isEmpty()) {
//                System.out.println("inside");
//                selectid = Integer.parseInt(jOrderID.getText());
//            }
//            System.out.println("idfound" + idfound + "selectfedfe" + selectid);
//            if (idfound == selectid) {
//                int k = cmbfeed.getSelectedIndex();
//                System.out.println("k = " + k);
//                request.setFeedback(cmbfeed.getItemAt(cmbfeed.getSelectedIndex()));
//                System.out.println(request.getFeedback());
//                userAccount.getWorkQueue().getWorkRequestList().set(l, request);
//                break;
//            }
//            l++;
//        }
//        JOptionPane.showMessageDialog(this, " Thank you for feedback");
//        jOrderID.setText("");
//        jOrderDetailsLabel.setText("");
//        try {
//            populateRequestTable();
//        } catch (IOException ex) {
//            Logger.getLogger(CustProfileJPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnfbackActionPerformed

    private void jStateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStateComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jStateComboBoxActionPerformed
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
    private javax.swing.JButton btnfback;
    private javax.swing.JButton btnorder;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCostLabel;
    private javax.swing.JComboBox<String> jGenderComboBox;
    private javax.swing.JComboBox<String> jGenderComboBox1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jStateComboBox;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblimage;
    private javax.swing.JTable tblWorkRequests;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDob;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtZip;
    // End of variables declaration//GEN-END:variables
protected ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            System.err.println("found file: " + path + " url " + imgURL);
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Couldn't find file: " + path + " url " + imgURL);
            return null;
        }
    }
}
