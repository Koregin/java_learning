package job4j.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalFlatMap {
    public static void main(String[] args) {
        Optional<Integer> opt = List.of("Hello.java", "Hello.js", "Hello.py").stream()
                .filter(s -> s.endsWith(".java"))
                .map(o -> o.length())
                .findFirst();
        System.out.println(opt.get());
    }
}
