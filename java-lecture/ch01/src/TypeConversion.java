public class TypeConversion {
    public static void main(String[] args) {
        byte b = 127;
        int i = 100;
        System.out.println(b + i);
        System.out.println(10 / 4); // int
        System.out.println(10.0 / 4); // int
        System.out.println(((int) 2.5) + 1.8); // int
        System.out.println((int) (2.9 + 1.8)); // int
        System.out.println((int) 2.9 + (int) 1.8); // int
    }
}
