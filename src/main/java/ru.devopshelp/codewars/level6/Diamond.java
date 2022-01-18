package ru.devopshelp.codewars.level6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Diamond {
    public static String print(int n) {
        StringBuilder sb = new StringBuilder();
        if (n > 0 && n % 2 != 0) {
            for (int i = 1, j = n / 2; i < n; i += 2, j--) {
                sb.append(IntStream.range(0, j).mapToObj(num -> " ").collect(Collectors.joining()));
                sb.append(IntStream.range(0, i).mapToObj(num -> "*").collect(Collectors.joining()));
                sb.append("\n");
            }
            for (int i = n, j = 0; i >= 1; i -= 2, j++) {
                sb.append(IntStream.range(0, j).mapToObj(num -> " ").collect(Collectors.joining()));
                sb.append(IntStream.range(0, i).mapToObj(num -> "*").collect(Collectors.joining()));
                sb.append("\n");
            }
        } else {
            sb = null;
        }
        return sb == null ? null : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(print(0));
        System.out.println(print(1));
        System.out.println(print(3));
        System.out.println(print(5));
        System.out.println(print(7));
    }
}
