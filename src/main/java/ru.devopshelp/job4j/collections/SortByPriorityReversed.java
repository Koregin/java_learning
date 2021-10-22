package ru.devopshelp.job4j.collections;

import java.util.Comparator;

public class SortByPriorityReversed implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.compareTo(first);
    }
}
