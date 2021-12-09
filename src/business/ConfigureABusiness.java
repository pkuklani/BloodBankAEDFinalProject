/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.DeliveryMan.DeliveryMan;
import business.Employee.Employee;
import business.Organization.AdminOrganization;
import business.Organization.CustOrganization;
import business.Organization.DeliveryOrganization;
import business.Organization.CollectionCenterOrganization;
import business.Organization.OrganizationDirectory;
import business.Organization.Organization;
import business.Role.AdminRole;
import business.Role.ManagerRole;
import business.Role.CustRole;
import business.Role.LabTestRole;
import business.UserAccount.UserAccount;
import business.Restaurant.Foodmenu;
import business.Restaurant.FoodmenuDirectory;
import business.WorkQueue.WorkRequest;
import business.DeliveryMan.DeliveryManDirectory;
import business.Restaurant.CollectionCenter;
import business.user;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 *
 * @author pkuklani
 */
public class ConfigureABusiness {

    private business.DeliveryMan.DeliveryManDirectory ddirectory;

    //private 
    public static Business configure() throws FileNotFoundException, IOException {
        //  private business.DeliveryMan.DeliveryManDirectory ddirectory;
        Business business = Business.getInstance();
        // DeliveryMan =dman;
        AdminOrganization adminOrganization = new AdminOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(adminOrganization);
        // admin    
        user u1 = new user();
        Employee employee = new Employee();
        employee.setName("Priyanka Kuklani");
        Foodmenu foodmenu = new Foodmenu();
        FoodmenuDirectory foodmenudirectory = new FoodmenuDirectory();
        foodmenu.setFoodid(1);
        foodmenu.setFoodname("B+");
        foodmenudirectory.createFoodmenu(1, "B+");
        foodmenudirectory.getFoodmenuList().add(foodmenu);
        foodmenu.setFoodid(2);
        foodmenu.setFoodname("O+");
        foodmenudirectory.createFoodmenu(2, "O+");
        foodmenudirectory.getFoodmenuList().add(foodmenu);
        foodmenu.setFoodid(3);
        foodmenu.setFoodname("AB+");
        foodmenudirectory.createFoodmenu(3, "AB+");
        foodmenudirectory.getFoodmenuList().add(foodmenu);
        foodmenu.setFoodid(4);
        foodmenu.setFoodname("AB-");
        foodmenudirectory.createFoodmenu(4, "AB-");
        foodmenudirectory.getFoodmenuList().add(foodmenu);
        UserAccount account = new UserAccount();
        account.setUsername("admin");
        account.setPassword("admin");
        account.setRole(new AdminRole());
        account.setEmployee(employee);
        u1.setUserid("admin");
        u1.setId(1);
        u1.setPassword("admin");
        u1.setRole("Admin");
        try {
            FileOutputStream fs = new FileOutputStream("users.dat");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(u1);
            os.close();
        } catch (FileNotFoundException e) {
            FileOutputStream fs = new FileOutputStream(new File("user.dat"));
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(u1);
            os.close();

        }
        account.setPassword("admin");
        account.setRole(new AdminRole());
        adminOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account);

        //  
        // Delivery 
        Employee employee2 = new Employee();
        DeliveryMan dman = new DeliveryMan();
        UserAccount account2 = new UserAccount();
        DeliveryOrganization deliveryOrganization = new DeliveryOrganization();
        DeliveryManDirectory dmanlist = new DeliveryManDirectory();
        business.getOrganizationDirectory().getOrganizationList().add(deliveryOrganization);
        employee2.setName("sam");
        account2.setUsername("sam");
        account2.setPassword("sam");
        account2.setRole(new LabTestRole());
        account2.setEmployee(employee2);
        dman.setDmanid(1);
        dman.setDmanname("sam");
        deliveryOrganization.getEmployeeDirectory().getEmployeeList().add(employee2);
        deliveryOrganization.getUserAccountDirectory().getUserAccountList().add(account2);
        dmanlist.getDeliverymanList().add(dman);
        business.getDeliveryDirectory().getDeliveryMan().add(dman);
        
        //
        // Rest   
        Employee employee1 = new Employee();
        UserAccount account1 = new UserAccount();
        CollectionCenterOrganization restOrganization = new CollectionCenterOrganization();
        restOrganization.setName("Boston Blood Center");
        business.getOrganizationDirectory().getOrganizationList().add(restOrganization);
        business.getRestaurantDirectory().createRestaurant(0, "Boston Blood Center", "Boston Downtown", "09:00", "17:00");
        employee1.setName("Ray");
        account1.setUsername("ray");
        account1.setPassword("ray");
        account1.setRole(new ManagerRole());
        account1.setEmployee(employee1);
        restOrganization.getEmployeeDirectory().getEmployeeList().add(employee1);
        restOrganization.getUserAccountDirectory().getUserAccountList().add(account1);
        
