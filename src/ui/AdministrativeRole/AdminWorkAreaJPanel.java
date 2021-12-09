

package ui.AdministrativeRole;

import business.Business;
import business.DeliveryMan.DeliveryManDirectory;
import business.Organization.AdminOrganization;
import business.Organization.Organization;
import business.Organization.CollectionCenterOrganization;
import business.Restaurant.CollectionCenter;
import business.Restaurant.CollectionCenterDirectory;      
import business.Restaurant.Foodmenu;
import business.Restaurant.FoodmenuDirectory;
import business.UserAccount.UserAccount;
import business.UserAccount.UserAccountDirectory;
import java.awt.CardLayout;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author  pkuklani
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Business business;
    private CollectionCenterDirectory restdirectory;
    private CollectionCenter restaurant;
    private Foodmenu foodmenu;
    private FoodmenuDirectory foodmenudirectory;
    /** Creates new form AdminWorkAreaJPanel */
     private JPanel workArea;
     private Organization organization;
    private business.DeliveryMan.DeliveryMan dorganization;
    private business.DeliveryMan.DeliveryManDirectory ddirectory;
       private UserAccount userAccount;
    private UserAccount userAccount1;
    private UserAccountDirectory Daccount;
    private DeliveryManDirectory dmanlist;
    private JPanel mainWorkArea;
    public AdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount account,UserAccount account1 ,Organization organization, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
          this.workArea = workArea;
        this.organization = organization;
        this.business = business;
        this.userAccount = account;
         this.userAccount1 = account1;
         // String foodname="/food1.jpg";
        // ImageIcon icon=createImageIcon(foodname,"x"); 
                               //   icon.getImage().flush();
                                //  icon = createImageIcon(foodname, "a");
       // userProcessContainer.imageUpdate(foodname, SOMEBITS, WIDTH, WIDTH, WIDTH, WIDTH);
    }
    
        public AdminWorkAreaJPanel(JPanel mainWorkArea, Business business) {
        initComponents();

        this.mainWorkArea = mainWorkArea;
        this.business = business;
        this.jPhotoPanel.removeAll();
        this.jPhotoPanel.revalidate();
        this.jPhotoPanel.repaint();
        try {
            BufferedImage myPicture = ImageIO.read(new File(Paths.get("admin.png").toAbsolutePath().toString()));
            ImageIcon ii = new ImageIcon(scaleImage(400, 400, myPicture));
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
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userJButton = new javax.swing.JButton();
        manageRestaurantnJButton = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        managerestmanager = new javax.swing.JButton();
        btnoverview1 = new javax.swing.JButton();
        jPhotoPanel = new javax.swing.JPanel();
        jPhotoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(424, 344));

        userJButton.setBackground(new java.awt.Color(255, 0, 0));
        userJButton.setText("All Users");
        userJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userJButtonActionPerformed(evt);
            }
        });

        manageRestaurantnJButton.setBackground(new java.awt.Color(255, 0, 0));
        manageRestaurantnJButton.setText("Manage Collection Centers");
        manageRestaurantnJButton.setMaximumSize(new java.awt.Dimension(176, 29));
        manageRestaurantnJButton.setMinimumSize(new java.awt.Dimension(176, 29));
        manageRestaurantnJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageRestaurantnJButtonActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Admin Functions");

        managerestmanager.setBackground(new java.awt.Color(255, 0, 0));
        managerestmanager.setText("Manage Staff");
        managerestmanager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerestmanagerActionPerformed(evt);
            }
        });

        btnoverview1.setBackground(new java.awt.Color(255, 0, 0));
        btnoverview1.setText("Analyse Orders");
        btnoverview1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoverview1ActionPerformed(evt);
            }
        });

        jPhotoLabel.setText("jLabel1");

        javax.swing.GroupLayout jPhotoPanelLayout = new javax.swing.GroupLayout(jPhotoPanel);
        jPhotoPanel.setLayout(jPhotoPanelLayout);
        jPhotoPanelLayout.setHorizontalGroup(
            jPhotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPhotoPanelLayout.createSequentialGroup()
                .addContainerGap(307, Short.MAX_VALUE)
                .addComponent(jPhotoLabel)
                .addGap(299, 299, 299))
        );
        jPhotoPanelLayout.setVerticalGroup(
            jPhotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPhotoPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jPhotoLabel)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 766, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(manageRestaurantnJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(managerestmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnoverview1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPhotoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblTitle)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manageRestaurantnJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(managerestmanager, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnoverview1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPhotoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void userJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel muajp = new ManageUserAccountJPanel(userProcessContainer, business);
        userProcessContainer.add("ManageUserAccountJPanel", muajp);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_userJButtonActionPerformed

    private void manageRestaurantnJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageRestaurantnJButtonActionPerformed

        ManageCollectionCenterJPanel manageRestJPanel = new ManageCollectionCenterJPanel(userProcessContainer,business.getRestaurantDirectory(),business.getOrganizationDirectory());
        userProcessContainer.add("manageRestaurantJPanel", manageRestJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageRestaurantnJButtonActionPerformed

    private void managerestmanagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerestmanagerActionPerformed
        // TODO add your handling code here:
          ManageEmployeeJPanel manageEmployeeJPanel = new ManageEmployeeJPanel(userProcessContainer, business.getOrganizationDirectory(), business);
        userProcessContainer.add("manageEmployeeJPanel", manageEmployeeJPanel);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        
    }//GEN-LAST:event_managerestmanagerActionPerformed

    private void btnoverview1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoverview1ActionPerformed
        // TODO add your handling code here:
    overviewWorkAreaJPanel overviewJPanel = new overviewWorkAreaJPanel( userProcessContainer, userAccount, userAccount1 ,organization,business);    
    userProcessContainer.add("overviewJPanel", overviewJPanel);
       CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnoverview1ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnoverview1;
    private javax.swing.JLabel jPhotoLabel;
    private javax.swing.JPanel jPhotoPanel;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JButton manageRestaurantnJButton;
    private javax.swing.JButton managerestmanager;
    private javax.swing.JButton userJButton;
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

    private class jPhotoPanel {

        private static void removeAll() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void revalidate() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        private static void repaint() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public jPhotoPanel() {
        }
    }
}
