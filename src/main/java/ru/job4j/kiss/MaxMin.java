package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;


public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMaxMin(value, (x, y) -> comparator.compare(x, y) == 1);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMaxMin(value, (x, y) -> comparator.compare(x, y) == -1);
    }

    public <T> T findMaxMin(List<T> value, BiPredicate<T, T> predicate) {
        T result = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            if (predicate.test(value.get(i), result)) {
                result  = value.get(i);
            }
        }
        return result;
    }
}