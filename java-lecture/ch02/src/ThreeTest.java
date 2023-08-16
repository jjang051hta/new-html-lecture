import java.util.Arrays;
import java.util.Scanner;

public class ThreeTest {
    public static void main(String[] args) {
        System.out.println("양의 정수 10개를 입력하세요. 3의 배수를 찾아 드립니다.");
        Scanner scanner = new Scanner(System.in);
        int intArray[] = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            int num = scanner.nextInt();
            intArray[i] = num;
        }
        System.out.println(Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 3 == 0) {
                System.out.print(intArray[i] + " / ");
            }
        }
    }
}
