/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbank.Donor;

//import business.Restaurant.Restaurant;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class DeliveryManDirectory {
      private ArrayList<DeliveryMan> deliverymanList;

    public ArrayList<DeliveryMan> getDeliverymanList() {
        return deliverymanList;
    }

    public void setDeliverymanList(ArrayList<DeliveryMan> deliverymanList) {
        this.deliverymanList = deliverymanList;
    }

    public DeliveryManDirectory() {
        deliverymanList = new ArrayList<DeliveryMan>();
    }

    public ArrayList<DeliveryMan> getDeliveryMan() {
        return deliverymanList;
    }
    
   // public DeliveryMan createDeliveryMan(String name){
     //   DeliveryMan deliveryman = new DeliveryMan();
     //   deliveryman.setDmanid(0);
      //  deliveryman.setDmanname(name);
      //  deliveryman.getDmanmobile();
      //   deliverymanList.add(deliveryman);
     //   return deliveryman;
   // }
  
    
}
