public class Grade {
    private int kor;
    private int eng;
    private int math;

    public Grade(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    int average() {
        return (kor + eng + math) / 3;
    }

}
