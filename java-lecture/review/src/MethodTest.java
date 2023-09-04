public class MethodTest {
    static int add(int num01, int num02) {
        return num01 + num02;
    }

    static double average(int... nums) {
        double result = 0.0;
        for (int num : nums) {
            result += num;
        }
        return result / nums.length;
    }

    static void sayHello() {
        System.out.println("hello");
    }

    // 5! = 5*4*3*2*`1
    // recursive
    static int factorial(int num) {
        return num == 0 ? 1 : num * factorial(--num);
    }

    public static void main(String[] args) {
        int sum = add(10, 10);
        System.out.println(sum);
        sayHello();
        double score = average(80, 90, 30, 50, 100, 10, 45);
        System.out.println(score);
        int nums[] = { 80, 90, 30, 50, 100, 10, 45 };
        double score02 = average(nums);
        System.out.println(score02);
        int fact = factorial(10);
        System.out.println(fact);
        // 재귀 호출

    }
    // 자바에는 함수없다. method
}
