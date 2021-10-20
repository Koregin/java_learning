package ru.devopshelp.job4j.map;

import java.util.*;

public class GetOrDefault {
    private Map<Integer, List<String>> store = new HashMap<>();

    public void addValue(int index, List<String> list) {
        if (!store.containsKey(index)) {
            store.put(index, list);
        }
    }

    public List<String> getValue(int index) {
        return store.getOrDefault(index, new ArrayList<String>());
    }
}
