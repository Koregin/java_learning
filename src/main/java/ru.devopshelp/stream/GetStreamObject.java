package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 *  - Пустой стрим: Stream.empty() // Stream<String>
 *   - Стрим из List: list.stream() // Stream<String>
 *   - Стрим из Map: map.entrySet().stream() // Stream<Map.Entry<String, String>>
 *   - Стрим из массива: Arrays.stream(array) // Stream<String>
 *   - Стрим из указанных элементов: Stream.of("a", "b", "c") // Stream<String>
 */
public class GetStreamObject {
    public static void main(String[] args) {
        /**
         *
         */
        List<String> list = Arrays.stream(args)
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
        System.out.println(list);
        /**
         * Создание стрима из набора значений
         */
        IntStream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x < 300) // Пропусить элементы меньше 300
                .map(x -> x + 11) // прибавить к элементу 11
                .forEach(s -> System.out.print(s + ", ")); // вывести элементы в цикле
        System.out.println();
        /**
         * Код на второй строке выполнится, а вот на третьей выбросит исключение
         */
        Stream<String> stream = list.stream();
        stream.forEach(s -> System.out.print(s + ", "));
//        stream.filter(s -> s.contains("Stream API"));
//        stream.forEach(System.out::println);

        /**
         * так делать нельзя, потомучто может выдасться исключение
         */
//        final List<Integer> ints = new ArrayList<>();
//        IntStream.range(0, 1000000)
//                .parallel()
//                .forEach(ints::add);
//        System.out.println(ints.size());
        // Если null то пустой стрим
        System.out.println();
        String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
        Stream.ofNullable(str)
                .forEach(System.out::println);
        // Бесконечный стим
        Stream.generate(() -> 6)
                .limit(16)
                .forEach(s -> System.out.print(s + ", "));
        /**
         * Возвращает бесконечный стрим с элементами, которые образуются в
         * результате последовательного применения функции f к итерируемому значению.
         * Первым элементом будет seed, затем f(seed), затем f(f(seed)) и так далее.
         */
        Stream.iterate(2, x -> x + 6)
                .limit(6)
                .forEach(s -> System.out.print(s + ", "));
        /**
         * Конечный стрим с условием
         */
        Stream.iterate(2, x -> x < 25, x -> x + 6)
                .forEach(s -> System.out.print(s + ", "));
        /**
         * Объединение двух стримов
         * Сначала идут элементы первого стрима а затем второго
         */
        System.out.println();
        Stream.concat(
                        Stream.of(1, 2, 3),
                        Stream.of(4, 5, 6))
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        /**
         * builder()
         * Создаёт мутабельный объект для добавления элементов в стрим
         * без использования какого-либо контейнера для этого.
         */
        Stream.Builder<Integer> streamBuider = Stream.<Integer>builder()
                .add(0)
                .add(1);
        for (int i = 2; i <= 8; i += 2) {
            streamBuider.accept(i);
        }
        streamBuider
                .add(9)
                .add(10)
                .build()
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        /**
         * IntStream.range(int startInclusive, int endExclusive)
         * LongStream.range(long startInclusive, long endExclusive)
         * Создаёт стрим из числового промежутка [start..end),
         * то есть от start (включительно) по end.
         */
        IntStream.range(0, 10)
                .forEach(s -> System.out.print(s + ", "));
// 0, 1, 2, 3, 4, 5, 6, 7, 8, 9

