package ru.devopshelp.job4j.list;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        int first = list.indexOf(str);
        int last = list.lastIndexOf(str);
        return first != -1 && first == last;
    }
}
