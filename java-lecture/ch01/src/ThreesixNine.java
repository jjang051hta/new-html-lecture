import java.util.Scanner;

public class ThreesixNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int ten = num / 10;// 1,2,3,4,5,6,7,8,9
        int one = num % 10;// 1,2,3,4,5,6,7,8,9
        if (ten != 0 && ten % 3 == 0) {
            System.out.print("짝");
        }
        if (one != 0 && one % 3 == 0) {
            System.out.print("짝");
        }
    }
}
