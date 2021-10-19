package job4j.set;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<String>();
        names.add("Evgeny");
        names.add("Petr");
        names.add("Petr");
        names.add("Ivan");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
