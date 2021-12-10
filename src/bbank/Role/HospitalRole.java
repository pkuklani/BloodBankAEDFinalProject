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
import ui.Hospital.HospitalWorkAreaJPanel;

/**
 *
 * @author akhil
 */
public class HospitalRole extends Role {
   

    public HospitalRole() {
        this.RoleType = "Hospital";
    }

   //DonarRole role=new DonarRole();
   String RoleType;
 //@Override    
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String user,String RoleType) {
        this.RoleType = "Hospital";
        System.out.println("in Hospitalrole");
        return new HospitalWorkAreaJPanel(userProcessContainer, account,user,RoleType);
    }

   
   
}

    

   
   
  


