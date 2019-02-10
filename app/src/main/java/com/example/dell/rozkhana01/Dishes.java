package com.example.dell.rozkhana01;

public class Dishes {

    String dish_title;
    String dish_category;
    String ingredients;
    String dish_description;
    String dish_ing_names;
    private int thumbnail;



    public Dishes(String ingredients, String dish_title, String dish_description, int thumbnail, String cat, String dish_ing_names) {
        this.ingredients = ingredients;
        this.dish_title = dish_title;
        this.dish_description = dish_description;
        this.thumbnail = thumbnail;
        dish_category = cat;
        this.dish_ing_names = dish_ing_names;
    }

    Dishes()
    {

    }


    public String getDish_ing_names() {
        return dish_ing_names;
    }

    public void setDish_ing_names(String dish_ing_names) {
        this.dish_ing_names = dish_ing_names;
    }


    public String getDish_category() {
        return dish_category;
    }

    public void setDish_category(String dish_category) {
        this.dish_category = dish_category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDish_title() {
        return dish_title;
    }

    public void setDish_title(String dish_title) {
        this.dish_title = dish_title;
    }

    public String getDish_description() {
        return dish_description;
    }

    public void setDish_description(String dish_description) {
        this.dish_description = dish_description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
