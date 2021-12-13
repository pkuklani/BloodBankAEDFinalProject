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
import ui.NgoRole.NGOWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class NgoRole extends Role {
   

    public NgoRole() {
        this.RoleType = "NGO";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String RoleType) {
        this.RoleType = "NGO";
        System.out.println("in NGOrole");
        return new NGOWorkAreaJPanel(userProcessContainer, account,RoleType);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
       System.out.println("in NGO role over");
        return new NGOWorkAreaJPanel(userProcessContainer, account,RoleType);
    }
   
}

    

   
   
  


