package td1.original.api.restauration;

import td1.original.api.dietetic.DieteticElement;
import td1.original.api.monetary.Product;

public interface Food extends Product, DieteticElement {
    double weight();
    default double calories()
    {
        return ( weight() * calories_per_100g() ) / 100;
    }
}
