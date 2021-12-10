/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Role;

import bbank.Bbank;
import bbank.UserAccount.UserAccount;
//import ui.RestRole.RestWorkAreaJPanel;
import javax.swing.JPanel;
import ui.AdministrativeRole.BbankWorkAreaJPanel;

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
  //  public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String RoleType) {
   //     this.RoleType = "Bbank";
   //     return new BbankWorkAreaJPanel(userProcessContainer, account,RoleType);
   // }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, String user, String RoleType) {
       this.RoleType = "Bbank";
        return new BbankWorkAreaJPanel(userProcessContainer, account,user,RoleType);
    }
   
}

    

   
   
  


