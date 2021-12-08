package job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DirListFilesWithWalkTree extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.toAbsolutePath());
        return CONTINUE;
    }

    public static void main(String[] args) throws IOException {
        Path downloads = Paths.get("/home/ekoregin/Downloads");
        Files.walkFileTree(downloads, new DirListFilesWithWalkTree());
    }
}
