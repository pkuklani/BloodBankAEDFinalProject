/*
 * AdminWorkAreaJPanel.java
 *
 * Created on October 10, 2008, 8:50 AM
 */

package ui.Stores;

import ui.AdministrativeRole.*;
import bbank.Bbank;
import bbank.Donor.DeliveryManDirectory;

import bbank.UserAccount.UserAccount;
import bbank.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import ui.BbankRole.ReceivebloodJPanel;
import ui.BbankRole.IssuebloodJPanel;
import ui.BbankRole.ViewmypendingJPanel;
import ui.BbankRole.ViewalldonorsJPanel;
import ui.BbankRole.ViewmystockJPanel;

/**
 *
 * @author  akhil
 */
public class StoresWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Bbank business;
    
   // private Restaurant restaurant;
    //private Foodmenu foodmenu;
   // private FoodmenuDirectory foodmenudirectory;
    /** Creates new form AdminWorkAreaJPanel */
     private JPanel workArea;
   //  private Organization organization;
    private bbank.Donor.DeliveryMan dorganization;
    private bbank.Donor.DeliveryManDirectory ddirectory;
       private UserAccount userAccount;
    private UserAccount userAccount1;
    private UserAccountDirectory Daccount;
    private DeliveryManDirectory dmanlist;
    String user;
    String role;
    public StoresWorkAreaJPanel(JPanel userProcessContainer, String user,String role) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
          this.workArea = workArea;
       
        this.business = business;
       
        this.user=user;
        this.role=role;
       //  this.userAccount1 = account1;
         // String foodname="/food1.jpg";
        // ImageIcon icon=createImageIcon(foodname,"x"); 
                               //   icon.getImage().flush();
                                //  icon = createImageIcon(foodname, "a");
       // userProcessContainer.imageUpdate(foodname, SOMEBITS, WIDTH, WIDTH, WIDTH, WIDTH);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */

   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnissue = new javax.swing.JButton();
        btnbbank = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        btnreceive = new javax.swing.JButton();
        btnstock = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userJButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(424, 344));

        btnissue.setBackground(new java.awt.Color(102, 153, 255));
        btnissue.setText("Issue Blood");
        btnissue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnissueActionPerformed(evt);
            }
        });

        btnbbank.setBackground(new java.awt.Color(102, 153, 255));
        btnbbank.setText("View Pending Requests");
        btnbbank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbbankActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Blood Bank  Stores Work Area");

        btnreceive.setBackground(new java.awt.Color(102, 153, 255));
        btnreceive.setText("Receive Blood");
        btnreceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreceiveActionPerformed(evt);
            }
        });

        btnstock.setBackground(new java.awt.Color(102, 153, 255));
        btnstock.setText("Blood Bank Stock");
        btnstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstockActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Annapurna\\Documents\\NetBeansProjects\\blood-bank\\stores.jpg")); // NOI18N

        userJButton1.setBackground(new java.awt.Color(102, 153, 255));
        userJButton1.setText("View All Donors");
        userJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnstock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnreceive, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(lblTitle)
                    .addComponent(btnissue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnbbank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userJButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnbbank)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreceive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnissue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userJButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnstock))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnissueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnissueActionPerformed

        IssuebloodJPanel issuebloodJPanel = new IssuebloodJPanel(userProcessContainer,user,role);
        userProcessContainer.add("ReceivebloodJPanel", issuebloodJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnissueActionPerformed

    private void btnbbankActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbbankActionPerformed

        ViewmypendingJPanel viewmypendingJPanel = new ViewmypendingJPanel(userProcessContainer,user,role);
        userProcessContainer.add("manageBloodJPanel", viewmypendingJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnbbankActionPerformed

    private void btnreceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreceiveActionPerformed
        // TODO add your handling code here:
        ReceivebloodJPanel receivebloodJPanel = new ReceivebloodJPanel(userProcessContainer,user,role);
        userProcessContainer.add("ReceivebloodJPanel", receivebloodJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_btnreceiveActionPerformed

    private void btnstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstockActionPerformed
        // TODO add your handling code here:
    ViewmystockJPanel viewmystockJPanel = new ViewmystockJPanel(userProcessContainer,user,role);
        userProcessContainer.add("manageBloodJPanel", viewmystockJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnstockActionPerformed

    private void userJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButton1ActionPerformed
        // TODO add your handling code here:
         ViewalldonorsJPanel viewalldonorsJPanel = new ViewalldonorsJPanel(userProcessContainer,user,role);
        userProcessContainer.add("manageBloodJPanel", viewalldonorsJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButton1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbbank;
    private javax.swing.JButton btnissue;
    private javax.swing.JButton btnreceive;
    private javax.swing.JButton btnstock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton userJButton1;
    // End of variables declaration//GEN-END:variables
  
    protected ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
         System.err.println("found file: " + path+" url "+imgURL);
        return new ImageIcon(imgURL, description);
    } else {
        System.err.println("Couldn't find file: " + path+" url "+imgURL);
        return null;
    }
}
}
