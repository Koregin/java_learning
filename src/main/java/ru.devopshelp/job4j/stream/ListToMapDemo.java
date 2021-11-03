package job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ListToMapDemo {
    public static void main(String[] args) {
        System.out.println(
                List.of(1, 2, 3, 4).stream().distinct().collect(
                        Collectors.toMap(
                                e -> e,
                                e -> e * e
                        ))
        );
    }
}
