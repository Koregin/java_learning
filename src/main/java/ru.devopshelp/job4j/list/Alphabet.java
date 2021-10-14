package job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alphabet {
    public static String reformat(String a) {
        StringBuilder s = new StringBuilder();
        List<String> abc = Arrays.asList(a.split(""));
        abc.sort(String::compareTo);
        for (String l : abc) {
            s.append(l);
        }
        return s.toString();
    }
}
