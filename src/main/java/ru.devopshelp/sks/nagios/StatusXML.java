package sks.nagios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;

public class StatusXML {
    //public static List<Host> hosts = new ArrayList<>();
    public static Map<String, Map<String, String>> hosts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        FileTime newTime = null;
        FileTime currentTime = null;
        //Set<String> hostnames = new HashSet<>();
        Path statusFile = Paths.get("/home/mnemonic/programming/java/java_learning/src/data/status.dat");
        if (Files.exists(statusFile)) {
            BasicFileAttributes attr =
                    Files.readAttributes(statusFile, BasicFileAttributes.class);
            newTime = attr.lastModifiedTime();
        }
        try (FileReader fileReader = new FileReader(statusFile.toFile());
             BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            String hostname = null;
            String hoststate = null;
            boolean newhost = false;
            boolean newservice = false;
            String hostforservice = null;
            String servicename = null;
            String servicestatus = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().startsWith("hoststatus")) {
                    newhost = true;
                }
                if (newhost && line.trim().contains("host_name")) {
                    hostname = line.split("=", 2)[1];
                }
                if (newhost && line.trim().startsWith("current_state")) {
                    hoststate = line.split("=", 2)[1];
                }
                if (newhost && line.trim().contains("}")) {
                    String finalHoststate = hoststate;
                    hosts.put(hostname, new HashMap<>() {{
                        put("hoststate", finalHoststate);
                    }});
                    newhost = false;
                    hostname = "";
                    hoststate = "";
                }
                /* Добавление сервисов*/
                if (line.trim().startsWith("servicestatus")) {
                    newservice = true;
                }
                if (newservice && line.trim().contains("host_name")) {
                    hostforservice = line.split("=", 2)[1];
                }
                if (newservice && line.trim().contains("service_description")) {
                    servicename = line.split("=", 2)[1];
                }
                if (newservice && line.trim().contains("current_state")) {
                    servicestatus = line.split("=", 2)[1];
                }
                if (newservice && line.trim().contains("}")) {
                    if (hosts.containsKey(hostforservice)) {
                        hosts.get(hostforservice).put(servicename, servicestatus);
                    }
                    newservice = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String key : hosts.keySet()) {
            System.out.println("Host: " + key + ", " + hosts.get(key).toString());
        }
        System.out.println("Всего хостов: " + hosts.size());
    }
}
