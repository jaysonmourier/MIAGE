package org.example;

public class DarkRoast implements Beverage {
    private float value = 3f;
    @Override
    public String getDescription() {
        return "DarkRoast (" + this.value + "€)";
    }

    @Override
    public float cost() {
        return this.value;
    }
}
