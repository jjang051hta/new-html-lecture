import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        System.out.println("이름, 도시, 나이, 체중, 결혼 유무를 분리하여 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String myName = scanner.next();
        System.out.println("내이름은 " + myName);
        String city = scanner.next();
        System.out.println("사는 곳은 " + city);
        int age = scanner.nextInt();
        System.out.println("나이는  " + age);
        double weight = scanner.nextDouble();
        System.out.println("몸무게는  " + weight);
        boolean isMarried = scanner.nextBoolean();
        System.out.println("결혼은  " + isMarried);
        scanner.close();

    }
}
