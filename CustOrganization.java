/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import bbank.Role.DonarRole;
import bbank.Role.Role;
import java.util.ArrayList;


/**
 *
 * @author raunak
 */
public class CustOrganization extends Organization{

    public CustOrganization() {
        super(Organization.Type.Cust.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DonarRole());
        return roles;
    }
     
}