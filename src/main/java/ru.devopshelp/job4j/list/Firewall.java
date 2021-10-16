package ru.devopshelp.job4j.list;

import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String answer = "Вы сделали правильный выбор!";
        for (String str : s.split(" ")) {
            if(words.contains(str)) {
                answer = "Выберите другую статью...";
                break;
            }
        }
        return answer;
    }
}
