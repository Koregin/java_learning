package ru.devopshelp.shildt.io;

import java.io.File;
import java.nio.file.Path;

public class FileDemo {
    static void p(String s) {
        System.out.println(s);
    }
    public static void main(String[] args) {
        File f1 = new File("d:\\temp\\filefordelete.txt");
        p(f1.getName());
        p(f1.getPath());
        p(f1.getAbsolutePath());
        p(f1.getParent());
        Path f2 = f1.toPath();
        p("Размер: " + f1.length());
        System.out.println(f1.renameTo(new File("d:\\temp\\newname.txt")));
    }
}
