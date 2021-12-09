/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Business;
import business.Organization.DeliveryOrganization;
import business.Organization.Organization;
import business.UserAccount.UserAccount;
//import ui.RestRole.RestWorkAreaJPanel;
import javax.swing.JPanel;
import ui.DeliveryRole.DeliveryWorkAreaJPanel;

/**
 *
 * @author pkuklani
 */
public class LabTestRole extends Role {

    public LabTestRole() {
        this.type = RoleType.Delivery;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,UserAccount account1, Organization organization, Business business) {
        this.type = RoleType.Delivery;
        return new DeliveryWorkAreaJPanel(userProcessContainer, account,account1, (DeliveryOrganization) organization, business);
    }

}
