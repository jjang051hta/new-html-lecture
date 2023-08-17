class Calc {
    static int abs(int a) {
        return a > 0 ? a : -a;
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a > b ? b : a;
    }
}

public class StaticTest {
    public static void main(String[] args) {
        // Calc calc = new Calc();
        // Math.abs(-10);
        Calc.abs(-10);
    }
}
