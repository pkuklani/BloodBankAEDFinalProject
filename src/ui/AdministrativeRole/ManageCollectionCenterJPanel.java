/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.AdministrativeRole;

import business.Restaurant.CollectionCenter;
import business.Restaurant.CollectionCenterDirectory;
import business.Organization.Organization;
import business.Organization.Organization.Type;
import business.Organization.OrganizationDirectory;
import business.Organization.CollectionCenterOrganization;
import java.awt.CardLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pkuklani
 */
public class ManageCollectionCenterJPanel extends javax.swing.JPanel {
    // Restaurant restaurant;

    OrganizationDirectory directory;
    CollectionCenterDirectory restdirectory;
    private JPanel userProcessContainer;

    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageCollectionCenterJPanel(JPanel userProcessContainer, CollectionCenterDirectory restdirectory, OrganizationDirectory directory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.restdirectory = restdirectory;
        this.directory = directory;
        lblRestID.setText("");
        populateTable();
        // populateCombo();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();

        model.setRowCount(0);
        System.out.println("populate");
        for (CollectionCenter restaurant : restdirectory.getRestaurantList()) {
            Object[] row = new Object[6];
            row[0] = restaurant;
            row[1] = restaurant.getRestid();
            row[2] = restaurant.getRestname();
            row[3] = restaurant.getRestadd();
            row[4] = restaurant.getOpenFrom();
            row[5] = restaurant.getOpenTo();
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
        tblOrganizations = new javax.swing.JTable();
        btnmod = new javax.swing.JButton();
        lblSelectOrgType = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblOrganizationAdd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        btndel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lblRestID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFromTime = new javax.swing.JTextField();
        lblSelectOrgType1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtToTime = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        tblOrganizations.setBackground(new java.awt.Color(255, 0, 0));
        tblOrganizations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "", "ID", "Name", "Address", "Open From", "Open To"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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
        jScrollPane1.setViewportView(tblOrganizations);
        if (tblOrganizations.getColumnModel().getColumnCount() > 0) {
            tblOrganizations.getColumnModel().getColumn(0).setMinWidth(0);
            tblOrganizations.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnmod.setBackground(new java.awt.Color(255, 0, 0));
        btnmod.setText("Clear");
        btnmod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodActionPerformed(evt);
            }
        });

        lblSelectOrgType.setText("ID");

        btnBack.setBackground(new java.awt.Color(252, 128, 25));
        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Manage Blood Collection Centers");

        lblOrganizationAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOrganizationAdd.setText("Add /Modify Center:");

        jLabel1.setText("Name");

        jLabel2.setText("Address");

