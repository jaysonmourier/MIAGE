package org.example;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage wrappee;

    public BeverageDecorator(Beverage beverage) {
        this.wrappee = beverage;
    }
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public float cost() {
        return this.wrappee.cost();
    }
}
