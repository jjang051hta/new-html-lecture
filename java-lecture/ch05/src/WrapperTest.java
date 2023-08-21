public class WrapperTest {
    public static void main(String[] args) {

        Integer num01 = 12345;
        Integer num02 = 12345;

        System.out.println(num01 == num02); // 다른 참조
        System.out.println(num01.equals(num02)); // 값을 비교
        // System.out.println(num01 == num02);
        // 숫자 / 문자

    }
}
