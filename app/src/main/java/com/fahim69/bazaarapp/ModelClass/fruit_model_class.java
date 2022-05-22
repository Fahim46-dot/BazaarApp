package com.fahim69.bazaarapp.ModelClass;

public class fruit_model_class {
    String name, category, price;
    int imageview;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageview() {
        return imageview;
    }

    public void setImageview(int imageview) {
        this.imageview = imageview;
    }


    public fruit_model_class(String name, String category, String price, int imageview) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.imageview = imageview;
    }


}
