/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import java.util.ArrayList;

/**
 *
 * @author pkuklani
 */
public class CustomerDirectory {
    
    private ArrayList<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    public Customer createCustomer(String name){
        Customer customer = new Customer();
        customer.getId();
        customer.setName(name);
        customerList.add(customer);
        return customer;
    }
    
    public Customer createCustomer(Customer cModel){
        Customer customer = new Customer();
        customer.getId();
        customer.setName(cModel.getName());
        customer.setfName(cModel.getfName());
        customer.setlName(cModel.getlName());
        customer.setDob(cModel.getDob());
        customer.setGender(cModel.getGender());
        customer.setTelNo(cModel.getTelNo());
        customer.setCity(cModel.getCity());
        customer.setState(cModel.getState());
        customer.setZipCode(cModel.getZipCode());
        customer.setBloodGroup(cModel.getBloodGroup());
        customerList.add(customer);
        return customer;
    }
}