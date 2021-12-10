/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

import bbank.Bbank;
import bbank.DB.DButil;
import ui.LoginScreen;
import bbank.Employee.Employee;

import bbank.Role.Role;
import bbank.UserAccount.UserAccount;
import bbank.WorkQueue.WorkRequest;

import java.awt.CardLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import bbank.user;
import java.awt.event.ItemEvent;
import java.io.EOFException;
import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ui.LoginScreen;
import java.awt.event.ItemListener;
import ui.DonorregJPanel;
import static ui.LoginScreen.isValidPassword;
/**
 *
 * @author Administrator
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Bbank business;
    private UserAccount useraccount;
      private UserAccount useraccount1;
      private user fileuser;
     
        ResultSet resultSet = null;
           DButil dbconn= new DButil();
         // Connection conn = dbconn.getConnection();
          String orgsel,empsel,rolesel;
          int roleid;
           String roletype;
          String selectedorg;
     //private DB4OUtil dB4OUtil;
 
    public ManageUserAccountJPanel(JPanel container,String roletype) {
        initComponents();
        this.business = business;
        this.container = container;
this.useraccount=useraccount;
this.fileuser=fileuser;
  this.roletype=roletype;
popOrganizationComboBox();
        
   

        popUserAccountsTable();
    }
 @SuppressWarnings("unchecked")
    public void popOrganizationComboBox() {
       ResultSet resultSet1 = null;
         cmbOrganization.removeAllItems();
         //if(conn)conn.close();
          Connection conn = dbconn.getConnection();
        // conn = dbconn.getConnection();
          //  cmbOrganizationList.addItem(organization);
         String selectSql = "SELECT * from org where org_access=?";
       PreparedStatement stmt0;
       try {
            stmt0=conn.prepareStatement(selectSql);
            
       stmt0.setString(1,roletype);
            resultSet1 = stmt0.executeQuery();
       System.out.println("stmt"+ stmt0+"resultset = "+resultSet1);
            
             cmbOrganization.addItem("Select");
             String selval;
            // conn.close();
             while (resultSet1.next()) {
                selval=resultSet1.getString(2);
                  cmbOrganization.addItem(selval);
           
             }//while
             
               cmbOrganization.setEditable(true);
               
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        MyItemListener actionListener = new MyItemListener();
    cmbOrganization.addItemListener(actionListener);
    }
    
 @SuppressWarnings("unchecked")
    public void populateEmployeeComboBox() {
         cmbEmployee.removeAllItems();
          Connection conn = dbconn.getConnection();
           ResultSet resultSet1 = null;
//conn = dbconn.getConnection();
          String selectSql = "SELECT * from employee_list where org=?";
      PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
       stmt.setString(1, orgsel);
            resultSet = stmt.executeQuery();
            // conn.close();
            System.out.println("in loop...........");
             while (resultSet.next()) {
                 
            cmbEmployee.addItem(resultSet.getString(2));
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        
    }

   

    public void popUserAccountsTable() {

        DefaultTableModel model = (DefaultTableModel) tblUsers.getModel();
 model.setRowCount(0);
  Connection conn = dbconn.getConnection();
        // conn = dbconn.getConnection();
          String selectSql5 = "SELECT a.user_id,a.username,b.role from users a, roles b where a.role_id=b.role_id ";
      Statement stmt5;
       try {
            stmt5 = conn.createStatement();
       
            resultSet = stmt5.executeQuery(selectSql5);
            // conn.close();
            System.out.println("in loop...........");
             while (resultSet.next()) {
                 Object[] row = new Object[3];
                  System.out.println("in loop"+ resultSet.getString(2));
            row[0] = resultSet.getString(1);
            row[1] = resultSet.getString(2);
              row[2] = resultSet.getString(3);
            model.addRow(row);
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
       
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
        tblUsers = new javax.swing.JTable();
        grpNewUser = new javax.swing.JPanel();
        btnCreateUser = new javax.swing.JButton();
        txtUserName = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        lblEmployee = new javax.swing.JLabel();
        cmbEmployee = new javax.swing.JComboBox();
        lblOrganization = new javax.swing.JLabel();
        cmbOrganization = new javax.swing.JComboBox();
        lblRole = new javax.swing.JLabel();
        lblCreateUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtrole = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblUsersList = new javax.swing.JLabel();
        btndel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblUsers.setBackground(new java.awt.Color(204, 255, 204));
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUsers);
        if (tblUsers.getColumnModel().getColumnCount() > 0) {
            tblUsers.getColumnModel().getColumn(0).setResizable(false);
            tblUsers.getColumnModel().getColumn(1).setResizable(false);
            tblUsers.getColumnModel().getColumn(2).setResizable(false);
        }

        grpNewUser.setBackground(new java.awt.Color(255, 255, 255));

        btnCreateUser.setBackground(new java.awt.Color(102, 153, 255));
        btnCreateUser.setText("Create");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        lblUserName.setText("User Name:");

        lblPassword.setText("Password:");

        lblEmployee.setText("Employee:");

        cmbEmployee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEmployeeActionPerformed(evt);
            }
        });

        lblOrganization.setText("Organization:");

        cmbOrganization.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationActionPerformed(evt);
            }
        });

        lblRole.setText("Role:");

        lblCreateUser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblCreateUser.setText("New User:");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Annapurna\\Documents\\NetBeansProjects\\order-food\\users.png")); // NOI18N
        jLabel1.setText("jLabel1");

        txtrole.setEditable(false);

        javax.swing.GroupLayout grpNewUserLayout = new javax.swing.GroupLayout(grpNewUser);
        grpNewUser.setLayout(grpNewUserLayout);
        grpNewUserLayout.setHorizontalGroup(
            grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grpNewUserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(grpNewUserLayout.createSequentialGroup()
                            .addComponent(lblOrganization)
                            .addGap(18, 18, 18)
                            .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(grpNewUserLayout.createSequentialGroup()
                            .addComponent(lblEmployee)
                            .addGap(18, 18, 18)
                            .addComponent(cmbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(grpNewUserLayout.createSequentialGroup()
                            .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblUserName)
                                .addComponent(lblRole)
                                .addComponent(lblPassword))
                            .addGap(18, 18, 18)
                            .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addComponent(txtrole)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, grpNewUserLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCreateUser)))
                    .addComponent(lblCreateUser))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        grpNewUserLayout.setVerticalGroup(
            grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grpNewUserLayout.createSequentialGroup()
                .addComponent(lblCreateUser)
                .addGap(18, 18, 18)
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganization)
                    .addComponent(cmbOrganization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmployee)
                    .addComponent(cmbEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(txtrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(grpNewUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateUser)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(118, Short.MAX_VALUE))
        );

        btnBack.setBackground(new java.awt.Color(102, 153, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Users");

        lblUsersList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblUsersList.setText("Users List:");

        btndel.setBackground(new java.awt.Color(102, 153, 255));
        btndel.setText("Delete User");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsersList)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btndel)
                                .addGap(39, 39, 39)))
                        .addComponent(grpNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitle)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsersList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndel))
                    .addComponent(grpNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
 Connection conn = dbconn.getConnection();
        //conn = dbconn.getConnection();
        if(txtUserName.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid User name");
        return;
     }  
 if(txtPassword.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid Password");
        return;
     } 
 // check password
 boolean flag=false;
  boolean flag1=false;
 String password=txtPassword.getText();
 String username=txtUserName.getText();
 String role=txtrole.getText();
 flag=isValidPassword(password);

  if(!flag)
     {
         JOptionPane.showMessageDialog(this, "kindly use a Strong  Password");
        return;
     }
 //check password
        // is user already there
        // conn= dbconn.getConnection();
           // Connection conn = DriverManager.getConnection(dburl, user, pass);
 System.out.println("Connected to database !");
  String selectSql = "SELECT * from users";
      Statement stmt;
        try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
             while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                    if((resultSet.getString(1).equals(username))||(resultSet.getString(2).equals(password)))
            
          { System.out.println("resultSet.getString(1)"+resultSet.getString(1)+" text box "+username);
              flag1 = true;
               break;
            }
             }//while
            System.out.println("xxx"+flag1);
          if (flag1) {
              System.out.println("false");
          JOptionPane.showMessageDialog(null, "User Name/ Password. already available Try Again");
           return;
        }//if found
        
         } catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }       
         // is user already there
         //insert into table
          String selectSql2="select role_id from roles where role=?";
         String  selectSql1 = "insert into users(user_id,passwd,role_id,username,status)" +" values(?,?,?,?,?);";
 PreparedStatement stmt1,stmt2;
       
          try {
             // stmt = conn.createStatement();
            stmt2=conn.prepareStatement(selectSql2);
             stmt2.setString(1, role);
             resultSet = stmt2.executeQuery();
              while (resultSet.next()) {
             // roleid=resultSet.getInt(1);
              }
              stmt1=conn.prepareStatement(selectSql1);
              stmt1.setString(1, username);
               stmt1.setString(2, password);
                stmt1.setInt(3, roleid);
                 stmt1.setString(4, empsel);
                  stmt1.setInt(5, 1);
                  stmt1.executeUpdate();
                  conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
   
 
         //insert into table
        popUserAccountsTable();

        JOptionPane.showMessageDialog(null, "User Account added successfully.");
        txtUserName.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_btnBackActionPerformed
    private void cmbOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationActionPerformed
      Connection conn = dbconn.getConnection();
        ResultSet resultSet2 = null;
        orgsel=(String)cmbOrganization.getSelectedItem();
        //resultSet = null;
      if(orgsel=="Select")
      {
        System.out.println("if "+orgsel);   
      }
      else
      {System.out.println( "selected cmb = "+cmbOrganization.getSelectedItem());
            System.out.println("else "+orgsel);   
        //adding employees 
        //adding employees
        cmbEmployee.removeAllItems();
//conn = dbconn.getConnection();

          String selectSql = "SELECT * from employee_list where org=?";
      PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
       stmt.setString(1, orgsel);
       int first=0;
       
            resultSet2 = stmt.executeQuery();
            // conn.close();
           
             while (resultSet2.next()) {
                 if(first==0)
                 {
                 rolesel=resultSet2.getString(3);
                 }
                  System.out.println("in loop..........."+resultSet2.getString(2));
            cmbEmployee.addItem(resultSet2.getString(2));
           
             }//while
             txtrole.setText(rolesel);
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
 
      }
          // populateEmployeeComboBox();
            //populateRoleComboBox();
        
    }//GEN-LAST:event_cmbOrganizationActionPerformed

    private void cmbEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEmployeeActionPerformed
        // TODO add your handling code here:
         Connection conn = dbconn.getConnection();
          ResultSet resultSet2 = null;
         empsel=(String)cmbEmployee.getSelectedItem();
      if(empsel=="Select")
      {
        System.out.println("if "+orgsel);   
      }
      else
      {System.out.println( "selected cmb = "+cmbEmployee.getSelectedItem());
            System.out.println("else "+empsel);   
        //adding employees 
        //adding employees
      txtrole.setText(null);
//conn = dbconn.getConnection();
          String selectSql = "SELECT role_id,role from roles where role=?";
      PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
       stmt.setString(1, orgsel);
       int first=0;
       
            resultSet2 = stmt.executeQuery();
            // conn.close();
           System.out.println("in loo org"+ orgsel); 
             while (resultSet2.next()) {
                 roleid=resultSet2.getInt(1);
                 rolesel=resultSet2.getString(2);
                   System.out.println("in loop..........."+roleid+ "org"+ orgsel);          
             }//while
             txtrole.setText(rolesel);
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
 
      }
          // populateEmployeeComboBox();
            //populateRoleComboBox();
     
    }//GEN-LAST:event_cmbEmployeeActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
         Connection conn = dbconn.getConnection();
          int SelectedRowIndex=tblUsers.getSelectedRow();
        System.out.print("select"+SelectedRowIndex);
        if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a row to delete");
            
        return;
        }
        
        DefaultTableModel model =(DefaultTableModel) tblUsers.getModel();
      // workqueue.deletevitals(vs);
       // WorkRequest request= (WorkRequest) model.getValueAt(SelectedRowIndex, 0);
       String deluserid =(String) model.getValueAt(SelectedRowIndex, 0);
        System.out.println("request"+deluserid);
        //delete
      //  conn = dbconn.getConnection();
          String selectSql = "Delete from users where user_id=?;";
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
             
                 stmt.setString(1, deluserid);
                                   
              stmt.executeUpdate();
          conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
     
        //delete
        JOptionPane.showMessageDialog(this, "selected data deleted");
       
            popUserAccountsTable();
       
     
    }//GEN-LAST:event_btndelActionPerformed
  class MyItemListener implements ItemListener {
  // This method is called only if a new item has been selected.
       @Override
  public void itemStateChanged(ItemEvent evt) {
    //JComboBox cmbOrganization = (JComboBox) evt.getSource();

    Object item = evt.getItem();

    if (evt.getStateChange() == ItemEvent.SELECTED) {
      // Item was just selected
    } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
      // Item is no longer selected
    }
  }

        
    }
    //
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btndel;
    private javax.swing.JComboBox cmbEmployee;
    private javax.swing.JComboBox cmbOrganization;
    private javax.swing.JPanel grpNewUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCreateUser;
    private javax.swing.JLabel lblEmployee;
    private javax.swing.JLabel lblOrganization;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUsersList;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtrole;
    // End of variables declaration//GEN-END:variables
}
