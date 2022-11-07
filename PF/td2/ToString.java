import java.util.function.Function;

@FunctionalInterface
public interface ToString<T, R> extends Function<T, R> {
    R apply(T elt);
}