        LongStream.range(-10L, -5L)
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        /**
         *  filter(Predicate predicate)
         * Фильтрует стрим, принимая только те элементы, которые удовлетворяют заданному условию.
         */
        Stream.of(1, 2, 3)
                .filter(x -> x == 10)
                .forEach(s -> System.out.print(s + ", "));
        // Вывода нет, так как после фильтрации стрим станет пустым
        Stream.of(120, 410, 85, 32, 314, 12)
                .filter(x -> x > 100)
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        IntStream.range(2, 9)
                .filter(x -> x % 3 == 0)
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        /**
         * map(Function mapper)
         * Применяет функцию к каждому элементу и затем возвращает стрим,
         * в котором элементами будут результаты функции.
         * map можно применять для изменения типа элементов.
         */
        Stream.of("3", "4", "5")
                .map(Integer::parseInt)
                .map(x -> x + 10)
                .forEach(s -> System.out.print(s + ", "));
        // 13, 14, 15
        Stream.of(120, 410, 85, 32, 314, 12)
                .map(x -> x + 11)
                .forEach(s -> System.out.print(s + ", "));
        // 131, 421, 96, 43, 325, 23
        Stream.of("10", "11", "32")
                .map(x -> Integer.parseInt(x, 16))
                .forEach(s -> System.out.print(s + ", "));
        System.out.println();
        /**
         * flatMap(Function<T, Stream<R>> mapper)
         * Один из самых интересных операторов.
         * Работает как map, но с одним отличием — можно преобразовать один элемент в ноль,
         * один или множество других.
         */
        Stream.of(2, 3, 0, 1, 3)
                .flatMapToInt(x -> IntStream.range(0, x))
                .forEach(s -> System.out.print(s + ", "));
        // 0, 1, 0, 1, 2, 0, 0, 1, 2
        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6)
                .flatMap(x -> {
                    switch (x % 3) {
                        case 0:
                            return Stream.of(x, x * x, x * x * 2);
                        case 1:
                            return Stream.of(x);
                        case 2:
                        default:
                            return Stream.empty();
                    }
                })
                .forEach(s -> System.out.print(s + ", "));
        // 1, 3, 9, 18, 4, 6, 36, 72
        System.out.println();
        /**
         * mapMulti(BiConsumer<T, Consumer<R>> mapper)
         * Появился в Java 16. Этот оператор похож на flatMap,
         * но использует императивный подход при работе.
         * Теперь вместе с элементом стрима приходит ещё и Consumer,
         * в который можно передать одно или несколько значений, либо не передавать вовсе.
         */
        Stream.of(1, 2, 3, 4, 5, 6)
                .mapMulti((x, consumer) -> {
                    if (x % 2 == 0) {
                        consumer.accept(-x);
                        consumer.accept(x);
                    }
                })
                .forEach(s -> System.out.print(s + ", "));
        // -2, 2, -4, 4, -6, 6
        System.out.println();
        /**
         * limit(long maxSize)
         * Ограничивает стрим maxSize элементами.
         */
        Stream.of(120, 410, 85, 32, 314, 12)
                .limit(4)
                .forEach(s -> System.out.print(s + ", "));
        // 120, 410, 85, 32
        System.out.println();
        /**
         * skip(long n)
         * Пропускает n элементов стрима.
         */
        Stream.of(5, 10)
                .skip(40)
                .forEach(s -> System.out.print(s + ", "));
        // Вывода нет

        Stream.of(120, 410, 85, 32, 314, 12)
                .skip(2)
                .forEach(s -> System.out.print(s + ", "));
        // 85, 32, 314, 12
        System.out.println();
        /**
         * T reduce(T identity, BinaryOperator accumulator)
         * U reduce(U identity, BiFunction accumulator, BinaryOperator combiner)
         * Ещё один полезный оператор. Позволяет преобразовать все элементы стрима
         * в один объект. Например, посчитать сумму всех элементов, либо найти минимальный элемент.
         * Сперва берётся объект identity и первый элемент стрима,
         * применяется функция accumulator и identity становится её результатом.
         * Затем всё продолжается для остальных элементов.
         */
        int sum = Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (acc, x) -> acc + x);
        System.out.println("Sum: " + sum);
        System.out.println();
        /**
         * Optional reduce(BinaryOperator accumulator)
         * Этот метод отличается тем, что у него нет начального объекта identity.
         * В качестве него служит первый элемент стрима.
         * Поскольку стрим может быть пустой и тогда identity объект не присвоится,
         * то результатом функции служит Optional, позволяющий обработать и эту ситуацию,
         * вернув Optional.empty().
         */
        Optional<Integer> result = Stream.<Integer>empty()
                .reduce((acc, x) -> acc + x);
        System.out.println(result.isPresent());
        // false

        Optional<Integer> sum2 = Stream.of(1, 2, 3, 4, 5)
                .reduce((acc, x) -> acc + x);
        System.out.println(sum2.get());
        // 15
        int product = IntStream.range(0, 10)
                .filter(x -> ++x % 4 == 0)
                .reduce((acc, x) -> acc * x)
                .getAsInt();
        System.out.println("Product: " + product);

    }
}
