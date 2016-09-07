package fr.epsi.poe.mobile.restaurant;
import fr.epsi.poe.mobile.restaurant.controllers.RestaurantControllers;
import fr.epsi.poe.mobile.restaurant.models.Restaurant;

import java.util.*;

/**
 * Created by Fly on 19/07/2016.
 */
public class RestaurantChooserApiApplication {

    public static void main (String [] args){
        double latitude, longitude;
        Scanner input = new Scanner(System.in);
        System.out.println("Please, enter your location : latitude and longitude. At first : latitude = as **,** ");
        latitude = input.nextDouble();
        System.out.println("Now input the longitude = as **,**");
        longitude = input.nextDouble();
       // System.out.println("Please, enter your reserche radius in metters : ");
        //int radius = input.nextInt();
        RestaurantControllers identifiants = new RestaurantControllers();
        List<Restaurant> listTampon = identifiants.getRestaurant(latitude,longitude);
        for (int i=0; i<listTampon.size(); i++){
            System.out.println(listTampon.get(i).getName() + " / " + listTampon.get(i).getVicinity());
        }

    }


}
