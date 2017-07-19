package com.hazem.al3rosa.model;

/**
 * Created by hazem on 4/29/2017.
 */

public class ProductModel {
    private String id;
    private String text;
    private int imageDummy;
    private String imageUrl;
    private int colorBack;

    public ProductModel() {
    }

    public ProductModel(String text, int imageDummy) {
        this.text = text;
        this.imageDummy = imageDummy;
    }

    public int getColorBack() {
        return colorBack;
    }

    public void setColorBack(int colorBack) {
        this.colorBack = colorBack;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageDummy() {
        return imageDummy;
    }

    public void setImageDummy(int imageDummy) {
        this.imageDummy = imageDummy;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
