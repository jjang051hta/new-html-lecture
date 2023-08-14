import java.util.Scanner;

public class GradeSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하시오.");
        int score = scanner.nextInt(); // 100 10, 99~90 9, 89~80 8
        char grade;
        // switch바꾸기 case 수식은 안됨 문자열(String) 또는 정수 문자(char)
        switch (score / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';

        }
        System.out.println(grade);
        // if (score >= 90) {
        // grade = 'A';
        // } else if (score >= 80) {
        // grade = 'B';
        // }
    }
}
