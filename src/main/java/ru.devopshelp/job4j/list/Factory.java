package ru.devopshelp.job4j.list;

import java.util.List;

public class Factory {
    public static void main(String[] args) {
        List<String> list = List.of("first", "second", "third", "fourth", "fifth");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
