import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        // iterable

        String strArray[] = { "둘리", "희동이", "도우너" };

        Integer array[] = { 1, 2, 3, 4, 5 }; // 기본 타입 못들어감,,,

        // List<StudentDto> studentList = new ArrayList<>();
        ArrayList<String> strArrayList = new ArrayList<>(
                Arrays.asList(strArray));
        System.out.println(strArrayList.get(0));
        System.out.println(strArrayList.get(1));
        System.out.println(strArrayList.get(2));

        ArrayList<Integer> intArrayList = new ArrayList<>(
                Arrays.asList(array));
        System.out.println(intArrayList.get(0));
        System.out.println(intArrayList.get(1));
        System.out.println(intArrayList.get(2));

        ArrayList<Integer> intArray = new ArrayList<>();

        intArray.add(11);
        intArray.add(22);
        intArray.add(33);
        intArray.add(44);

        Iterator<Integer> it = intArray.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());
        // System.out.println(it.next());
    }
}
