package job4j.stream;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReductionDemo {
    public static void main(String[] args) {
        Supplier<Deque<Integer>> supplier = LinkedList::new;
        BiConsumer<Deque<Integer>, Integer> biConsumer = Deque::addFirst;
        BinaryOperator<Deque<Integer>> operator = (left, right) -> {
            right.forEach(left::addFirst);
            return left;
        };

        Deque<Integer> result = List.of(1, 2, 3).stream()
                .collect(Collector.of(
                        supplier,
                        biConsumer,
                        operator)
                );
        result.forEach(System.out::println);
    }

}
