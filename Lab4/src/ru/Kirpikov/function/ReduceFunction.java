package ru.Kirpikov.function;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceFunction {
    public static <T> T reduce(List<T> input, T identity, BinaryOperator<T> reducer) {
        T result = identity;
        if (input != null) {
            for (T value : input) {
                if (value != null) {
                    result = reducer.apply(result, value);
                }
            }
        }
        return result;
    }
}
