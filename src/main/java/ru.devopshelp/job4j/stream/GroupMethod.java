package job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupMethod {

    public static class User1 {

        private int age;

        private String name;

        public User1(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User1 user = (User1) o;
            return age == user.age
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }
    }

    public static Map<Integer, List<User1>> groupBy(List<User1> users) {
        return users.stream()
                .collect(Collectors.groupingBy(User1::getAge));
    }
}
