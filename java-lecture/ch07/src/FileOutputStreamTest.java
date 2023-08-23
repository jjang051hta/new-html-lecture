import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
    public static void main(String[] args) {
        byte b[] = { 10, 20, 30, 40, 50, 60 };
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("C:\\temp\\test.out");
            for (int i = 0; i < b.length; i++) {
                fileOutputStream.write(b[i]);
            }
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
