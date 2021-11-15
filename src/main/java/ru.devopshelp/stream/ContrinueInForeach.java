package stream;

import java.util.ArrayList;
import java.util.stream.Stream;

public class ContrinueInForeach {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        stringList.forEach(str -> {
            if (str.equals("b")) return; // only skips this iteration.
            System.out.println(str);
        });
        //
        Stream.of("cat", "dog", "elephant", "fox", "rabbit", "duck")
                .takeWhile(n -> n.length() % 2 != 0)
                .forEach(System.out::println);
    }
}
