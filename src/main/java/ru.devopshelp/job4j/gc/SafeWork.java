package ru.devopshelp.job4j.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SafeWork {
    public static void main(String[] args) {
        List<SoftReference<Integer>> numbers = new ArrayList<>();
        /*Создаем массив мягких ссылок на Integer*/
        for (int i = 0; i < 100; i++) {
            numbers.add(new SoftReference<Integer>(i));
        }
        /* Работает с объектами безопасно */
        for (SoftReference<Integer> numRef : numbers) {
            Integer num = numRef.get();
            if (num != null) {
                System.out.println(num);
            }
        }
    }
}
