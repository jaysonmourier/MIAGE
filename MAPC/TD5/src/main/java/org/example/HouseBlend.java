package org.example;

public class HouseBlend implements Beverage {
    private float value = 4f;
    @Override
    public String getDescription() {
        return "HouseBlend (" + this.value + "€)";
    }

    @Override
    public float cost() {
        return this.value;
    }
}
