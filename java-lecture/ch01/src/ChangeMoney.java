import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        int remain, money;
        Scanner scanner = new Scanner(System.in);
        System.out.println("금액을 입력하면 지폐 및 동전으로 나눠 드립니다.");
        money = scanner.nextInt();
        remain = money / 50000;
        System.out.println("오만원권 === " + remain);
        money = money % 50000;
        remain = money / 10000;
        System.out.println("만원권 === " + remain);
        money = money % 10000;
        remain = money / 5000;
        System.out.println("오천원권 === " + remain);
        money = money % 5000;
        remain = money / 1000;
        System.out.println("천원권 === " + remain);
        money = money % 1000;
        remain = money / 500;
        System.out.println("오백원 === " + remain);
        money = money % 500;
        remain = money / 100;
        System.out.println("백원 === " + remain);
        money = money % 100;
        remain = money / 50;
        System.out.println("오십원 === " + remain);
        money = money % 50;
        remain = money / 10;
        System.out.println("십원 === " + remain);

    }
}
