import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BufferedTest {
    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\temp\\test.txt");
            BufferedOutputStream bOutputStream = new BufferedOutputStream(System.out, 7);
            int c;

            while ((c = fileReader.read()) != -1) {
                bOutputStream.write(c);
            }
            bOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
