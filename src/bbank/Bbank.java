/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank;

//import business.

import bbank.Donor.DeliveryManDirectory;
import bbank.UserAccount.UserAccountDirectory;


/**
 *
 * @author akhil
 */
public class Bbank {

    private static Bbank business;
       
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
             
        deliveryDirectory=new DeliveryManDirectory();
       // useraccountdirectory=new UserAccountDirectory();
    }

    //public UserAccountDirectory getUseraccountdirectory() {
      //  return useraccountdirectory;
  //  }

  //  public void setUseraccountdirectory(UserAccountDirectory useraccountdirectory) {
   //     this.useraccountdirectory = useraccountdirectory;
   // }

  
     

    public DeliveryManDirectory getDeliveryDirectory() {
        return deliveryDirectory;
    }

    public void setDeliveryDirectory(DeliveryManDirectory deliveryDirectory) {
        this.deliveryDirectory = deliveryDirectory;
    }
    
}
