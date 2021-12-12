/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import bbank.Bbank;
import bbank.Role.AdminRole;
import bbank.Role.BbankRole;
import bbank.Role.DonarRole;
import bbank.Role.MhaRole;
import bbank.Role.NgoRole;
import bbank.Role.Role;
import bbank.Role.LabRole;
import bbank.Role.StoresRole;
import bbank.Role.TechRole;
import bbank.Role.HospitalRole;
 import bbank.Role.DoctorRole;
import bbank.Role.BillRole;
import bbank.Role.ResearchRole;

import bbank.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author akhil
 */
public class MainScreen extends javax.swing.JPanel {

    JPanel mainWorkArea;
   
    String user;
    UserAccount userAccount;
    String role;
    DonarRole role1=new DonarRole();
     DonarRole urole =new DonarRole();
     AdminRole arole=new AdminRole();
     BbankRole brole=new BbankRole();
       NgoRole nrole=new NgoRole();
       MhaRole mrole=new MhaRole();
     StoresRole srole=new StoresRole();
       LabRole lrole=new LabRole();
       TechRole trole=new TechRole();
       HospitalRole hrole=new HospitalRole();
       DoctorRole drole=new DoctorRole();
       BillRole billrole=new BillRole();
       ResearchRole rrrole= new  ResearchRole();
     /* Creates new form MainScreen
     */
    public MainScreen(JPanel mainWorkArea,UserAccount userAccount, String username,String user){
        initComponents();
        this.mainWorkArea = mainWorkArea;
        this.user = username;
        this.userAccount= userAccount;
        this.role=user;
       // this.role1.RoleType="Admin";
        System.out.println("main role "+role+"username"+user);
        initUserWorkArea();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splitPane = new javax.swing.JSplitPane();
        menuPanel = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        workArea = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        menuPanel.setBackground(new java.awt.Color(255, 204, 255));

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblWelcome.setText("<WelcomeMsg>");

        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        jButton1.setText("Change Password");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut)
                .addGap(26, 26, 26))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(btnLogOut)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        splitPane.setTopComponent(menuPanel);

        workArea.setBackground(new java.awt.Color(255, 255, 255));
        workArea.setLayout(new java.awt.CardLayout());
        workArea.add(jTabbedPane1, "card2");

        splitPane.setRightComponent(workArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
//mainWorkArea.resetKeyboardActions();
        mainWorkArea.remove(this);
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        
        layout.previous(mainWorkArea);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("user ,,,"+user);
          // FinalChangePassword change = new FinalChangePassword(user);
          Changepasswd change = new Changepasswd(user);
       change.setVisible(true);
        change.setSize(350, 300);
        change.setLocation(500, 100);
        //change.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // change.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        change.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton jButton1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel workArea;
    // End of variables declaration//GEN-END:variables

    private void initUserWorkArea() {
        
        lblWelcome.setText("Welcome " + user + "!");
        
        
        CardLayout layout = (CardLayout) workArea.getLayout();
        System.out.println("mainscreen = "+role);
        if (role.equals("Admin"))
         workArea.add("workArea", arole.createWorkArea(workArea, userAccount,user,role));
        if (role.equals("Bbank"))
         workArea.add("workArea", brole.createWorkArea(workArea, userAccount,user,role));
        if (role.equals("Donor"))
         workArea.add("workArea", urole.createWorkArea(workArea, userAccount,user,role));
         if (role.equals("NGO"))
         workArea.add("workArea", nrole.createWorkArea(workArea, userAccount,user,role));
 if (role.equals("MHA"))
         workArea.add("workArea", mrole.createWorkArea(workArea, userAccount,user,role));      
if (role.equals("Stores"))
         workArea.add("workArea", srole.createWorkArea(workArea, userAccount,user,role));      

if (role.equals("LAB"))
         workArea.add("workArea", lrole.createWorkArea(workArea, userAccount,user,role));      

if (role.equals("Tech"))
         workArea.add("workArea", trole.createWorkArea(workArea, userAccount,user,role));      

if (role.equals("Hospital"))
         workArea.add("workArea", hrole.createWorkArea(workArea, userAccount,user,role));      


if (role.equals("Bill-desk"))
         workArea.add("workArea", billrole.createWorkArea(workArea, userAccount,user,role));      

if (role.equals("Research"))
         workArea.add("workArea", rrrole.createWorkArea(workArea, userAccount,user,role)); 

if (role.equals("Doctor"))
         workArea.add("workArea", drole.createWorkArea(workArea, userAccount,user,role)); 

//  workArea.add("workArea", userid.createWorkArea(workArea, user));
        layout.next(workArea);
    }
}
