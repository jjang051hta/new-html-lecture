import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ScoreAvg {
    public static void main(String[] args) {
        Character ch[] = { 'A', 'B', 'A', 'B', 'C', 'F' };
        ArrayList<Character> scoreList = new ArrayList<>(Arrays.asList(ch));
        Iterator<Character> it = scoreList.iterator();
        double score = 0.0;
        while (it.hasNext()) {
            char ch02 = it.next();
            switch (ch02) {
                case 'A':
                    score += 4.0;
                    break;
                case 'B':
                    score += 3.0;
                    break;
                case 'C':
                    score += 2.0;
                    break;
                case 'D':
                    score += 1.0;
                    break;
                case 'F':
                    score += 0.0;
                    break;

            }
        }
        System.out.println(score / scoreList.size());
        // ArrayList<Character> scoreList = new ArrayList<>();
        // scoreList.add('A');
        // scoreList.add('B');
        // scoreList.add('C');
        // scoreList.add('B');
        // scoreList.add('A');
        // scoreList.add('D');
        // //
        // double score = 0.0;
        // for (int i = 0; i < scoreList.size(); i++) {
        // System.out.println(scoreList.get(i));
        // char ch = scoreList.get(i);
        // switch (ch) {
        // case 'A':
        // score += 4.0;
        // break;
        // case 'B':
        // score += 3.0;
        // break;
        // case 'C':
        // score += 2.0;
        // break;
        // case 'D':
        // score += 1.0;
        // break;
        // case 'F':
        // score += 0.0;
        // break;

        // }
        // }
        // System.out.println(score / scoreList.size());
    }
}
