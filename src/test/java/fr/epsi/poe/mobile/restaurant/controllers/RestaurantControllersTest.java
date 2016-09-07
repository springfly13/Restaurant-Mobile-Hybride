package fr.epsi.poe.mobile.restaurant.controllers;

import fr.epsi.poe.mobile.restaurant.models.Restaurant;


//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;

//import static org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.fail;
//import d'une methode. Tant que assertThat sont tres nombreux donc ils sont en mode "static"


/**
 * Created by Fly on 19/07/2016.
 */
public class RestaurantControllersTest {
    private RestaurantControllers restaurantControllers = new RestaurantControllers();
    /*@Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }*/

    @Test
    public void shouldThrowExceptionWhenIllegalParametersArePassed() throws Exception {
        try {
            restaurantControllers.getRestaurant(null, null);
            fail("No exception were trown whereas it should have");
        } catch (Exception exept){
            assertThat(exept).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude connot be empty")
                    .hasNoCause();

        }

        try {
            restaurantControllers.getRestaurant(0.0, 0.0);
            fail("No exception were trown whereas it should have");
        } catch (Exception exept2){
            assertThat(exept2).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("latitude and longitude connot be zero")
                    .hasNoCause();

        }
    }




}