package org.example;

public class Lait extends BeverageDecorator {
    private final float value = 1f;
    private final String desc = "Lait (" + this.value + "€)";
    public Lait(Beverage beverage) {
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
