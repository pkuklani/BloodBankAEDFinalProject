/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

import bbank.Bbank;
import bbank.Donor.DeliveryMan;
import bbank.Donor.DeliveryManDirectory;
import bbank.Employee.Employee;

import bbank.UserAccount.UserAccount;
import bbank.UserAccount.UserAccountDirectory;
//import business.WorkQueue.LabTestWorkRequest;
import bbank.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class overviewWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
   
    private bbank.Donor.DeliveryMan dorganization;
    private bbank.Donor.DeliveryManDirectory ddirectory;
    private Bbank business;
    private UserAccount userAccount;
    private UserAccount userAccount1;
    private UserAccountDirectory Daccount;
    private DeliveryManDirectory dmanlist;
  //  private UserAccountDirectory daccount =dorganization.getUserAccountDirectory().getUserAccountList();
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public overviewWorkAreaJPanel(JPanel workArea, UserAccount account) {
        initComponents();
        System.out.println(account);
        this.workArea = workArea;
       
        this.userAccount = account;
        
        // this.dmanlist=dorganization.getEmployeeDirectory().getEmployeeList().;
          // Daccount ==business1.getDeliveryDirectory().getDeliverymanList().;
        // this.Daccount=dorganization.getUserAccountDirectory().getUserAccountList().get(0);
     //  this. userAccount1=account
   // System.out.println("delivery"+dmanlist.getDeliverymanList().);
  // for(Organization org:business.getOrganizationDirectory().getOrganizationList())
  // for(UserAccount org:organization.getUserAccountDirectory().getUserAccountList())
   //for(DeliveryMan dman:dmanlist.getDeliverymanList() )
  
        populateRequestTable();
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
       // for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
        {
            Object[] row = new Object[7];
          //  row[0]=request;
          //  row[1]=request.getId();
          //  row[2] = request.getMessage();
           // row[3] = request.getReceiver();
           //  row[3] = request.getCustname();
         //   row[4] = request.getStatus();
          //  row[5]=request.getDname();
          //  row[6]=request.getFeedback();
          //  String result = ((LabTestWorkRequest) request).getTestResult();
           // row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
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
        tblWorkRequests = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        cmbfood = new javax.swing.JComboBox<>();
        btnftype = new javax.swing.JButton();
        cmbstatus = new javax.swing.JComboBox<>();
        btnstatus = new javax.swing.JButton();
        cmbfeed = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(797, 350));

        tblWorkRequests.setBackground(new java.awt.Color(204, 255, 204));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Order ID", "Food Ordered", "Order By", "Status", "Delivery Boy", "Feedback"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tblWorkRequests);
        if (tblWorkRequests.getColumnModel().getColumnCount() > 0) {
            tblWorkRequests.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblWorkRequests.getColumnModel().getColumn(1).setPreferredWidth(1);
            tblWorkRequests.getColumnModel().getColumn(2).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(3).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(4).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(5).setResizable(false);
        }

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Overview of Orders");

        cmbfood.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pizza", "Burger", "French Fries" }));

        btnftype.setBackground(new java.awt.Color(102, 153, 255));
        btnftype.setText("Food Type");
        btnftype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnftypeActionPerformed(evt);
            }
        });

        cmbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pending", "Pickup", "Delivered" }));

        btnstatus.setBackground(new java.awt.Color(102, 153, 255));
        btnstatus.setText("By Order Status");
        btnstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnstatusActionPerformed(evt);
            }
        });

        cmbfeed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Excellent", "Good", "Bad" }));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setText("By Feedback");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnftype)
                                .addGap(18, 18, 18)
                                .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnstatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbfeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))))
                .addGap(128, 128, 128))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbfood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnftype)
                    .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnstatus)
                    .addComponent(cmbfeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnftypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnftypeActionPerformed
         populatefoodTable();
        //TODO add your handling code here:
    }//GEN-LAST:event_btnftypeActionPerformed

    private void btnstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnstatusActionPerformed
        // TODO add your handling code here:
         populatestatusTable();
    }//GEN-LAST:event_btnstatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         populatefeedTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        workArea.remove(this);
        // userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)  workArea.getLayout();
        layout.previous( workArea);
    }//GEN-LAST:event_jButton2ActionPerformed
 // search by food
     public void populatefoodTable(){
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
       // for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
        {
            String search=cmbfood.getItemAt(cmbfood.getSelectedIndex());
         //   String tablevalue=request.getMessage();
          //  if(search=="All")tablevalue="All";
          //  if(search==tablevalue)
            {
            Object[] row = new Object[7];
           // row[0]=request;
          //  row[1]=request.getId();
           // row[2] = request.getMessage();
           // row[3] = request.getReceiver();
          //   row[3] = request.getCustname();
          //  row[4] = request.getStatus();
          //  row[5]=request.getDname();
          //  row[6]=request.getFeedback();
          //  String result = ((LabTestWorkRequest) request).getTestResult();
           // row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
        }
    }

    
    // status
     public void populatestatusTable(){
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
       // for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
        {
            String search=cmbstatus.getItemAt(cmbstatus.getSelectedIndex());
            String tablevalue=null;
        //=request.getStatus();
            if(search=="All")tablevalue="All";
            if(search==tablevalue)
            {
            Object[] row = new Object[7];
           // row[0]=request;
           // row[1]=request.getId();
           // row[2] = request.getMessage();
           // row[3] = request.getReceiver();
            // row[3] = request.getCustname();
            //row[4] = request.getStatus();
           // row[5]=request.getDname();
           // row[6]=request.getFeedback();
          //  String result = ((LabTestWorkRequest) request).getTestResult();
           // row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
        }
    }

     //feedback
    public void populatefeedTable(){
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
     //   for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
        {
            String search=cmbfeed.getItemAt(cmbfeed.getSelectedIndex());
            String tablevalue=null;
                    //=request.getFeedback();
            if(search=="All")tablevalue="All";
            if(search==tablevalue)
            {
            Object[] row = new Object[7];
           // row[0]=request;
          //  row[1]=request.getId();
          //  row[2] = request.getMessage();
           // row[3] = request.getReceiver();
           //  row[3] = request.getCustname();
           // row[4] = request.getStatus();
           // row[5]=request.getDname();
          //  row[6]=request.getFeedback();
          //  String result = ((LabTestWorkRequest) request).getTestResult();
           // row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnftype;
    private javax.swing.JButton btnstatus;
    private javax.swing.JComboBox<String> cmbfeed;
    private javax.swing.JComboBox<String> cmbfood;
    private javax.swing.JComboBox<String> cmbstatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    // End of variables declaration//GEN-END:variables
}
