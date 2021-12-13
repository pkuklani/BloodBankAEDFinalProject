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
import ui.Lab.LabtestJPanel;

/**
 *
 * @author akhil
 */
public class LabRole extends Role {
   

    public LabRole() {
        this.RoleType = "LAB";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType)  {
        this.RoleType = "LAB";
        System.out.println("in labrole");
        return new LabtestJPanel(userProcessContainer);
    }

    //@Override
   //public JPanel createWorkArea(JPanel userProcessContainer) {
   //    System.out.println("in labrole over");
   //     return new LabtestJPanel(userProcessContainer);
   // }
   
}

    

   
   
  


