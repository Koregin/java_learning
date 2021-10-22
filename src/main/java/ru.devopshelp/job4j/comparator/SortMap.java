package ru.devopshelp.job4j.comparator;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SortMap {
    public static Map<Integer, String> sort(Map<Integer, String> map) {
        Map<Integer, String> tmap = new TreeMap<>(Comparator.reverseOrder());
        tmap.putAll(map);
        return tmap;
    }
}
