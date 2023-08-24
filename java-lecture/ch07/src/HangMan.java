import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// 이런 코드드링 쌓이면 library  
class Words {
    // field
    List<String> wordsList = new ArrayList<>();

    public Words(String sourceFile) {
        File file = new File(sourceFile);
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                wordsList.add(word);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        int ran = (int) (Math.random() * wordsList.size());
        return wordsList.get(ran);
    }

}

public class HangMan {

    public String randomWord;
    public Scanner scanner;
    public StringBuffer hiddenWord;

    private void go() {
        while (true) {
            String str = scanner.next();
            char ch = str.charAt(0);
            System.out.println(hiddenWord);
            if (trueOrFalse(ch))
                break;
        }
    }

    private boolean trueOrFalse(char ch) {
        boolean result = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (hiddenWord.charAt(i) == '-' && randomWord.charAt(i) == ch) {
                System.out.println("맞음");
                result = true;
            }
        }
        return result;
    }

    public void run() {
        System.out.println("행맨 게임을 시작합니다.");
        Words words = new Words("c:\\temp\\words.txt");
        while (true) {
            // wordList에서 정답 뽑아 오기
            randomWord = words.getRandomWord();
            // System.out.println("정답===" + randomWord);
            // 정답에서 해당하는 글자 하나만 - 로 바꿔서 hiddenWord만들기
            makeHiddenWord();
            System.out.println(hiddenWord);
            scanner = new Scanner(System.in);
            go();
            // 멈춰야 된다.
            System.out.println("한게임 더하시겠습니까? 할꺼면 y 아니면 n");
            String yesOrNo = scanner.next();
            if (yesOrNo.equals("n")) {
                break;
            }

        }
    }

    // 답을 맞추고 나서 다신 실행해야하는 메서드
    private void makeHiddenWord() {
        Random random = new Random();
        int idx = random.nextInt(randomWord.length());
        char ch = randomWord.charAt(idx);
        hiddenWord = new StringBuffer(randomWord);
        for (int i = 0; i < randomWord.length(); i++) {
            if (hiddenWord.charAt(i) == ch) {
                hiddenWord.setCharAt(i, '-');
            }
        }
    }

    public static void main(String[] args) {

        // 반복문 돌려서 맞는지 틀린지 판단...

        // System.out.println(hiddenWord.toString());
        HangMan hangMan = new HangMan();
        hangMan.run();

    }
}
