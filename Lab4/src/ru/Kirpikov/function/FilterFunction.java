package ru.Kirpikov.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterFunction {
    public static <T> List<T> filter(List<T> input, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T value : input) {
            if (predicate.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
