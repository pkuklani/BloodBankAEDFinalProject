/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.DonorRole;

import bbank.Bbank;
import bbank.DB.DButil;
import bbank.Role.DonarRole;

import bbank.UserAccount.UserAccount;
//import business.WorkQueue.LabTestWorkRequest;
import bbank.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import ui.LoginScreen;

/**
 *
 * @author akhil
 */
public class DonorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
   
 
 ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public DonorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
         //  this.userAccount1 = account1;
        this.business = business;
        //this.deliveryOrganization = (DeliveryOrganization) organization;

        populateTable();
    }

    public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
       
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT * from Blood_demand where status=0";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getInt(1);
            row[2] = resultSet.getString(2);
            row[3] = resultSet.getString(3);
          //  row[3]=resultSet.getString(4);
                  row[4]=resultSet.getInt(5); 
                   row[6]=resultSet.getInt(6);
                  row[5]=resultSet.getDate(7).toString();
                   
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
      
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
        btnAssign = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblWorkRequests.setBackground(new java.awt.Color(204, 255, 204));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Blood Bank ID", "Blood Bank Name", "Blood Group", "Patient Name", "Quantity", "Request  Date", "Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, true
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
            tblWorkRequests.getColumnModel().getColumn(0).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblWorkRequests.getColumnModel().getColumn(1).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblWorkRequests.getColumnModel().getColumn(2).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(3).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(4).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(4).setPreferredWidth(10);
            tblWorkRequests.getColumnModel().getColumn(5).setResizable(false);
        }

        btnAssign.setBackground(new java.awt.Color(102, 153, 255));
        btnAssign.setText("Set Status Delivered");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Donor Work Area");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Pending Blood requirements ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAssign)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addGap(47, 47, 47)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnAssign)
                .addContainerGap(181, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed

        int selectedRow = tblWorkRequests.getSelectedRow();

        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblWorkRequests.getValueAt(selectedRow, 0);
            if (request.getMessage().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
                Date now=new Date();
                request.setReceiver(userAccount);
                request.setStatus("Delivered");
                request.setResolveDate(now);
                 JOptionPane.showMessageDialog(null, "Order Delivered");
                populateTable();

            }

        } else {
            JOptionPane.showMessageDialog(null, "Choose a order to deliver");
            return;
        }


    }//GEN-LAST:event_btnAssignActionPerformed

     //overriding by akhil
   class MyObjectOutputStream extends ObjectOutputStream {
 
    // Constructor of ths class
    // 1. Default
    MyObjectOutputStream() throws IOException
    {
 
        // Super keyword refers to parent class instance
        super();
    }
 
    // Constructor of ths class
    // 1. Parameterized constructor
    MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }
 
    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    // End of variables declaration//GEN-END:variables
}