        //  
        // Customer 
        //  DeliveryMan dman=new DeliveryMan();
        Employee employee3 = new Employee();
        UserAccount account3 = new UserAccount();
        CustOrganization custOrganization = new CustOrganization();
        business.getOrganizationDirectory().getOrganizationList().add(custOrganization);
        employee3.setName("Tom");
        account3.setUsername("tom");
        account3.setPassword("tom");
        account3.setRole(new CustRole());
        account3.setEmployee(employee3);
        custOrganization.getEmployeeDirectory().getEmployeeList().add(employee3);
        custOrganization.getUserAccountDirectory().getUserAccountList().add(account3);
        //reading from txt file and adding to list
        // reading back
        File yourFile = new File("user.txt");
        try {

            // Creating new file using File object above
            yourFile.createNewFile();
        } // Catch block to handle the exception
        catch (FileNotFoundException e) {
        }
        ////////////
        // If the file is empty
        if (yourFile.length() != 0) {

            try {

                // If file doesn't exists
                FileInputStream fis = null;

                fis = new FileInputStream(
                        "user.txt");
                ObjectInputStream ois
                        = new ObjectInputStream(fis);

                user u2 = null;

                while (fis.available() != 0) {
                    u2 = (user) ois.readObject();
                    String name = u2.getName();
                    System.out.println("name ==" + name);
                    String role = u2.getRole();
                    System.out.println("role ==" + role);
                    System.out.println("userid ==" + u2.getPassword());
                    System.out.println("password ==" + u2.getPassword());
                    dman = new DeliveryMan();
                    employee = new Employee();
                    account = new UserAccount();
                    employee.setName(u2.getName());

                    account.setUsername(u2.getUserid());
                    account.setPassword(u2.getPassword());
                    // account.setRole(new AdminRole());
                    account.setEmployee(employee);
                    if (role == "Admin") {
                        account.setRole(new AdminRole());
                        adminOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
                        adminOrganization.getUserAccountDirectory().getUserAccountList().add(account);
                    }
                    if (role == "Restaurant") {
                        account.setRole(new ManagerRole());
                        restOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
                        restOrganization.getUserAccountDirectory().getUserAccountList().add(account);
                    }
                    if (role.equalsIgnoreCase("Delivery")) {
                        account.setRole(new LabTestRole());
                        System.out.println("inside if delivery :" + account.getUsername());
                        dman.setDmanid(u2.getId());
                        dman.setDmanname(u2.getName());
                        System.out.println(" delivery dman:" + dman.getDmanname());
                        deliveryOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
                        deliveryOrganization.getUserAccountDirectory().getUserAccountList().add(account);
                        dmanlist.getDeliverymanList().add(dman);
                    }
                    if (role == "Customer") {
                        account.setRole(new CustRole());
                        custOrganization.getEmployeeDirectory().getEmployeeList().add(employee);
                        custOrganization.getUserAccountDirectory().getUserAccountList().add(account);
                    }
                }

                // Closing the connection to release memory
                // resources using close() method
                ois.close();
                fis.close();

                // Once all connection are closed after the
                // desired action change the flag state
            } // Catch block to handle the exception // Catch block to handle the exception // Catch block to handle the exception // Catch block to handle the exception
            catch (Exception e) {

                // Print the exception on the console
                // along with display message
                System.out.println("Error Occurred" + e);

                // Exception encountered line is also
                // displayed on console using the
                // printStackTrace() method
                e.printStackTrace();
            }
        }

        //reading from txt file and adding to list
        //add static order
        File yourFile1 = new File("order.txt");
        try {

            // Creating new file using File object above
            yourFile1.createNewFile();
        } // Catch block to handle the exception
        //catch (Exception e) {
        //}
        catch (FileNotFoundException e) {
        }

        WorkRequest request = new WorkRequest();
        if (yourFile1.length() == 0) {
            request.setMessage("Burger");
            request.setSender(account3);
            request.setStatus("Pending");
            Date now = new Date();
            request.setRequestDate(now);
            request.setId(1);
            request.setCustname("Tom");
            // userAccount1.setUsername("not assigned");
            // request.setReceiver(userAccount1);
            request.setUsertype(1);
            account3.getWorkQueue().getWorkRequestList().add(request);
        }
//custOrganization.setWorkQueue(

//reading text customer order
        //reading from txt file and adding to list
        // reading back
        //  File yourFile1 = new File("order.txt");
        //  try {
        // Creating new file using File object above
        //   yourFile1.createNewFile();
        // }
        // Catch block to handle the exception
        //catch (Exception e) {
        //}
        ////////////
        // If the file is empty
        if (yourFile1.length() != 0) {

            try {

                // If file doesn't exists
                FileInputStream fis = null;

                fis = new FileInputStream(
                        "order.txt");
                ObjectInputStream ois
                        = new ObjectInputStream(fis);

                order u2 = null;

                while (fis.available() != 0) {
                    u2 = (order) ois.readObject();

                    System.out.println("food ==" + u2.getFood());
                    System.out.println("customer ==" + u2.getCustname());
                    request = new WorkRequest();
                    request.setMessage(u2.getFood());
                    // request.setSender(u2.getCustname());
                    request.setStatus(u2.getStatus());

                    request.setRequestDate(u2.getRequestDate());
                    request.setId(u2.getId());
                    request.setCustname(u2.getCustname());
                    request.setRestName(u2.getRestName());
                    request.setFeedback(u2.getFeedback());
                    request.setDname(u2.getDname());
                    request.setResolveDate(u2.getResolveDate());
                    // userAccount1.setUsername("not assigned");
                    // request.setReceiver(userAccount1);
                    request.setUsertype(1);
                    account3.getWorkQueue().getWorkRequestList().add(request);
                }

                // Closing the connection to release memory
                // resources using close() method
                ois.close();
                fis.close();

                // Once all connection are closed after the
                // desired action change the flag state
            } // Catch block to handle the exception
            catch (Exception e) {

                // Print the exception on the console
                // along with display message
                System.out.println("Error Occurred" + e);

                // Exception encountered line is also
                // displayed on console using the
                // printStackTrace() method
                e.printStackTrace();
            }
        }

        //reading from txt file and adding to list
//reading text customer order
        return business;
    }

}
