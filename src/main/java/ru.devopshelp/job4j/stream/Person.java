package job4j.stream;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));

//        for (Person person : persons) {
//            System.out.println(person);
//        }
//        System.out.println("Создание списка из элементов потока");
//        List<Person> filtered =
//                persons
//                        .stream()
//                        .filter(p -> p.name.startsWith("P"))
//                        .collect(Collectors.toList());
//        System.out.println(filtered);
//        System.out.println("Группировка по возрасту");
//        Map<Integer, List<Person>> personsByAge = persons
//                .stream()
//                .collect(Collectors.groupingBy(p -> p.age));
//        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
//        System.out.println("Агрегация возраста. Средний возраст.");
//        Double averageAge = persons
//                .stream()
//                .collect(Collectors.averagingInt(p -> p.age)); // Считаем средний возраст
//        System.out.println(averageAge);
//        System.out.println("Резюмирующий коллектор");
//        IntSummaryStatistics ageSummary =
//                persons
//                        .stream()
//                        .collect(Collectors.summarizingInt(p -> p.age));
//        System.out.println(ageSummary);
//        System.out.println("Объединение всех имен в одну строку");
//        String phrase = persons
//                .stream()
//                .filter(p -> p.age >= 18)
//                .map(p -> p.name) // выбирает из потока только имя
//                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
//        System.out.println(phrase);
        System.out.println("Преобразование потока в отображение");
        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.age,
                        p -> p.name,
                        (name1, name2) -> name1 + ";" + name2
                ));
        System.out.println(map);
        System.out.println("Создание своего коллектора");
        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),  // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
        System.out.println("метод reduce. определение элемента с наибольшим возрастом");
        persons
                .stream()
                .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
                .ifPresent(System.out::println);
        System.out.println("Создание Person в виде сложение имен и возраста");
        Person result =
                persons
                        .stream()
                        .reduce(new Person("", 0), (p1, p2) -> {
                            p1.age += p2.age;
                            p1.name += p2.name;
                            return p1;
                        });
        System.out.format("name=%s; age=%s", result.name, result.age);
        System.out.println();
        System.out.println("----------------------");
//        Integer ageSum = persons
//                .stream()
//                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
//
//        System.out.println(ageSum);  // 76
        Integer ageSum = persons
                .stream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
        System.out.println("Параллельное выполнение");
        Integer ageSum2 = persons
                .parallelStream()
                .reduce(0,
                        (sum, p) -> {
                            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        });
    }
}
