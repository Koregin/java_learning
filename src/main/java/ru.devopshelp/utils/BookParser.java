package ru.devopshelp.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookParser {

    private static final int WORD_MIN_REPEAT = 15;
    private static final int MIN_LENGTH = 4;
    private static Path fileForRead = Paths.get("e:\\temp\\Book 1 - The Philosopher's Stone.txt");
    private static Path fileForWrite = Paths.get("e:\\temp\\harrypotter1words.txt");

    public static void main(String[] args) throws IOException {
        Map<String, Integer> uniqueWords = createMap(readBookFile(fileForRead));
        saveSortedMap(uniqueWords, fileForWrite);
    }

    /**
     * Получение списка фильтрованных слов. Удаление знаков препинания и слов меньше 3 букв
     * @param file текстовый файл
     * @return список слов
     * @throws IOException
     */
    private static List<String> readBookFile(Path file) throws IOException {
        try(Stream<String> stringStream = Files.lines(file)) {
            return  stringStream
                    .filter(string -> !string.matches("^Page.*"))
                    .map(string -> string.split("\\s"))
                    .flatMap(Arrays::stream)
                    .filter(word -> !word.contains("’"))
                    .map(word -> word.replaceAll("[”“.!?,;:()‘]", ""))
                    .map(word -> word.replaceAll("^-", ""))
                    .map(word -> word.replaceAll("-$", ""))
                    .filter(word -> !word.matches("\\d+"))
                    .map(String::toLowerCase)
                    .filter(word -> word.length() > BookParser.MIN_LENGTH)
                    .collect(Collectors.toList());
        }
    }

    /**
     * Создание словаря с уникальными словами и количеством повторений в тексте
     * @param wordsList список слов
     * @return словарь: слово : кол-во повторений
     */
    private static Map<String, Integer> createMap(List<String> wordsList) {
        Map<String, Integer> uniqueWords = new TreeMap<String, Integer>();
        for (String word : wordsList) {
            uniqueWords.putIfAbsent(word, 1);
            uniqueWords.computeIfPresent(word, (key, value) -> value = value + 1);
        }
        return valueSort(uniqueWords);
    }

    /**
     * Сохранение словаря в файл
     * @param sortedMap словарь
     * @param file файл для записи
     */
    private static void saveSortedMap(Map<String, Integer> sortedMap, Path file) {
        Set<Map.Entry<String, Integer>> set = sortedMap.entrySet();
        Iterator<Map.Entry<String, Integer>> i = set.iterator();
        try(FileWriter writer = new FileWriter(file.toString())) {
            String ln = System.lineSeparator();
            writer.write("Название книги: " + fileForRead.getFileName() + ln);
            writer.write("Количество уникальных слов: " + sortedMap.size() + ln);
            writer.write("Минимальная длина слова: " + MIN_LENGTH + ln);
            writer.write("Минимальное число повторений слова в тексте: " + BookParser.WORD_MIN_REPEAT + ln);
            writer.write(System.lineSeparator());
            while (i.hasNext()) {
                Map.Entry mp = (Map.Entry) i.next();
                if ((Integer)mp.getValue() >= (Integer) BookParser.WORD_MIN_REPEAT) {
                    writer.write(mp.getKey() + ": " + mp.getValue());
                    writer.write(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Static Method with return type Map and
     * extending comparator class which compares values
     * associated with two keys
     * @param map
     * @param <K>
     * @param <V>
     * @return
     */
    private static <K, V extends Comparable<V> > Map<K, V> valueSort(final Map<K, V> map)
    {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int comp = map.get(k2).compareTo(map.get(k1));
                return comp == 0 ? 1 : comp;
            }
        };
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        sorted.putAll(map);
        return sorted;
    }
}
