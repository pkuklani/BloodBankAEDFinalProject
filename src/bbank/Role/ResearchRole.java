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
import ui.Research.CheckinfectionJPanel;

/**
 *
 * @author akhil
 */
public class ResearchRole extends Role {
   

    public ResearchRole() {
        this.RoleType = "Research";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String user,String RoleType) {
        this.RoleType = "Research";
        System.out.println("in Researchrole");
        return new CheckinfectionJPanel(userProcessContainer, user,RoleType);
    }

   
   
}

    

   
   
  


