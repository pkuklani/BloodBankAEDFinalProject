/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bbank.DB.DButil;

import java.awt.CardLayout;
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

/**
 *
 * @author akhil
 */

public class NgoregJPanel1 extends JPanel {
   // Restaurant restaurant;
         private JPanel userProcessContainer;
    int did=0;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public NgoregJPanel1(JPanel userProcessContainer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
          ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
                        
       
    }
    
    

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        btnreg = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtuserid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtpasswd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtmobile = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 204, 255));
        setDoubleBuffered(false);
        setMaximumSize(new java.awt.Dimension(367, 367));

        btnBack.setBackground(new java.awt.Color(102, 153, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Register as NGO");

        jLabel1.setText("NGO Name");

        jLabel2.setText("Address");

        btnreg.setBackground(new java.awt.Color(102, 153, 255));
        btnreg.setText("Register");
        btnreg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/akhil_kaundinya/NetBeansProjects/bloodbanksystem/ngo.png")); // NOI18N

        jLabel4.setText("Userid");

        jLabel5.setText("Password");

        jLabel7.setText("Mobile");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtaddress, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(txtmobile))))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack)
                .addGap(15, 15, 15)
                .addComponent(lblTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtmobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtuserid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addComponent(txtpasswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnreg))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnregActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregActionPerformed
        // TODO add your 
       // int donorid=Integer.parseInt(txtid.getText());
        int mobile=0;
          ResultSet resultSet = null;
       String address=txtaddress.getText();
        String ngoname=txtname.getText();
        String userid=txtuserid.getText();
        
        String pass=txtpasswd.getText();
        mobile=Integer.parseInt(txtmobile.getText());
        //
    int stop=0;
     if(txtname.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid name");
         stop=1;
     }
     if(txtaddress.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid address");
         stop=1;
     }
  
    
    
     if(txtuserid.getText().isEmpty())
     {
         JOptionPane.showMessageDialog(this, "Please enter valid ID");
         stop=1;
     }
      int did=0;
    
     
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
            
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
                
       
          //find if useid already there
           // Connection conn = DriverManager.getConnection(dburl, user, pass);
 System.out.println("Connected to database !");
 // String selectSql = "insert into Doners values("+did+","+donorname+","+address+","+bgroup+",9999999999,0,0)";
 String selectSql = "insert into ngo(name,address,mobile,status)" +" values(?,?,?,?);";
 String  selectSql1 = "insert into users(user_id,passwd,role_id,username,status)" +" values(?,?,?,?,?);";
 PreparedStatement stmt,stmt1;
       
          try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
              stmt1=conn.prepareStatement(selectSql1);
          
             stmt.setString(1, ngoname);
              stmt.setString(2, address);
              stmt.setInt(3, mobile);
                 stmt.setInt(4, 0);
                                 
              stmt.executeUpdate();
              stmt1.setString(1, userid);
               stmt1.setString(2, pass);
               
                stmt1.setInt(3, 5);
                 stmt1.setString(4, ngoname);
                 stmt1.setInt(5, 0);
                  stmt1.executeUpdate();
                  conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(NgoregJPanel1.class.getName()).log(Level.SEVERE, null, ex);
          }
   
  
  
  
JOptionPane.showMessageDialog(this,"new NGO added");

     
  //stop

  txtname.setText("");
   txtaddress.setText("");
    
       
    }//GEN-LAST:event_btnregActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnreg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtmobile;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtpasswd;
    private javax.swing.JTextField txtuserid;
    // End of variables declaration//GEN-END:variables

}
