package ru.devopshelp.job4j.io;

import java.io.*;
import java.nio.file.Files;

public class DataInputOutputDemo {
    public static void main(String[] args) throws IOException {
        int number = 100;
        long longNumber = 200L;
        float floatNumber = 3.14F;
        double doubleNumber = 34.23423423432;
        /* Запись двоичных данных в файл */
        try(FileOutputStream fos = new FileOutputStream("d:\\temp\\employee.dat");
            DataOutputStream outputStream = new DataOutputStream(fos)) {
            outputStream.writeInt(number);
            outputStream.writeLong(longNumber);
            outputStream.writeFloat(floatNumber);
            outputStream.writeDouble(doubleNumber);
        }
        /* Чтение двоичных данных из файла */
        try (FileInputStream fis = new FileInputStream("d:\\temp\\employee.dat");
             DataInputStream inputStream = new DataInputStream(fis)) {
            var numInt = inputStream.readInt();
            System.out.println(numInt);
            System.out.println(inputStream.readLong());
            System.out.println(inputStream.readFloat());
            System.out.println(inputStream.readDouble());
        }
    }
}
