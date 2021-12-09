/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.LabTestRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pkuklani
 */
public class DeliveryOrganization extends Organization{

    public DeliveryOrganization() {
        super(Organization.Type.Delivery.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new LabTestRole());
        return roles;
    }
     
}