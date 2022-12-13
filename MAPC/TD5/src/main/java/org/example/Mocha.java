package org.example;

public class Mocha extends BeverageDecorator {
    private final float value = 2.1f;
    private final String desc = "Mocha (" + this.value + "€)";

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return this.wrappee.getDescription() + ", " + this.desc;
    }

    public float cost() {
        return this.wrappee.cost() + this.value;
    }
}
