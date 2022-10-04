package td1.original.api.restauration;

import td1.original.api.dietetic.DieteticElement;
import td1.original.api.monetary.Product;

public interface Base extends Product, DieteticElement {
    boolean hasUniquePrice();
}
