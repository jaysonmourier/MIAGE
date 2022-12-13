package org.example;

public class Discount extends BeverageDecorator {
    private final float value = .15f;
    private final String desc = "Discount (" + String.format("%.2f", this.value * 100) + "%)";
    public Discount(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return this.wrappee.getDescription() + ", " + this.desc;
    }

    public float cost() {
        return this.wrappee.cost() * (1 - this.value);
    }
}
