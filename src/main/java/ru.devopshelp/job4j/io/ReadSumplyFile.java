package ru.devopshelp.job4j.io;

import java.io.*;
import java.nio.BufferUnderflowException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadSumplyFile {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("d:\\Programming\\java\\вопросы в фоксмайндед.txt");
        /* Чтение файла в ввиде символьной строки*/
        String content = Files.readString(file, Charset.defaultCharset());
        System.out.println(content);
        /* Чтение файла в виде последовательности строк */
        List<String> lines = Files.readAllLines(file, Charset.defaultCharset());
        lines.forEach(System.out::println);
        /* Обработка крупных файлов в ввиде потока типа Stream<String> */
        Path readme = Paths.get("d:\\Programs\\tools\\apache-maven-3.8.3\\README.txt");
        try (Stream<String> streamlines = Files.lines(readme)) {
            streamlines.forEach(System.out::println);
        }
        /* Обработка данных при помощи Bufferedreader */
        InputStream inputStream = new FileInputStream("d:\\IOS_IP_Multicast_Analysis_09-03-2020.1627.json");
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
//            String line;
//            while ((line = in.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
        //
        try (BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            in.lines().forEach(System.out::println);
        }

        InputStream inputStream1 = new FileInputStream("d:\\temp\\index.php");
        String str = new String(inputStream1.readAllBytes(), Charset.forName("WINDOWS-1251"));
        System.out.println(str);
    }
}
