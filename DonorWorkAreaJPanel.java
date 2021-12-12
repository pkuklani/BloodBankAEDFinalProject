/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.DonorRole;

import bbank.Bbank;
import bbank.Role.DonarRole;
import business.Organization.DeliveryOrganization;
import business.Organization.RestOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
//import business.WorkQueue.LabTestWorkRequest;
import business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import bbank.order;
import java.io.File;
import java.io.FileOutputStream;
import ui.BbankRole.BbankWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class DonorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Bbank business;
    private UserAccount userAccount;
     private UserAccount userAccount1;
    private DeliveryOrganization deliveryOrganization;
 private order fileuser;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public DonorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,String role) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
         //  this.userAccount1 = account1;
        this.business = business;
        //this.deliveryOrganization = (DeliveryOrganization) organization;

        populateTable();
    }

    public void populateTable() {
            DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
      //  for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
        {
            Object[] row = new Object[7];
            String dname="A";
           // dname=request.getDname();
            if(dname==null)dname="A";
           // String name=request.getReceiver().getUsername();
            String lname=null;
            System.out.println("name"+dname+"username"+lname);
           if(dname.equals(lname))
           {
System.out.println("inside dname");
           //    row[0]=request;
           // row[1]=request.getId();
           // row[2] = request.getMessage();
           // row[3] = request.getReceiver();
           //  row[3] = request.getCustname();
           // row[5] = request.getStatus();
           // row[4]=request.getDname();
          //  row[6]=request.getResolveDate();
            
          //  String result = ((LabTestWorkRequest) request).getTestResult();
           // row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
        }
        //write into text file
         //writing to file
        File yourFile = new File("order.txt");
        yourFile.delete();
         order u1=new order();
       try
       {
           
//yourFile.createNewFile(); // if file already exists will do nothing 
FileOutputStream fs =null;
fs = new FileOutputStream("order.txt", true); 
ObjectOutputStream os= new ObjectOutputStream(fs);
MyObjectOutputStream oos=new MyObjectOutputStream (fs);
         //  FileOutputStream fs =new FileOutputStream("users.dat") ;
       
     //  ObjectOutputStream os= new ObjectOutputStream(fs);
     int i=0;
      if(yourFile.length()==0)
        {
        i=0;
        } else i=1;
     //  for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
       {
        //for (WorkRequest request :workqueue.getWorkRequestList() ){
        
        
     //   u1.setId(request.getId());
     //   u1.setCustname(request.getCustname());
      //  u1.setFood(request.getMessage());
       // u1.setRequestDate(request.getRequestDate());
       // u1.setStatus(request.getStatus());
      //  u1.setFeedback(request.getFeedback());
      //  u1.setDname(request.getDname());
      //  u1.setResolveDate(request.getResolveDate());
        System.out.println("dname in loop"+u1.getDname());
         System.out.println("feedback in loop"+u1.getFeedback());
        if(i==0)
        {//ObjectOutputStream oos = null;
                  //  os = new ObjectOutputStream(fs);
             oos = null;
                    oos =new  MyObjectOutputStream(fs);
       oos.writeObject(u1);
       i++;
        }
        else
        { oos = null;
                    oos = new MyObjectOutputStream(fs);
                    oos.writeObject(u1);
                    i++;
        }
      // os.close();
       }//for
        oos.close();
       
        // System.out.print("added to file");
       
      
    } //try
      catch (Exception e) {
 
                // Print the exception along with the
                // display message
                System.out.println("Error Occurred" + e);
            } 
       
 
        ///write
        //write into text file
  
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
        btnAssign = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblWorkRequests.setBackground(new java.awt.Color(204, 255, 204));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "null", "Message", "Order By", "Delivery Boy", "Status", "Delivery Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true
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
            tblWorkRequests.getColumnModel().getColumn(0).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblWorkRequests.getColumnModel().getColumn(1).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(1).setPreferredWidth(0);
            tblWorkRequests.getColumnModel().getColumn(2).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(3).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(4).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(5).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        btnAssign.setBackground(new java.awt.Color(102, 153, 255));
        btnAssign.setText("Set Status Delivered");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Delivery Boy Work Area");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAssign)
                            .addComponent(lblTitle)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(btnAssign)
                .addContainerGap(207, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed

        int selectedRow = tblWorkRequests.getSelectedRow();

        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) tblWorkRequests.getValueAt(selectedRow, 0);
            if (request.getMessage().equalsIgnoreCase("Completed")) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
                Date now=new Date();
                request.setReceiver(userAccount);
                request.setStatus("Delivered");
                request.setResolveDate(now);
                 JOptionPane.showMessageDialog(null, "Order Delivered");
                populateTable();

            }

        } else {
            JOptionPane.showMessageDialog(null, "Choose a order to deliver");
            return;
        }


    }//GEN-LAST:event_btnAssignActionPerformed

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
    private javax.swing.JButton btnAssign;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    // End of variables declaration//GEN-END:variables
}
