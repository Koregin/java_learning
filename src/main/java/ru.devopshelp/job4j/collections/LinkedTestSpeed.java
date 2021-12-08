package job4j.collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedTestSpeed {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < 5_000_000; i++) {
            list.add(i);
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            list.add(2_000_000, Integer.MAX_VALUE);
        }
        System.out.println("Время работы для LinkedList (в милисекундах) = "
                + (System.currentTimeMillis() - start));
    }
}
