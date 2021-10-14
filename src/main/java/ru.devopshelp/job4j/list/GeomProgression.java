package job4j.list;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        int res = first;
        for (int index = first + 1; index <= count; index++) {
            res += first * Math.pow(denominator, index - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateAndSum(1, 3, 10));
        System.out.println(generateAndSum(1, -1, 10));
    }
}
