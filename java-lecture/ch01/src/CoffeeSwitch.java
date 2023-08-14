import java.util.Scanner;

public class CoffeeSwitch {
    public static void main(String[] args) {
        int price = 0;
        System.out.println(price);
        Scanner scanner = new Scanner(System.in);
        String coffee = scanner.next();
        // 카페라떼 3000
        switch (coffee) {
            case "아메리카노":
                price = 2000;
                break;
            case "카푸치노":
            case "카페라떼":
            case "바닐라라떼":
                price = 3000;
                break;
            default:
                System.out.println("우리가게에 없어요. 스벅을 이용해 주세요.");
        }
        System.out.println("주문하신 " + coffee + "의 가격은 " + price + "입니다.");
    }
}
