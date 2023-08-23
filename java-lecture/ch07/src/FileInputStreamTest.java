import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class FileInputStreamTest {
    public static void main(String[] args) {
        // 바이트 스트림 모든 문서 다읽기
        InputStreamReader in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\temp\\test.txt");
            in = new InputStreamReader(fin, "UTF-8");
            System.out.println(in.getEncoding());
            int c;
            while ((c = in.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
