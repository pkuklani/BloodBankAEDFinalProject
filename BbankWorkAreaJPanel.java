/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.BbankRole;

import bbank.Bbank;
import bbank.Donor.DeliveryMan;
import bbank.Donor.DeliveryManDirectory;
import business.Employee.Employee;
import business.Organization.Organization;
import business.Organization.RestOrganization;
import business.Restaurant.Restaurant;
import business.UserAccount.UserAccount;
import business.UserAccount.UserAccountDirectory;
//import business.WorkQueue.LabTestWorkRequest;
import business.WorkQueue.WorkRequest;
import bbank.order;
import java.awt.CardLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import bbank.order;

/**
 *
 * @author raunak
 */
public class BbankWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel workArea;
    private RestOrganization organization;
    private bbank.Donor.DeliveryMan dorganization;
    private bbank.Donor.DeliveryManDirectory ddirectory;
    private Bbank business;
    private UserAccount userAccount;
    private UserAccount userAccount1;
    private UserAccountDirectory Daccount;
    private DeliveryManDirectory dmanlist;
     private order fileuser;
  //  private UserAccountDirectory daccount =dorganization.getUserAccountDirectory().getUserAccountList();
    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public BbankWorkAreaJPanel(JPanel workArea, UserAccount account,String user ) {
        initComponents();
        System.out.println(account);
        this.workArea = workArea;
        this.organization = organization;
      
        this.userAccount = account;
        // this.userAccount1 = account1;
        // this.ddirectory=business1.getDeliveryDirectory();
        // this.dmanlist=dorganization.getEmployeeDirectory().getEmployeeList().;
          // Daccount ==business1.getDeliveryDirectory().getDeliverymanList().;
        // this.Daccount=dorganization.getUserAccountDirectory().getUserAccountList().get(0);
     //  this. userAccount1=account
   // System.out.println("delivery"+dmanlist.getDeliverymanList().);
  // for(Organization org:business.getOrganizationDirectory().getOrganizationList())
  // for(UserAccount org:organization.getUserAccountDirectory().getUserAccountList())
  // for(DeliveryMan dman:dmanlist.getDeliverymanList() )
  for(DeliveryMan dman :ddirectory.getDeliverymanList())
   {   
       System.out.println("dman= "+dman.getDmanname());
      cmbdelivery.addItem(dman.getDmanname().toString());
  // daccount=organization.getUserAccountDirectory().getUserAccountList().
           }
        populateRequestTable();
    }
    
    public void populateRequestTable(){
        DefaultTableModel model = (DefaultTableModel) tblWorkRequests.getModel();
        
        model.setRowCount(0);
       // for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
        {
            Object[] row = new Object[6];
         //   row[0]=request;
          //  row[1]=request.getId();
         //   row[2] = request.getMessage();
           // row[3] = request.getReceiver();
          //   row[3] = request.getCustname();
          //  row[4] = request.getStatus();
           // row[5]=request.getDname();
          //  String result = ((LabTestWorkRequest) request).getTestResult();
           // row[3] = result == null ? "Waiting" : result;
            
            model.addRow(row);
        }
        //add to text file
          ////writing to file
        ///write
       
        
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
      // for (WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
      {
        //for (WorkRequest request :workqueue.getWorkRequestList() ){
        
        
    //    u1.setId(request.getId());
    //    u1.setCustname(request.getCustname());
    //    u1.setFood(request.getMessage());
      //  u1.setRequestDate(request.getRequestDate());
      //  u1.setStatus(request.getStatus());
      //  u1.setFeedback(request.getFeedback());
      //  u1.setDname(request.getDname());
     //   u1.setResolveDate(request.getResolveDate());
        System.out.println("dname in loop"+u1.getDname());
         System.out.println("feedback in loop"+u1.getFeedback());
        if(i==0)
        {//ObjectOutputStream oos = null;
                  //  os = new ObjectOutputStream(fs);
             oos = null;
                    oos = new MyObjectOutputStream(fs);
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
        ///writing to file
          ////writing to file
        ///write
       
        
      //writing to file
       
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
        btnassignboy = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        cmbdelivery = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtorder = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(797, 350));

        tblWorkRequests.setBackground(new java.awt.Color(204, 255, 204));
        tblWorkRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "Order ID", "Food Ordered", "Order By", "Status", "Delivery Boy"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            tblWorkRequests.getColumnModel().getColumn(1).setPreferredWidth(1);
            tblWorkRequests.getColumnModel().getColumn(2).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(3).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(4).setResizable(false);
            tblWorkRequests.getColumnModel().getColumn(5).setResizable(false);
        }

        btnassignboy.setBackground(new java.awt.Color(102, 153, 255));
        btnassignboy.setText("Assign delivery Boy");
        btnassignboy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnassignboyActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Restaurant Work Area");

        jLabel1.setText("Order");

        jLabel2.setText("Delivery Boy");

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtid.setEditable(false);
        txtid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnassignboy)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(cmbdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)))))
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(btnRefresh))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnassignboy)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbdelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtorder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnassignboyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnassignboyActionPerformed
        
        CardLayout layout = (CardLayout) workArea.getLayout();
        //workArea.add("RequestLabTestJPanel", new RequesDeliveryJPanel(workArea, userAccount, business));
        layout.next(workArea);
               
          int SelectedRowIndex=tblWorkRequests.getSelectedRow();
       System.out.println("SelectedRowIndex "+SelectedRowIndex);
                  if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select an Order");
            
        return;
        }
        DefaultTableModel model1 =(DefaultTableModel) tblWorkRequests.getModel();
        //System.out.print("model1.getValueAt(SelectedRowIndex, 0) "+model1.getValueAt(SelectedRowIndex, Restaurant));
        WorkRequest selectedvital= (WorkRequest) model1.getValueAt(SelectedRowIndex, 0); 
    txtorder.setText(String.valueOf(selectedvital.getMessage()));
    txtid.setText(String.valueOf(selectedvital.getId()));
    //  txtname.setText(String.valueOf(selectedvital.getRestname()));
      // txtaddress.setText(String.valueOf(selectedvital.getRestadd()));
      
//txtid.setEditable(false);
 //btnAdd.setEnabled(false);
//tblOrganizations.setEnabled(true);

        
    }//GEN-LAST:event_btnassignboyActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        populateRequestTable();
        
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int l=0;
     //    for( WorkRequest request : userAccount1.getWorkQueue().getWorkRequestList())
       {
      //  int idfound=request.getId();
        int selectid=0;
        if(!txtid.getText().isEmpty())
        {System.out.println("inside");
                selectid=Integer.parseInt(txtid.getText());}
       // String s=request.
    //   System.out.println("idfound"+idfound+"selectfedfe"+selectid);
  // if(idfound==selectid)
   { //request.setDname(cmbdelivery.getItemAt(cmbdelivery.getSelectedIndex()));
   //request.setStatus("Pick Up");
     // request.setReceiver(cmbdelivery.getItemAt(cmbdelivery.getSelectedIndex()));
     //  vs.setRestname(pname);
     //  vs.setRestadd(address);
       
    //  history.setHistory(vs);
    // userAccount1.getWorkQueue().getWorkRequestList().set(l, request);
  // break;
       }
        l++;
    }//GEN-LAST:event_jButton1ActionPerformed
 JOptionPane.showMessageDialog(this," Order assigned for Pickup");
  populateRequestTable();
    }
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
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnassignboy;
    private javax.swing.JComboBox<String> cmbdelivery;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblWorkRequests;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtorder;
    // End of variables declaration//GEN-END:variables
}
