package com.example.dell.rozkhana01;



class Orders {

    String orderId;
    String Ingredient1;
    String Ingredient2;
    String Ingredient3;
    String Ingredient4;
    String Ingredient5;
    String IngredientHidden1;
    String IngredientHidden2;
    String IngredientHidden3;
    String IngredientHidden4;
    String IngredientHidden5;

    public Orders()
    {

    }

    public Orders(String id)
    {
        orderId = id;
    }

    public Orders(String orderId, String ingredient1, String ingredient2, String ingredient3, String ingredient4, String ingredient5, String ingredientHidden1, String ingredientHidden2, String ingredientHidden3, String ingredientHidden4, String ingredientHidden5) {
        this.orderId = orderId;
        Ingredient1 = ingredient1;
        Ingredient2 = ingredient2;
        Ingredient3 = ingredient3;
        Ingredient4 = ingredient4;
        Ingredient5 = ingredient5;
        IngredientHidden1 = ingredientHidden1;
        IngredientHidden2 = ingredientHidden2;
        IngredientHidden3 = ingredientHidden3;
        IngredientHidden4 = ingredientHidden4;
        IngredientHidden5 = ingredientHidden5;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIngredient1() {
        return Ingredient1;
    }

    public void setIngredient1(String ingredient1) {
        Ingredient1 = ingredient1;
    }

    public String getIngredient2() {
        return Ingredient2;
    }

    public void setIngredient2(String ingredient2) {
        Ingredient2 = ingredient2;
    }

    public String getIngredient3() {
        return Ingredient3;
    }

    public void setIngredient3(String ingredient3) {
        Ingredient3 = ingredient3;
    }

    public String getIngredient4() {
        return Ingredient4;
    }

    public void setIngredient4(String ingredient4) {
        Ingredient4 = ingredient4;
    }

    public String getIngredient5() {
        return Ingredient5;
    }

    public void setIngredient5(String ingredient5) {
        Ingredient5 = ingredient5;
    }

    public String getIngredientHidden1() {
        return IngredientHidden1;
    }

    public void setIngredientHidden1(String ingredientHidden1) {
        IngredientHidden1 = ingredientHidden1;
    }

    public String getIngredientHidden2() {
        return IngredientHidden2;
    }

    public void setIngredientHidden2(String ingredientHidden2) {
        IngredientHidden2 = ingredientHidden2;
    }

    public String getIngredientHidden3() {
        return IngredientHidden3;
    }

    public void setIngredientHidden3(String ingredientHidden3) {
        IngredientHidden3 = ingredientHidden3;
    }

    public String getIngredientHidden4() {
        return IngredientHidden4;
    }

    public void setIngredientHidden4(String ingredientHidden4) {
        IngredientHidden4 = ingredientHidden4;
    }

    public String getIngredientHidden5() {
        return IngredientHidden5;
    }

    public void setIngredientHidden5(String ingredientHidden5) {
        IngredientHidden5 = ingredientHidden5;
    }
}
