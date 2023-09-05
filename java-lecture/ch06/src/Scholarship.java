import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Scholarship {
    public static void main(String[] args) {
        double cutline = 3.8;
        HashMap<String, Double> studentList = new HashMap<>();
        studentList.put("장성호", 3.5);
        studentList.put("손흥민", 3.8);
        studentList.put("조규성", 3.9);
        studentList.put("메시", 4.5);
        studentList.put("음바페", 4.2);
        studentList.put("이천수", 2.5);

        Set<String> set = studentList.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String name = it.next();
            double score = studentList.get(name);
            if (score >= cutline) {
                System.out.println(name + "은 장학금 지급");
            } else {
                System.out.println(name + "은 엄빠장학금 지급");
            }
        }

    }
}
