public class ConditionTest {
    public static void main(String[] args) {
        boolean open = true;
        if (open) {
            System.out.println("가게 문열었음");
        } else {
            System.out.println("가게 문닫았음");
        }
        int score = 95;
        // if (score > 90) {
        // System.out.println("A");
        // return;
        // }
        // if (score > 80) {
        // System.out.println("B");
        // return;
        // }
        String strScore = score > 90 ? "A" : "B";
        System.out.println(strScore);
        int num = 10;
        switch (num) {
            case 10:
                System.out.println("10");
                break;
            case 20:
                System.out.println("20");
                break;
            default:
                System.out.println("없는 숫자입니다.");
        }
        int month = 8;
        switch (month) {
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("봄");
                break;
            case 7:
            case 8:
            case 9:
                System.out.println("여름");
                break;
            default:
                System.out.println("겨울");

        }
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "/");
        }
        int nums[] = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        // forEach
        for (int item : nums) {
            System.out.println(item);
        }
        // continue / break;
        // for문에 label 붙여서 쓸 수 있다.
        outer: for (int i = 0; i < 10; i++) {
            inner: for (int j = 0; j < 10; j++) {
                if (j % 2 == 0) {
                    continue inner;
                }
                if (i * j >= 30) {
                    continue outer;
                }
                System.out.printf("i : %d, j : %d%n", i, j);
            }
        }
        int num03 = 0;
        while (num03 < 10) {
            System.out.println(num03);
            num03++;
        }
        System.out.println("fdsfd");
        while (true) {
            System.out.println("무한루프");
        }
        // for (;;) {
        // System.out.println("무한루프");
        // }

    }
}
