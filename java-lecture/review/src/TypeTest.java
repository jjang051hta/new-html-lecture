public class TypeTest {
    public static void main(String[] args) {
        // type은 많다.
        // 8개
        boolean isTrue = true; // false
        System.out.println(isTrue);
        int intNum = 2000000000; // int 는 4바이트
        long longNum = 4000000000000000000L; // long 은 8바이트
        byte byteNum = 127; // 1바이트 (2*8)
        short shortNum = 10000; // 2 바이트 (2*16)
        // int price = 10_000_000;
        float floatNum = 3.14f;
        double doubleNum = 3.14;
        char ch = 'c';
        String str = "글을 씁니다.";
        System.out.println(10 + 2);
        System.out.println(10 - 2);
        System.out.println(10 * 2);
        System.out.println(10 / 2);
        System.out.println(10 % 4);
        int x = 0;
        x = x + 1;
        x += 1;
        x++;
        int y = 10;
        System.out.println(x++);
        System.out.println(x > y);
        System.out.println(x >= y);
        System.out.println(x < y);
        System.out.println(x <= y);
        System.out.println(x == y);
        System.out.println(x != y);
        boolean isStop = false;
        System.out.println(!isStop);

        System.out.println(Float.MAX_VALUE);
        System.out.println(-Float.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);
        double double01 = 5.0 / 2;
        System.out.println(double01);

        char ch01 = 'a';
        char ch02 = 97;
        System.out.println((int) ch01);
        System.out.println(ch02);

        // System.out.println(Math.pow(2, 64));

    }
}