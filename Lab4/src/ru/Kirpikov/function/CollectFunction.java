package ru.Kirpikov.function;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class CollectFunction {
    public static <T, P> P collect(
            List<T> input,
            Supplier<P> collectionSupplier,
            BiConsumer<P, T> accumulator) {

        P result = collectionSupplier.get();
        for (T value : input) {
            accumulator.accept(result, value);
        }
        return result;
    }
}
