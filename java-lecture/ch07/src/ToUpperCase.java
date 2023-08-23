import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ToUpperCase {
    public static void main(String[] args) {
        // 중요란건 꺽이지 않는 마음
        File file = new File("c:\\windows\\system.ini");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int c;
            while ((c = fileReader.read()) != -1) {
                char ch = (char) c;
                ch = Character.toUpperCase(ch); // int double string
                System.out.print(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
