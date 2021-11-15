package job4j.collections;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Integer, Character> mapleft = IntStream.range(0, left.length()).boxed()
                .collect(Collectors.toMap(i -> i, left::charAt));
        mapleft = mapleft.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (x, y) -> {
                                    throw new AssertionError(); },
                                LinkedHashMap::new
                        ));
        Map<Integer, Character> mapright = IntStream.range(0, right.length()).boxed()
                .collect(Collectors.toMap(i -> i, right::charAt));
        mapright = mapright.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError(); },
                        LinkedHashMap::new
                ));

        return new ArrayList(mapleft.values()).equals(new ArrayList(mapright.values()));
    }

    public static void main(String[] args) {
        System.out.println(eq("Hello", "Hlloe"));
    }
}
