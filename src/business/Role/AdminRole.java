/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Business;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
import ui.AdministrativeRole.AdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author pkuklani
 */
public class AdminRole extends Role{
private UserAccount useraccount;
private UserAccount useraccount1;
    public AdminRole(){
        this.type = RoleType.Admin;
    }
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,UserAccount account1, Organization organization, Business business) {
        
        return new AdminWorkAreaJPanel(userProcessContainer,account,account1,organization, Business.getInstance());
    }

    
    
}
