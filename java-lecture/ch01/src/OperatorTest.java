import java.util.Scanner;

public class OperatorTest {
    // 초를 정수로 입력받기
    // 5000 몇시간 볓분 몇초인지 출력
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("초를 입력하면 시분초로 알려드립니다.");
        int temp = scanner.nextInt();
        // System.out.println(temp);
        // 1200
        int sec = temp % 60;
        int min = (temp / 60) % 60;
        int hour = (temp / 60) / 60;
        System.out.println(temp + "초는 " + hour + "시간 " + min + "분 " + sec + "초 입니다.");
        // 시분초로 바꾸기...
    }
}
