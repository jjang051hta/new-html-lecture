import java.util.HashMap;
import java.util.Scanner;

public class Population {
    public static void main(String[] args) {
        // ArrayList, Map
        HashMap<String, Integer> nations = new HashMap<>();
        nations.put("한국", 5000);
        nations.put("중국", 140000);
        nations.put("미국", 30000);
        nations.put("일본", 10000);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String nation = scanner.next();
            if (nation.equals("그만"))
                break;
            Integer population = nations.get(nation);
            if (population == null)
                System.out.println("없는 나라입니다.");
            else
                System.out.println(population);
        }
    }
}
