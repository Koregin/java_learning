package ru.devopshelp.job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concordance {
    public static Map<Character, List<Integer>> collectCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chs = s.replaceAll("\\s", "").toCharArray();
        for (int index = 0; index < chs.length; index++) {
            if (!map.containsKey(chs[index])) {
                map.computeIfAbsent(chs[index], key -> new ArrayList<Integer>());
                map.get(chs[index]).add(index);
            } else {
                map.get(chs[index]).add(index);
            }
        }
        return map;
    }
}
