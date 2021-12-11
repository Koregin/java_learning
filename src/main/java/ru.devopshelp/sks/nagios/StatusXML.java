package sks.nagios;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;

public class StatusXML {
    public static Map<String, Map<String, String>> hosts = new HashMap<>();

    public static void main(String[] args) throws IOException {
        FileTime newTime = null;
        FileTime currentTime = null;
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
        int hostWithproblems = 0;

        StringBuilder sb = new StringBuilder();
        sb.append(headerFooter("header"));
        int rowcount = 0;
        for (String key : hosts.keySet()) {
            String problem = null;
            Map<String, String> services = hosts.get(key);
            for (String param : services.keySet()) {
                if (!"0".equals(services.get(param))){
                    //System.out.println("Host: " + key + ", " + param + ": " + services.get(param));
                    hostWithproblems++;
                    problem = param;
                }
            }
            if (rowcount % 5 == 0) {
                sb.append("<tr>\n");
            }
            if (problem != null) {
                if ("PING".equals(problem)) {
                    sb.append("<td class=\"statusPING\">").append(key).append(" <b>PING</b>").append("</td>\n");
                } else {
                    sb.append("<td class=\"statusWARNING\">").append(key).append("  <b>").append(problem).append("</b></td>\n");
                }
            } else {
                sb.append("<td class=\"statusOK\">").append(key).append("</td>\n");
            }
            if (rowcount % 5 == 4) {
                sb.append("</tr>\n");
            }
            rowcount++;
        }
        sb.append(headerFooter("footer"));
        System.out.println(sb.toString());
        System.out.println("Всего хостов: " + hosts.size());
        System.out.println("Хостов с проблемами: " + hostWithproblems);
    }

    public static String headerFooter(String html) {
        String header = "<HTML>\n" +
                " <HEAD>\n" +
                "  <META http-equiv=\"Refresh\" content=\"120\">\n" +
                "  <TITLE>Current Network Status</TITLE>\n" +
                "  <STYLE>\n" +
                "TABLE { width: 100%; }\n" +
                "A { color: black; }\n" +
                ".statusHOSTPENDING { font: 20pt arial,serif; background-color: #ACACAC; }\n" +
                ".statusOK { font: 20pt arial,serif; background-color: #33FF00; }\n" +
                ".statusPING { font: 20pt arial,serif; background-color: #F83838; }\n" +
                ".statusWARNING { font: 20pt arial,serif; background-color: #FFBB33; }\n" +
                "  </STYLE>\n" +
                " </HEAD>\n" +
                " <BODY>\n" +
                "  <TABLE width=\"100%\">\n";
        String footer = "</TABLE>\n" +
                " </BODY>\n" +
                "</HTML>";
        return "header".equals(html) ? header : footer;
    }
}
