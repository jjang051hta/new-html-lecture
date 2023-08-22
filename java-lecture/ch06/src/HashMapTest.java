import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, String> dictionary = new HashMap<>();
        // dictionary.put("apple", "사과");
        // 학생 3명의 이름(String)과 점수(int)를 HashMap으로 만들어서 이름과 점수 출력하기....
        // 손흥민 100,김하성 98,류현진 85

        HashMap<String, Integer> scoreMap = new HashMap<>();
        scoreMap.put("손흥민", 100);
        scoreMap.put("김하성", 98);
        scoreMap.put("류현진", 85);

        for (String str : scoreMap.keySet()) {
            System.out.println(scoreMap.get(str));
        }
        Set<String> scoreListKeys = scoreMap.keySet();
        Iterator<String> it02 = scoreListKeys.iterator();
        while (it02.hasNext()) {
            System.out.println(it02.next());
        }

        dictionary.put("apple", "홍로");
        dictionary.put("plum", "자두");
        dictionary.put("peach", "복숭아");

        // System.out.println(dictionary.get("apple"));
        Set<String> keys = dictionary.keySet();
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // ArrayList + HashMap
        LinkedHashMap<String, String> dictionary02 = new LinkedHashMap<>();
        // dictionary.put("apple", "사과");
        dictionary02.put("apple", "홍로");
        dictionary02.put("plum", "자두");
        dictionary02.put("peach", "복숭아");
        System.out.println(dictionary02.keySet());
        System.out.println(dictionary.keySet());
    }
}
