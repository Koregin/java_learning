package job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class MinMethod {
    public static String min(List<String> list) {
        return list.stream()
                .min(String::compareTo)
                .get();
    }

    public static Stream<Object> createStream(Integer[] data) {
        return Stream.builder().add(data[0]).add(data[data.length - 1]).build();
    }
}
