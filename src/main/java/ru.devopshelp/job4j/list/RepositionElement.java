package ru.devopshelp.job4j.list;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        String temp = list.remove(list.size() - 1);
        if (index < list.size()) {
            list.set(index, temp);
        }
        return list;
    }
}
