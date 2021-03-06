/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.tech;

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
import javax.swing.JFrame;

import ui.DonorregJPanel;
import ui.LoginScreen;

/**
 *
 * @author akhil
 */
public class ExtractcomponentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
    

 ResultSet resultSet = null;
 ResultSet rSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0;
           int Bbankid,Did,bloodquant=0,available=0;
           String user,role,Pname,Pbgroup;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public ExtractcomponentJPanel(JPanel userProcessContainer,String user,String role) {
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
            DefaultTableModel model = (DefaultTableModel) tblblood.getModel();
         ResultSet resultSet2 = null;
        model.setRowCount(0);
        System.out.println("populate");
        //
         conn = dbconn.getConnection();
         String selectSql = "SELECT a.bbank_id,b.bbank_name,a.bgroup_name,a.quantity from Bbank_stock a,blood_bank b where a.bbank_id=b.bbank_id and  a.bbank_id=? ";
       PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
              stmt.setInt(1, Bbankid);
       
             resultSet2 = stmt.executeQuery();
            // conn.close();
             while (resultSet2.next()) {
                
                  Object[] row = new Object[8];
            row[0]=resultSet2.getInt(1);
            row[1] = resultSet2.getString(2);
            row[2] = resultSet2.getString(3);
             row[3]=resultSet2.getInt(4); 
                 
                  
                   
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
        btnextract = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtunits = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        cmbcomp = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tblblood.setBackground(new java.awt.Color(204, 255, 204));
        tblblood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Bank Id", "Bank Name", "Blood Group", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
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
            tblblood.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblblood.getColumnModel().getColumn(2).setResizable(false);
            tblblood.getColumnModel().getColumn(3).setResizable(false);
            tblblood.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Extract Blood Components");

        btnextract.setText("Extract Blood");
        btnextract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnextractActionPerformed(evt);
            }
        });

        jLabel2.setText("Component Type");

        jLabel3.setText("Units");

        txtunits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunitsActionPerformed(evt);
            }
        });
        txtunits.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtunitsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtunitsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtunitsKeyTyped(evt);
            }
        });

        btnsave.setText("Save components");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        cmbcomp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red Cells", "Platelets", "Plasma", "White cells" }));

        jButton1.setText("View Components");
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
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(btnextract))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtunits)
                                    .addComponent(cmbcomp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsave)))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnextract)
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cmbcomp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtunits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsave)
                            .addComponent(jButton1)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnextractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnextractActionPerformed
        // TODO add your handling code here:
         conn = dbconn.getConnection();
          int SelectedRowIndex=tblblood.getSelectedRow();
       System.out.println("SelectedRowIndex "+SelectedRowIndex);
                  if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a a row to extract Blood");
            
        return;
        }
        DefaultTableModel model1 =(DefaultTableModel) tblblood.getModel();
       int bid= (int) model1.getValueAt(SelectedRowIndex, 0);
         //String pname =  (String) model1.getValueAt(SelectedRowIndex, 2);
         //String bgroup=(String) model1.getValueAt(SelectedRowIndex, 1);
         int bquant=(int)model1.getValueAt(SelectedRowIndex, 3);
       
         Bbankid=bid;
         bloodquant=bquant;
         if(bloodquant ==0)
             {
         JOptionPane.showMessageDialog(this, "Please select where quantity is >0");
            
        return;
        }
     
       
       //get available quantity from stock table   
    }//GEN-LAST:event_btnextractActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
         int units=Integer.parseInt(txtunits.getText());
         String comp=cmbcomp.getItemAt(cmbcomp.getSelectedIndex());
         if(units==0)
         {
         JOptionPane.showMessageDialog(this, "Please enter Units>0");
            
        return;
        }
        // donorid=Integer.getInteger(txtid.getText());
              
        conn = dbconn.getConnection();
        
   
    
       if(txtunits.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Unit cannot be empty");
        return;
     }
     
       
     String selectSql = "Insert into blood_components(bbank_id,component,quantity) values(?,?,?);";
     
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
                       // java.sql.Date ourJavaDateObject = new java.sql.Date(calendar.getTime().getTime());
             stmt=conn.prepareStatement(selectSql);
            
              stmt.setInt(1, Bbankid);
              stmt.setString(2, comp);
              stmt.setInt(3, units);
                             // stmt.setDate(6, java.sql.Date(now));
                                   
              stmt.executeUpdate();
             
          conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(ExtractcomponentJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
        JOptionPane.showMessageDialog(this, "Blood component saved ");
                 txtunits.setText("");
    }//GEN-LAST:event_btnsaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
           String user="Tech";
           String roletype="Tech";
       JFrame techScreen = new BloodcomponentsJFrame(userProcessContainer,user,roletype);
         techScreen.setVisible(true);
        techScreen.setSize(500, 500);
        techScreen.setLocation(400, 200);
        techScreen.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtunitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunitsActionPerformed

    private void txtunitsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunitsKeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_txtunitsKeyPressed

    private void txtunitsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunitsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunitsKeyReleased

    private void txtunitsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtunitsKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
       if(!(Character.isDigit(c) )) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_txtunitsKeyTyped

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
    private javax.swing.JButton btnextract;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox<String> cmbcomp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblblood;
    private javax.swing.JTextField txtunits;
    // End of variables declaration//GEN-END:variables
}
