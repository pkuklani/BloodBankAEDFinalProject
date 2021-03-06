/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import bbank.DB.DButil;

import java.awt.CardLayout;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static ui.LoginScreen.isValidPassword;

/**
 *
 * @author akhil
 */

public class DonorregJPanel extends javax.swing.JFrame {
 private JPanel userProcessContainer;
    int did=0;
    /**
     * Creates new form Donor
     */
    public DonorregJPanel() {
        initComponents();
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
        txtaddress = new javax.swing.JTextField();
        btnreg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtuserid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtpasswd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cmbgroup = new javax.swing.JComboBox<>();
        txtname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        txtmobile.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmobileKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmobileKeyTyped(evt);
            }
        });

        btnreg.setBackground(new java.awt.Color(102, 153, 255));
        btnreg.setText("Register");
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/akhil_kaundinya/NetBeansProjects/bloodbanksystem/blood-donar.jpg")); // NOI18N

        jLabel4.setText("Userid");

        jLabel5.setText("Password");

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Register as Voluntary Donor");

        jLabel6.setText("Blood Group");

        jLabel1.setText("Name");

        cmbgroup.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "O+", "O-", "B+", "B-", "AB+", "AB-" }));

        txtname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnameKeyPressed(evt);
            }
        });

        jLabel7.setText("Mobile");

        jLabel2.setText("Address");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(lblTitle))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txtmobile)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTitle)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cmbgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreg))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
        // TODO add your
        // int donorid=Integer.parseInt(txtid.getText());
        int donorid=did;
        ResultSet resultSet = null;
        String address=txtaddress.getText();
        String donorname=txtname.getText();
        String userid=txtuserid.getText();
        String bgroup=cmbgroup.getItemAt(cmbgroup.getSelectedIndex());
        String pass=txtpasswd.getText();
        long mobile=Long.parseLong(txtmobile.getText());
         boolean flag=false;
         flag=isValidPassword(pass);
          if(!flag)
     {
         JOptionPane.showMessageDialog(this, "kindly use a Strong  Password");
        return;
     }
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

        if(txtuserid.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid ID");
            return;
        }
            if(txtmobile.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please enter valid ID");
            return;
        }
        int did=0;
        if(!txtuserid.getText().isBlank())
        {
            //  did=Integer.parseInt(txtid.getText());
        }

        //

        DButil dbconn= new DButil();
        Connection conn = dbconn.getConnection();

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
                if((resultSet.getString(1).equals(userid))||(resultSet.getString(2).equals(pass)))
                { //System.out.print("inside");
                    JOptionPane.showMessageDialog(this, "UserID/Password already exists");
                    return;
                }
            }//while
            did++;
            System.out.print("did "+did);
            //  conn.close();
            // txtid.setText(Integer.toString(did));
        }//try
        catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

        //find if useid already there
        // Connection conn = DriverManager.getConnection(dburl, user, pass);
        System.out.println("Connected to database !");
        // String selectSql = "insert into Doners values("+did+","+donorname+","+address+","+bgroup+",9999999999,0,0)";
        String selectSql = "insert into Doners(donor_name,address,bgroup_name,mobile,status,donated_count) values(?,?,?,?,?,?);";
        String  selectSql1 = "insert into users(user_id,passwd,role_id,donor_id,username,status) values(?,?,?,?,?,?);";
        PreparedStatement stmt,stmt1;

        try {
            // stmt = conn.createStatement();
            stmt=conn.prepareStatement(selectSql);
            stmt1=conn.prepareStatement(selectSql1);
            stmt.setString(1, donorname);
            stmt.setString(2, address);
            stmt.setString(3, bgroup);
            stmt.setLong(4, mobile);
            stmt.setInt(5, 0);
            stmt.setInt(6, 0);
            

            stmt.executeUpdate();
            stmt1.setString(1, userid);
            stmt1.setString(2, pass);

            stmt1.setInt(3, 3);
            stmt1.setString(5, userid);
            stmt1.setInt(4, did);
            stmt1.setInt(6, 1);
            stmt1.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        JOptionPane.showMessageDialog(this,"new Donor added");

        //stop
        //txtid.setText("");
        txtname.setText("");
        txtaddress.setText("");
         txtmobile.setText("");
          txtuserid.setText("");
           txtpasswd.setText("");

    }//GEN-LAST:event_btnregActionPerformed

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

    private void txtmobileKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmobileKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
       if(!(Character.isDigit(c) )) {
           getToolkit().beep();
          evt.consume();
       }
    }//GEN-LAST:event_txtmobileKeyTyped

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreg;
    private javax.swing.JComboBox<String> cmbgroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpasswd;
    private javax.swing.JTextField txtuserid;
    // End of variables declaration//GEN-END:variables
}
