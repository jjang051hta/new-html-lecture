import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        // StringTokenizer st = new StringTokenizer(str, " ");
        // int total = st.countTokens();
        String words[] = str.split(" ");
        int total = words.length;
        System.out.println(total);
    }
}
