package fr.epsi.poe.mobile.restaurant.services;

import com.google.maps.*;
import com.google.maps.model.*;
import fr.epsi.poe.mobile.restaurant.models.Restaurant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fly on 19/07/2016.
 */

@Service

public class RestaurantServices {
    @Value("${myapp.google_api_key}")
    private String cleApi ;


    private String url;

    private String type;

    @Value("${is_it_open_now}")
    private Boolean openNow;

    @Value("${radius_of_search}")
    private int radius;

    public List<Restaurant> getRestaurantsFromGoogle (Double latitude, Double longitude) throws IllegalArgumentException {
        List<Restaurant> res = new ArrayList<>();
        PlacesSearchResponse reponseDeGoogle = callGoogle(latitude, longitude);



        for (int i=0; i<reponseDeGoogle.results.length; i++) {
            Restaurant newRestaurantFromGoogle = new Restaurant();
            newRestaurantFromGoogle.setName(reponseDeGoogle.results[i].name);
            newRestaurantFromGoogle.setVicinity(reponseDeGoogle.results[i].vicinity);
            newRestaurantFromGoogle.setIcon(reponseDeGoogle.results[i].icon.toString());

            //String ref = reponseDeGoogle.results[i].photos[0].photoReference;
            //newRestaurantFromGoogle.setPhotos(reponseDeGoogle.results[i].photos[0].photoReference);
            if (reponseDeGoogle.results[i].photos != null && reponseDeGoogle.results[i].photos.length > 0) {
                newRestaurantFromGoogle.setPhotos(reponseDeGoogle.results[i].photos[0].photoReference);
                //else newRestaurantFromGoogle.setPhotos("");

                try {
                    //if (ref != null && ref.length() > 0) {
                       // PhotoResult photoIdent = callPhoto(ref);
                        PhotoResult photoIdent = callPhoto(reponseDeGoogle.results[i].photos[0].photoReference);
                        newRestaurantFromGoogle.setImageData(photoIdent.imageData);
                        newRestaurantFromGoogle.setContentType(photoIdent.contentType);
                   // }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
                //newRestaurantFromGoogle.setPhotos(ref);




            //(reponseDeGoogle.results[i].photos != null && reponseDeGoogle.results[i].photos.length >0)
               //     ? newRestaurantFromGoogle.setPhotos(reponseDeGoogle.results[i].photos[0].photoReference.toString()):"";

            //newRestaurantFromGoogle.setPhotos(reponseDeGoogle.results[i].photos[0].photoReference.toString());


            res.add(newRestaurantFromGoogle); //on ajoute une copie du restaurent qu'on vient de creer
        }
        return res;

    }

    protected  PlacesSearchResponse callGoogle (Double latitude, Double longitude)throws IllegalArgumentException {
        //protected - le controlleur ne peut pas acceder, cette methode reste accessible pour le test

        PlacesSearchResponse placeResult = null;
        GeoApiContext context = new GeoApiContext().setApiKey(cleApi);
        NearbySearchRequest request = PlacesApi.nearbySearchQuery( context ,new LatLng(latitude, longitude));
        //request.openNow(false);
        request.radius(500);
        request.type(PlaceType.RESTAURANT);

        String paramPageToken = "";
        request.pageToken(paramPageToken);

        //System.out.println (request);

      //  for (int j=0; j<2; j++){
            try {
                placeResult = request.await();
                //request.pageToken(paramPageToken);
                //placesResult.results - le resultat est un tableau
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
           paramPageToken = placeResult.nextPageToken;

       // }

        return placeResult;


    }



    protected PhotoResult callPhoto (String reference)throws IllegalArgumentException {
        //protected - le controlleur ne peut pas acceder, cette methode reste accessible pour le test

        PhotoResult photoResult = null;
        GeoApiContext context = new GeoApiContext().setApiKey(cleApi);
        PhotoRequest request = PlacesApi.photo(context, reference);
              //  PhotoRequest (context,reference ) ;
              //  PlacesApi.nearbySearchQuery( context ,new LatLng(latitude, longitude));
        //request.openNow(false);
       // request.photoReference(reference);
        request.maxWidth(400);
        request.maxHeight(400);
        //System.out.println (request);

        try{
            photoResult = request.await();
            //placesResult.results - le resultat est un tableau
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return photoResult;


    }



}



