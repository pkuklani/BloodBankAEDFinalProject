/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Role;

import bbank.Bbank;
import bbank.UserAccount.UserAccount;
//import ui.RestRole.RestWorkAreaJPanel;
import javax.swing.JPanel;
import ui.DonorRole.DonorWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class DonarRole extends Role {
   

    public DonarRole() {
        this.RoleType = "Donor";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String RoleType) {
        this.RoleType = "Donor";
        System.out.println("in donorrole");
        return new DonorWorkAreaJPanel(userProcessContainer, account,RoleType);
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
       this.RoleType = "Donor";
        System.out.println("in donorrole over");
        return new DonorWorkAreaJPanel(userProcessContainer, account,RoleType);
    }
   
}

    

   
   
  


