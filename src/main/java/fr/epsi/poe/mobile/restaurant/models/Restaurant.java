package fr.epsi.poe.mobile.restaurant.models;

import com.google.maps.model.Photo;

/**
 * Created by Fly on 13/07/2016.
 */
public class Restaurant {

    // Restaurant location

    private Geometry geometry;
    private String photos;
    private Photo photo;
    private Opening_hours oprning_hours;
    private String reference;
    private String scope;
    private String vicinity;
    private int price_level;
    private double rating;
    private String contentType;
    private byte[] imageData;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    private String icon;
    private String name;
    private String place_id;

    public Restaurant() {
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }








}
