package job4j.stream;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentLevel {
    public static class Student {

        private int score;
        private String surname;

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getScore() {
            return score;
        }

        public String getSurname() {
            return surname;
        }

        public Student(String surname, int score) {
            this.score = score;
            this.surname = surname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return score == student.score
                    && surname.equals(student.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(score, surname);
        }

        @Override
        public String toString() {
            return "Student{"
                    + "score=" + score
                    + ", surname='" + surname + '\''
                    + '}';
        }
    }

    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(Objects::nonNull)
                .sorted((left, right) -> right.getScore() - left.getScore())
                .takeWhile(st -> st.score > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        System.out.println(StudentLevel.levelOf(input, 20).toString());
        System.out.println(StudentLevel.levelOf(input, 100));
    }
}
