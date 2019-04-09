package com.example.dell.rozkhana01;

public class Foods {

    private int foodId;
    private String foodName;
    private String foodGenre;
    private String foodThumbnail;

    public Foods() {

    }

    public Foods(int foodId, String foodName, String foodGenre, String foodThumbnail) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodGenre = foodGenre;
        this.foodThumbnail = foodThumbnail;
    }

    public int getFoodId() {
        return foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodGenre() {
        return foodGenre;
    }

    public String getFoodThumbnail() {
        return foodThumbnail;
    }

    public void setFoodThumbnail(String foodThumbnail) {
        this.foodThumbnail = foodThumbnail;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodGenre(String foodGenre) {
        this.foodGenre = foodGenre;
    }
}