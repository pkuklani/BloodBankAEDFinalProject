/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Restaurant;

//import Restaurant
import java.util.ArrayList;

/**
 *
 * @author pkuklani
 */
public class CollectionCenterDirectory {
    private ArrayList<CollectionCenter> restaurantList;
    private int maxID = 0;
    public CollectionCenterDirectory() {
        restaurantList = new ArrayList<CollectionCenter>();
    }

    public ArrayList<CollectionCenter> getRestaurantList() {
        return restaurantList;
    }
    
    public CollectionCenter createRestaurant(int id,String name, String restadd, String openFrom, String openTo){
        CollectionCenter restaurant = new CollectionCenter();
        maxID++;
        restaurant.setRestid(maxID);
        restaurant.setRestname(name);
        restaurant.setRestadd(restadd);
        restaurant.setOpenFrom(openFrom);
        restaurant.setOpenTo(openTo);
        restaurantList.add(restaurant);
        return restaurant;
    }
    public void deleteRestaurant(CollectionCenter vs)
    {
        restaurantList.remove(vs);
    }
    
}
