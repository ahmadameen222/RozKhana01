package com.example.dell.rozkhana01;

public class Food {

    //String[] foods;
    String title;
    String Description;
    private int Thumbnail;

    Food()
    {

    }

    public Food(String title, String description, int thumbnail/*, String[] foods*/) {
        this.title = title;
        Description = description;
        Thumbnail = thumbnail;
        //this.foods = foods;
    }

    public Food(String[] strings, String chinese_foods, String description_book, int thevigitarian)
    {

    }

    /*
    public String[] getFoods() {
        return foods;
    }

    public void setFoods(String[] foods) {
        this.foods = foods;
    }
*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }




}
