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
}