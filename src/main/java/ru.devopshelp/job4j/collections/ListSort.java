package job4j.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        Integer first = 1;
        Integer second = 2;
        int rsl = first.compareTo(second);
        System.out.println(rsl);

        String petr = "Petr";
        String ivan = "Ivan";
        int rslStr = ivan.compareTo(petr);
        System.out.println(rslStr);

        List<Integer> list2 = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list2);
        Collections.sort(list2, Collections.reverseOrder());
        System.out.println(list2);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList( 1, 4, 5, 7));
        for (Integer num : list1) {
            System.out.println(num);
        }
    }
}
