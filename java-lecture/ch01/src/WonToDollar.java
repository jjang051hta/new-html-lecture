import java.util.Scanner;

public class WonToDollar {
    public static void main(String[] args) {
        // 1. 변하지 않는 더블 타입의 상수 rate 1380
        // 2. 정수 won 를 입력받아서
        // 1870000 몇달러인지 알려주기
        final double rate = 1380;
        Scanner scanner = new Scanner(System.in);
        int won = scanner.nextInt();
        double dollar = Math.round(won / rate * 100.0) / 100.0;
        // 소숫점 2짜리...
        // 97488
        // 소수점 두자리 반올림...

        System.out.println(dollar);
    }
}
