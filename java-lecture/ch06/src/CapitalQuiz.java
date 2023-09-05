import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CapitalQuiz {
    public static void main(String[] args) {
        Map<String, String> nations = new HashMap<>();
        nations.put("한국", "서울");
        nations.put("미국", "워싱턴");
        nations.put("프랑스", "파리");
        nations.put("영국", "런던");
        nations.put("독일", "베를린");
        nations.put("일본", "도쿄");
        nations.put("중국", "베이징");
        nations.put("러시아", "모스크바");
        nations.put("호주", "캔버라");
        // int total = nations.size();
        // int ran = (int) (Math.random() * total);
        Set<String> keys = nations.keySet();
        Object keyArray[] = keys.toArray();
        Iterator<String> values = nations.values().iterator();
        Iterator<Map.Entry<String, String>> entries = nations.entrySet().iterator();
        while (entries.hasNext()) {
            String keyValue = entries.next().getKey();
            System.out.println(keyValue + ":" + nations.get(keyValue));
        }
        // System.out.println(keyArray.length);
        int total = keyArray.length;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int ran = (int) (Math.random() * total);
            String question = (String) keyArray[ran];
            String answer = nations.get(question);
            System.out.println(question + "의 수도는?");
            String capital = scanner.next();
            if (capital.equals("그만"))
                break;
            if (answer.equals(capital)) {
                System.out.println("딩동댕");
            } else {
                System.out.println("땡");
            }
        }
        // System.out.println(keyArray[ran]);
    }
}
