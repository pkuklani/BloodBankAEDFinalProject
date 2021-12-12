/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

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

public class ManageBloodJPanel extends javax.swing.JPanel {
   // Restaurant restaurant;
    
    
    private JPanel userProcessContainer;
      ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageBloodJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       
        
         
        populateTable();
       // populateCombo();
    }
    
    

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();
        
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
        btnmod = new javax.swing.JButton();
        lblSelectOrgType = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblOrganizationList = new javax.swing.JLabel();
        lblOrganizationAdd = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txthos = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();

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
                "ID", "Name", "hospital", "Address", "mobile"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
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
            tblOrganizations.getColumnModel().getColumn(2).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(3).setResizable(false);
        }

        btnmod.setBackground(new java.awt.Color(102, 153, 255));
        btnmod.setText("Modify");
        btnmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodActionPerformed(evt);
            }
        });

        lblSelectOrgType.setText("ID");

        btnBack.setBackground(new java.awt.Color(102, 153, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Blood Banks");

        lblOrganizationList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationList.setText("List of Blood Banks");

        lblOrganizationAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationAdd.setText("Add /Modify Blood Bank Details");

        txtid.setEditable(false);

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        btnedit.setBackground(new java.awt.Color(102, 153, 255));
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndel.setBackground(new java.awt.Color(102, 153, 255));
        btndel.setText("Delete");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(102, 153, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel4.setText("Hospital");

        jLabel5.setText("Mobile");

        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOrganizationList)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(29, 29, 29)
                        .addComponent(lblTitle))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrganizationAdd)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(lblSelectOrgType)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(txtid, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(txthos)
                                            .addComponent(txtmobile)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnmod, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(32, 32, 32)
                .addComponent(lblOrganizationList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnedit)
                            .addComponent(btndel))
                        .addGap(0, 0, 0)
                        .addComponent(lblOrganizationAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectOrgType)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txthos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnmod))
                        .addContainerGap())
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodActionPerformed

     
             int bbankid=Integer.parseInt(txtid.getText());
        String address=txtaddress.getText();
        String bname=txtname.getText();
        long mobile=Long.parseLong(txtmobile.getText());
        String hos=txthos.getText();
        conn = dbconn.getConnection();
           //
    int stop=0;
     if(txtname.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid name");
      return;
     }
     if(txtaddress.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid address");
        return;
     }
     //if(txthos.getText().isEmpty())
     //{
         //JOptionPane.showMessageDialog(this, "Please enter valid Hospital");
        // return;
     //}
      if(txtmobile.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid Mobile Number");
         return; 
     }
 // if(stop==0)
  {System.out.println("stop0"+mobile);
      //checking if id is already there
    //  int found=0;
     String selectSql = "Update Blood_bank set Bbank_name=?,Hospital_name=?,Address=?,Mobile=? where Bbank_id=?;";
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
              stmt.setString(1, bname);
              stmt.setString(3, address);
               stmt.setString(2, hos);
                stmt.setLong(4, mobile);
                 stmt.setInt(5, bbankid);
                                   
              stmt.executeUpdate();
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
JOptionPane.showMessageDialog(this,"Blood Bank data Updated");

       populateTable(); 
   
  }//stop
  txtid.setText("");
  txtname.setText("");
  txtaddress.setText("");
  txthos.setText("");
  txtmobile.setText("");
  
 
 btnAdd.setEnabled(true);
 //txtid.setEditable(true);

       
       // populateTable();
    }//GEN-LAST:event_btnmodActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
       
          int SelectedRowIndex=tblOrganizations.getSelectedRow();
       System.out.println("SelectedRowIndex "+SelectedRowIndex);
                  if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a row to edit");
            
        return;
        }
        DefaultTableModel model1 =(DefaultTableModel) tblOrganizations.getModel();
       int bbankid=(int) model1.getValueAt(SelectedRowIndex, 0);
           
       System.out.print("model1.getValueAt(SelectedRowIndex, 0) "+model1.getValueAt(SelectedRowIndex, 0));
      conn = dbconn.getConnection();
       
       String selectSql = "SELECT * from Blood_bank where Bbank_id="+bbankid;
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                
                  Object[] row = new Object[5];
            txtid.setText(Integer.toString(resultSet.getInt(1)));
            txtname.setText(resultSet.getString(2));
             txthos.setText(resultSet.getString(3));
             txtaddress.setText(resultSet.getString(4));
             txtmobile.setText(Long.toString(resultSet.getInt(5)));
            
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
 txtid.setEditable(false);
 btnAdd.setEnabled(false);
       
    }//GEN-LAST:event_btneditActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
         int SelectedRowIndex=tblOrganizations.getSelectedRow();
        if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a row to delete");
            
        return;
        }
        DefaultTableModel model =(DefaultTableModel) tblOrganizations.getModel();
         int bbankid=(int) model.getValueAt(SelectedRowIndex, 0);
       
         conn = dbconn.getConnection();
          String selectSql = "Delete from Blood_bank where Bbank_id=?;";
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
             
                 stmt.setInt(1, bbankid);
                                   
              stmt.executeUpdate();
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
    
         
        JOptionPane.showMessageDialog(this, "selected data deleted");
        populateTable();
     
    }//GEN-LAST:event_btndelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
          // int bbankid=Integer.parseInt(txtid.getText());
        String address=txtaddress.getText();
        String bname=txtname.getText();
        long mobile=Long.parseLong(txtmobile.getText());
        String hos=txthos.getText();
        conn = dbconn.getConnection();
        
    int stop=0;
     if(txtname.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid name");
        return;
     }
     if(txtaddress.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid address");
         return;
     }
     //if(txthos.getText().isEmpty())
    // {
       //  JOptionPane.showMessageDialog(this, "Please enter valid Hospital");
         //return;
     //}
      if(txtmobile.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid Mobile Number");
         return;
     }
  if(stop==0)
  {System.out.println("stop0");
      //checking if id is already there
       //find if userid already there
            String checkSql = "SELECT * from users";
      Statement stmtc;
       try {
            stmtc = conn.createStatement();
       
            resultSet = stmtc.executeQuery(checkSql);
              
            // conn.close();
             while (resultSet.next()) {
                 // did=resultSet.getInt(1);
              //    System.out.println("1="+resultSet.getString(1)+" userid"+userid+"2="+resultSet.getString(2)+" pass"+pass);
                   if((resultSet.getString(1).equals(bname))||(resultSet.getString(2).equals(bname)))
                   { //System.out.print("inside");
                        JOptionPane.showMessageDialog(this, "UserID/Password already exists");
                  return;
                   }
                       }//while
             did++;
          //   System.out.print("did "+did);
            // conn.close();
            // txtid.setText(Integer.toString(did));
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
          //find if useid already there
         
    //  int found=0;
     String selectSql = "Insert into Blood_bank (bbank_name,hospital_name,address,mobile,status)values(?,?,?,?,?);";
     String  selectSql1 = "insert into users(user_id,passwd,role_id,Bbank_id,username)  values(?,?,?,?,?);";
     PreparedStatement stmt,stmt1;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
              stmt1=conn.prepareStatement(selectSql1);
             // stmt.setInt(1, bbankid);
              stmt.setString(1, bname);
              stmt.setString(3, address);
               stmt.setString(2, hos);
                stmt.setLong(4, mobile);
                 stmt.setInt(5, 0);
                                   
              stmt.executeUpdate();
              stmt1.setString(1, bname);
               stmt1.setString(2, bname);
                stmt1.setInt(3, 2);
                 stmt1.setString(5, bname);
                 stmt1.setInt(4, 0);
                  stmt1.executeUpdate();
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(ManageBloodJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
JOptionPane.showMessageDialog(this,"Blood Bank Added");

       populateTable(); 
   
  }//stop
  txtid.setText("");
  txtname.setText("");
  txtaddress.setText("");
  txthos.setText("");
  txtmobile.setText("");
  
     
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnmod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrganizationAdd;
    private javax.swing.JLabel lblOrganizationList;
    private javax.swing.JLabel lblSelectOrgType;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txthos;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}
