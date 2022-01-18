package ru.devopshelp.codewars.level7;

public class Square {
    public static boolean isSquare(int n) {
        boolean result = false;
        for (int i = 0; i * i <= n; i++) {
            if (i * i == n) {
                System.out.println(n + " is a square " + "(" + i + " * " + i +")");
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        isSquare(-1);
        isSquare(-4);
        isSquare(0);
        isSquare(3);
        isSquare(4);
        isSquare(25);
        isSquare(26);
        isSquare(192750656);
    }
}
