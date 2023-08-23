import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {
    public static void main(String[] args) {
        // 파일 쓰기...
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        // writer / reader는 전부 문자관련
        try {
            fileWriter = new FileWriter("C:\\temp\\test.txt");
            while (true) {
                String line = scanner.nextLine();
                if (line.length() == 0)
                    break;
                fileWriter.write(line, 0, line.length());
                fileWriter.write("\r\n", 0, 2);
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
