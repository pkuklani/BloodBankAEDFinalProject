/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Customer;

import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class CustomerDirectory {
    
    private ArrayList<Customer> customerList;

    public CustomerDirectory() {
        customerList = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }
    
    public Customer createCustomer(){
        Customer customer = new Customer();
        customer.setId(0);
        customer.setName("hello");
        customerList.add(customer);
        return customer;
    }
}