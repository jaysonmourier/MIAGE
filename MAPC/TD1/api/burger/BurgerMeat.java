package td1.original.api.burger;

import td1.original.api.restauration.Base;

public enum BurgerMeat implements Base {
    BEEF,
    WHITEFISH;

    @Override
    public double calories_per_100g() {
        double cal = 0;
        switch (this) {
            case BEEF:
                cal = 200;
                break;
            case WHITEFISH:
                cal = 170;
                break;
            default:
                cal = 0;
        }
        return cal;
    }

    @Override
    public double price() {
        double p = 0;
        switch (this)
        {
            case BEEF:
                p = 4;
                break;
            case WHITEFISH:
                p = 6;
                break;
        }
        return p;
    }

    @Override
    public boolean hasUniquePrice() {
        return false;
    }
}
