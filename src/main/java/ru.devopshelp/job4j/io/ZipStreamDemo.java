package ru.devopshelp.job4j.io;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("d:\\temp\\test.zip");
        ZipOutputStream zos = new ZipOutputStream(fos);
        FileInputStream fis = new FileInputStream("d:\\temp\\dump.xml");
        ZipEntry ze = new ZipEntry(String.valueOf("d:\\temp\\dump.xml"));
        zos.putNextEntry(ze);
        zos.write(fis.readAllBytes());
        zos.closeEntry();
        zos.close();
    }
}
