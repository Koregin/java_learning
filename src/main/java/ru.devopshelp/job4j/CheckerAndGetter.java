package job4j;

import java.util.List;

public class CheckerAndGetter {
    public static String getElement(List<String> list) {

        return list.isEmpty() ? "" : list.get(0);
    }
}
