/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank;

//import business.
import business.Customer.CustomerDirectory;
import business.Restaurant.RestaurantDirectory;
import business.Organization.OrganizationDirectory;
import business.Restaurant.FoodmenuDirectory;
import bbank.Donor.DeliveryManDirectory;
import business.UserAccount.UserAccountDirectory;


/**
 *
 * @author akhil
 */
public class Bbank {

    private static Bbank business;
    private OrganizationDirectory organizationDirectory;
     private RestaurantDirectory restaurantDirectory;
      private CustomerDirectory customerDirectory;
     private FoodmenuDirectory foodmenuDirectory;
     private DeliveryManDirectory deliveryDirectory;
    // private UserAccountDirectory useraccountdirectory;

    public static Bbank getBusiness() {
        return business;
    }

    public static void setBusiness(Bbank business) {
        Bbank.business = business;
    }

   // public FoodmenuDirectory getFoodmenuDirectory() {
       // return foodmenuDirectory;
    //}

    //public void setFoodmenuDirectory(FoodmenuDirectory foodmenuDirectory) {
     //   this.foodmenuDirectory = foodmenuDirectory;
   // }

    public static Bbank getInstance() {
        if (business == null) {
            business = new Bbank();
        }
        return business;
    }

    public Bbank() {
        organizationDirectory = new OrganizationDirectory();
        restaurantDirectory= new RestaurantDirectory();
         customerDirectory= new CustomerDirectory();
        foodmenuDirectory=new FoodmenuDirectory();
        deliveryDirectory=new DeliveryManDirectory();
       // useraccountdirectory=new UserAccountDirectory();
    }

    //public UserAccountDirectory getUseraccountdirectory() {
      //  return useraccountdirectory;
  //  }

  //  public void setUseraccountdirectory(UserAccountDirectory useraccountdirectory) {
   //     this.useraccountdirectory = useraccountdirectory;
   // }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
     public RestaurantDirectory getRestaurantDirectory() {
        return restaurantDirectory;
    }
      public CustomerDirectory getCustomerDirectory() {
        return customerDirectory;
    }
     public FoodmenuDirectory getFoodmenuDirectory(){
         return foodmenuDirectory;
     }

    public DeliveryManDirectory getDeliveryDirectory() {
        return deliveryDirectory;
    }

    public void setDeliveryDirectory(DeliveryManDirectory deliveryDirectory) {
        this.deliveryDirectory = deliveryDirectory;
    }
    
}
