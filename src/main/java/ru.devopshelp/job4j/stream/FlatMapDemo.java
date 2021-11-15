package job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FlatMapDemo {
    static class Foo {
        private List<Bar> bars = new ArrayList<>();
        private String name;

        Foo(String name) {
            this.name = name;
        }
    }

    static class Bar {
        private String name;

        Bar(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();
        //create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));
        //create bars
        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));
        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
        System.out.println("Конвеер операций");
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }
}
