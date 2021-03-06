/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Hospital;

import ui.NgoRole.*;
import ui.AdministrativeRole.*;
import bbank.DB.DButil;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.DonorregJPanel;
import ui.LoginScreen;

/**
 *
 * @author admin
 */

public class AddBloodbanksJPanel extends javax.swing.JPanel {
   // Restaurant restaurant;
    
    
    private JPanel userProcessContainer;
      ResultSet resultSet = null;
           DButil dbconn= new DButil();
          //Connection conn = dbconn.getConnection();
           int did=0;
           String user,roletype;
           int hospital_id=0;
           String hospital_name;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public AddBloodbanksJPanel(JPanel userProcessContainer,String user, String roletype) {
        initComponents();
          Connection conn = dbconn.getConnection();
        this.userProcessContainer = userProcessContainer;
       this.user=user;
       this.roletype=roletype;
        ResultSet resultSet2 = null;
         String selectSql3 = "SELECT a.hospital_id,b.name from employee_list a, hospitals b where a.name=? and a.hospital_id=b.id";
         PreparedStatement stmt3;
       int hid=0;
       String hname=null;
                try {
              //get hospital id from employee table
               stmt3=conn.prepareStatement(selectSql3);
                stmt3.setString(1, user);
             resultSet2 = stmt3.executeQuery();
              while (resultSet2.next()) {
             // roleid=resultSet.getInt(1);
             
               hid=resultSet2.getInt(1);
               hname=resultSet2.getString(2);
              }//while
               hospital_id=hid;
               hospital_name=hname;
                  conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
        //finding hospital id
         
        populateTable();
       // populateCombo();
    }
    
    

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();
          Connection conn = dbconn.getConnection();
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT * from Blood_bank";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[5];
            row[0]=resultSet.getInt(1);
            row[1] = resultSet.getString(2);
            row[2] = resultSet.getString(3);
            row[3]=resultSet.getString(4);
                  row[4]=resultSet.getInt(5);  
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
        tblOrganizations = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblOrganizations.setBackground(new java.awt.Color(204, 255, 204));
        tblOrganizations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Hospital", "Address", "mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblOrganizations);
        if (tblOrganizations.getColumnModel().getColumnCount() > 0) {
            tblOrganizations.getColumnModel().getColumn(0).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(1).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(3).setResizable(false);
        }

        btnBack.setBackground(new java.awt.Color(102, 153, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("List of Blood Banks");

        jButton1.setText("Add Selected Blood Bank to the hospital");
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
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(29, 29, 29)
                        .addComponent(lblTitle))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int SelectedRowIndex=tblOrganizations.getSelectedRow();
       System.out.println("SelectedRowIndex "+SelectedRowIndex);
                  if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a Blood Bank to add");
            
        return;
        }
                   DefaultTableModel model1 =(DefaultTableModel) tblOrganizations.getModel();
       int bbankid=(int) model1.getValueAt(SelectedRowIndex, 0);
          ResultSet resultSet = null;
           ResultSet resultSet1 = null;
          Connection conn = dbconn.getConnection();
         String selectSql = "Update Blood_bank set hospital_name=? where Bbank_id=?;";
          String selectSql1 = "Update hospitals set bbank_id=? where id=?;";
     PreparedStatement stmt,stmt1;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
              stmt.setString(1, hospital_name);   
               stmt.setInt(2, bbankid);
              stmt.executeUpdate();
              stmt1=conn.prepareStatement(selectSql1);
              stmt1.setInt(1, bbankid);  
               stmt1.setInt(2, hospital_id);  
              stmt1.executeUpdate(); 
              
          conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
         populateTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    // End of variables declaration//GEN-END:variables

}
