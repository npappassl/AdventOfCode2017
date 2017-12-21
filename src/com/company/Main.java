package com.company;

public class Main {

    public static void main(String[] args) {
        Cat myCat = Cat.getSiamBlackCat();
        System.out.println("I have a "+ myCat.getColor() +",  "+ myCat.getBreed()+" cat");
    }
}
