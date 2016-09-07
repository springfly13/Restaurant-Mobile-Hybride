package fr.epsi.poe.mobile.restaurant.models;

/**
 * Created by Fly on 13/07/2016.
 */
public class Photos {
    private int height;
    private String htmlAttributions;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public String getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(String htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public int getWidth() {
        return width;

    }

    public void setWidth(int width) {
        this.width = width;
    }

    private String photoReference;
    private int width;

    public String getPhotoReference() {
        return photoReference;
    }

    public void setPhotoReference(String photoReference) {
        this.photoReference = photoReference;
    }
}
