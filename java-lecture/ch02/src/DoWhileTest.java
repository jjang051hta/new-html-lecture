public class DoWhileTest {
    public static void main(String[] args) {
        // a~z
        char c = 'a';
        // System.out.println((char) (c + 2));
        do {
            System.out.print(c);
            c = (char) (c + 1);
        } while (c <= 'z');

    }
}
