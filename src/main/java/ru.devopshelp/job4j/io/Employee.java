package ru.devopshelp.job4j.io;

import java.io.Serializable;

public class Employee implements Serializable {
    String name;
    long salary;

    public Employee(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
