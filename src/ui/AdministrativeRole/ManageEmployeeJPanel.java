/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

import bbank.DB.DButil;
import bbank.Employee.Employee;

import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import ui.DonorregJPanel;
import ui.LoginScreen;

/**
 *
 * @author raunak
 */
public class ManageEmployeeJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
     ResultSet resultSet = null;
           DButil dbconn= new DButil();
          Connection conn = dbconn.getConnection();
          String roletype,user;
          String selectedorg;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageEmployeeJPanel(JPanel userProcessContainer,String user,String roletype) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
       this.roletype=roletype;
       this.user=user;
          lblhos.setVisible(false);
        cmbhospital.setVisible(false);
            lblbank.setVisible(false);
        cmbbank.setVisible(false);
        System.out.println(" user = "+user +" role type = "+roletype);
        populateOrganizationComboBox();
         populatebank();
          populatehospital();
        populateTable();
    }
     @SuppressWarnings("unchecked")
    public void populateOrganizationComboBox(){
        cmbOrganizationList.removeAllItems();
         cmbOrganizationList.addItem("Select");
          //  cmbOrganizationList.addItem(organization);
         String selectSql = "SELECT * from org where org_access=?";
       PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
            
       stmt.setString(1,roletype);
            resultSet = stmt.executeQuery();
       
           
            // conn.close();
             while (resultSet.next()) {
                
                  cmbOrganizationList.addItem(resultSet.getString(2));
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   //hospital table
      @SuppressWarnings("unchecked")
    public void populatehospital(){
        cmbhospital.removeAllItems();
         //cmbhospital.addItem("Select");
          //  cmbOrganizationList.addItem(organization);
           Connection conn = dbconn.getConnection();
         String selectSql = "SELECT id,name from hospitals";
       PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
            
      // stmt.setString(1,roletype);
            resultSet = stmt.executeQuery();
       
           
            // conn.close();
             while (resultSet.next()) {
                 String cmbvalue=resultSet.getString(1)+"-"+resultSet.getString(2);
                   System.out.println("cmbvalue hos "+cmbvalue);
                  cmbhospital.addItem(cmbvalue);
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    //hospital table
      //bank table
      @SuppressWarnings("unchecked")
    public void populatebank(){
        cmbhospital.removeAllItems();
         //cmbhospital.addItem("Select");
          //  cmbOrganizationList.addItem(organization);
           Connection conn = dbconn.getConnection();
         String selectSql = "SELECT bbank_id,bbank_name from blood_bank";
       PreparedStatement stmt;
       try {
            stmt=conn.prepareStatement(selectSql);
            
      // stmt.setString(1,roletype);
            resultSet = stmt.executeQuery();
       
           
            // conn.close();
             while (resultSet.next()) {
                 String cmbvalue=resultSet.getString(1)+"-"+resultSet.getString(2);
                System.out.println("cmbvalue "+cmbvalue);
                  cmbbank.addItem(cmbvalue);
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
   
    //bank table
 
      private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) tblEmployees.getModel();
        
        model.setRowCount(0);
         conn = dbconn.getConnection();
          String selectSql = "SELECT * from employee_list";
      Statement stmt;
       try {
            stmt = conn.createStatement();
       
            resultSet = stmt.executeQuery(selectSql);
            // conn.close();
            System.out.println("in loop...........");
             while (resultSet.next()) {
                 Object[] row = new Object[3];
                  System.out.println("in loop"+ resultSet.getString(2));
            row[0] = resultSet.getInt(1);
            row[1] = resultSet.getString(2);
              row[2] = resultSet.getString(3);
            model.addRow(row);
           
             }//while
             
            
             conn.close();
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
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

        lblTitle = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblOrganizationPicker = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployees = new javax.swing.JTable();
        lblEmployeeList = new javax.swing.JLabel();
        lblOrganizationList1 = new javax.swing.JLabel();
        lblEmployeeName = new javax.swing.JLabel();
        txtEmployeeName = new javax.swing.JTextField();
        btnCreateEmployee = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbOrganizationList = new javax.swing.JComboBox<>();
        lblhos = new javax.swing.JLabel();
        cmbhospital = new javax.swing.JComboBox<>();
        lblbank = new javax.swing.JLabel();
        cmbbank = new javax.swing.JComboBox<>();
        btndelete = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setText("Manage Employees");

        btnBack.setBackground(new java.awt.Color(102, 153, 255));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblOrganizationPicker.setText(" Organization:");

        tblEmployees.setBackground(new java.awt.Color(204, 255, 204));
        tblEmployees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Name", "Organization"
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
        jScrollPane1.setViewportView(tblEmployees);
        if (tblEmployees.getColumnModel().getColumnCount() > 0) {
            tblEmployees.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblEmployees.getColumnModel().getColumn(0).setMaxWidth(50);
            tblEmployees.getColumnModel().getColumn(1).setResizable(false);
            tblEmployees.getColumnModel().getColumn(2).setResizable(false);
        }

        lblEmployeeList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblEmployeeList.setText("Employee List:");

        lblOrganizationList1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblOrganizationList1.setText("New Employee:");

        lblEmployeeName.setText("Name:");

        btnCreateEmployee.setBackground(new java.awt.Color(102, 153, 255));
        btnCreateEmployee.setText("Create Employee");
        btnCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Annapurna\\Documents\\NetBeansProjects\\order-food\\manager.png")); // NOI18N
        jLabel1.setText("jLabel1");

        cmbOrganizationList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbOrganizationList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrganizationListActionPerformed(evt);
            }
        });

        lblhos.setText("Hospital");

        cmbhospital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblbank.setText("Blood Bank");

        cmbbank.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btndelete.setText("Delete Employee");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEmployeeList)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOrganizationPicker)
                                .addGap(23, 23, 23)
                                .addComponent(cmbOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblOrganizationList1)
                                .addGap(141, 141, 141)
                                .addComponent(btndelete))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblhos)
                                    .addComponent(lblEmployeeName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmbhospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCreateEmployee))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(lblbank)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(104, 104, 104)))
                        .addGap(77, 77, 77)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(18, 18, 18)
                        .addComponent(lblTitle)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(lblTitle))
                .addGap(26, 26, 26)
                .addComponent(lblEmployeeList)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganizationPicker)
                    .addComponent(cmbOrganizationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrganizationList1)
                    .addComponent(btndelete))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmployeeName))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblhos)
                    .addComponent(cmbhospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblbank)
                    .addComponent(cmbbank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(btnCreateEmployee)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeActionPerformed
        
        String org=cmbOrganizationList.getItemAt(cmbOrganizationList.getSelectedIndex());
        String name1 = txtEmployeeName.getText();
        String hname=cmbhospital.getItemAt(cmbhospital.getSelectedIndex());
        String bname=cmbbank.getItemAt(cmbbank.getSelectedIndex());
         conn = dbconn.getConnection();
            ResultSet resultSetu = null;
        if (name1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee name cannot be empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int bbankid=0;int hid=0;
        if(selectedorg.equals("Hospital"))
        {
           hid=Integer.parseInt(hname.substring(0,hname.lastIndexOf("-")) );
        }
         if(selectedorg.equals("Bbank"))
        {
           bbankid=Integer.parseInt(bname.substring(0,bname.lastIndexOf("-")) );
        }
         if((roletype.equals("Bbank"))||(roletype.equals("Hospital")))
         { //finding bankid and hospital id 
              String selectSqlu = "SELECT bbank_id,hospital_id from users where user_id=?";
       PreparedStatement stmtu;
       try {
            stmtu=conn.prepareStatement(selectSqlu);
            
       stmtu.setString(1,user);
            resultSetu = stmtu.executeQuery();
       
           
            // conn.close();
             while (resultSetu.next()) {
              if  (roletype.equals("Bbank"))
                  bbankid=resultSetu.getInt(1);
               if  (roletype.equals("Hospital"))
                  hid=resultSetu.getInt(2);
           
             }//while
             
            
        System.out.println("user "+user+" bbankid "+bbankid + " hid "+hid);
             
       }//try
       catch (SQLException ex) {
            Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
       
             
         }
         
         String selectSql = "Insert into employee_list (name,org,bank_id,hospital_id) values(?,?,?,?)";
   
     PreparedStatement stmt;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
              stmt.setString(1, name1);
              stmt.setString(2, org);
               stmt.setInt(3, bbankid);
              stmt.setInt(4, hid);
                           
              stmt.executeUpdate();
             
                conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(ManageBloodJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
JOptionPane.showMessageDialog(this,"New Employee Added");

         
        txtEmployeeName.setText("");
         lblhos.setVisible(false);
        cmbhospital.setVisible(false);
            lblbank.setVisible(false);
        cmbbank.setVisible(false);
        populateTable();
        
    }//GEN-LAST:event_btnCreateEmployeeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbOrganizationListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrganizationListActionPerformed
        // TODO add your handling code here:
       // if(cmbOrganizationList.getSelectedItem().equals("Hospital"))
       lblhos.setVisible(false);
        cmbhospital.setVisible(false);
            lblbank.setVisible(false);
        cmbbank.setVisible(false);
       String selorg;
       if(cmbOrganizationList.getSelectedItem()==null)
           selorg="Select";
       else
          selorg=(String)cmbOrganizationList.getSelectedItem(); 
       selectedorg=selorg;
       System.out.println("1 "+selorg);
       if(selorg=="Select")
      {
        System.out.println("if "+selorg);   
      }
        else
        { //String selorg=(String)cmbOrganizationList.getSelectedItem();
            System.out.println("1 else"+selorg);
        if(selorg.equals("Hospital"))
        {
            System.out.println("1 else if "+selorg);
             lblhos.setVisible(true);
        cmbhospital.setVisible(true);
        }
         if(selorg.equals("Bbank"))
        {
            System.out.println("1 else if "+selorg);
             lblbank.setVisible(true);
        cmbbank.setVisible(true);
        }
    }//GEN-LAST:event_cmbOrganizationListActionPerformed
    }
    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
         Connection conn = dbconn.getConnection();
          int SelectedRowIndex=tblEmployees.getSelectedRow();
        System.out.print("select"+SelectedRowIndex);
        if(SelectedRowIndex<0)
        {
         JOptionPane.showMessageDialog(this, "Please select a row to delete");
            
        return;
        }
        
        DefaultTableModel model =(DefaultTableModel) tblEmployees.getModel();
      // workqueue.deletevitals(vs);
       // WorkRequest request= (WorkRequest) model.getValueAt(SelectedRowIndex, 0);
        String delusern=(String) model.getValueAt(SelectedRowIndex, 1);
       int  delempid =(int) model.getValueAt(SelectedRowIndex, 0);
        System.out.println("request"+delempid);
        //delete
      //  conn = dbconn.getConnection();
          String selectSql = "Delete from users where user_id=?;";
           String selectSql1 = "Delete from employee_list where id=?;";
     PreparedStatement stmt,stmt1;
      try {
             // stmt = conn.createStatement();
             stmt=conn.prepareStatement(selectSql);
             
                 stmt.setString(1, delusern);
                                   
              stmt.executeUpdate();
                stmt1=conn.prepareStatement(selectSql1);
             
                 stmt1.setInt(1, delempid);
                                   
              stmt1.executeUpdate();
          conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(DonorregJPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
     
        //delete
        JOptionPane.showMessageDialog(this, "selected data deleted");
       
          populateTable();
       
     
    }//GEN-LAST:event_btndeleteActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateEmployee;
    private javax.swing.JButton btndelete;
    private javax.swing.JComboBox<String> cmbOrganizationList;
    private javax.swing.JComboBox<String> cmbbank;
    private javax.swing.JComboBox<String> cmbhospital;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEmployeeList;
    private javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblOrganizationList1;
    private javax.swing.JLabel lblOrganizationPicker;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblbank;
    private javax.swing.JLabel lblhos;
    private javax.swing.JTable tblEmployees;
    private javax.swing.JTextField txtEmployeeName;
    // End of variables declaration//GEN-END:variables
}
