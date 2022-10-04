package td1.original.api.burger;

import td1.original.api.restauration.Base;

public enum BurgerIngredient implements Base {
    CHEDDAR,
    DEEPFRIEDONIONS,
    TOMATO;

    @Override
    public double calories_per_100g() {
        return 0;
    }

    @Override
    public double price() {
        return 0;
    }

    @Override
    public boolean hasUniquePrice() {
        return false;
    }
}
