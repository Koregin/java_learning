package ru.devopshelp.job4j.collections;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
