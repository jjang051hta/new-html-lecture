public class StringTest {
    public static void main(String[] args) {
        // 거의 String
        String a = new String("  Java");
        String b = new String(",Spring ");
        System.out.println(a.length());
        System.out.println(a.contains("J"));
        System.out.println(a.concat(b));
        a = a.trim();
        b = b.trim();
        System.out.println(a.concat(b));

        String c = " ";
        String d = " \t\n";
        System.out.println(c.isEmpty()); // 문자열의 길이가 0
        System.out.println(c.length()); // 문자열의 길이가 0
        System.out.println(d.isBlank()); // 문자열의 길이가 0
        // isEmpty는 순수하게 문자열의 길이가 0인지 아닌지 비교
        // isBlank는 문자열의 공백을 제거한 다음 길이가 0인지 아닌지 비교

        String e = "피곤한 월요일 월요일";
        char first = e.charAt(e.length() - 1);
        System.out.println(first);
        int pos = e.indexOf("월");
        int lastPos = e.lastIndexOf("월");
        System.out.println(pos);
        System.out.println(lastPos);

        String f = "hello java";
        String g = "HELLO JAVA";
        System.out.println(f.equals(g));
        System.out.println(f.equalsIgnoreCase(g));

    }
}
