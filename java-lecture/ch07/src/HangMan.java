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

    // words.txt 읽어와서
    // list에 넣기
    // 랜덤 단어 출력
    // horse
    // h-rse char하나 빼서 -로 대체하기...
    // 숨긴 char랑 내가 쓴 char가 맞으면 다음게임 진행
    // 그만
    public static void main(String[] args) {
        Words words = new Words("c:\\temp\\words.txt");
        String randomWord = words.getRandomWord();
        Random random = new Random();
        int idx = random.nextInt(randomWord.length());
        System.out.println(randomWord + "/" + idx + "/" + randomWord.charAt(idx));
        char ch = randomWord.charAt(idx);
        StringBuffer hiddenWord = new StringBuffer(randomWord);

        for (int i = 0; i < randomWord.length(); i++) {
            if (hiddenWord.charAt(i) == ch) {
                hiddenWord.setCharAt(i, '-');
            }
        }
        // 반복문 돌려서 맞는지 틀린지 판단...
        while (true) {
            // 맞는지 틀렸는지 따져보기...
        }
        // System.out.println(hiddenWord.toString());
    }
}
