import java.util.Scanner;

class Dictionary {
    static String kor[] = { "사과", "자두", "포도" };
    static String eng[] = { "apple", "plum", "grape" };

    public static String korToEng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return eng[i];
            }
        }
        return null;
    }
}

public class DictionaryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("한글 단어를 입력하시오.");
            String kor = scanner.next();
            if (kor.equals("그만"))
                break;
            String eng = Dictionary.korToEng(kor);
            if (eng == null) {
                System.out.println("없는 단어입니다. 다시 입력해 주세요.");
            } else {
                System.out.println(kor + "의 영어는 " + eng + "입니다.");
            }
        }
    }
}
