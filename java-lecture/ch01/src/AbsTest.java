public class AbsTest {
    public static void main(String[] args) {
        // 양수 두개의 차이를 양수로 표현하기...
        int a = 3;
        int b = 5;
        int result;
        // 2 나오게 하기...

        // System.out.println(a - b);
        // 조건문 생각해보기...
        if (a > b) {
            result = a - b;
        } else {
            result = b - a;
        }
        // 삼항연산자...
        result = a > b ? a - b : b - a;
        System.out.println(result);

    }
}
