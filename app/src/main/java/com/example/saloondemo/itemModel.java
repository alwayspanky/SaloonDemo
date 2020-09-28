package com.example.saloondemo;

class itemModel {

    int image, itemImage, offerImage;
    String name, itemName;

    public int getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(int offerImage) {
        this.offerImage = offerImage;
    }

    public int getImage(){
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getItemImage(){
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
