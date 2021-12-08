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
public class RestaurantDirectory {
    private ArrayList<Restaurant> restaurantList;
    private int maxID = 0;
    public RestaurantDirectory() {
        restaurantList = new ArrayList<Restaurant>();
    }

    public ArrayList<Restaurant> getRestaurantList() {
        return restaurantList;
    }
    
    public Restaurant createRestaurant(int id,String name, String restadd){
        Restaurant restaurant = new Restaurant();
        maxID++;
        restaurant.setRestid(maxID);
        restaurant.setRestname(name);
        restaurant.setRestadd(restadd);
        restaurantList.add(restaurant);
        return restaurant;
    }
    public void deleteRestaurant(Restaurant vs)
    {
        restaurantList.remove(vs);
    }
    
}
