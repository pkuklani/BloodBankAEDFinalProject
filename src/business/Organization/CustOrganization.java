/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.LabTestRole;
import business.Role.Role;
import java.util.ArrayList;
import business.Role.CustRole;

/**
 *
 * @author pkuklani
 */
public class CustOrganization extends Organization{

    public CustOrganization() {
        super(Organization.Type.Cust.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CustRole());
        return roles;
    }
     
}