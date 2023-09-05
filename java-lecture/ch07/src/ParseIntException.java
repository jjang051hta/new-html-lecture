public class ParseIntException {
    public static void main(String[] args) {
        String strNumber[] = { "10", "20", "3.14", "99" };
        int i = 0;

        for (i = 0; i < strNumber.length; i++) {
            try {
                int result = Integer.parseInt(strNumber[i]);
                System.out.println(result);
            } catch (NumberFormatException e) {
                System.out.println(strNumber[i] + "는 정수로 변환이 되지 않습니다.");
            }
        }
    }

}
