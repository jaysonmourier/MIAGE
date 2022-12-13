package org.example;

public class Decaf implements Beverage {
    private float value = 2.5f;
    @Override
    public String getDescription() {
        return "Decaf (" + this.value + "€)";
    }

    @Override
    public float cost() {
        return this.value;
    }
}
