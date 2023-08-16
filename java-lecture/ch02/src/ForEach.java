public class ForEach {
    public static void main(String[] args) {
        int intArray[] = { 1, 2, 3, 4, 5 };
        int i = 0;
        for (int num : intArray) {
            System.out.printf("intArra[%d] : %d %n", i, num);
            i++;
        }
        enum Week {
            Mon, Tue, Wed, Thu, Fri, Sat, Sun
        }
        Week days[] = Week.values();

        // for (Week day : Week.values()) {
        // System.out.println(day);
        // }
    }
}
