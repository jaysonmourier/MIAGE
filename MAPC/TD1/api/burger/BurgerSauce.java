package td1.original.api.burger;

import td1.original.api.restauration.Base;

public enum BurgerSauce implements Base {
    BURGER,
    BARBECUE,
    BEARNAISE;

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
