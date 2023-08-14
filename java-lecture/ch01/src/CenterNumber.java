import java.util.Scanner;

public class CenterNumber {
    public static void main(String[] args) {
        System.out.println("숫자 3개를 입력하면 가운데 숫자를 알려드립니다.");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int center = a;
        if ((a >= b && a <= c) || (a >= c && a <= b)) {
            center = a;
        } else if ((b >= a && b <= c) || (b >= c && b <= a)) {
            center = b;
        } else {
            center = c;
        }
        System.out.println("가운데 숫자는 " + center + "입니다.");

        System.out.println(3 > 2 || 3 > 6);
    }
}
