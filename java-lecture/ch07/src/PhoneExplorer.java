import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneExplorer {
    public static void main(String[] args) {
        File file = new File("c:\\temp\\phone.txt");
        try {
            // 키 밸류
            // HashMap <String, String>
            Map<String, String> phoneMap = new HashMap<>();
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            System.out.println(file.getPath() + "를 출력합니다.");
            while (scanner.hasNext()) {
                String name = scanner.next();
                String tel = scanner.next();
                phoneMap.put(name, tel);
                // String str = scanner.nextLine();
                // System.out.println(str);
            }
            scanner.close();
            Scanner phoneScanner = new Scanner(System.in);
            while (true) {
                System.out.println("이름을 입력하세요===>>");
                String name = phoneScanner.next();
                if (name.equals("그만"))
                    break;
                String tel = phoneMap.get(name);
                if (tel == null)
                    System.out.println("없는 사람입니다.");
                else
                    System.out.println(tel);
            }
            // System.out.println(phoneMap.get("임재호"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
