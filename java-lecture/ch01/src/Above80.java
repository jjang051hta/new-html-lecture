import java.util.Scanner;

public class Above80 {
    public static void main(String[] args) {
        // 키보드로부터 정수를 입력받아 80 이상이면 합격 아니면 불합격 출력해보기..
        // 조건문
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        if (result % 3 == 0) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }
        scanner.close();
    }
}
