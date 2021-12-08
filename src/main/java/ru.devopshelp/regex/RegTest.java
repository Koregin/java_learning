package regex;

import java.util.Arrays;

public class RegTest {
    public static void main(String[] args) {
        String[] config = {"name=Ivanov", "passw=pass", "\n", "ip=10.3.0.3", "#Config",
                "gender==male", "=panda", "key=", "star=Trek==break", "hello world"};
        for (String line : config) {
            // Пропустить пустые строки и комментарии
            if (line.length() > 1 && !line.contains("#") && line.contains("=")) {
                //System.out.println(line);
                // Выявить нарушение шаблона
                String[] pair = line.split("=");
                if (pair[0].length() < 1 || pair.length != 2) {
                    System.out.println("Строка не соответствует шаблону: ");
                }
                System.out.println(Arrays.toString(pair) + ", size: " + pair.length);
            }
        }
    }
}
