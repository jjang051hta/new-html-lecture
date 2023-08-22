import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class BigNumber {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("-1을 입력하면 종료합니다. 정수를 입력해주세요.");
        while (true) {
            int num = sc.nextInt();
            if (num == -1)
                break;
            vec.add(num);
        }
        // Collections.sort(vec); // 내림차순 정렬
        Collections.sort(vec, Collections.reverseOrder());
        System.out.println(vec.get(0));
        // System.out.println(vec.get(vec.size() - 1));
        // int big = vec.get(0);
        // for (int i = 1; i < vec.size(); i++) {
        // if (vec.get(i) > big) {
        // big = vec.get(i);
        // }
        // }
        // System.out.printf("입력된 숫자중 제일 큰 숫자는 %d", big);

    }
}
