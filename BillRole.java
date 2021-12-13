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
import ui.Bill.GeneratebillJPanel;

/**
 *
 * @author akhil
 */
public class BillRole extends Role {
   

    public BillRole() {
        this.RoleType = "Bill-desk";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String user,String RoleType) {
        this.RoleType = "Bill-desk";
        System.out.println("in bill-desk role");
        return new GeneratebillJPanel(userProcessContainer,user,RoleType);
    }

   
   
}

    

   
   
  


