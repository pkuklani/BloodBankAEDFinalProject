/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Role;

import bbank.Bbank;
import bbank.UserAccount.UserAccount;
//import ui.RestRole.RestWorkAreaJPanel;
import javax.swing.JPanel;
import ui.AdministrativeRole.AdminWorkAreaJPanel;
import ui.DonorRole.DonorWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class AdminRole extends Role {
   

    public AdminRole() {
        this.RoleType = "Admin";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String user,String RoleType) {
        this.RoleType = "Admin";
        System.out.println("in adminrole....");
        return new AdminWorkAreaJPanel(userProcessContainer, account,user,RoleType);
    }

    //@Override
   // public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
   //    System.out.println("in adminrole over");
   //     return new AdminWorkAreaJPanel(userProcessContainer, account,user,RoleType);
   // }
   
}

    

   
   
  


