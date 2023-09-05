import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

class Pocket<T1, T2, T3> {
    private T1 a;
    private T2 b;
    private T3 c;

    public T1 getA() {
        return a;
    }

    public T2 getB() {
        return b;
    }

    public T3 getC() {
        return c;
    }

    public Pocket(T1 a, T2 b, T3 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

}

public class GenericTest {
    public static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        Pocket<String, String, String> pocket01 = new Pocket<>("10", "20", "30");
        Pocket<Integer, Integer, Integer> pocket02 = new Pocket<>(10, 20, 30);
        System.out.println(add(10, 10));
        // 오늘 하면 자바 끝...
        // 프로그래밍은 전부 다 알고 쓰는거 절대 아니다.
        // List, Map, Set
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        intList.add(40);
        for (int i = 0; i < intList.size(); i++) {
            System.out.println(intList.get(i));
        }
        for (int num : intList) {
            System.out.println(num);
        }
        Iterator<Integer> it = intList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        LinkedList<String> strList = new LinkedList<>();
        strList.push("aa");

        Set<Integer> intSet = new LinkedHashSet<>(); // 느립니다.
        // set은 순서를 보장하지 않음 중복을 허용하지 않음... 오름차순정렬
        // TreeSet 오름차순, LinkedHashSet 입력순서대로, HashSet 아무것도 없음...
        intSet.add(100);
        intSet.add(10);
        intSet.add(30);
        intSet.add(40);
        intSet.add(60);
        intSet.add(50);
        System.out.println("size==" + intSet.size());
        for (int item : intSet) {
            System.out.println("item===" + item);
        }
        Iterator<Integer> it02 = intSet.iterator();
        while (it02.hasNext()) {
            System.out.println(it02.next());
        }
        Map<String, Integer> studentMap = new LinkedHashMap<>();
        studentMap.put("이승환", 20);
        studentMap.put("김승환", 1);
        studentMap.put("장일성", 2);
        studentMap.put("배찬용", 3);
        studentMap.put("김승환", 10);
        // System.out.println(studentMap.get("김승환"));
        for (String name : studentMap.keySet()) {
            System.out.println(name + "===" + studentMap.get(name));
        }
    }
}
// create read update delete select update delete insert