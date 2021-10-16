package ru.devopshelp.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;

public class Pangram {
    public static boolean checkString(String s) {
        HashSet<Character> abc = new HashSet<>();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if ((int) temp > 96 && (int) temp < 123) {
                abc.add(temp);
            }
        }
        return abc.size() == 26;
    }

    public static void main(String[] args) {
        String s = "Jackdaws love my big sphinx, of quartz%";
        HashSet<Character> abc = new HashSet<>();
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if ((int) temp > 96 && (int) temp < 123) {
                abc.add(temp);
            }
        }
        System.out.println(Pangram.checkString(s));
    }
}
