import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneWrite {
    public static void main(String[] args) {

        File file = new File("c:\\temp\\phone.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            Scanner scanner = new Scanner(System.in);
            System.out.println("전화번호를 입력프로그램입니다.");
            while (true) {
                System.out.println("이름 전화번호===>");
                String line = scanner.nextLine();
                if (line.equals("그만"))
                    break;
                // fileWriter.write(line, 0, line.length());
                // fileWriter.write("\r\n", 0, 2);
                fileWriter.write(line + "\r\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
