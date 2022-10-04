package td1.original.api.restauration;

public class Ingredient implements Food {
    private double weight;
    private Base base;

    // METHODS
    public Ingredient(Base base, double weight)
    {
        this.base = base;
        this.weight = weight;
    }

    @Override
    public double calories_per_100g() {
        return 0;
    }

    @Override
    public double price() {
        return 0;
    }

    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public double calories() {
        return Food.super.calories();
    }
}
