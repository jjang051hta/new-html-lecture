import java.util.Scanner;

public class WordsQuiz {
    public static void main(String[] args) {

        String words[][] = { { "apple", "사과" }, { "plum", "자두" }, { "grape", "포도" } };
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%d 번 문제 주어진 영어단어 %s의 뜻은===", i + 1, words[i][0]);
            String answer = scanner.nextLine();
            if (answer.equals(words[i][1])) {
                System.out.println("딩동댕");
            } else {
                System.out.printf("떙 정답은 %s 입니다.", words[i][1]);
            }

        }
        // 반복문 돌려서 문제가 나오고 맞으면 딩동댕 틀리면 땡
        // nextLine();
        // 주어진 단어의 뜻을 쓰시오.
        // apple
        // 사과
    }
}
