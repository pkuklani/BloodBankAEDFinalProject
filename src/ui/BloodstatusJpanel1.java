/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
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

public class BloodstatusJpanel1 extends javax.swing.JFrame {
private JPanel userProcessContainer;
      ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
           int did=0,bankid=0;
           String bname,bgroup;
    public BloodstatusJpanel1(JPanel userProcessContainer) {
        
        initComponents();
        this.userProcessContainer = userProcessContainer;
                               addcmbtype();
addcmbbank();

                
        populateTable();
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
                  //row[6]=resultSet.getInt(7);
                  row[6]=resultSet.getLong(7);
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

        jPanel1 = new javax.swing.JPanel();
        txtmobile = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnedit = new javax.swing.JButton();
        txtnamep = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtgroup = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblblood = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtquantity = new javax.swing.JTextField();
        lblOrganizationAdd = new javax.swing.JLabel();
        cmbtype = new javax.swing.JComboBox<>();
        btntype = new javax.swing.JButton();
        cmbbank = new javax.swing.JComboBox<>();
        btnbank = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmobileActionPerformed(evt);
            }
        });
        txtmobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmobileKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmobileKeyTyped(evt);
            }
        });

        jLabel1.setText("Bank Name");

        jLabel6.setText("Blood Group");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });
        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        jLabel7.setText("Patient Name");

        btnedit.setBackground(new java.awt.Color(102, 153, 255));
        btnedit.setText("Select Blood Bank");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        txtnamep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnamepKeyPressed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(102, 153, 255));
        btnAdd.setText("Add Blood Request");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setText("Address");

        tblblood.setBackground(new java.awt.Color(204, 255, 204));
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

        jLabel4.setText("Units");

        jLabel5.setText("Mobile");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText(" Blood Availabilty Status");

        txtquantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtquantityKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtquantityKeyTyped(evt);
            }
        });

        lblOrganizationAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationAdd.setText("Request for  Blood ");

        btntype.setText("Search By Type");
        btntype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntypeActionPerformed(evt);
            }
        });

        btnbank.setText("Search by Bank");
        btnbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbankActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnedit)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtnamep, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jLabel1)))
                                .addGap(18, 18, 18)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(lblTitle)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnAdd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btntype)
                        .addGap(70, 70, 70)
                        .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbank)))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(lblOrganizationAdd)
                    .addContainerGap(340, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTitle)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntype)
                    .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbank))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnedit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnamep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(19, 19, 19)
                .addComponent(btnAdd)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(300, Short.MAX_VALUE)
                    .addComponent(lblOrganizationAdd)
                    .addGap(200, 200, 200)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:

        int SelectedRowIndex=tblblood.getSelectedRow();
        System.out.println("SelectedRowIndex "+SelectedRowIndex);
        if(SelectedRowIndex<0)
        {
            JOptionPane.showMessageDialog(this, "Please select a Bank to register");

            return;
        }
        DefaultTableModel model1 =(DefaultTableModel) tblblood.getModel();
        bankid=(int) model1.getValueAt(SelectedRowIndex, 0);
        bname=  model1.getValueAt(SelectedRowIndex, 1).toString();
        bgroup=model1.getValueAt(SelectedRowIndex, 2).toString();
        txtname.setText(bname);
        txtgroup.setText(bgroup);
        // System.out.print("model1.getValueAt(SelectedRowIndex, 0) "+model1.getValueAt(SelectedRowIndex, 0));

    }//GEN-LAST:event_btneditActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        String address=txtaddress.getText();
        String pname=txtnamep.getText();
        String bgroup=txtgroup.getText();
        long mobile=Long.parseLong(txtmobile.getText());
        int qty=Integer.parseInt(txtquantity.getText());
        conn = dbconn.getConnection();

        int stop=0;
        if(txtname.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
            return;
        }
        if(txtnamep.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid name");
            return;
        }
        if(txtaddress.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid address");
            return;
        }
        if(txtquantity.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity");
            return;
        }
        if(txtmobile.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid Mobile Number");
            return;
        }
        if(stop==0)
        {System.out.println("stop0");

            //  int found=0;
            String selectSql = "insert into blood_demand(bbank_id,Bgroup_name,Patient_name,address,quantity,status,mobile)" +" values(?,?,?,?,?,?,?);";

            PreparedStatement stmt;
            try {
                // stmt = conn.createStatement();
                stmt=conn.prepareStatement(selectSql);

                stmt.setInt(1, bankid);
                stmt.setString(2, bgroup);
                stmt.setString(3, pname);
                stmt.setString(4, address);
                stmt.setInt(5, qty);
                stmt.setInt(6, 0);
                //stmt.setInt(7, mobile);
                stmt.setLong(7, mobile);
                stmt.executeUpdate();

                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BloodstatusJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(this,"Blood Request Added");

            populateTable();

        }//stop

        txtname.setText("");
        txtaddress.setText("");

        txtmobile.setText("");

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmobileActionPerformed

    private void txtmobileKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobileKeyPressed
        // TODO add your handling code here:
        System.out.println("im in validation");
              String unit =txtmobile.getText();
        //if(PhoneNo.matches("^[0-9]*$") && PhoneNo.length()==10)
        if(unit.length()<11)
        {
             System.out.println("in if "+unit);
            //txtid.setBackground(Color.yellow);
            //JOptionPane.showMessageDialog(null,"You Have Entered Correct PhoneNO");
        }
        else
       
        {
            System.out.println("in else "+unit);
            //txtid.setBackground(Color.blue);
            JOptionPane.showMessageDialog(null,"Please Enter Correct Mobile Number");
        }
    }//GEN-LAST:event_txtmobileKeyPressed

    private void txtquantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantityKeyPressed
        // TODO add your handling code here:
         /*     String unit =txtquantity.getText();
        //if(PhoneNo.matches("^[0-9]*$") && PhoneNo.length()==10)
        if((unit.matches("^[0-9]*$")) && (unit.length()<11) )
        {
            //txtid.setBackground(Color.yellow);
            //JOptionPane.showMessageDialog(null,"You Have Entered Correct PhoneNO");
        }
        else
       
        {
            //txtid.setBackground(Color.blue);
            JOptionPane.showMessageDialog(null,"Please Enter Correct Units");
        }*/
    }//GEN-LAST:event_txtquantityKeyPressed

    private void txtnamepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamepKeyPressed
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
    }//GEN-LAST:event_txtnamepKeyPressed

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

    private void btntypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntypeActionPerformed
        // TODO add your handling code here:
       populatetypeTable();
    }//GEN-LAST:event_btntypeActionPerformed

    private void btnbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbankActionPerformed
        // TODO add your handling code here:
        populatebankTable();
    }//GEN-LAST:event_btnbankActionPerformed

    private void txtmobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobileKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
       if(!(Character.isDigit(c) )) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_txtmobileKeyTyped

    private void txtquantityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantityKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
       if(!(Character.isDigit(c) )) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_txtquantityKeyTyped

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnbank;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btntype;
    private javax.swing.JComboBox<String> cmbbank;
    private javax.swing.JComboBox<String> cmbtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrganizationAdd;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblblood;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtgroup;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnamep;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
