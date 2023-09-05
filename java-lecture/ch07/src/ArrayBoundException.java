public class ArrayBoundException {
    public static void main(String[] args) {
        int intArray[] = new int[5];
        intArray[0] = 10;
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(intArray[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // e.printStackTrace();
            System.out.println("배열의 인댁스 범위를 벘어났습니다.");
        } finally {
            System.out.println("여기는 예외랑 상관없이 무조건 실행");
        }
    }
}
