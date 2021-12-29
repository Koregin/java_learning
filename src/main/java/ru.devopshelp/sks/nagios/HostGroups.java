package ru.devopshelp.sks.nagios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Получение хостов из файлов конфигураций в выбранной директории
 * @author Koregin Evgeny
 */

public class HostGroups {

    public static void main(String[] args) {
        Path switches = Paths.get("d:\\projects\\SKS\\nagios\\config\\switches");
        Set<String> swhosts = getGroupHosts(switches);
        swhosts.forEach(System.out::println);
    }
    /**
     * Аггрегирование хостов из файлов всей директории
     * @param confDir путь к директории с конфигами
     * @return множество хостов из всех файлов
     */
    public static Set<String> getGroupHosts(Path confDir) {
        Set<String> hostsGroup = new HashSet<>();
        try(Stream<Path> stream =
                    Files.list(confDir)) {
            stream.filter(file -> !Files.isDirectory(file))
                    .map(Path::toString)
                    .forEach(config -> hostsGroup.addAll(getHosts(config)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hostsGroup;
    }

    /**
     * Получение хостов из одного файла конфигурации
     * @param config путь к файлу конфигурации
     * @return множество хостов из одного файла
     */
    public static Set<String> getHosts(String config) {
        Set<String> hosts = new HashSet<>();
        try(BufferedReader br = new BufferedReader(
                new FileReader(config)
        )) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("host_name")) {
                    hosts.add(line.trim().split("\s+")[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hosts;
    }
}
