package fr.epsi.poe.mobile.restaurant.services;

import com.google.maps.model.PlacesSearchResponse;
import fr.epsi.poe.mobile.restaurant.models.Restaurant;
import org.junit.Test;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;

import static org.junit.Assert.*;

/**
 * Created by Fly on 19/07/2016.
 */
public class RestaurantServicesTest {
    private RestaurantServices restaurantServices = new RestaurantServices();
    double latitude = 45.764;
    double longitude = 4.8325;

   @Test
    public void shouldReturnAListOfRestaurants() {
        List<Restaurant> restaurantList = restaurantServices.getRestaurantsFromGoogle(latitude, longitude);
        assertThat(restaurantList).isEmpty();

    }

    @Test
    public void googleResponse (){
        PlacesSearchResponse resultatDeRecherche = restaurantServices.callGoogle(latitude,longitude);
        assertThat(resultatDeRecherche.results).isNotEmpty();
        //for (int i=0; i<resultatDeRecherche.results.length; i++) System.out.println(resultatDeRecherche.results[i].name);
    }

    @Test
    public void verificationOfListOfRestaurants (){
        List<Restaurant> listCreated = restaurantServices.getRestaurantsFromGoogle(latitude, longitude);
        assertThat(listCreated).isNotEmpty();
        for (int i=0; i<listCreated.size(); i++){
            System.out.println(listCreated.get(i).getName()+ " " + listCreated.get(i).getVicinity() );
        }
    }



}