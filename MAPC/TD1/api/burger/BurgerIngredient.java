package td1.original.api.burger;

import td1.original.api.restauration.Base;

public enum BurgerIngredient implements Base {
    CHEDDAR,
    DEEPFRIEDONIONS,
    TOMATO;

    @Override
    public double calories_per_100g() {
        double cal = 0;
        switch (this)
        {
            case CHEDDAR:
                cal = 400;
                break;
            case DEEPFRIEDONIONS:
                cal = 590;
                break;
            case TOMATO:
                cal = 16;
                break;
        }
        return 0;
    }

    @Override
    public double price() {
        double p = 0;
        switch (this)
        {
            case CHEDDAR:
                p = 4;
                break;
            case DEEPFRIEDONIONS:
                p = 1.5;
                break;
            case TOMATO:
                p = 0.5;
                break;
        }
        return p;
    }

    @Override
    public boolean hasUniquePrice() {
        return false;
    }
}
