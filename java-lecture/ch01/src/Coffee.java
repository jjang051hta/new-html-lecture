import java.util.Scanner;

public class Coffee {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String coffee = scanner.next();
        // switch로 바꿔보기...
        // 이때 만약 두개의 메뉴에 없으면 우리 가게에 없어요.
        // 옆에 스벅 이용해 주세요...
        int price = 0;
        // 문자열 비교는 equals()라는 메서드를 이용한다.
        if (coffee.equals("아메리카노")) {
            price = 2000;
        } else if (coffee.equals("카푸치노")) {
            price = 3000;
        }
        System.out.println("주문하신 " + coffee + "의 가격은 " + price + "입니다.");
    }
}
