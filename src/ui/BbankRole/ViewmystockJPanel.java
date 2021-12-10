/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.BbankRole;

import ui.DonorRole.*;
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
public class ViewmystockJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
    
 
 ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
           String user;
           String role;
           int ubbankid;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public ViewmystockJPanel(JPanel userProcessContainer,String user,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
       
        this.business = business;
        this.user=user;
        System.out.println("user "+user+"role "+role);
        //this.deliveryOrganization = (DeliveryOrganization) organization;

        populateTable();
    }

    public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
       
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT * from Bbank_stock ";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getString(2);
           
                  row[1]=resultSet.getInt(3); 
                  
                   
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
        lblTitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnback = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblWorkRequests.setBackground(new java.awt.Color(204, 255, 204));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Blood Group", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
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
            tblWorkRequests.getColumnModel().getColumn(1).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Blood Bank Work Area");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Blood Stock Details");

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblTitle)
                        .addGap(47, 47, 47)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnback)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed

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
    private javax.swing.JButton btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    // End of variables declaration//GEN-END:variables
}
