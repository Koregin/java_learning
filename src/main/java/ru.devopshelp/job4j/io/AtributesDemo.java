package job4j.io;

import javax.print.attribute.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.jar.Attributes;

public class AtributesDemo {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("/home/ekoregin/tmp/duplicates.zip");
        BasicFileAttributeView basicView = Files.getFileAttributeView(file, BasicFileAttributeView.class);
        System.out.println(basicView.readAttributes().size());
        System.out.println(Files.isDirectory(file));
        System.out.println(Files.getLastModifiedTime(file));
        System.out.println(Files.getOwner(file));
        UserPrincipal name = new UserPrincipal() {
            @Override
            public String getName() {
                return "root";
            }
        };
        Files.setOwner(file, name);
        //System.out.println(Files.getOwner(file));
    }
}
