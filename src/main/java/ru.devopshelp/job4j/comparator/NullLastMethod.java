package ru.devopshelp.job4j.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NullLastMethod {
    public static Comparator<String> nullLast() {
        return Comparator.nullsLast(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("3", "2", "1", null);
        list.sort(NullLastMethod.nullLast());
        System.out.println(list);
    }
}
