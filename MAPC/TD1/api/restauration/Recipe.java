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

    public void add(Base base, double weight)
    {
        this.ingredients.add(new Ingredient(base, weight));
    }

    @Override
    public double calories_per_100g() {
        double cal = 0;
        for(Food f : this.ingredients)
        {
            cal += f.calories_per_100g();
        }
        return cal;
    }

    @Override
    public double weight() {
        double w = 0;
        for(Food f : this.ingredients)
        {
            w += f.weight();
        }
        return w;
    }

    @Override
    public double price() {
        double p = 0;
        for(Food f : this.ingredients)
        {
            p += f.price();
        }
        return p;
    }

    public String toString()
    {
        String str = "";
        for(Food i : this.ingredients)
        {
            str += i.weight() + " ";
        }
        return str;
    }
}
