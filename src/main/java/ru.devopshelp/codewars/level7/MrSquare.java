package codewars.level7;

public class MrSquare {
    public static Boolean fitIn(int a, int b, int m, int n) {
        // Условия
        // Стороны двух квадратов не должны превышать
        // самую длинную сторону прямоугольника
        return a + b <= Math.max(m, n);
    }
}
