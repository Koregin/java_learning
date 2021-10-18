package ru.devopshelp.job4j.list;

import java.util.Arrays;
import java.util.HashSet;

public class Isogram {
    public static boolean checkString(String s) {
        String[] word = s.split("");
        HashSet<String> iso = new HashSet<>(Arrays.asList(word));
        return word.length == iso.size();
    }
}
