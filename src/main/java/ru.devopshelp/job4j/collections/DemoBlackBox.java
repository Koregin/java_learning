package job4j.collections;

public class DemoBlackBox {
    public static void main(String[] args) {
        BlackBox object1 = new BlackBox(5, 10);
        BlackBox object2 = new BlackBox(5, 10);
        System.out.println("Хэш код 1: " + object1.hashCode());
        System.out.println("Хэш код 2: " + object2.hashCode());
        System.out.println("Сравнение двух объектов: " + object1.equals(object2));
    }
}
