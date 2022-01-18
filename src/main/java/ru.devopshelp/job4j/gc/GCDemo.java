package ru.devopshelp.job4j.gc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GCDemo {
    private static List<User> users = new ArrayList();
    private static boolean cont = true;
    private static String input;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static int age = 0;
    private static int index = 0;

    private static final Runtime ENVIRONMENT = Runtime.getRuntime();

    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: %d%n", freeMemory);
        System.out.printf("Total: %d%n", totalMemory);
        System.out.printf("Max: %d%n", maxMemory);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        for (int i = 0; i < 10000000; i++) {
            System.out.println("Creating object " + i);
            new User("User" + i, i);
        }
//        System.out.println("Welcome to Memory Tool!");
//        info();
//        while (cont) {
//            System.out.println(
//                    "\n\nI have " + users.size() + " objects in use, about " +
//                            (users.size() * 92) + " B." +
//                            "\nWhat would you like me to do?\n" +
//                            "1. Create some objects\n" +
//                            "2. Remove some objects\n" +
//                            "3. Show created objects\n" +
//                            "0. Quit");
//            input = in.readLine();
//            if ((input != null) && (input.length() >= 1)) {
//                if (input.startsWith("0")) cont = false;
//                if (input.startsWith("1")) createObjects();
//                if (input.startsWith("2")) removeObjects();
//                if (input.startsWith("3")) showObjects();
//            }
//        }
    }

    private static void createObjects() {
        System.out.println("Creating objects...");
        users.add(new User("Name" + index, age));
        age++;
        index++;
        info();
    }

    private static void removeObjects() {
        System.out.println("Removing objects...");
        users.remove(index-1);
        index--;
        info();
    }

    private static void showObjects() {
        for (User user : users) {
            System.out.println(user.name + " | " + user.age);
        }
    }

    public void HeapUsage() {
        System.out.println("Before ");
        printHeapUsage();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i<10000000; i++) {
            set.add(String.valueOf(i));
        }
        System.out.println("After");
        printHeapUsage();
    }

    private static void printHeapUsage() {
        for (MemoryPoolMXBean mpbean :
                ManagementFactory.getMemoryPoolMXBeans()) {
            MemoryUsage usage = mpbean.getCollectionUsage();
            if (usage != null) {
                long max = usage.getMax();
                long used = usage.getUsed();
                System.out.println(mpbean.getName() + " Used " + used + ", Max " + max);
            }
        }
    }
}
