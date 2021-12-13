/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Lab;

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

public class LabtestJPanel extends javax.swing.JPanel {
   // Restaurant restaurant;
    
    
    private JPanel userProcessContainer;
      ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public LabtestJPanel(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       
        
         
        populateTable();
       // populateCombo();
    }
    
    

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();
         Connection conn = dbconn.getConnection();
        model.setRowCount(0);
        System.out.println("populate");
        //
         String selectSql = "SELECT * from lab_tests";
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
        lblTitle = new javax.swing.JLabel();
        lblOrganizationAdd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtdesc = new javax.swing.JTextField();
        btndel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblOrganizations.setBackground(new java.awt.Color(204, 255, 204));
        tblOrganizations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tblOrganizations);
        if (tblOrganizations.getColumnModel().getColumnCount() > 0) {
            tblOrganizations.getColumnModel().getColumn(0).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(1).setResizable(false);
            tblOrganizations.getColumnModel().getColumn(2).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Blood Tests");

        lblOrganizationAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationAdd.setText("Add  New Blood Tests");

        jLabel1.setText("Name of the Test");

        jLabel2.setText("Description");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
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
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtdesc, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                            .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTitle)
                .addGap(62, 62, 62)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btndel)
                        .addGap(0, 0, 0)
                        .addComponent(lblOrganizationAdd)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(txtdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd)
                        .addContainerGap())
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
         int SelectedRowIndex=tblOrganizations.getSelectedRow();
        if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a row to delete");
            
        return;
        }
        DefaultTableModel model =(DefaultTableModel) tblOrganizations.getModel();
         int testid=(int) model.getValueAt(SelectedRowIndex, 0);
       
         conn = dbconn.getConnection();
          String selectSql = "Delete from lab_tests where test_id=?;";
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
             
                 stmt.setInt(1, testid);
                                   
              stmt.executeUpdate();
          conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
    
         
        JOptionPane.showMessageDialog(this, "selected data deleted");
        populateTable();
     
    }//GEN-LAST:event_btndelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
           
        String testdesc=txtdesc.getText();
        String testname=txtname.getText();
       
        conn = dbconn.getConnection();
        
    int stop=0;
     if(txtname.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid name");
        return;
     }
     if(txtdesc.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid Description");
         return;
     }
   
  if(stop==0)
  {System.out.println("stop0");
      //checking if id is already there
       //find if userid already there
            String checkSql = "SELECT * from lab_tests";
      Statement stmtc;
       try {
            stmtc = conn.createStatement();
       
            resultSet = stmtc.executeQuery(checkSql);
              
            // conn.close();
             while (resultSet.next()) {
                 // did=resultSet.getInt(1);
              //    System.out.println("1="+resultSet.getString(1)+" userid"+userid+"2="+resultSet.getString(2)+" pass"+pass);
                   if((resultSet.getString(2).equals(testname)))
                   { //System.out.print("inside");
                        JOptionPane.showMessageDialog(this, " Test  already exists");
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
     String selectSql = "Insert into lab_tests (test_name,test_desc) values(?,?);";
   
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
                         // stmt.setInt(1, bbankid);
              stmt.setString(1, testname);
              stmt.setString(2, testdesc);
                                             
              stmt.executeUpdate();
             
          conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(LabtestJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
JOptionPane.showMessageDialog(this,"New Test Added");

       populateTable(); 
   
  }//stop

  txtname.setText("");
  txtdesc.setText("");
  
  
     
    }//GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btndel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrganizationAdd;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    private javax.swing.JTextField txtdesc;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}