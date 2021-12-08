package job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirListWithMethodList {
    public static void main(String[] args) throws IOException {
        try (Stream<Path> stream = Files.list(Paths.get("/home/ekoregin/Downloads"))) {
            stream.filter(file -> !Files.isDirectory(file))
                    .map(Path::toString)
                    .forEach(System.out::println);
        }
    }
}
