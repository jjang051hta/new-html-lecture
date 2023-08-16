import java.util.Scanner;

public class ContinueTest {
    public static void main(String[] args) {
        // 다섯개의 정수를 입력받겠다.
        // 이때 양의 정수의 합만 구하시오.
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.println("정수 다섯개를 입력하시오.");
        for (int i = 0; i < 5; i++) {
            int num = scanner.nextInt();
            if (num < 0) {
                continue;
            } else {
                sum += num;
            }
        }
        System.out.println(sum);
    }
}
