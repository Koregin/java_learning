package ru.devopshelp.job4j.map;

import org.w3c.dom.ls.LSOutput;

import java.util.TreeMap;

public class MostUsedCharacter {
    public static char getMaxCount(String str) {
        char rsl = ' ';
        String str1 = str.toLowerCase().replace(" ", "");
        TreeMap<Character, Integer> mostUsed = new TreeMap<>();
        for (Character ch : str1.toCharArray()) {
            if (!mostUsed.containsKey(ch)) {
                mostUsed.putIfAbsent(ch, 1);
            } else {
                mostUsed.computeIfPresent(ch, (k, v) -> v = v + 1);
            }
        }
        int count = 1;
        for (Character key : mostUsed.keySet()) {
            if (mostUsed.get(key) > count) {
                rsl = key;
                count = mostUsed.get(key);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String str = "Мой дядя самых честных правил "
                + "Когда не в шутку занемог "
                + "Он уважать себя заставил "
                + "И лучше выдумать не мог "
                + "Его пример другим наука "
                + "Но боже мой какая скука "
                + "С больным сидеть и день и ночь "
                + "Не отходя ни шагу прочь "
                + "Какое низкое коварство "
                + "Полуживого забавлять "
                + "Ему подушки поправлять "
                + "Печально подносить лекарство "
                + "Вздыхать и думать про себя "
                + "Когда же черт возьмет тебя";
        System.out.println(MostUsedCharacter.getMaxCount(str));

    }
}
