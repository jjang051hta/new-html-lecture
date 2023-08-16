import java.util.Scanner;

public class ChangeMOney {
    public static void main(String[] args) {
        int remain = 0;
        int unit[] = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
        Scanner scanner = new Scanner(System.in);
        System.out.println("금액을 입력하면 지폐로 바꿔드립니다.");
        int money = scanner.nextInt();
        // 0개면 출력에서 배제 시키기
        for (int i = 0; i < unit.length; i++) {
            remain = money / unit[i];
            if (remain == 0) {
                continue;
            }
            System.out.print(unit[i] + "원 " + remain + "장");
            money = money % unit[i];
        }
    }
}
