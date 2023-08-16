import java.util.Scanner;

// 카카오 
public class MaxNumberTest {
    public static void main(String[] args) {
        int intArray[] = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            intArray[i] = scanner.nextInt();
        }
        int max = intArray[0];
        int min = intArray[0];
        for (int i = 0; i < 5; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
            }
            if (intArray[i] < min) {
                min = intArray[i];
            }
            // 작은 숫자 찾기
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(intArray[i] + ",");
        }
        System.out.printf("제일 큰 숫자는 %d", max);
        System.out.printf("제일 작은 숫자는 %d", min);
    }
}
