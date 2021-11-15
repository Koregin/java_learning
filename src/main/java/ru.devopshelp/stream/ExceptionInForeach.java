package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExceptionInForeach {
    public static void main(String[] args) {
        try {
            List<String> fruits = new ArrayList<>();
            fruits.add("mango");
            fruits.add("apple");
            fruits.add("pineapple");
            fruits.add("orange");

            fruits.stream().forEach(fruit -> {
                if (fruit.equals("pineapple")) {
                    throw new RuntimeException();
                }
                System.out.println(fruit);
            });
        } catch (Exception e) { }

        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();
        streamBuilder.forEach(System.out::println);
    }
}
