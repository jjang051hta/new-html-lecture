import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ten = num / 10;
        int one = num % 10; // 0~9
        if (ten == one) {
            System.out.println("같따");
        } else {
            System.out.println("다르다");
        }
    }
}
