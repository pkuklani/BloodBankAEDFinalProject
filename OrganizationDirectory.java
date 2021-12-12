/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Delivery.getValue())){
           organization = new DeliveryOrganization();
           organizationList.add(organization);
        }
       else if (type.getValue().equals(Type.Rest.getValue())){
           organization = new RestOrganization();
           organizationList.add(organization);
       }
        return organization;
    }
}