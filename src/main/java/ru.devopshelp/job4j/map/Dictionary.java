package ru.devopshelp.job4j.map;

import java.util.*;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        for (String str : strings) {
            String fl = str.split("")[0];
            if (!rsl.containsKey(fl)){
                rsl.computeIfAbsent(fl, key -> new ArrayList<String>());
                rsl.get(fl).add(str);
            } else {
                rsl.get(fl).add(str);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] data = {"two", "three", "four", "five", "six", "seven"};
        Dictionary.collectData(data);
    }
}