        btnedit.setBackground(new java.awt.Color(255, 0, 0));
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndel.setBackground(new java.awt.Color(255, 0, 0));
        btndel.setText("Delete");
        btndel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(255, 0, 0));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lblRestID.setText("ID");

        jLabel4.setText("From:");

        lblSelectOrgType1.setText("Hours of Operation (24 hour format)");

        jLabel5.setText("To:");

        txtToTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtToTimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblOrganizationAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnmod, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(39, 39, 39))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblSelectOrgType)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                    .addComponent(jLabel4)))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblRestID)
                                                .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel5)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(txtToTime, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(lblSelectOrgType1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndel, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(388, 388, 388)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBack)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitle)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnedit)
                            .addComponent(btndel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrganizationAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSelectOrgType)
                            .addComponent(lblRestID))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblSelectOrgType1)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFromTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtToTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnmod)
                            .addComponent(btnAdd))
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnmodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodActionPerformed

        lblRestID.setText("");
        txtname.setText("");
        txtaddress.setText("");
        txtFromTime.setText("");
        txtToTime.setText("");
        btnAdd.setEnabled(true);
        btnAdd.setText("Add");
    }//GEN-LAST:event_btnmodActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        int SelectedRowIndex = tblOrganizations.getSelectedRow();
        System.out.println("SelectedRowIndex " + SelectedRowIndex);
        if (SelectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Collection Center record to edit");
            return;
        }
        DefaultTableModel model1 = (DefaultTableModel) tblOrganizations.getModel();
        CollectionCenter selectedvital = (CollectionCenter) model1.getValueAt(SelectedRowIndex, 0);
        lblRestID.setText(String.valueOf(selectedvital.getRestid()));
        txtname.setText(String.valueOf(selectedvital.getRestname()));
        txtaddress.setText(String.valueOf(selectedvital.getRestadd()));
        txtFromTime.setText(String.valueOf(selectedvital.getOpenFrom()));
        txtToTime.setText(String.valueOf(selectedvital.getOpenTo()));
        btnAdd.setEnabled(true);
        btnAdd.setText("Update");
    }//GEN-LAST:event_btneditActionPerformed

    private void btndelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelActionPerformed
        // TODO add your handling code here:
        int SelectedRowIndex = tblOrganizations.getSelectedRow();
        if (SelectedRowIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a Collection Center record to delete");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblOrganizations.getModel();
        CollectionCenter selectedvital = (CollectionCenter) model.getValueAt(SelectedRowIndex, 0);
        restdirectory.deleteRestaurant(selectedvital);
        JOptionPane.showMessageDialog(this, "Collection Center deleted successfully");
        populateTable();

    }//GEN-LAST:event_btndelActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int restid = 0;
        if (lblRestID.getText() != null && !lblRestID.getText().isBlank() && !lblRestID.getText().isEmpty()) {
            restid = Integer.parseInt(lblRestID.getText());
        }
        String address = txtaddress.getText();
        String pname = txtname.getText();
        String openFrom = txtFromTime.getText();
        String openTo = txtToTime.getText();
        String validationMessage = "";
        if (txtname.getText().isEmpty() || txtname.getText().isBlank()) {
            validationMessage += "Collection Center Name is required.";
        }
        if (txtaddress.getText().isEmpty() || txtaddress.getText().isBlank()) {
            if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
                validationMessage += "\n";
            }
            validationMessage += "Collection Center Address is required.";
        }
        if (openFrom.isEmpty() || openFrom.isBlank()) {
            if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
                validationMessage += "\n";
            }
            validationMessage += "From Time is required.";
        }
        if (openTo.isEmpty() || openTo.isBlank()) {
            if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
                validationMessage += "\n";
            }
            validationMessage += "To Time is required.";
        }
        String staticValidationMessage = "One or more issues found. Please resolve and click Save again.\n\n";
        if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
            JOptionPane.showMessageDialog(this, staticValidationMessage + validationMessage);
        } else {
            if (restid == 0) {
                CollectionCenter md = restdirectory.createRestaurant(restid, pname, address, openFrom, openTo);
                md.setRestname(pname);
                md.setRestadd(address);
                md.setOpenFrom(openFrom);
                md.setOpenTo(openTo);
                CollectionCenterOrganization restOrganization = new CollectionCenterOrganization();
                restOrganization.setName(pname);
                directory.getOrganizationList().add(restOrganization);
                JOptionPane.showMessageDialog(this, "Collection Center Added");
            } else {
                for (CollectionCenter vs : restdirectory.getRestaurantList()) {
                    int idfound = vs.getRestid();
                    if (idfound == restid) {
                        vs.setRestname(pname);
                        vs.setRestadd(address);
                        vs.setOpenFrom(openFrom);
                        vs.setOpenTo(openTo);
                    }
                }
                JOptionPane.showMessageDialog(this, "Collection Center Data Updated");
            }

            populateTable();

        }
        lblRestID.setText("");
        txtname.setText("");
        txtaddress.setText("");
        txtFromTime.setText("");
        txtToTime.setText("");
        btnAdd.setEnabled(true);
        btnAdd.setText("Add");

    }//GEN-LAST:event_btnAddActionPerformed

    private void txtToTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtToTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtToTimeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btndel;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnmod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOrganizationAdd;
    private javax.swing.JLabel lblRestID;
    private javax.swing.JLabel lblSelectOrgType;
    private javax.swing.JLabel lblSelectOrgType1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOrganizations;
    private javax.swing.JTextField txtFromTime;
    private javax.swing.JTextField txtToTime;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}