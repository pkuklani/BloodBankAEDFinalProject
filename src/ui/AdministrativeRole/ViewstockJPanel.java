/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

import ui.BbankRole.*;
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
import java.sql.PreparedStatement;
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
public class ViewstockJPanel extends javax.swing.JPanel {

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
    public ViewstockJPanel(JPanel userProcessContainer,String user,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
       
        this.business = business;
        this.user=user;
        System.out.println("user "+user+"role "+role);
        //this.deliveryOrganization = (DeliveryOrganization) organization;
addcmbtype();
addcmbbank();
      populateTable();
    }
//blood type
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
//bank type
       public void addcmbbank()
                {
                    cmbbank.removeAll();
                    // cmbbank.removeAll();
          cmbbank.addItem("All");
           ResultSet resultSet = null;
          //  cmbOrganizationList.addItem(organization);
          Connection conn = dbconn.getConnection();
         String selectSql = "SELECT bbank_name from blood_bank";
       PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
            
      // stmt.setString(1,roletype);
            resultSet = stmt.executeQuery();
       
           
            // conn.close();
             while (resultSet.next()) {
                 String cmbvalue=resultSet.getString(1);
                   System.out.println("cmbvalue hos "+cmbvalue);
                  cmbbank.addItem(cmbvalue);
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
                }
//bank typepopulatebankTable
       //populate 
        public void populatebankTable() {
            DefaultTableModel model = (DefaultTableModel) tblstock.getModel();
              Connection conn = dbconn.getConnection();
               ResultSet resultSet = null;
        String bbank=cmbbank.getItemAt(cmbbank.getSelectedIndex());
        System.out.println("bgroup==="+bbank);
        model.setRowCount(0);
        System.out.println("populate");
        String selectSql;
        //
        if(bbank.equals("All"))
        { selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id  ";
        }
        else
        {
             selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id and b.bbank_name=? ";
        }
        
        // String selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id and a.bgroup_name=? ";
      PreparedStatement stmt;
       try {
            stmt = conn.prepareStatement(selectSql);
              if(!bbank.equals("All"))
       stmt.setString(1, bbank);
             resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getString(2);
            row[1]=resultSet.getString(3);
                  row[2]=resultSet.getInt(4); 
                  
                   
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
      
    }

       //populatetype
    

       //populate bank

  //populatetype
        public void populatetypeTable() {
            DefaultTableModel model = (DefaultTableModel) tblstock.getModel();
              Connection conn = dbconn.getConnection();
               ResultSet resultSet = null;
        String bgroup=cmbtype.getItemAt(cmbtype.getSelectedIndex());
        System.out.println("bgroup==="+bgroup);
        model.setRowCount(0);
        System.out.println("populate");
        String selectSql;
        //
        if(bgroup.equals("All"))
        { selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id  ";
        }
        else
        {
             selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id and a.bgroup_name=? ";
        }
        
        // String selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id and a.bgroup_name=? ";
      PreparedStatement stmt;
       try {
            stmt = conn.prepareStatement(selectSql);
              if(!bgroup.equals("All"))
       stmt.setString(1, bgroup);
             resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getString(2);
            row[1]=resultSet.getString(3);
                  row[2]=resultSet.getInt(4); 
                  
                   
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
      
    }

       //populatetype

    


        
        public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tblstock.getModel();
         Connection conn = dbconn.getConnection();
          ResultSet resultSet = null;
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id ";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getString(2);
            row[1]=resultSet.getString(3);
                  row[2]=resultSet.getInt(4); 
                  
                   
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
        tblstock = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnftype = new javax.swing.JButton();
        cmbbank = new javax.swing.JComboBox<>();
        btnbank = new javax.swing.JButton();
        cmbtype = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        tblstock.setBackground(new java.awt.Color(204, 255, 204));
        tblstock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Bank name", "Blood Group", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblstock);
        if (tblstock.getColumnModel().getColumnCount() > 0) {
            tblstock.getColumnModel().getColumn(0).setResizable(false);
            tblstock.getColumnModel().getColumn(1).setResizable(false);
            tblstock.getColumnModel().getColumn(2).setResizable(false);
            tblstock.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Blood Stock Details");

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnftype.setBackground(new java.awt.Color(102, 153, 255));
        btnftype.setText("Blood Type");
        btnftype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnftypeActionPerformed(evt);
            }
        });

        btnbank.setBackground(new java.awt.Color(102, 153, 255));
        btnbank.setText("By Bank");
        btnbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbankActionPerformed(evt);
            }
        });

        cmbtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbtypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnback))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnftype)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbank))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton1)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(12, 12, 12)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnftype)
                    .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbank)
                    .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnftypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnftypeActionPerformed
        populatetypeTable();
        //TODO add your handling code here:
    }//GEN-LAST:event_btnftypeActionPerformed

    private void btnbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbankActionPerformed
        // TODO add your handling code here:
        populatebankTable();
    }//GEN-LAST:event_btnbankActionPerformed

    private void cmbtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbtypeActionPerformed

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
    private javax.swing.JButton btnbank;
    private javax.swing.JButton btnftype;
    private javax.swing.JComboBox<String> cmbbank;
    private javax.swing.JComboBox<String> cmbtype;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblstock;
    // End of variables declaration//GEN-END:variables
}
