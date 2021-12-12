/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Role;

import bbank.Bbank;
import business.Organization.DeliveryOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
//import ui.RestRole.RestWorkAreaJPanel;
import javax.swing.JPanel;
import ui.DonorRole.DonorWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class BbankRole extends Role {
   

    public BbankRole() {
        this.RoleType = "Bbank";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String RoleType) {
        this.RoleType = "Donor";
        return new DonorWorkAreaJPanel(userProcessContainer, account,RoleType);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
        return new DonorWorkAreaJPanel(userProcessContainer, account,RoleType);
    }
   
}

    

   
   
  


