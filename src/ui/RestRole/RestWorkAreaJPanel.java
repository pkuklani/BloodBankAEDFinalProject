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

/**
 *
 * @author pkuklani
 */
public class RestWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private CollectionCenterOrganization organization;
    private business.DeliveryMan.DeliveryMan dorganization;
    private business.DeliveryMan.DeliveryManDirectory ddirectory;
    private Business business;
    private UserAccount userAccount;
    private UserAccount userAccount1;
    private UserAccountDirectory Daccount;
    private DeliveryManDirectory dmanlist;
    private order fileuser;

    public RestWorkAreaJPanel(JPanel workArea, UserAccount account, UserAccount account1, CollectionCenterOrganization organization, Business business1) {
        initComponents();
        System.out.println(account);
        this.workArea = workArea;
        this.organization = organization;
        this.business = business1;
        this.userAccount = account;
        this.userAccount1 = account1;
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
                    cmbdelivery.addItem(ua.getEmployee().getName().toString());
                }
            }
        }

        populateRequestTable();
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[7];
            row[0] = request;
            row[1] = request.getId();
            row[2] = request.getMessage();
            row[3] = request.getCustname();
            row[4] = request.getRestName();
            row[5] = request.getStatus();
            row[6] = request.getDname();

            model.addRow(row);
        }
        File yourFile = new File("order.txt");
        yourFile.delete();
        order u1 = new order();
        try {
            FileOutputStream fs = null;
            fs = new FileOutputStream("order.txt", true);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            MyObjectOutputStream oos = new MyObjectOutputStream(fs);
            int i = 0;
            if (yourFile.length() == 0) {
                i = 0;
            } else {
                i = 1;
            }
            for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList()) {
                u1.setId(request.getId());
                u1.setCustname(request.getCustname());
                u1.setRestName(request.getRestName());
                u1.setFood(request.getMessage());
                u1.setRequestDate(request.getRequestDate());
                u1.setStatus(request.getStatus());
                u1.setFeedback(request.getFeedback());
                u1.setDname(request.getDname());
                u1.setResolveDate(request.getResolveDate());
                System.out.println("dname in loop" + u1.getDname());
                System.out.println("feedback in loop" + u1.getFeedback());
                if (i == 0) {
                    oos = null;
                    oos = new MyObjectOutputStream(fs);
                    oos.writeObject(u1);
                    i++;
                } else {
                    oos = null;
                    oos = new MyObjectOutputStream(fs);
                    oos.writeObject(u1);
                    i++;
                }
            }
            oos.close();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkRequests = new javax.swing.JTable();
        btnassignboy = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        cmbdelivery = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(797, 350));

        tblWorkRequests.setBackground(new java.awt.Color(255, 0, 0));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Order ID", "Food Ordered", "Order By", "Restaurant", "Status", "Delivery Boy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false
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
            tblWorkRequests.getColumnModel().getColumn(1).setPreferredWidth(1);
        }

        btnassignboy.setBackground(new java.awt.Color(255, 0, 0));
        btnassignboy.setText("Assign delivery Boy");
        btnassignboy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnassignboyActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(255, 0, 0));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Restaurant Work Area");

        cmbdelivery.setBackground(new java.awt.Color(255, 0, 0));

        jLabel2.setText("Delivery Boy");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnassignboy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(93, 93, 93)))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnassignboy)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(cmbdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnassignboyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnassignboyActionPerformed

        CardLayout layout = (CardLayout) workArea.getLayout();
        layout.next(workArea);

        int SelectedRowIndex = tblWorkRequests.getSelectedRow();
        System.out.println("SelectedRowIndex " + SelectedRowIndex);
        if (SelectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select an Order");
            return;
        }
        DefaultTableModel model1 = (DefaultTableModel) tblWorkRequests.getModel();
        WorkRequest selectedvital = (WorkRequest) model1.getValueAt(SelectedRowIndex, 0);
        var orderStatus = String.valueOf(selectedvital.getStatus());
        if (orderStatus.equalsIgnoreCase("Delivered")) {
            JOptionPane.showMessageDialog(this, "Order is already delivered. Cannot be assigned a Delivery Boy");
            return;
        }
        txtid.setText(String.valueOf(selectedvital.getId()));
    }//GEN-LAST:event_btnassignboyActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        populateRequestTable();

    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int l = 0;
        for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList()) {
            int idfound = request.getId();
            int selectid = 0;
            if (!txtid.getText().isEmpty()) {
                System.out.println("inside");
                selectid = Integer.parseInt(txtid.getText());
            }
            System.out.println("idfound" + idfound + "selectfedfe" + selectid);
            if (idfound == selectid) {
                request.setDname(cmbdelivery.getItemAt(cmbdelivery.getSelectedIndex()));
                request.setStatus("Pick Up");
                userAccount1.getWorkQueue().getWorkRequestList().set(l, request);
                break;
            }
            l++;
    }//GEN-LAST:event_jButton1ActionPerformed
        JOptionPane.showMessageDialog(this, " Order assigned for Pickup");
        populateRequestTable();
    }

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
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnassignboy;
    private javax.swing.JComboBox<String> cmbdelivery;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
