import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamTest02 {
    public static void main(String[] args) {
        byte b[] = new byte[1000];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:\\temp\\plum.png");
            int c;
            int n = 0;
            while ((c = fileInputStream.read()) != -1) {
                b[n] = (byte) c;
                n++;
            }
            for (int i = 0; i < b.length; i++) {
                System.out.println(b[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
