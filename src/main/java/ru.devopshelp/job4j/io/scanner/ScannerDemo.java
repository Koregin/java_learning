package job4j.io.scanner;

import java.util.Map;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
//        System.out.println("Введите число:");
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        System.out.println("Вы ввели: " + i);

//        String input = "1 fish 2 fish red fish blue fish";
//        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//        System.out.println(s.nextInt());
//        System.out.println(s.next().getClass());
//        System.out.println(s.next());
//        System.out.println(s.next());
//        s.close();

        Map<String, String> map = Map.of("path", "/home/ekoregin", "filter", "admin");
        System.out.println(map.get("pat"));
    }
}
