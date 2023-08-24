import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordExplorer {
    // words.txt를 읽어서
    // 단어를 입력하면
    // 해당되는 단어 출력하기
    // cat
    public static void main(String[] args) {
        File file = new File("c:\\temp\\words.txt");
        List<String> wordsList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                wordsList.add(word);
            }
            scanner.close();
            System.out.println(wordsList.get(0));
            Scanner searchScanner = new Scanner(System.in);
            while (true) {
                System.out.println("단어를 입력해 주세요.");
                String searchWord = searchScanner.nextLine();
                if (searchWord.equals("그만"))
                    break;
                for (int i = 0; i < wordsList.size(); i++) {
                    String word = wordsList.get(i);

                    if (searchWord.length() > word.length()) {
                        continue;
                    }

                    String findWord = word.substring(0, searchWord.length());
                    if (searchWord.equals(findWord)) {
                        System.out.println(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
