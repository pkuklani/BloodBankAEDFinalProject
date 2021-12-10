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
import ui.tech.ExtractcomponentJPanel;

/**
 *
 * @author akhil
 */
public class TechRole extends Role {
   

    public TechRole() {
        this.RoleType = "Tech";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user,String RoleType) {
        this.RoleType = "Tech";
        System.out.println("in techrole");
        return new ExtractcomponentJPanel(userProcessContainer,user,RoleType);
    }

   // @Override
   // public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
   //    System.out.println("in techrole over");
   //     return new ExtractcomponentJPanel(userProcessContainer, user,RoleType);
   // }
   
}

    

   
   
  


