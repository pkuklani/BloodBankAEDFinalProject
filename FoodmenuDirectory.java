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
 * @author akhil
 */
public class FoodmenuDirectory {
    private ArrayList<Foodmenu> foodmenuList;

    public FoodmenuDirectory() {
        foodmenuList = new ArrayList<Foodmenu>();
    }

    public ArrayList<Foodmenu> getFoodmenuList() {
        return foodmenuList;
    }
    
    public Foodmenu createFoodmenu(int id,String name){
        Foodmenu foodmenu = new Foodmenu();
        foodmenu.setFoodid(id);
        foodmenu.setFoodname(name);
        foodmenuList.add(foodmenu);
        return foodmenu;
    }
    public void deleteFoodmenu(Foodmenu vs)
    {foodmenuList.remove(vs);
    }
    
}
