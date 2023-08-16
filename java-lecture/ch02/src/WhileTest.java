import java.util.Scanner;

public class WhileTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;
        int num = scanner.nextInt();
        // 변수 2개 필요 count, sum
        while (num != -1) {
            sum += num;
            count++;
            num = scanner.nextInt();
        }
        System.out.println("입력한 정수의 갯수는 " + count + "이고 평균은 " + ((double) sum / count) + "이다");
    }
    // 소수점 출력되게 바꿔 보기...
}
