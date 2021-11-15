package job4j.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));
        System.out.println(stream.anyMatch(s -> true));
        //System.out.println(stream.noneMatch(s -> true));

        System.out.println("Создаем поставщика для конструктора нового потока");
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));
        // Каждый вызов метода get создает новый поток
        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok
    }
}
