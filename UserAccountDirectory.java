/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.UserAccount;

import bbank.Employee.Employee;
import bbank.Role.Role;
import bbank.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    
    
    public UserAccount createUserAccount(String username, String password, String name, String role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(password);
       userAccount.setStatus(1);
       userAccount.setName(name);
       userAccount.setRole(role);
        userAccountList.add(userAccount);
        return userAccount;
    }
      public void deluserAccount(UserAccount vs)
    {userAccountList.remove(vs);
    }
}
