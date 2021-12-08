package codewars;

public class Kata1 {
    public static String multiTable(int num) {
        String result = "";
        String ln = System.lineSeparator();
        for (int i = 1; i < 11; i++) {
            result += i + " * " + num + " = " + i * num;
            if (i < 10) {
                result += ln;
            }
        }
        return result; // good luck
    }

    public static void main(String[] args) {
        System.out.println(multiTable(5));
    }
}
