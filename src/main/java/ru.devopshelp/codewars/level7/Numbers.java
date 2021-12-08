package codewars.level7;

import java.util.Arrays;

public class Numbers {
    public static double twoDecimalPlaces(double number) {
        String s = Double.toString(number);
        String[] str = s.split("\\.");
        str[1] = str[1].substring(0, 2);
        s = String.join(".", str);
        return Double.parseDouble(s);
    }

    public static void main(String[] args) {
        System.out.println(twoDecimalPlaces(124.7668));
        System.out.println((int) (127.789 * 100) / 100.0);
    }
}
