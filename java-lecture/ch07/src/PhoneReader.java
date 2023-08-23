import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PhoneReader {
    public static void main(String[] args) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        File file = new File("c:\\temp\\phone.txt");
        // 보조 스트림
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            long before = System.currentTimeMillis();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null)
                    break;
                System.out.println(line);
            }
            long after = System.currentTimeMillis();
            System.out.println(after - before);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // try {
        // fileReader = new FileReader(file);
        // int c;
        // // while ((c = fileReader.read()) != -1) {
        // // bufferedReader();
        // long before = System.currentTimeMillis();
        // while (true) {
        // c = fileReader.read();
        // if (c == -1)
        // break;
        // System.out.print((char) c);
        // }
        // long after = System.currentTimeMillis();
        // System.out.println(after - before);
        // fileReader.close();

        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }
}
