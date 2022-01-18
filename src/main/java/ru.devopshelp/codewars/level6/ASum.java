package ru.devopshelp.codewars.level6;

public class ASum {
    public static long findNb(long m) {
        long i = 0;
        while (m > 0) {
            i++;
            m -= i * i * i;
        }
        return m == 0 ? i : -1;
    }

    public static void main(String[] args) {
        System.out.println(findNb(1071225));
        System.out.println(findNb(1706540015414063025L));
        System.out.println(findNb(91716553919377L));
    }
}
