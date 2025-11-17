package ru.Kirpikov.function;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

public class Functions {
    public static <T, P> List<P> map(List<T> input, Function<T, P> func) {
        return input.stream().map(func::apply).collect(Collectors.toList());
    }
}