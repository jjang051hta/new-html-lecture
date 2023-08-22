import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("홍길동");
        arrayList.add("임꺽정");
        arrayList.add("심청이");
        arrayList.add("둘리");
        arrayList.add(0, "고길동");
        for (int i = 0; i < arrayList.size(); i++) {
            // System.out.println(arrayList.get(i));
        }

        // arrayList.clear();
        // arrayList.remove("고길동");
        arrayList.set(0, "희동이");
        for (String str : arrayList) {
            System.out.println(str);
        }
        System.out.println(arrayList.isEmpty());
        System.out.println(arrayList.contains("도우너"));

        // int intArray[] = { 11, 22, 33, 44, 55 };
        ArrayList<Integer> intArrayList = new ArrayList<>(
                Arrays.asList(11, 22, 33, 44, 55));
        System.out.println(intArrayList.get(0));

        ArrayList<String> strArrayList = new ArrayList<>(
                Arrays.asList("미켈란젤로", "다빈치", "둘리", "로트렉", "볼프강 아마데우스 폰 모짜르트"));

        // 이름이 제일 긴 사람 출력
        // for (String str : strArrayList) {
        // System.out.println(str);
        // }
        int longIdx = 0;
        for (int i = 1; i < strArrayList.size(); i++) {
            if (strArrayList.get(i).length() > strArrayList.get(longIdx).length()) {
                longIdx = i;
            }
        }
        System.out.println(strArrayList.get(longIdx));
    }
}
