import java.util.Scanner;

public class GradeTest {
    public static void main(String[] args) {
        Grade myGrade = new Grade(90, 85, 50);
        int myAvg = myGrade.average();
        System.out.printf("나의 평균은 %d", myAvg);
    }
}
