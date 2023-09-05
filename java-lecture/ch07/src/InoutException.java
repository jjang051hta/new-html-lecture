import java.util.InputMismatchException;
import java.util.Scanner;

public class InoutException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 3개를 입력하시오");
        int sum = 0, num = 0;
        // 자바 io, 모든 걸 다할 수는 없다.
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "===>");
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닙니다. 제발 정수 입력해주세요");
                scanner.next();
                i--;
                continue;
            }
            sum += num;
        }
        System.out.println("세 수의 합은" + sum);
    }
}
