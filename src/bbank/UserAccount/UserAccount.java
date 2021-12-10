/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.UserAccount;

import bbank.Employee.Employee;
import bbank.Role.Role;
import bbank.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private String name;
    private String role;
   private int status;

    public UserAccount() {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}