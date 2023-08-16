import java.util.Scanner;

public class StarPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요. 별찍어 드립니다.");
        int total = scanner.nextInt();
        for (int i = total; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
