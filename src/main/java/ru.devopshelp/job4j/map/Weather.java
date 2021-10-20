package job4j.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Weather {
    public static List<Info> editData(List<Info> list) {
        List<Info> rsl = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (Info info : list) {
            if (!map.containsKey(info.getCity())) {
                map.put(info.getCity(), info.getRainfall());
            } else {
                map.merge(info.getCity(), info.getRainfall(), (oldV, newV) -> oldV += newV);
            }
        }
        for (String key : map.keySet()) {
            rsl.add(new Info(key, map.get(key)));
        }
        return rsl;
    }

    public static class Info {
        private String city;

        private int rainfall;

        public Info(String city, int rainfall) {
            this.city = city;
            this.rainfall = rainfall;
        }

        public String getCity() {
            return city;
        }

        public int getRainfall() {
            return rainfall;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return rainfall == info.rainfall
                    && Objects.equals(city, info.city);
        }

        @Override
        public int hashCode() {
            return Objects.hash(city, rainfall);
        }
    }
}
