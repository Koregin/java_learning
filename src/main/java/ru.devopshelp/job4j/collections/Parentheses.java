package job4j.collections;

public class Parentheses {
    public static boolean valid(char[] data) {
        boolean res = false;
        if (data[0] == '(') {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == '(') {
                    res = false;
                } else if (data[i] == ')') {
                    res = true;
                }
            }
        }
        return res;
    }

    public static boolean valid2(char[] data) {
                boolean res = false;
        int temp = 0;
        if (data[0] == '(') {
            for (int i = 0; i < data.length; i++) {
                if (data[i] == '(') {
                    temp++;
                } else if (data[i] == ')') {
                    temp--;
                }
            }
            if (temp == 0) {
                res = true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[] parent = new char[] {'(', '(', ')', ')'};
        char[] parent2 = new char[] {'(', ')', '(', ')'};
        char[] parent3 = new char[] {')', ')', '(', '('};
        char[] parent4 = new char[] {'(', ')', '(', '('};
        //1. Проверка на равное кол-во скобок разных типов
        //2. Проверка на очередность
        //List<char[]> chars = List.of(parent);

        System.out.println(valid(parent));
        System.out.println(valid(parent2));
        System.out.println(valid(parent3));
        System.out.println(valid(parent4));
    }
}
