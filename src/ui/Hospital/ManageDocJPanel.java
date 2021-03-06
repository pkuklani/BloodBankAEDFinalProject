/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Hospital;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.DonorregJPanel;
import ui.LoginScreen;

/**
 *
 * @author admin
 */

public class ManageDocJPanel extends javax.swing.JPanel {
   // Restaurant restaurant;
    
    
    private JPanel userProcessContainer;
      ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
           String user,roletype;
           int hospital_id=0;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageDocJPanel(JPanel userProcessContainer,String user,String roletype) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       this.user=user;
       this.roletype=roletype;
        //finding hospital id
         ResultSet resultSet2 = null;
         String selectSql3 = "SELECT hospital_id from employee_list where name=?";
         PreparedStatement stmt3;
       int hid=0;
                try {
              //get hospital id from employee table
               stmt3=conn.prepareStatement(selectSql3);
                stmt3.setString(1, user);
             resultSet2 = stmt3.executeQuery();
              while (resultSet2.next()) {
             // roleid=resultSet.getInt(1);
             
               hid=resultSet2.getInt(1);
              }//while
               hospital_id=hid;
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
         ResultSet resultSet = null;
        model.setRowCount(0);
        System.out.println("populate");
         Connection conn = dbconn.getConnection();
        //
         String selectSql = "SELECT doc_id,name,specialization,address,mobile from doctors where hospital_id=?";
 PreparedStatement stmt;
       try {
         
         stmt=conn.prepareStatement(selectSql);
          stmt.setInt(1, hospital_id);
           resultSet = stmt.executeQuery();
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
        btndel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbspecial = new javax.swing.JComboBox<>();

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
                "ID", "Name", "Specialization", "Address", "mobile"
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

        lblSelectOrgType.setText("ID");

        btnBack.setBackground(new java.awt.Color(102, 153, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Doctors");

        lblOrganizationList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationList.setText("List of Doctors");

        lblOrganizationAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationAdd.setText("Add /Modify Doctor Details");

        txtid.setEditable(false);

        jLabel1.setText("Name");

        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        jLabel2.setText("Address");

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

        jLabel4.setText("Specialization");

        jLabel5.setText("Mobile");

        txtmobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmobileKeyPressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/akhil_kaundinya/NetBeansProjects/bloodbanksystem/doctor.png")); // NOI18N

        cmbspecial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Orthopedic", "ENT", "Brain", "Nuro" }));

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
                                            .addComponent(txtaddress)
                                            .addComponent(txtname)
                                            .addComponent(txtid)
                                            .addComponent(txtmobile)
                                            .addComponent(cmbspecial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addGap(32, 32, 32)
                .addComponent(lblOrganizationList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btndel)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOrganizationAdd)
                                .addGap(18, 18, 18)
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
                                    .addComponent(cmbspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(btnAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
         int SelectedRowIndex=tblOrganizations.getSelectedRow();
        if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a row to delete");
            
        return;
        }
        DefaultTableModel model =(DefaultTableModel) tblOrganizations.getModel();
         int did=(int) model.getValueAt(SelectedRowIndex, 0);
         String dname=(String) model.getValueAt(SelectedRowIndex, 1);
       
         conn = dbconn.getConnection();
          String selectSql = "Delete from doctors where doc_id=?;";
           String selectSql1 = "Delete from users where username=?;";
          
     PreparedStatement stmt,stmt1;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
               stmt1=conn.prepareStatement(selectSql1);
             
                 stmt.setInt(1, did);
                                   
              stmt.executeUpdate();
                stmt1.setString(1, dname);
                                   
              stmt1.executeUpdate();
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
        String dname=txtname.getText();
        Long mobile=Long.parseLong(txtmobile.getText());
        String special=cmbspecial.getItemAt(cmbspecial.getSelectedIndex());
        conn = dbconn.getConnection();
        
   
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
          if(txtmobile.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid Mobile Number");
         return;
     }
 
  {System.out.println("stop0");
     
     String selectSql = "Insert into doctors (name,specialization,address,mobile,hospital_id) values(?,?,?,?,?);";
     String  selectSql1 = "insert into users(user_id,passwd,role_id,hospital_id,username) values(?,?,?,?,?);";
     PreparedStatement stmt,stmt1;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
              stmt1=conn.prepareStatement(selectSql1);
             // stmt.setInt(1, bbankid);
              stmt.setString(1, dname);
              stmt.setString(2, special);
               stmt.setString(3, address);
                stmt.setLong(4, mobile);
                 stmt.setInt(5, hospital_id);
                
                                   
              stmt.executeUpdate();
              
              stmt1.setString(1, dname);
               stmt1.setString(2, dname);
                stmt1.setInt(3, 10);
                 stmt1.setString(5, dname);
                 stmt1.setInt(4, hospital_id);
                  stmt1.executeUpdate();
         // conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(ManageDocJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
JOptionPane.showMessageDialog(this,"New Doctor added to the Hospital");

       populateTable(); 
   
  }//stop
  txtid.setText("");
  txtname.setText("");
  txtaddress.setText("");
 
  txtmobile.setText("");
  
     
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnameKeyPressed
        // TODO add your handling code here:
          String name =txtname.getText();
        Pattern pattern = Pattern.compile(new String ("^[a-zA-Z\\s]*$"));
        Matcher matcher = pattern.matcher(name);
    if(matcher.matches())
    {
         //if pattern matches
        //txtName.setBackground(Color.yellow);
    }
    else
    {
         //if pattern does not matches
        //txtName.setBackground(Color.orange);
            JOptionPane.showMessageDialog(null,"Please Enter your Correct Name");
    }
    }//GEN-LAST:event_txtnameKeyPressed

    private void txtmobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobileKeyPressed
        // TODO add your handling code here:
              String mobile =txtmobile.getText();
        //if(PhoneNo.matches("^[0-9]*$") && PhoneNo.length()==10)
        if((mobile.matches("^[0-9]*$")) && (mobile.length()<11) )
        {
            //txtid.setBackground(Color.yellow);
            //JOptionPane.showMessageDialog(null,"You Have Entered Correct PhoneNO");
        }
        else
       
        {
            //txtid.setBackground(Color.blue);
            JOptionPane.showMessageDialog(null,"Please Enter Correct Mobile Number");
        }
        
    }//GEN-LAST:event_txtmobileKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btndel;
    private javax.swing.JComboBox<String> cmbspecial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrganizationAdd;
    private javax.swing.JLabel lblOrganizationList;
    private javax.swing.JLabel lblSelectOrgType;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}
