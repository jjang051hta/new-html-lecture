import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        // test04.txt파일을 만들어서 hello java 글 써놓기....
        File file = new File("c:\\temp\\test03.txt");
        File folder = new File("c:\\temp\\sample");
        File tempFolder = new File("c:\\temp");
        File fileList[] = tempFolder.listFiles();
        File test04 = new File("c:\\temp\\test04.txt");
        if (!test04.exists()) {
            try {
                test04.createNewFile();
                FileWriter fw = new FileWriter(test04);
                fw.write("hello\r\njava");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(fileList.length);
        // if (!folder.exists()) {
        // folder.mkdir();
        // }
        // System.out.println(file.exists());
        // if (file.exists()) {
        // file.delete();
        // }
        // if (!file.exists()) {
        // try {
        // file.createNewFile();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        // }
        // }
        // System.out.println(file.getPath() + "," + file.getParent() + "," +
        // file.getName());
    }
}
