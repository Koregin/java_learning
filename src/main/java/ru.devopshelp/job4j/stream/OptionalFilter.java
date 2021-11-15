package job4j.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalFilter {
    public static class Worker {

        private String passport;

        private List<Child> children = new LinkedList<>();

        public Worker(String passport, List<Child> children) {
            this.passport = passport;
            this.children = children;
        }

        public String getPassport() {
            return passport;
        }

        public List<Child> getChildren() {
            return children;
        }
    }

    public static class Child {

        private String name;

        private int age;

        public Child(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static List<Child> defineChildren(List<Worker> workers, String passport) {
        List<Child> child = findByPassport(workers, passport).get().getChildren();
        return child.size() > 2 ? child.stream().filter(ch -> ch.getAge() < 15).collect(Collectors.toList()) : List.of();
    }

    public static Optional<Worker> findByPassport(List<Worker> workers, String passport) {
        return workers.stream()
                .filter(w -> w.getPassport().equals(passport))
                .findFirst();
    }

    public static void main(String[] args) {
        Child c1 = new Child("c1", 15);
        Child c2 = new Child("c2", 13);
        Child c3 = new Child("c1", 10);
        Child c4 = new Child("c2", 15);
        Worker worker1 = new Worker("123", List.of(c1, c2, c3));
        Worker worker2 = new Worker("456", List.of(c4));
//        List<Worker> workers = List.of(worker1, worker2);
//        Optional<Worker> foundWorker = findByPassport(workers, "123");
        System.out.println(OptionalFilter.defineChildren(List.of(worker1, worker2), "123"));
        System.out.println(OptionalFilter.defineChildren(List.of(worker1, worker2), "123"));
        System.out.println(OptionalFilter.defineChildren(List.of(worker1, worker2), "123").size());
    }
}
