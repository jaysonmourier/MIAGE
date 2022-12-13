package org.example;

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Discount(new Lait(new Soja(new Mocha(new Expresso()))));
        System.out.println("Description: " + beverage.getDescription());
        System.out.println("prix: " + beverage.cost() + "€");
    }
}