class Sample {
    public int a;
    private int b;
    int c;
}

public class AccessTest {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.a = 10;
        sample.c = 30;
    }
}
