package ru.devopshelp.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BRReadLines {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строки:");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("стоп"));
    }
}
