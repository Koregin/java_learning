package ru.devopshelp.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan Ivanov", 50000);
        Employee petr = new Employee("Petr Arsentev", 80000);
        Path file = Paths.get("d:\\temp\\employee.dat");
        try (FileOutputStream fos = new FileOutputStream(file.toFile());
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(ivan);
            oos.writeObject(petr);
            oos.writeDouble(3.14);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file.toFile()))) {
            Employee e1 = (Employee) in.readObject();
            Employee e2 = (Employee) in.readObject();
            System.out.println(e1.toString());
            System.out.println(e2.toString());
            System.out.println(in.readDouble());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
