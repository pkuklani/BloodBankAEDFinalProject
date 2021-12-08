/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

//import business.
import business.Customer.CustomerDirectory;
import business.Restaurant.RestaurantDirectory;
import business.Organization.OrganizationDirectory;
import business.Restaurant.FoodmenuDirectory;
import business.DeliveryMan.DeliveryManDirectory;
import business.UserAccount.UserAccountDirectory;


/**
 *
 * @author pkuklani
 */
public class Business {

    private static Business business;
    private OrganizationDirectory organizationDirectory;
     private RestaurantDirectory restaurantDirectory;
      private CustomerDirectory customerDirectory;
     private FoodmenuDirectory foodmenuDirectory;
     private DeliveryManDirectory deliveryDirectory;
    // private UserAccountDirectory useraccountdirectory;

    public static Business getBusiness() {
        return business;
    }

    public static void setBusiness(Business business) {
        Business.business = business;
    }

   // public FoodmenuDirectory getFoodmenuDirectory() {
       // return foodmenuDirectory;
    //}

    //public void setFoodmenuDirectory(FoodmenuDirectory foodmenuDirectory) {
     //   this.foodmenuDirectory = foodmenuDirectory;
   // }

    public static Business getInstance() {
        if (business == null) {
            business = new Business();
        }
        return business;
    }

    public Business() {
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
