/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Employee;

import business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author pkuklani
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    
    public Employee createEmployee(String name, Customer cust){
        Employee employee = new Employee();
        employee.setName(name);
        employee.setCustomer(cust);
        employeeList.add(employee);
        return employee;
    }
}