package org.example;

public class Expresso implements Beverage {
    private float value = 2f;
    @Override
    public String getDescription() {
        return "Expresso (" + this.value + "€)";
    }

    @Override
    public float cost() {
        return this.value;
    }
}
