package ru.devopshelp.job4j.map;

import org.junit.Test;

import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class NonUniqueStringTest {
    @Test
    public void checkData() {
        String[] data = {"a", "b", "a", "c", "b"};
        Map<String, Boolean> rsl = ru.devopshelp.job4j.map.NonUniqueString.checkData(data);
        Map<String, Boolean> expected = Map.of("a", true, "b", true, "c", false);
        assertThat(rsl, is(expected));
    }
}