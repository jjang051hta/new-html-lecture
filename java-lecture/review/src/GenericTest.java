class Pocket<T1, T2, T3> {
    private T1 a;
    private T2 b;
    private T3 c;

    public T1 getA() {
        return a;
    }

    public T2 getB() {
        return b;
    }

    public T3 getC() {
        return c;
    }

    public Pocket(T1 a, T2 b, T3 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

}

public class GenericTest {
    public static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        Pocket<String, String, String> pocket01 = new Pocket<>("10", "20", "30");
        Pocket<Integer, Integer, Integer> pocket02 = new Pocket<>(10, 20, 30);
        System.out.println(add(10, 10));

    }
}
