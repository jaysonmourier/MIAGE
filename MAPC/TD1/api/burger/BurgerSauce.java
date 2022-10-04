package td1.original.api.burger;

import td1.original.api.restauration.Base;

public enum BurgerSauce implements Base {
    BURGER,
    BARBECUE,
    BEARNAISE;

    @Override
    public double calories_per_100g() {
        double cal = 0;
        switch (this)
        {
            case BURGER:
                cal = 240;
                break;
            case BARBECUE:
                cal = 130;
                break;
            case BEARNAISE:
                cal = 550;
                break;
        }
        return cal;
    }

    @Override
    public double price() {
        return 1;
    }

    @Override
    public boolean hasUniquePrice() {
        return true;
    }
}
