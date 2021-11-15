package job4j.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Article {
    public static boolean generateBy(String origin, String line) {
        List<String> originlist = Arrays.asList(origin.split("[-.!,:; ]"));
        List<String> linelist = new ArrayList<>(Arrays.asList(line.split("[-.!,:; ]")));
        Map<Integer, String> origintext = IntStream.range(0, originlist.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, originlist::get));
        for (Integer key : origintext.keySet()) {
            for (String word : linelist) {
                if (origintext.get(key).equals(word)) {
                    linelist.remove(word);
                    break;
                }
            }
        }
        return linelist.size() == 0;
    }

    public static void main(String[] args) {
        String origin = "Мой дядя самых честных правил, "
                + "Когда не в шутку занемог, "
                + "Он уважать себя заставил "
                + "И лучше выдумать не мог. "
                + "Его пример другим наука; "
                + "Но, боже мой, какая скука "
                + "С больным сидеть и день и ночь, "
                + "Не отходя ни шагу прочь! "
                + "Какое низкое коварство "
                + "Полуживого забавлять, "
                + "Ему подушки поправлять, "
                + "Печально подносить лекарство, "
                + "Вздыхать и думать про себя: "
                + "Когда же черт возьмет тебя!";
        String line = "Мой дядя мог думать про тебя и день и ночь";
        System.out.println(generateBy(origin, line));
        /*//String line = "Мой дядя мог думать про Linux и Java день и ночь";
        List<String> originlist = Arrays.asList(origin.split("[-.!,:\\; ]"));
        List<String> linelist = new ArrayList<>(Arrays.asList(line.split("[-.!,:\\; ]")));
        //int linelistsize = linelist.size();
        Map<Integer, String> origintext = IntStream.range(0, originlist.size())
                                .boxed()
                                .collect(Collectors.toMap(i -> i, originlist::get));
        //int counter = 0;
        for (Integer key : origintext.keySet()) {
            for (String word : linelist) {
                if (origintext.get(key).equals(word)) {
                    //counter++;
                    linelist.remove(word);
                    break;
                }
            }
        }
        //if (counter == linelistsize) {
        if (linelist.size() == 0) {
            System.out.println("Текст взят из оригинала");
        } else {
            System.out.println("Текст не из оригинала");
        }*/
    }
}
