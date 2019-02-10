package com.example.dell.rozkhana01;

public class Note {

    //String[] foods;
    String title;
    String Description;
    private String Thumbnail;

    Note()
    {

    }

    public Note(String title, String description, String thumbnail/*, String[] foods*/) {
        this.title = title;
        Description = description;
        Thumbnail = thumbnail;
        //this.foods = foods;
    }

    public Note(String[] strings, String chinese_foods, String description_book, int thevigitarian)
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

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

}
