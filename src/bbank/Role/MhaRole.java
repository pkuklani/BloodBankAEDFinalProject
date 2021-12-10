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
import ui.MhaRole.MhaWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class MhaRole extends Role {
   

    public MhaRole() {
        this.RoleType = "MHA";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String RoleType) {
        this.RoleType = "MHA";
        System.out.println("in mharole");
        return new MhaWorkAreaJPanel(userProcessContainer, account,RoleType);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
       System.out.println("in mharole over");
        return new MhaWorkAreaJPanel(userProcessContainer, account,RoleType);
    }
   
}

    

   
   
  


