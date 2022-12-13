package org.example;

public abstract class BeverageDecorator implements Beverage {
    private Beverage wrapper;
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Integer cost() {
        return null;
    }
}
