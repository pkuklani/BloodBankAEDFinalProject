/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Role;

import bbank.Bbank;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author akhil
 */
public abstract   class Role {

   public String RoleType;

    public String getRoleType() {
        return RoleType;
    }

    public void setRoleType() {
        this.RoleType = RoleType;
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,String user,String RoleType);

   

  

  

}
