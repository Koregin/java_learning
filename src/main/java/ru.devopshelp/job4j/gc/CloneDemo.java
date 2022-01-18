package ru.devopshelp.job4j.gc;

public class CloneDemo {
    static class Person implements Cloneable {
        String name;
        int age;
        String color;

        public Person(String name, int age, String color) {
            this.name = name;
            this.age = age;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", color=" + color +
                    '}';
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        String string =  "String demo";
        Person person = new Person("Ivan", 23, "red");
        Person clone = (Person) person.clone();
        System.out.println(person);
        System.out.println(clone);
        clone.name = "Petr";
        clone.age = 33;
        System.out.println(person);
        System.out.println(clone);
    }
}
