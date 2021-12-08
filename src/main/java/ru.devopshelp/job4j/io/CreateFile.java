package job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreateFile {
    public static void main(String[] args) throws IOException {
//        Path newfile = Paths.get("/home/ekoregin/newfile.avi");
//        Files.createFile(Paths.get("/home/ekoregin/newfile.avi"));
//        if (Files.exists(Paths.get("/home/ekoregin/newfile.avi"))) {
//            System.out.println("File is create");
//        }
        // Создание директории
        Files.createDirectory(Paths.get("/home/ekoregin/tmp/testDir"));
        if (Files.isDirectory(Paths.get("/home/ekoregin/tmp/testDir"))) {
            System.out.println("This is directory");
        }
    }
}
