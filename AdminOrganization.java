/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Organization;

//import bbank.Role.AdminRole;
import bbank.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author akhil
 */
public class AdminOrganization extends Organization{

    public AdminOrganization() {
        super(Type.Admin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
     
}
