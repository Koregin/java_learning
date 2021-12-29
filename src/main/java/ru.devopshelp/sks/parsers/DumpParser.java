package ru.devopshelp.sks.parsers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Парсинг дампа tcpdump для нахождения уникальных IP адресов
 */

public class DumpParser {
    public static void main(String[] args) {
        Path path = Paths.get("data/tcpdumputm.log");
        if (!Files.exists(path)) {
            System.out.println("Файл не найден");
        }
        Set<String> ips = new HashSet<>();
        try(Scanner scanner = new Scanner(path)) {
            while (scanner.hasNextLine()) {
                List<String> list = List.of(scanner.nextLine().split("\\s"));
                if (list.size() >= 3) {
                    String str = list.get(2);
                    int iend = list.get(2).lastIndexOf(".");
                    ips.add(str.substring(0, iend));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        printIps(ips);
    }

    /**
     * Выводит список IP адресов
     * @param ips на вход принимает множество
     */
    private static void printIps(Set<String> ips) {
        for (String ip : ips) {
            System.out.println(ip);
        }
    }
}
