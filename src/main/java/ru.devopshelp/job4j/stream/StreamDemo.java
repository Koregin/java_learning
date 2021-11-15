package job4j.stream;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList
                .stream() // Create stream
                .filter(s -> s.startsWith("c")) // filter stream with start letter "c"
                .map(String::toUpperCase) // Convert stream element
                .sorted() // Sorting
                .forEach(System.out::println);
        System.out.println("Последовательный поток из списка");
        // Последовательный поток из списка
        Arrays.asList("a1", "a2", "a3")
                .stream()
                .findFirst() //Выводит первое значение списка
                .ifPresent(System.out::println);
        System.out.println("Вывод потока без коллекции");
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("Поток из примитивных типов");
        IntStream.range(1, 4)
                .forEach(System.out::println);
        System.out.println("Методы для примитивных типов");
        Arrays.stream(new int[] {1, 2, 3})
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);
        System.out.println("Превращение потока объектов в поток примитивов");
        Stream.of("a1", "a2", "a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);
        System.out.println("Преобразование потока примитивов в поток объектов");
        IntStream.range(1, 4)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        System.out.println("-----------------------------");
        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(i -> "a" + i)
                .forEach(System.out::println);
        System.out.println("Пример без терминального метода");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                });
        System.out.println("Пример c терминальным методом. "
                + "Элементы обрабатываются по цепочке через все методы");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("foreach: " + s));
        System.out.println("-----------------");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
        System.out.println("-----------------");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A"); // вернет значение если начинается с А
                })
                .forEach(s -> System.out.println("forEach: " + s)); // вызовется только для элемента
        //прошедшего фильтр
        System.out.println("-----Фильтр на первом месте-----");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
        System.out.println("---------Добавим сортировку--------");
        Stream.of("d2", "a2", "b1", "b3", "c")
                // Выполняется сортировка всей коллекции
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
        System.out.println("Оптимизация кода посредством изменения порядка вызовов методов");
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                // Сортировка не вызывается так как после фильтра поступает один элемент
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }
}
