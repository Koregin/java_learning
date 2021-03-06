package job4j.io.find;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        ArgsName argsName = validate(args);
        saveFile(argsName.get("o"), search(argsName.get("d"), pathPredicate(argsName.get("t"), argsName.get("n"))));
    }

    private static ArgsName validate(String[] args) {
        if (args.length != 4) {
            throw new IllegalArgumentException("Not correct arguments. Usage: java -jar find.jar -d=ROOT_DIR -n=FILTER_VALUE -t={mask | name | regex} -o=TARGET_FILE");
        }
        ArgsName argsFind = ArgsName.of(args);
        if (argsFind.get("d") == null || argsFind.get("n") == null
                && argsFind.get("t") == null || argsFind.get("o") == null) {
            throw new IllegalArgumentException("Not correct arguments. Usage: java -jar find.jar -d=ROOT_DIR -n=FILTER_VALUE -t={mask | name | regex} -o=TARGET_FILE");
        }
        if (!Files.isDirectory(Path.of(argsFind.get("d")))) {
            throw new IllegalArgumentException("Is not directory");
        }
        if (!Files.exists(Path.of(argsFind.get("d")))) {
            throw new IllegalArgumentException("Directory not exist");
        }
        if (!Arrays.asList("mask", "name", "regex").contains(argsFind.get("t"))) {
            throw new IllegalArgumentException("Type of filter should be mask, name or regex");
        }
        return argsFind;
    }

    public static Predicate<Path> pathPredicate(String typeSearch, String valueSearch) {
        Predicate<Path> condition = null;
        if (typeSearch.equals("mask")) {
            condition = path -> path.toFile().getName().endsWith(valueSearch);
        } else if (typeSearch.equals("name")) {
            condition = path -> path.toFile().getName().equals(valueSearch);
        } else if (typeSearch.equals("regex")){
            condition = path -> path.toFile().getName().contains(valueSearch);
        }
        return condition;
    }

    public static List<Path> search(String root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(Path.of(root), searcher);
        return searcher.getPaths();
    }

    public static void saveFile(String file, List<Path> list) {
        try (PrintWriter out = new PrintWriter(file)){
            list.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
