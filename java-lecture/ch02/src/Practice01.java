public class Practice01 {
    public static void main(String[] args) {
        int i = 0, sum = 0, sum02 = 0;
        while (i <= 100) {
            sum += i;
            i += 2;
        }
        System.out.println(sum);
        for (int j = 0; j <= 100; j += 2) {
            sum02 += j;
        }
        int k = 0, sum03 = 0;
        do {
            if (k > 100)
                break;
            sum03 += k;
            k += 2;
        } while (true);
        System.out.println(sum03);
    }
}
