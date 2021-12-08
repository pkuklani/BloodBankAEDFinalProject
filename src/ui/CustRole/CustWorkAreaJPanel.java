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
import business.Restaurant.Restaurant;
import business.Role.RestRole;
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
public class CustWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private CustOrganization organization;
    private Business business;
    private UserAccount userAccount;
    private UserAccount userAccount1;
    private WorkQueue workqueue;
    private Organization org;
    private order fileuser;

    /**
     * Creates new form CustWorkAreaJPanel
     */
    public CustWorkAreaJPanel(JPanel workArea, UserAccount account, UserAccount account1, CustOrganization organization, Business business) throws IOException {
        try {
            initComponents();

            this.workArea = workArea;
            this.organization = organization;
            this.business = business;
            this.userAccount = account;
            this.userAccount1 = account1;
            this.business = business;
            populateOrganizationComboBox();
            jOrderID.setText("");
            jOrderDetailsLabel.setText("");
            populateRequestTable();
            cmbOrganizationList.setSelectedIndex(-1);
            cmbfood.setSelectedIndex(-1);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void populateOrganizationComboBox() {
        cmbOrganizationList.removeAllItems();

        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {
            var organizType = organization.getClass();
            if (organizType.getName().equals("business.Organization.RestOrganization")) {
                cmbOrganizationList.addItem(organization);
            }
        }
    }

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
        }
        catch (Exception e) {
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
        btnfeed = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btndelorder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cmbfood = new javax.swing.JComboBox<>();
        btnorder = new javax.swing.JButton();
        lblimage = new javax.swing.JLabel();
        lblcost = new javax.swing.JLabel();
        cmbfeed = new javax.swing.JComboBox<>();
        btnfback = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbOrganizationList = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jCostLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jOrderDetailsLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jOrderID = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setBackground(new java.awt.Color(255, 255, 255));
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

        btnfeed.setBackground(new java.awt.Color(255, 0, 0));
        btnfeed.setText("Feedback");
        btnfeed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfeedActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Customers's Work Area");

        btndelorder.setBackground(new java.awt.Color(255, 0, 0));
        btndelorder.setText("Delete Order");
        btndelorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelorderActionPerformed(evt);
            }
        });

        jLabel2.setText("Food Item");

        cmbfood.setBackground(new java.awt.Color(255, 0, 0));
        cmbfood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pizza", "Burger", "French Fries" }));
        cmbfood.setSelectedIndex(-1);
        cmbfood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbfoodItemStateChanged(evt);
            }
        });

        btnorder.setBackground(new java.awt.Color(255, 0, 0));
        btnorder.setText("Place Order");
        btnorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnorderActionPerformed(evt);
            }
        });

        cmbfeed.setBackground(new java.awt.Color(255, 0, 0));
        cmbfeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Excellent", "Good", "Bad" }));
        cmbfeed.setSelectedIndex(-1);

        btnfback.setBackground(new java.awt.Color(255, 0, 0));
        btnfback.setText("Submit Feedback");
        btnfback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfbackActionPerformed(evt);
            }
        });

        jLabel3.setText("Restaurant");

        cmbOrganizationList.setBackground(new java.awt.Color(255, 0, 0));
        cmbOrganizationList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrganizationList.setSelectedIndex(-1);
        cmbOrganizationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationListActionPerformed(evt);
            }
        });

        jLabel4.setText("Cost");

        jLabel5.setText("Feedback:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Leave Feedback");

        jOrderDetailsLabel.setText("ORDER");

        jLabel7.setText("Order Details: ");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("New Order");

        jLabel9.setText("Order ID");

        jOrderID.setText("ORDER");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnfback)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbfeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jOrderDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(278, 278, 278)
                        .addComponent(btndelorder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnfeed))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnorder)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2))
                                                .addGap(2, 2, 2))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cmbfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cmbOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lblcost, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCostLabel))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(605, 605, 605)
                        .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnfeed)
                    .addComponent(btndelorder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblimage, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jCostLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cmbOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblcost, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnorder)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOrderID)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOrderDetailsLabel)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbfeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnfback)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnfeedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfeedActionPerformed
        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);

        int SelectedRowIndex = tblWorkRequests.getSelectedRow();
        System.out.println("SelectedRowIndex " + SelectedRowIndex);
        if (SelectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Order");

            return;
        }
        jOrderID.setText("");
        jOrderDetailsLabel.setText("");
        DefaultTableModel model1 = (DefaultTableModel) tblWorkRequests.getModel();
        WorkRequest selectedvital = (WorkRequest) model1.getValueAt(SelectedRowIndex, 0);
        jOrderDetailsLabel.setText(String.valueOf(selectedvital.getMessage()));
        jOrderID.setText(String.valueOf(selectedvital.getId()));

    }//GEN-LAST:event_btnfeedActionPerformed

    private void btnorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnorderActionPerformed
        // TODO add your handling code here:
        user fileuser = null;
        String foodname = cmbfood.getItemAt(cmbfood.getSelectedIndex());

        Date now = new Date();

        String custname = userAccount.getEmployee().getName();
        String restName = cmbOrganizationList.getSelectedItem().toString();
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
            Logger.getLogger(CustWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        jOrderID.setText("");
        jOrderDetailsLabel.setText("");
    }//GEN-LAST:event_btnorderActionPerformed

    private void cmbfoodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbfoodItemStateChanged

        int i = cmbfood.getSelectedIndex();
        String cost = "$" + 15;;
        //String foodname = "/food" + i + ".jpg";
        if (i == 0) {
            cost = "$" + 20;
        }
        if (i == 1) {
            cost = "$" + 10;
        }
        if (i == 2) {
            cost = "$" + 6;
        }
        jCostLabel.setText(cost);
    }//GEN-LAST:event_cmbfoodItemStateChanged

    private void btndelorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelorderActionPerformed
        // TODO add your handling code here:
        int SelectedRowIndex = tblWorkRequests.getSelectedRow();
        System.out.print("select" + SelectedRowIndex);
        if (SelectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete");
            return;
        }
        DefaultTableModel model1 = (DefaultTableModel) tblWorkRequests.getModel();
        WorkRequest selectedvital = (WorkRequest) model1.getValueAt(SelectedRowIndex, 0);
        var orderStatus = String.valueOf(selectedvital.getStatus());
        if (!orderStatus.equalsIgnoreCase("Pending")) {
            JOptionPane.showMessageDialog(this, "Order is already  being processed. Cannot be deleted, only Pending orders can be deleted.");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        WorkRequest request = (WorkRequest) model.getValueAt(SelectedRowIndex, 0);
        System.out.println("request" + request);
        userAccount1.getWorkQueue().deletevitals(request);
        JOptionPane.showMessageDialog(this, "Order deleted");
        try {
            populateRequestTable();
        } catch (IOException ex) {
            Logger.getLogger(CustWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        jOrderID.setText("");
        jOrderDetailsLabel.setText("");
    }//GEN-LAST:event_btndelorderActionPerformed

    private void btnfbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfbackActionPerformed
        // TODO add your handling code here:
        int l = 0;
        if (jOrderID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select an order for feedback");
            return;
        }
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            int idfound = request.getId();
            int selectid = 0;
            if (!jOrderID.getText().isEmpty()) {
                System.out.println("inside");
                selectid = Integer.parseInt(jOrderID.getText());
            }
            System.out.println("idfound" + idfound + "selectfedfe" + selectid);
            if (idfound == selectid) {
                int k = cmbfeed.getSelectedIndex();
                System.out.println("k = " + k);
                request.setFeedback(cmbfeed.getItemAt(cmbfeed.getSelectedIndex()));
                System.out.println(request.getFeedback());
                userAccount.getWorkQueue().getWorkRequestList().set(l, request);
                break;
            }
            l++;
        }
        JOptionPane.showMessageDialog(this, " Thank you for feedback");
        jOrderID.setText("");
        jOrderDetailsLabel.setText("");
        try {
            populateRequestTable();
        } catch (IOException ex) {
            Logger.getLogger(CustWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnfbackActionPerformed

    private void cmbOrganizationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationListActionPerformed
        Organization organization = (Organization) cmbOrganizationList.getSelectedItem();
        if (organization != null) {
            //populateTable(organization);
        }
    }//GEN-LAST:event_cmbOrganizationListActionPerformed
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
    private javax.swing.JButton btndelorder;
    private javax.swing.JButton btnfback;
    private javax.swing.JButton btnfeed;
    private javax.swing.JButton btnorder;
    private javax.swing.JComboBox cmbOrganizationList;
    private javax.swing.JComboBox<String> cmbfeed;
    private javax.swing.JComboBox<String> cmbfood;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jCostLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jOrderDetailsLabel;
    private javax.swing.JLabel jOrderID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblcost;
    private javax.swing.JLabel lblimage;
    private javax.swing.JTable tblWorkRequests;
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
