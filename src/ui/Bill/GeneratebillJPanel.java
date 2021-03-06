/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Bill;

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

import ui.DonorregJPanel;
import ui.LoginScreen;

/**
 *
 * @author akhil
 */
public class GeneratebillJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
    

 ResultSet resultSet = null;
 ResultSet rSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
           int Bbankid,Did,Pbquant=0,available=0;
           String user,role,Pname,Pbgroup,Bbankname;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public GeneratebillJPanel(JPanel userProcessContainer,String user,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
       
        this.business = business;
        this.user=user;
        this.role=role;
        System.out.println("user "+user+"role "+role);
        ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           String selectSql = "SELECT a.Bbank_id,b.bbank_name from users a, blood_bank b where user_id=? and a.bbank_id=b.bbank_id;";
            System.out.print("state "+selectSql);
           PreparedStatement stmt;
           try {
           stmt=conn.prepareStatement(selectSql);
            
       stmt.setString(1,user);
            resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                  Bbankid=resultSet.getInt(1);
                   Bbankname=resultSet.getString(2);
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

        populateTable();
    }

    public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tblpatient.getModel();
       
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT * from Blood_demand where status=0 ";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet.getInt(1);
            row[1] = resultSet.getString(3);
            row[2] = resultSet.getString(4);
          //  row[3]=resultSet.getString(4);
                  row[3]=resultSet.getInt(6); 
                  row[4]=resultSet.getDate(8).toString();
                   row[5]=resultSet.getInt(7);
                  
                   
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
        tblpatient = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareabill = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblpatient.setBackground(new java.awt.Color(204, 255, 204));
        tblpatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                " Id", "Blood Group", "Patient Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblpatient);
        if (tblpatient.getColumnModel().getColumnCount() > 0) {
            tblpatient.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblpatient.getColumnModel().getColumn(1).setResizable(false);
            tblpatient.getColumnModel().getColumn(3).setResizable(false);
            tblpatient.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Bill Desk Work Area");

        jButton2.setText("Generate Bill");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtareabill.setColumns(20);
        txtareabill.setRows(5);
        jScrollPane2.setViewportView(txtareabill);

        jLabel5.setText("Bill");

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGap(295, 295, 295)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(365, 365, 365)
                        .addComponent(jButton1)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(lblTitle)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(137, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         conn = dbconn.getConnection();
          int SelectedRowIndex=tblpatient.getSelectedRow();
       System.out.println("SelectedRowIndex "+SelectedRowIndex);
                  if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a Patient to issue Bill");
            
        return;
        }
        DefaultTableModel model1 =(DefaultTableModel) tblpatient.getModel();
       int did= (int) model1.getValueAt(SelectedRowIndex, 0);
         String pname =  (String) model1.getValueAt(SelectedRowIndex, 2);
         String bgroup=(String) model1.getValueAt(SelectedRowIndex, 1);
         int pquant=(int)model1.getValueAt(SelectedRowIndex, 3);
         Pname=pname;
         Pbgroup=bgroup;
         Did=did;
         Pbquant=pquant;
       System.out.print("idid "+model1.getValueAt(SelectedRowIndex, 0) +" name "+model1.getValueAt(SelectedRowIndex, 1));
    // txtid.setText(Integer.toString(did));
                
       int billamount=10*Pbquant;
       //add to text area
       txtareabill.append("\n                       Bill               \n");
       txtareabill.append(" Bbank id :"+Bbankid+ "                     Bbank Name:"+Bbankname+" \n");
        txtareabill.append("------------------------------------------------------------------ \n\n");
       txtareabill.append(" Patient Name :"+Pname+" \n\n");
       txtareabill.append(" Blood Group :"+Pbgroup+" \n\n");
       txtareabill.append(" Quantity :"+Pbquant+" \n\n");
       txtareabill.append(" Unit Price : 10$ \n\n");
          txtareabill.append("------------------------------------------------------------------ \n\n");
       txtareabill.append(" Bill Amount :"+billamount+" \n");
       
       
       //add to text area
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try
        {
        txtareabill.print();
        }catch(Exception e)
        {e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblpatient;
    private javax.swing.JTextArea txtareabill;
    // End of variables declaration//GEN-END:variables
}
