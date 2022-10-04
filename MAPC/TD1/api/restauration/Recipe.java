package td1.original.api.restauration;

import java.util.ArrayList;
import java.util.List;

public abstract class Recipe implements ComposedFood {
    private String name;
    List<Food> ingredients;

    // METHODS

    public Recipe(String name)
    {
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public String name()
    {
        return this.name;
    }

    public double add(Base base, double weight)
    {
        this.ingredients.add(new Ingredient(base, weight));
        return weight;
    }

    @Override
    public double calories_per_100g() {
        return 0;
    }

    @Override
    public double weight() {
        return 0;
    }

    @Override
    public double price() {
        return 0;
    }
}
