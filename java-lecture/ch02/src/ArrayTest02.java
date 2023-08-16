public class ArrayTest02 {
    public static void main(String[] args) {
        // int intArray[] = new int[5];
        int intArray[] = { 10, 30, 40, 20, 15, 90, 80 };
        // 동물 이름 배열 길이 5개를 만들고 출력하기...
        // String animals[] = new String[5];
        String animals[] = { "lion", "tiger", "bear", "dog", "cat" };
        for (int i = 0; i < animals.length; i++) {
            System.out.printf("animals[%d] : %s%n", i, animals[i]);
        }
        // 퀴즈
        // 양의정수 5개를 입력받아서 제일 큰 숫자 출력하기...
    }
}
