/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Business;
import business.Organization.Organization;
import business.Organization.RestOrganization;
import business.UserAccount.UserAccount;
//import ui.DeliveryRole.DeliveryWorkAreaJPanel;
import javax.swing.JPanel;
import ui.RestRole.RestWorkAreaJPanel;

/**
 *
 * @author pkuklani
 */
public class RestRole extends Role {

    public RestRole() {
        this.type = RoleType.Rest;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,UserAccount account1, Organization organization, Business business) {
        this.type = RoleType.Rest;
        return new RestWorkAreaJPanel(userProcessContainer, account,account1,(RestOrganization) organization, business);
    }

}
