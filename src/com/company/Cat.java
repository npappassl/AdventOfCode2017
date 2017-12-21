package com.company;

import java.util.List;

public class Cat {
    private String color;
    private String breed;

    public static Cat getSiamBlackCat(){
        return CatBuilder.createSiameseBlackCat();
    }
    public static class CatBuilder{
        public static Cat createSiameseBlackCat(){
            Cat retCat = new Cat();
            retCat.breed = "Siamese";
            retCat.color = "Black";
            return retCat;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
