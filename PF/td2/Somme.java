import java.util.function.BinaryOperator;

@FunctionalInterface
public interface Somme<T> extends BinaryOperator<T> {
    T apply(T a, T b);
}
