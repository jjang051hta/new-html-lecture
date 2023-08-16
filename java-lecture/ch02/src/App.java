public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        int i;
        int sum = 0;
        // 1 + 2 + 3 + 4... + 10 = 55; // 홀수의 합
        for (i = 10; i > 0; i--) {
            sum = sum + i;
            // System.out.print(i);
        }
        System.out.println(sum);
    }
}
