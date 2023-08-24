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

    public void run() {
        System.out.println("행맨 게임을 시작합니다.");
        Words words = new Words("c:\\temp\\words.txt");
        randomWord = words.getRandomWord();
    }

    // 답을 맞추고 나서 다신 실행해야하는 메서드
    public void makeHiddenWord() {
        Random random = new Random();
        int idx = random.nextInt(randomWord.length());
        char ch = randomWord.charAt(idx);
        StringBuffer hiddenWord = new StringBuffer(randomWord);
        for (int i = 0; i < randomWord.length(); i++) {
            if (hiddenWord.charAt(i) == ch) {
                hiddenWord.setCharAt(i, '-');
            }
        }
    }

    public static void main(String[] args) {

        // 반복문 돌려서 맞는지 틀린지 판단...
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 맞는지 틀렸는지 따져보기...
            // scanner에서 입력받은 글자중에 제일 첫번째 글자 찾아서
            // 글자 갯수만큼 반복문 돌려서
            System.out.println(hiddenWord);
            String str = scanner.next();
            if (str.equals("그만"))
                break;
            char ch02 = str.charAt(0);
            // hor-e
            for (int i = 0; i < randomWord.length(); i++) {
                if (hiddenWord.charAt(i) == '-' && randomWord.charAt(i) == ch02) {
                    System.out.println("맞음");
                    // System.out.println(randomWord);
                }
            }
        }
        // System.out.println(hiddenWord.toString());
    }
}
