package job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SummingMethod {
    public static class User {

        private String name;

        private List<Bill> bills = new ArrayList<>();

        public User(String name, List<Bill> bills) {
            this.name = name;
            this.bills = bills;
        }

        public String getName() {
            return name;
        }

        public List<Bill> getBills() {
            return bills;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + ", bills=" + bills
                    + '}';
        }
    }

    public static class Bill {

        private int balance;

        public Bill(int balance) {
            this.balance = balance;
        }

        public int getBalance() {
            return balance;
        }

        @Override
        public String toString() {
            return "Bill{"
                    + "balance=" + balance
                    + '}';
        }
    }

    private static class Pair {
        private User user;
        private Bill bill;

        public Pair(User user, Bill bill) {
            this.user = user;
            this.bill = bill;
        }

        public User getUser() {
            return user;
        }

        public Bill getBill() {
            return bill;
        }

        @Override
        public String toString() {
            return "Pair{"
                    + "user=" + user
                    + ", bill=" + bill
                    + '}';
        }
    }

    public static Map<String, Integer> summing(List<User> users) {
        List<Pair> pairs = new ArrayList<>();
        for (User user : users) {
            for (Bill bill : user.getBills()) {
                pairs.add(new Pair(user, bill));
            }
        }
        return pairs.stream()
                .collect(Collectors.groupingBy(user -> user.getUser().getName(),
                        Collectors.summingInt(bill -> bill.getBill().getBalance())));
    }

    public static void main(String[] args) {
        Bill b1 = new Bill(1);
        Bill b2 = new Bill(2);
        Bill b3 = new Bill(3);
        Bill b4 = new Bill(4);
        Bill b5 = new Bill(5);
        Bill b6 = new Bill(6);
        User u1 = new User("u1", List.of(b1));
        User u2 = new User("u2", List.of(b2, b3));
        User u3 = new User("u3", List.of(b4, b5, b6));
        // Надо создать список Pair для Пары User<->Bill
        List<Pair> pairs = new ArrayList<>();
/*        for (User user : List.of(u1, u2, u3)) {
            for (Bill bill : user.getBills()) {
                pairs.add(new Pair(user, bill));
            }
        }*/
        List.of(u1, u2, u3).forEach(user -> {
            user.getBills().forEach(bill -> {
                pairs.add(new Pair(user, bill));
            });
        });

        Map<String, Integer> summing = pairs.stream()
                .collect(Collectors.groupingBy(user -> user.getUser().getName(),
                Collectors.summingInt(bill -> bill.getBill().getBalance())));
        System.out.println(summing);
    }
}
