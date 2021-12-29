package ru.devopshelp.collections.map;

import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args)
    {
        HashMap map = new HashMap();
        map.put(new Key("vishal"), 20);
        map.put(new Key("sachin"), 30);
        map.put(new Key("vaibhav"), 40);

        System.out.println();
        System.out.println("Value for key sachin: " + map.get(new Key("sachin")));
        System.out.println("Value for key vaibhav: " + map.get(new Key("vaibhav")));
    }
}
