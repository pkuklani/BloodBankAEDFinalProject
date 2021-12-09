/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Role.ManagerRole;
import business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author pkuklani
 */
public class CollectionCenterOrganization extends Organization{

    public CollectionCenterOrganization() {
        super(Organization.Type.Rest.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManagerRole());
        return roles;
    }
     
   
    
    
}
