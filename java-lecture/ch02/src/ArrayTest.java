public class ArrayTest {
    public static void main(String[] args) {
        int intArray[] = new int[5];
        // int[] intArray = new int[5];
        intArray[0] = 90;
        intArray[1] = 95;
        intArray[2] = 80;
        intArray[3] = 70;
        intArray[4] = 50;
        // String txt01 = "world";
        // System.out.printf("Hello, %s, %s%n", "world", "Java");
        // System.out.printf("Hello, %d, %d%n", 10, 20);
        // System.out.printf("Hello, %f, %f", 10.0, 20.0);
        for (int i = 0; i < intArray.length; i++) {
            // System.out.println(intArray[i]);
            // intArray[0]:90;
            // intArray[1]:95;
            // intArray[2]:80;
            // intArray[3]:70;
            // intArray[4]:50;
            // System.out.println("intArray[" + i + "]:" + intArray[i]);
            System.out.printf("intArray[%d] : %d %n", i, intArray[i]);
        }
        // System.out.println(intArray[6]);
    }
}
