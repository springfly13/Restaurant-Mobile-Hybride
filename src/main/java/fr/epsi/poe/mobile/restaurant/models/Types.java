package fr.epsi.poe.mobile.restaurant.models;

/**
 * Created by Fly on 13/07/2016.
 */
public enum  Types {
    FOOD ("food"),
    ESTABLISHMENT("establishment"),
    POINT_OF_INTEREST("point_of_interest");

private String typeName;
    Types(String typeName){
        this.typeName = typeName;
    }

}
