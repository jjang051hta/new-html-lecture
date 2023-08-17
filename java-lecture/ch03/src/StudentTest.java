public class StudentTest {
    public static void main(String[] args) {
        Student st01 = new Student(01, "하리수", 4.0, "남자");
        st01.setScore(3.2);
        st01.setGender("여자");
        System.out.printf("하리수의 학점 : %f%n", st01.getScore());
        System.out.printf("하리수의 성별 : %s%n", st01.getGender());

    }
}
