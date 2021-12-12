/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

//import bbank.Role.BbankRole;
import bbank.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class RestOrganization extends Organization{

    public RestOrganization() {
        super(Organization.Type.Rest.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
     
   
    
    
}
