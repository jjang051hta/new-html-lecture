import java.util.StringTokenizer;

public class StringBufferTest {
    public static void main(String[] args) {
        // String str = new String("this");
        StringBuffer sb = new StringBuffer("this");
        sb.append(" is not pipe");
        // str.concat(" is not pipe");
        System.out.println(sb);
        sb.insert(1, "a");
        System.out.println(sb);
        sb.replace(13, 17, "apple");
        System.out.println(sb);
        sb.delete(0, 5);
        System.out.println(sb);
        // System.out.println(str);
        // StringBuffer는 가변 객체이다. 원본이 바뀐다.
        // 편한거 쓰면 됨... 속도 차이 거의 안남...
        String title = "홍길동/심청전/콩쥐/팥쥐/개구리/왕눈이";
        StringTokenizer st = new StringTokenizer(title, "/");
        // if (st.hasMoreTokens()) {
        // System.out.println(st.nextToken());
        // }
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
