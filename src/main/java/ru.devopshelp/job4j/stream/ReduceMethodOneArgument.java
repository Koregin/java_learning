package job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class ReduceMethodOneArgument {
    public static Integer reduce(List<Integer> list) {
        return list.stream().reduce((n1, n2) -> n1 * n2).get();
    }
}
