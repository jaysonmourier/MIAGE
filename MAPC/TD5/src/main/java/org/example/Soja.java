package org.example;

public class Soja extends BeverageDecorator {
    private final float value = 2.3f;
    private final String desc = "Soja (" + this.value + "€)";

    public Soja(Beverage beverage) {
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
