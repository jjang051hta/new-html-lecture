import java.util.Arrays;

public class AlphabetCount {
    public static void main(String[] args) {
        System.out.println((int) '가');
        System.out.println((int) '힣');
        int alphabets[] = new int[26];
        // [1,1,0,0,0,2,0,0,0,2]
        String str = "ab   baf  ja f d f 한글 idi ouikfjhjdsfsjdfjdskfjdlksjafkljskajfdsa".toLowerCase();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);// ch는 연산 가능
            // alphabets[(int) ch - 97]++;
            if (ch >= 'a' && ch <= 'z') {
                alphabets[ch - 'a']++;
            }
        }
        System.out.print(Arrays.toString(alphabets));
        for (int i = 0; i < alphabets.length; i++) {
            System.out.printf("%c=%d%n", (char) (97 + i), alphabets[i]);
        }
        // for (int i = 0; i < alphabets.length; i++) {
        // System.out.println(alphabets[i]);
        // }
    }
}
