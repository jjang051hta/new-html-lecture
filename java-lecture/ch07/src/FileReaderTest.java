import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\Windows\\system.ini");
            int c;
            // -1은 문서의 끝
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
