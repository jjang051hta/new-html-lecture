import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        // 번호 6개 뽑기....
        // 섞어 놓고 6개 뽑기...
        // 1~45
        int nums[] = new int[45];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        System.out.println(nums);
        System.out.println(Arrays.toString(nums));
        // int a = 10;
        // int b = 20;
        // int temp;
        // temp = b;
        // b = a;
        // a = temp;
        for (int i = 0; i < 100; i++) {
            // 코드 주세요...
            int selected = (int) (Math.random() * nums.length);
            // 0~44
            int temp = nums[0];
            nums[0] = nums[selected];
            nums[selected] = temp;
        }
        int lotto[] = Arrays.copyOf(nums, 6);
        System.out.println(Arrays.toString(lotto));
        Arrays.sort(lotto);
        System.out.println(Arrays.toString(lotto));

        // System.out.println(a + "===" + b);
    }
}
