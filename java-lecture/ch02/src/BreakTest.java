import java.util.Scanner;

public class BreakTest {
    public static void main(String[] args) {
        // 문자열을 입력받아서 출력하는데
        // exit가 입력되면 종료합니다. 출력하기...
        Scanner scanner = new Scanner(System.in);
        System.out.println("exit를 입력하면 종료합니다.");

        while (true) {
            String msg = scanner.nextLine();
            if (msg.equals("exit") || msg.equals("EXIT")) {
                break;
            }
        }
        System.out.println("종료합니다.");
    }
}
