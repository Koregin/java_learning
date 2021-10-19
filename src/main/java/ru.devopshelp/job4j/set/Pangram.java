package job4j.set;

import java.util.*;

public class Pangram {
    public static boolean checkString(String s) {
        Set<String> strings = new HashSet(Set.of(s.split(" ")));
        //Iterator<String> iterator = strings.iterator();
        HashSet<String> abc = new HashSet<>();
        for (String str : strings) {
            System.out.println();
        }
        /*while (iterator.hasNext()) {
            for (String str : str)
        }*/
        return false;
    }

    public static void main(String[] args) {
        String str = "Jackdaws love my big sphinx of quartz";
        String[] listStr = str.split(" ");
        HashSet<String> abc = new HashSet<String>();
        for (String str1 : listStr) {
            for (String s : str1.split("")) {
                abc.add(s);
            }
        }
        for (String a : abc) {
            System.out.print(a);
        }
        //Pangram.checkString(str);
    }
}
