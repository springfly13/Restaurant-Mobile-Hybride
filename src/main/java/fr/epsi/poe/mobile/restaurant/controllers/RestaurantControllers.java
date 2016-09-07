package fr.epsi.poe.mobile.restaurant.controllers;

import fr.epsi.poe.mobile.restaurant.models.Restaurant;
import fr.epsi.poe.mobile.restaurant.services.RestaurantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by Fly on 19/07/2016.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api/restaurants")

public class RestaurantControllers {

    //private RestaurantServices restaurantServices = new RestaurantServices();
    @Autowired
    private RestaurantServices restaurantServices;
    @RequestMapping(value="/nearby",method = RequestMethod.GET) // @RequestMapping("/neaby")
    public List<Restaurant> getRestaurant (@RequestParam Double latitude, @RequestParam Double longitude) throws IllegalArgumentException {
       //getRestaurants(lgt, longitude){
        if (latitude ==null || longitude == null) {
            throw new IllegalArgumentException("latitude and longitude connot be empty");
        }
        if (latitude ==0 || longitude ==0) {
            throw new IllegalArgumentException("latitude and longitude connot be zero");
        }


        //List<Restaurant> res = new ArrayList<>();
        return restaurantServices.getRestaurantsFromGoogle(latitude, longitude );
        //return res;
    }



}
