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
import ui.Stores.StoresWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class StoresRole extends Role {
   

    public StoresRole() {
        this.RoleType = "Stores";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer,String user,String RoleType) {
        this.RoleType = "Stores";
        System.out.println("in storesrole");
        return new StoresWorkAreaJPanel(userProcessContainer, user,RoleType);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
       System.out.println("in storesrole over");
        return new StoresWorkAreaJPanel(userProcessContainer, user,RoleType);
    }
   
}

    

   
   
  


