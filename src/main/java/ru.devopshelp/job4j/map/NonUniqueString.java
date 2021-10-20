package ru.devopshelp.job4j.map;

import java.util.HashMap;
import java.util.Map;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        for (String str : strings) {
            if (!map.containsKey(str)) {
                map.putIfAbsent(str, false);
            } else {
                map.computeIfPresent(str, (k, v) -> v = true);
            }
        }
        return map;
    }
}
