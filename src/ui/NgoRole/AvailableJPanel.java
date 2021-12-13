/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.NgoRole;

import ui.*;
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



public class AvailableJPanel extends javax.swing.JPanel {
   // Restaurant restaurant;
     
     
    private JPanel userProcessContainer;
      ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0,bankid=0;
           String bname,bgroup;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public AvailableJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
         addcmbtype();
         addcmbbank();
        populateTable();
       // populateCombo();
    }
   //addcmbbank starts
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

    //add cmbbank ends
    //addcmbtype starts
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
     //populatebanktable starts
      private void populatebankTable(){
        DefaultTableModel model = (DefaultTableModel) tblblood.getModel();
        
        model.setRowCount(0);
        System.out.println("populate");
        //
          Connection conn = dbconn.getConnection();
               ResultSet resultSet = null;
        String bbank=cmbbank.getItemAt(cmbbank.getSelectedIndex());
         String selectSql;
        //
        if(bbank.equals("All"))
        {
         selectSql = "select a.bbank_id,b.bbank_name,a.bgroup_name ,a.quantity, b.hospital_name,b.address,b.mobile   from bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id";
        }
        else
        {
           selectSql = "select a.bbank_id,b.bbank_name,a.bgroup_name ,a.quantity, b.hospital_name,b.address,b.mobile   from bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id and b.bbank_name=?";   
        }
          PreparedStatement stmt;
       try {
            stmt = conn.prepareStatement(selectSql);
              if(!bbank.equals("All"))
       stmt.setString(1, bbank);
             resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[7];
            row[0]=resultSet.getInt(1);
            row[1] = resultSet.getString(2);
            row[2] = resultSet.getString(3);
             row[3]=resultSet.getInt(4);  
            row[4]=resultSet.getString(5);
            row[5]=resultSet.getString(6);
                  row[6]=resultSet.getInt(7);  
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
       
    }
   
     //populatebanktable ends
//populatetypetable starts
       private void populatetypeTable(){
        DefaultTableModel model = (DefaultTableModel) tblblood.getModel();
        Connection conn = dbconn.getConnection();
               ResultSet resultSet = null;
        String bgroup=cmbtype.getItemAt(cmbtype.getSelectedIndex());
        model.setRowCount(0);
        System.out.println("populate");
        //
         // conn = dbconn.getConnection();
          String selectSql ;
          if(bgroup.equals("All"))
          {
         selectSql = "select a.bbank_id,b.bbank_name,a.bgroup_name ,a.quantity, b.hospital_name,b.address,b.mobile   from bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id";
          }
          else
          {
          selectSql = "select a.bbank_id,b.bbank_name,a.bgroup_name ,a.quantity, b.hospital_name,b.address,b.mobile   from bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id and a.bgroup_name=?";     
          }
         PreparedStatement stmt;
       try {
             stmt = conn.prepareStatement(selectSql);
              if(!bgroup.equals("All"))
       stmt.setString(1, bgroup);
       
            resultSet = stmt.executeQuery();
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[7];
            row[0]=resultSet.getInt(1);
            row[1] = resultSet.getString(2);
            row[2] = resultSet.getString(3);
             row[3]=resultSet.getInt(4);  
            row[4]=resultSet.getString(5);
            row[5]=resultSet.getString(6);
                  row[6]=resultSet.getInt(7);  
            model.addRow(row);
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
        //
       
    }
   
     //populatetypetable ends
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblblood.getModel();
        
        model.setRowCount(0);
        System.out.println("populate");
        //
          conn = dbconn.getConnection();
         String selectSql = "select a.bbank_id,b.bbank_name,a.bgroup_name ,a.quantity, b.hospital_name,b.address,b.mobile   from bbank_stock a, blood_bank b where a.bbank_id=b.bbank_id";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[7];
            row[0]=resultSet.getInt(1);
            row[1] = resultSet.getString(2);
            row[2] = resultSet.getString(3);
             row[3]=resultSet.getInt(4);  
            row[4]=resultSet.getString(5);
            row[5]=resultSet.getString(6);
                  row[6]=resultSet.getInt(7);  
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
        tblblood = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbtype = new javax.swing.JComboBox<>();
        btntype = new javax.swing.JButton();
        cmbbank = new javax.swing.JComboBox<>();
        btnbank = new javax.swing.JButton();

        setBackground(new java.awt.Color(221, 230, 227));

        tblblood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Bank Name", "Blood Group", "Quantity", "hospital", "Address", "mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tblblood);
        if (tblblood.getColumnModel().getColumnCount() > 0) {
            tblblood.getColumnModel().getColumn(0).setResizable(false);
            tblblood.getColumnModel().getColumn(1).setResizable(false);
            tblblood.getColumnModel().getColumn(2).setResizable(false);
            tblblood.getColumnModel().getColumn(4).setResizable(false);
            tblblood.getColumnModel().getColumn(5).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText(" Blood Availabilty Status");

        jButton1.setBackground(new java.awt.Color(212, 49, 50));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btntype.setText("Search By Type");
        btntype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntypeActionPerformed(evt);
            }
        });

        btnbank.setText("Search By bank");
        btnbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbankActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btntype)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(54, 54, 54)
                                .addComponent(lblTitle)))
                        .addGap(18, 18, 18)
                        .addComponent(btnbank)))
                .addGap(201, 201, 201)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(lblTitle))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntype)
                    .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbank))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btntypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntypeActionPerformed
        // TODO add your handling code here:
         populatetypeTable();
    }//GEN-LAST:event_btntypeActionPerformed

    private void btnbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbankActionPerformed
        // TODO add your handling code here:
         populatebankTable();
    }//GEN-LAST:event_btnbankActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbank;
    private javax.swing.JButton btntype;
    private javax.swing.JComboBox<String> cmbbank;
    private javax.swing.JComboBox<String> cmbtype;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblblood;
    // End of variables declaration//GEN-END:variables

}
