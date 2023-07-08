package ru.job4j.kiss;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMinTest {
    MaxMin maxMin = new MaxMin();
    List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4, 5);
    List<Integer> list2 = Arrays.asList(5, 4, 3, 2, 1, 0);
    List<Integer> list3 = Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    List<Integer> list4 = Arrays.asList(-2, 3, -4, 2, -5, 0, -3, 4, 0, 1, 5, -1);

    Comparator<Integer> integerComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 == o2)
                return 0;
            else if (o1 > o2)
                return 1;
            else
                return -1;
        }
    };

    @Test
    public void test1() {
        Integer expectedMax = 5;
        Integer expectedMin = 0;
        Integer resultMax = maxMin.max(list1, integerComparator);
        Integer resultMin = maxMin.min(list1, integerComparator);
        assertThat(resultMax).isEqualTo(expectedMax);
        assertThat(resultMin).isEqualTo(expectedMin);
    }

    @Test
    public void test2() {
        Integer expectedMax = 5;
        Integer expectedMin = 0;
        Integer resultMax = maxMin.max(list2, integerComparator);
        Integer resultMin = maxMin.min(list2, integerComparator);
        assertThat(resultMax).isEqualTo(expectedMax);
        assertThat(resultMin).isEqualTo(expectedMin);
    }
    @Test
    public void test3() {
        Integer expectedMax = 5;
        Integer expectedMin = -5;
        Integer resultMax = maxMin.max(list3, integerComparator);
        Integer resultMin = maxMin.min(list3, integerComparator);
        assertThat(resultMax).isEqualTo(expectedMax);
        assertThat(resultMin).isEqualTo(expectedMin);
    }

    @Test
    public void test4() {
        Integer expectedMax = 5;
        Integer expectedMin = -5;
        Integer resultMax = maxMin.max(list3, integerComparator);
        Integer resultMin = maxMin.min(list3, integerComparator);
        assertThat(resultMax).isEqualTo(expectedMax);
        assertThat(resultMin).isEqualTo(expectedMin);
    }
}
