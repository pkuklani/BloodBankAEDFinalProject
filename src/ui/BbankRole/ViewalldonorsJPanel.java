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
import java.sql.PreparedStatement;
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
public class ViewalldonorsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
   
 ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
           String user,role;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public ViewalldonorsJPanel(JPanel userProcessContainer,String user,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
       // this.userAccount = account;
         //  this.userAccount1 = account1;
        this.business = business;
        this.role=role;
        this.user=user;
        //this.deliveryOrganization = (DeliveryOrganization) organization;
addcmbtype();
        populateTable();
    }
//add cbtype starts
    public void addcmbtype()
        {
             cmbtype.removeAll();
                    // cmbbank.removeAll();
          cmbtype.addItem("All");
          //  cmbOrganizationList.addItem(organization);
           Connection conn = dbconn.getConnection();
            ResultSet resultSet = null;
         String selectSql = "SELECT bgroup_name from bgroup";
       PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
            
      // stmt.setString(1,roletype);
            resultSet = stmt.executeQuery();
       
           
            // conn.close();
             while (resultSet.next()) {
                 String cmbvalue=resultSet.getString(1);
                  // System.out.println("cmbvalue hos "+cmbvalue);
                  cmbtype.addItem(cmbvalue);
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
        
//blood type
    //addcmbtype ends
    // populate type starts
     public void populatetypeTable() {
            DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        Connection conn = dbconn.getConnection();
        ResultSet resultSet = null;
        model.setRowCount(0);
          String bgroup=cmbtype.getItemAt(cmbtype.getSelectedIndex());
        System.out.println("populate");
        //
         String selectSql=null;
         if(bgroup.equals("All"))
         {
         selectSql = "SELECT * from Doners";
         }
         else
            {
         selectSql = "SELECT * from Doners where bgroup_name=?";
         }  
       PreparedStatement stmt;
       try {
            stmt = conn.prepareStatement(selectSql);
        if(!bgroup.equals("All"))
        {
             stmt.setString(1, bgroup);
        }
            resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getString(2);
            row[1] = resultSet.getString(4);
            row[2] = resultSet.getString(3);
          //  row[3]=resultSet.getString(4);
                  row[3]=resultSet.getInt(5); 
                   row[4]=resultSet.getInt(7);
                 
                   
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
      
    }

    //populate type ends
    public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        Connection conn = dbconn.getConnection();
        ResultSet resultSet = null;
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT * from Doners";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getString(2);
            row[1] = resultSet.getString(4);
            row[2] = resultSet.getString(3);
          //  row[3]=resultSet.getString(4);
                  row[3]=resultSet.getInt(5); 
                   row[4]=resultSet.getInt(7);
                 
                   
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
        btnback = new javax.swing.JButton();
        cmbtype = new javax.swing.JComboBox<>();
        btntype = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblWorkRequests.setBackground(new java.awt.Color(204, 255, 204));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Donor Name", "Blood Group", "Address", "Mobile", "Donated Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
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
            tblWorkRequests.getColumnModel().getColumn(2).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Blood bank Work Area");

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btntype.setText("Search By Type");
        btntype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntypeActionPerformed(evt);
            }
        });

        jLabel1.setText("Donors list");

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
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnback))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btntype)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntype))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(227, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btntypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntypeActionPerformed
        // TODO add your handling code here:
        populatetypeTable();
    }//GEN-LAST:event_btntypeActionPerformed

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
    private javax.swing.JButton btntype;
    private javax.swing.JComboBox<String> cmbtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    // End of variables declaration//GEN-END:variables
}
