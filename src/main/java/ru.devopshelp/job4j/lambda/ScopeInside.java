package ru.devopshelp.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        String ayyyy = "ayyyyy";
        String name = echo(
                () -> {
                    return ayyyy;
                }
        );
        System.out.println(ayyyy);
        System.out.println(name);
    }

    private static String echo(Supplier<String> supplier) {
        String sound = supplier.get();
        return sound + " " + sound + " " + sound;
    }
}
