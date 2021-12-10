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
public class IssuebloodJPanel extends javax.swing.JPanel {

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
           String user,role,Pname,Pbgroup;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public IssuebloodJPanel(JPanel userProcessContainer,String user,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
       
        this.business = business;
        this.user=user;
        System.out.println("user "+user+"role "+role);
        ResultSet resultSet = null;
           DButil dbconn= new DButil();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtbgroup = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtunits = new javax.swing.JTextField();
        btnissue = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtavailable = new javax.swing.JTextField();
        btnback = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblpatient.setBackground(new java.awt.Color(204, 255, 204));
        tblpatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Blood Group", "Patient Name", "Quantity", "Request  Date", "Mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true
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
            tblpatient.getColumnModel().getColumn(0).setResizable(false);
            tblpatient.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblpatient.getColumnModel().getColumn(1).setResizable(false);
            tblpatient.getColumnModel().getColumn(2).setResizable(false);
            tblpatient.getColumnModel().getColumn(3).setResizable(false);
            tblpatient.getColumnModel().getColumn(3).setPreferredWidth(10);
            tblpatient.getColumnModel().getColumn(4).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Blood Bank Work Area");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Pending Blood requirements -Issue Blood ");
        jButton1.setEnabled(false);

        jButton2.setText("Select Patient");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient Name :");

        txtname.setEditable(false);

        jLabel2.setText("Blood Group");

        txtbgroup.setEditable(false);

        jLabel3.setText("Units");

        btnissue.setText("Issue");
        btnissue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnissueActionPerformed(evt);
            }
        });

        jLabel4.setText("Availability");

        txtavailable.setEditable(false);

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
                        .addGap(101, 101, 101)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnissue)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(txtbgroup)
                                    .addComponent(txtunits))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtavailable, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtbgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtunits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtavailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnissue)
                .addContainerGap(85, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         conn = dbconn.getConnection();
          int SelectedRowIndex=tblpatient.getSelectedRow();
       System.out.println("SelectedRowIndex "+SelectedRowIndex);
                  if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a Patient to issue Blood");
            
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
     txtname.setText(pname);
     txtbgroup.setText(bgroup);
     //get available quantity from stock table
     String sSql = "SELECT quantity from Bbank_stock where Bbank_id=? and Bgroup_name=? ";
      PreparedStatement st;
       try {
            st=conn.prepareStatement(sSql);
             st.setInt(1, Bbankid);
              st.setString(2, Pbgroup);
              rSet= st.executeQuery();
           // rSet = st.executeQuery(sSql);
            // conn.close();
             while (rSet.next()) {
                txtavailable.setText(Integer.toString(rSet.getInt(1)));
                available=rSet.getInt(1);
                 System.out.println("available  "+ txtavailable.getText());
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
       //get available quantity from stock table   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnissueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnissueActionPerformed
        // TODO add your handling code here:
         int donorid=0;
         
        // donorid=Integer.getInteger(txtid.getText());
              
        conn = dbconn.getConnection();
        
    int stop=0;
     if(txtname.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Patient name cannot be empty ");
        return;
     }
      if(txtbgroup.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Blood group cannot be empty");
        return;
     }
       if(txtunits.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Unit cannot be empty");
        return;
     }
        if(txtavailable.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Blood availability cannot be empty");
        return;
     }
        int txtunit=Integer.parseInt(txtunits.getText());
        System.out.println("pbquant "+Pbquant+" ava "+available+ "units "+txtunit);
    if((txtunit>Pbquant)|| (txtunit>available)) 
    {
         JOptionPane.showMessageDialog(this, "issued unit cannot be more than requested or more than available");
        return;
    
    }
     String selectSql = "Insert into Bbank_issued values(?,?,?,?,?);";
     String  selectSql1 = "update blood_demand set status=1  where Demand_id=?;";
    String selectSql2="update Bbank_stock set quantity=quantity-1 where Bbank_id=? and Bgroup_name=?;";
     PreparedStatement stmt,stmt1,stmt2;
      try {
             // stmt = conn.createStatement();
             int qty=Integer.parseInt(txtunits.getText());
             var now = new Date();
            // java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
             stmt=conn.prepareStatement(selectSql);
              stmt1=conn.prepareStatement(selectSql1);
               stmt2=conn.prepareStatement(selectSql2);
              stmt.setInt(1, Bbankid);
              stmt.setString(2, Pbgroup);
              stmt.setString(3, Pname);
                stmt.setInt(4, qty);
                // stmt.setDate(6, java.sql.Date(now));
                 stmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));
                                   
              stmt.executeUpdate();
              stmt1.setInt(1,Did);
               stmt1.executeUpdate();
                stmt2.setInt(1,Bbankid);
                stmt2.setString(2, Pbgroup);
                 stmt2.executeUpdate();
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(IssuebloodJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
        JOptionPane.showMessageDialog(this, "Blood issued to Patient ");
        txtavailable.setText("");
         txtname.setText("");
          txtbgroup.setText("");
           txtunits.setText("");
    }//GEN-LAST:event_btnissueActionPerformed

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
    private javax.swing.JButton btnissue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblpatient;
    private javax.swing.JTextField txtavailable;
    private javax.swing.JTextField txtbgroup;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtunits;
    // End of variables declaration//GEN-END:variables
}
