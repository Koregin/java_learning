package job4j.io;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirListFiles {
    public static void main(String[] args) {
        Path downloads = Paths.get("/home/ekoregin/Downloads");
        try (DirectoryStream<Path> dirStream =
                     Files.newDirectoryStream(downloads)) {
            for (Path child : dirStream) {
                System.out.println(child);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
