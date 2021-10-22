package ru.devopshelp.job4j.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NullFirstMethod {
    public static Comparator<String> nullFirst() {
        return Comparator.nullsFirst(Comparator.naturalOrder());
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("3", "2", "1", null);
        list.sort(NullFirstMethod.nullFirst());
        System.out.println(list);
    }
}
