package com.fahim69.bazaarapp.ModelClass;

public class popular_item_model {
    int item_images;
    String item_name;
    String item_category;
    String item_price;
    public popular_item_model(int item_images, String item_name, String item_category, String item_price) {
        this.item_images = item_images;
        this.item_name = item_name;
        this.item_category = item_category;
        this.item_price = item_price;
    }

    //    int images;
//    String fruitname;
//    String prices;
//    public int getImages() {
//        return images;
//    }
//
//    public void setImages(int images) {
//        this.images = images;
//    }
//
//    public String getFruitname() {
//        return fruitname;
//    }
//
//    public void setFruitname(String fruitname) {
//        this.fruitname = fruitname;
//    }
//
//    public String getPrices() {
//        return prices;
//    }
//
//    public void setPrices(String prices) {
//        this.prices = prices;
//    }
//    public popular_item_model(int images, String fruitname, String prices) {
//        this.images = images;
//        this.fruitname = fruitname;
//        this.prices = prices;
//    }


    public int getItem_images() {
        return item_images;
    }

    public void setItem_images(int item_images) {
        this.item_images = item_images;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_category() {
        return item_category;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }




}
