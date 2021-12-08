/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Role;

import business.Business;
import business.Organization.CustOrganization;
import business.Organization.DeliveryOrganization;
import business.Organization.Organization;
import business.Organization.RestOrganization;
import business.UserAccount.UserAccount;
import java.io.FileNotFoundException;
import ui.DeliveryRole.DeliveryWorkAreaJPanel;
import javax.swing.JPanel;
import ui.CustRole.CustWorkAreaJPanel;
import ui.RestRole.RestWorkAreaJPanel;

/**
 *
 * @author pkuklani
 */
public class CustRole extends Role {

    public CustRole() {
        this.type = RoleType.Cust;
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, UserAccount account1, Organization organization, Business business) {
        this.type = RoleType.Cust;
        try {
            return new CustWorkAreaJPanel(userProcessContainer, account, account1, (CustOrganization) organization, business);
        } catch (Exception ex) {
            return null;
        }
    }

    /*public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, UserAccount account1, Organization organization, Business business) {
        this.type = RoleType.Delivery;
        return new DeliveryWorkAreaJPanel(userProcessContainer, account, account1, (DeliveryOrganization) organization, business);
    }*/
}
