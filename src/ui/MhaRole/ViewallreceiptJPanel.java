/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.MhaRole;
import ui.BbankRole.*;
import java.sql.*;
import java.util.Calendar;
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

import ui.DonorregJPanel;
import ui.LoginScreen;

/**
 *
 * @author akhil
 */
public class ViewallreceiptJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
   

 ResultSet resultSet = null;
           DButil dbconn= new DButil();
       //   Connection conn = dbconn.getConnection();
           int did=0;
           int Bbankid,Did=0;
           String user,role,Dname,Dbgroup,roletype;
    /**
     * Creates new form 
     */
    public ViewallreceiptJPanel(JPanel userProcessContainer,String user,String roletype) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
       // this.userAccount = account;
         //  this.userAccount1 = account1;
        this.business = business;
        this.role=role;
        this.user=user;
        this.roletype=roletype;
        //this.deliveryOrganization = (DeliveryOrganization) organization;
//getting Bbank id of user
 ResultSet resultSet = null;
           DButil dbconn= new DButil();
           System.out.print("user "+user);
          Connection conn = dbconn.getConnection();
           String selectSql = "SELECT Bbank_id from users where user_id=?;";
            System.out.print("state "+selectSql);
           PreparedStatement stmt;
           try {
           stmt=conn.prepareStatement(selectSql);
            
       stmt.setString(1,user);
            resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                  Bbankid=resultSet.getInt(1);
             }//while
             did++;
             System.out.print("bank id "+Bbankid);
             conn.close();
            // txtid.setText(Integer.toString(did));
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
         
//getting Bbank id of user
addcmbtype();
        populateTable();
    }
    //addcmbtype start
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
    //populate type table start
     public void populatetypeTable() {
            DefaultTableModel model = (DefaultTableModel) tbldonor.getModel();
              Connection conn = dbconn.getConnection();
        ResultSet resultSet = null;
        model.setRowCount(0);
          String bgroup=cmbtype.getItemAt(cmbtype.getSelectedIndex());
        System.out.println("populate roletype="+ roletype+"blood=="+bgroup);
        //
        String selectSql=null,selectSql1=null;
        if((roletype.equals("Bbank"))||(roletype.equals("Stores")))
        {System.out.println("inifstores1==");
         if(bgroup.equals("All"))
         {
            selectSql = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id and a.bbank_id=?";  
         }
         else
         {System.out.println("not all1 "+bgroup);
            selectSql = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id and a.bbank_id=? and a.bgroup_name=?";
           // selectSql = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id";
         }
         }
        else
        {System.out.println("inelsestores1==");
         if(bgroup.equals("All"))
         {
            selectSql1 = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id ";
     
         }
         else
         {
             selectSql1 = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id and a.bgroup_name=?"; 
         }
         }
        PreparedStatement stmt,stmt1;
       try {
           
            if((roletype.equals("Bbank"))||(roletype.equals("Stores")))  
            {System.out.println("inifstores2==");
                 stmt = conn.prepareStatement(selectSql);
                  stmt.setInt(1, Bbankid);
                  if(!bgroup.equals("All"))
                  {System.out.println("not all set "+bgroup);
                 stmt.setString(2, bgroup);
                  }
                  
                  resultSet = stmt.executeQuery();
            }
            else
            {System.out.println("inelsestores2==");
                  stmt1= conn.prepareStatement(selectSql1);
                   if(!bgroup.equals("All"))
                   {
                      stmt1.setString(1, bgroup);
                   }
                  resultSet = stmt1.executeQuery();
            }
      
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
                  row[0]=resultSet.getInt(1);
            row[1]=resultSet.getString(2);
            row[2] = resultSet.getString(3);
            row[3] = resultSet.getString(4);
          row[4]=resultSet.getDate(5).toString();
                  row[5]=resultSet.getInt(6); 
                                   
                   
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
      
    }

    //populate type table end

    public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tbldonor.getModel();
              Connection conn = dbconn.getConnection();
        ResultSet resultSet = null;
        model.setRowCount(0);
        System.out.println("populate roletype="+ roletype);
        //
        String selectSql=null,selectSql1=null;
        if((roletype.equals("Bbank"))||(roletype.equals("Stores")))
        {System.out.println("inifstores1=="+Bbankid);
            selectSql = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id and a.bbank_id=?";
           // selectSql = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id";
        }
        else
        {System.out.println("inelsestores1==");
            selectSql1 = "SELECT a.bbank_id,b.bbank_name,a.donor_name,a.bgroup_name,a.date_receive,a.quantity from bbank_receive a,blood_bank b where a.bbank_id=b.bbank_id ";
     
        }
        PreparedStatement stmt,stmt1;
       try {
           
            if((roletype.equals("Bbank"))||(roletype.equals("Stores")))  
            {System.out.println("inifstores2=="+Bbankid);
                 stmt = conn.prepareStatement(selectSql);
                 stmt.setInt(1, Bbankid);
                  resultSet = stmt.executeQuery();
            }
            else
            {System.out.println("inelsestores2=="+Bbankid);
                  stmt1= conn.prepareStatement(selectSql1);
                  resultSet = stmt1.executeQuery();
            }
      
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
                  row[0]=resultSet.getInt(1);
            row[1]=resultSet.getString(2);
            row[2] = resultSet.getString(3);
            row[3] = resultSet.getString(4);
          row[4]=resultSet.getDate(5).toString();
                  row[5]=resultSet.getInt(6); 
                                   
                   
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
        tbldonor = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        cmbtype = new javax.swing.JComboBox<>();
        btntype = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tbldonor.setBackground(new java.awt.Color(204, 255, 204));
        tbldonor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Bank ID", "Bank Name", "Donor Name", "Blood Group", "Date Received", "Donated Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbldonor);
        if (tbldonor.getColumnModel().getColumnCount() > 0) {
            tbldonor.getColumnModel().getColumn(0).setResizable(false);
            tbldonor.getColumnModel().getColumn(1).setResizable(false);
            tbldonor.getColumnModel().getColumn(2).setResizable(false);
            tbldonor.getColumnModel().getColumn(2).setPreferredWidth(0);
            tbldonor.getColumnModel().getColumn(3).setResizable(false);
            tbldonor.getColumnModel().getColumn(4).setResizable(false);
            tbldonor.getColumnModel().getColumn(5).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Blood Received Details");

        btnback.setText("Back");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btntype.setText("Search by Blood Type");
        btntype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntypeActionPerformed(evt);
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
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnback))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btntype))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnback)
                .addGap(10, 10, 10)
                .addComponent(lblTitle)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntype))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tbldonor;
    // End of variables declaration//GEN-END:variables
}
