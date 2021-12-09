/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.Business;
import business.Customer.Customer;
import business.DB4OUtil.DB4OUtil;
import business.Organization.CustOrganization;
import business.Organization.Organization;
import business.Role.AdminRole;
import business.Role.CustRole;
import business.Role.LabTestRole;
import business.Role.ManagerRole;
import business.Role.Role;
import business.UserAccount.UserAccount;
import business.user;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ui.AdministrativeRole.ManageEmployeeJPanel;

/**
 *
 * @author pkuklani
 */
public class LoginScreen extends javax.swing.JPanel {

    JPanel mainWorkArea;
    Business business1;
    Business business;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen(JPanel mainWorkArea, Business business) {
        initComponents();

        this.mainWorkArea = mainWorkArea;
        this.business = business;
        this.jPhotoPanel.removeAll();
        this.jPhotoPanel.revalidate();
        this.jPhotoPanel.repaint();
        try {
            BufferedImage myPicture = ImageIO.read(new File(Paths.get("sLogo.png").toAbsolutePath().toString()));
            ImageIcon ii = new ImageIcon(scaleImage(900, 180, myPicture));
            jPhotoLabel.setIcon(ii);
            this.jPhotoLabel.setVisible(true);
            this.jPhotoPanel.add(new JLabel(ii));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static BufferedImage scaleImage(int w, int h, BufferedImage img) throws Exception {
        BufferedImage bi;
        bi = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(img, 0, 0, w, h, null);
        g2d.dispose();
        return bi;
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
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        pwdField = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPhotoPanel = new javax.swing.JPanel();
        jPhotoLabel = new javax.swing.JLabel();
        lblTitle1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();
        txtCustUserName = new javax.swing.JTextField();
        lblPassword1 = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        lblUserName1 = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        txtCustPassword = new javax.swing.JPasswordField();
        txtCustLastName = new javax.swing.JTextField();
        lblUserName2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("Username:");

        lblPassword.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPassword.setText("Password:");

        btnLogin.setBackground(new java.awt.Color(255, 0, 0));
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setMaximumSize(new java.awt.Dimension(356, 159));

        jPhotoPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPhotoLabel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPhotoPanelLayout = new javax.swing.GroupLayout(jPhotoPanel);
        jPhotoPanel.setLayout(jPhotoPanelLayout);
        jPhotoPanelLayout.setHorizontalGroup(
            jPhotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPhotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPhotoPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPhotoLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPhotoPanelLayout.setVerticalGroup(
            jPhotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPhotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPhotoPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPhotoLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lblTitle1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Not a DONOR yet? Register Now! ");

        lblUserName.setText("Username:");

        lblPassword1.setText("Password:");

        btnCreateUser.setBackground(new java.awt.Color(255, 0, 0));
        btnCreateUser.setText("Save a Life!");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        lblUserName1.setText("First Name:");

        lblUserName2.setText("Last Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                            .addComponent(lblPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCreateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCustUserName, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(txtCustName)
                                                .addComponent(txtCustPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtCustLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblUserName2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblUserName1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))))
                            .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser)
                            .addComponent(lblPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwdField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPhotoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(btnLogin)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblPassword, lblUser});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {pwdField, txtUserName});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPhotoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addGap(33, 33, 33)
                .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName1)
                    .addComponent(txtCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName2)
                    .addComponent(txtCustLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserName)
                    .addComponent(txtCustUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword1)
                    .addComponent(txtCustPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreateUser)
                .addGap(35, 35, 35))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // Get user name
        String userName = txtUserName.getText();
        // Get Password
        char[] passwordCharArray = pwdField.getPassword();
        String password = String.valueOf(passwordCharArray);
        boolean flag = false;

        UserAccount userAccount = null;
        UserAccount userAccount1 = null;
        //userAccount1 = organization.
        for (Organization organization : business.getOrganizationDirectory().getOrganizationList()) {

            userAccount = organization.getUserAccountDirectory().authenticateUser(userName, password);
            // userAccount1 = organization.getUserAccountDirectory().authenticateUser("tom", "tom");
            // userAccount1.setUsername("tom");
            // userAccount1.setPassword("tom");
            //  userAccount1.setRole((Type)"Cust");

            if (userAccount != null) {
                // validation
                for (Organization organization1 : business.getOrganizationDirectory().getOrganizationList()) {
                    userAccount1 = organization1.getUserAccountDirectory().authenticateUser("tom", "tom");
                    if (userAccount1 != null) {
                        break;
                    }
                }
                //

                JPanel mainScreen = new MainScreen(mainWorkArea, userAccount, userAccount1, organization, business);
                mainWorkArea.add("MainScreen", mainScreen);
                CardLayout layout = (CardLayout) mainWorkArea.getLayout();
                layout.next(mainWorkArea);

                flag = true;
                break;
            }
        }

        if (flag == false) {
            JOptionPane.showMessageDialog(null, "Invalid User Name/ Password.");
            return;
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        String name = txtCustName.getText();
        String lname = txtCustLastName.getText();
        String staticValidationMessage = "One or more issues found. Please resolve and click Save again.\n\n";
        String validationMessage = "";
        if (name.isEmpty() || name.isBlank()) {
            validationMessage += "First Name is required.";
        }
        if (lname.isEmpty() || lname.isBlank()) {
            validationMessage += "Last Name is required.";
        }
        if (txtCustUserName.getText().isEmpty() || txtCustUserName.getText().isBlank()) {
            if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
                validationMessage += "\n";
            }
            validationMessage += "User Name is required.";
        }
        if (txtCustPassword.getText().isEmpty()) {
            if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
                validationMessage += "\n";
            }
            validationMessage += "Password is required.";
        }
        if (!validationMessage.isBlank() && !validationMessage.isEmpty()) {
            JOptionPane.showMessageDialog(this, staticValidationMessage + validationMessage);
        } else {
            Organization organization = new CustOrganization();
            for (Organization org : business.getOrganizationDirectory().getOrganizationList()) {
                var organizType = org.getClass();
                if (organizType.getName().equals("business.Organization.CustOrganization")) {
                    organization = org;
                }
            }
            user fileuser = null;
            String userName = txtCustUserName.getText();
            String password = txtCustPassword.getText();
            Role role = new CustRole();
            Customer c = new Customer();
            c.setName(name + " " + lname);
            c.setfName(name);
            c.setlName(lname);
            var cust = business.getCustomerDirectory().createCustomer(c);
            var custEmployee = organization.getEmployeeDirectory().createEmployee(name, cust);
            var custUserAccount = organization.getUserAccountDirectory().createUserAccount(userName, password, custEmployee, role);
            System.out.println("calling stored fromuser form ");
            dB4OUtil.storeSystem(business);
            user u1 = new user();
            u1.setId(custEmployee.getId());
            u1.setName(name);
            u1.setUserid(userName);
            u1.setPassword(password);
            u1.setRole(role.toString());
            File yourFile = new File("user.txt");
            try {

                FileOutputStream fs = null;
                fs = new FileOutputStream("user.txt", true);
                if (yourFile.length() == 0) {
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(u1);
                    os.close();
                } else {
                    MyObjectOutputStream oos = null;
                    oos = new MyObjectOutputStream(fs);
                    oos.writeObject(u1);
                    oos.close();
                }
                System.out.print("added to file");
            } catch (Exception e) {
                System.out.println("Error Occurred" + e);
            }
            try {
                yourFile.createNewFile();
            } catch (Exception e) {
            }
            if (yourFile.length() != 0) {
                try {
                    FileInputStream fis = null;

                    fis = new FileInputStream(
                            "user.txt");
                    ObjectInputStream ois
                            = new ObjectInputStream(fis);

                    user u2 = null;

                    while (fis.available() != 0) {
                        u2 = (user) ois.readObject();
                        String uname = u2.getName();
                        System.out.println("id ==" + u2.getId());
                        System.out.println("name ==" + uname);
                        System.out.println("userid ==" + u2.getUserid());
                        System.out.println("password ==" + u2.getPassword());
                        System.out.println("role ==" + u2.getRole());
                    }
                    ois.close();
                    fis.close();
                } catch (Exception e) {
                    System.out.println("Error Occurred" + e);
                    e.printStackTrace();
                }
            }

            JOptionPane.showMessageDialog(null, "Customer Account created successfully. Please try logging in.");
            txtCustName.setText("");
            txtCustUserName.setText("");
            txtCustPassword.setText("");
    }//GEN-LAST:event_btnCreateUserActionPerformed
    }

    class MyObjectOutputStream extends ObjectOutputStream {

        // Constructor of ths class
        // 1. Default
        MyObjectOutputStream() throws IOException {

            // Super keyword refers to parent class instance
            super();
        }

        // Constructor of ths class
        // 1. Parameterized constructor
        MyObjectOutputStream(OutputStream o) throws IOException {
            super(o);
        }

        // Method of this class
        public void writeStreamHeader() throws IOException {
            return;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jPhotoLabel;
    private javax.swing.JPanel jPhotoPanel;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserName1;
    private javax.swing.JLabel lblUserName2;
    private javax.swing.JPasswordField pwdField;
    private javax.swing.JTextField txtCustLastName;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JPasswordField txtCustPassword;
    private javax.swing.JTextField txtCustUserName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

}
