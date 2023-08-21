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

        String str01 = "Hi~~ hoW are you fine thank you and you";
        String str02 = "hOW"; // 대소문자 무시하고 포함되어 있는지 따져보기...
        // 메서드 체이닝..
        boolean result = str01.toLowerCase().contains(str02.toLowerCase());
        System.out.println(result);
        String str03 = "점";
        String concatStr = str03.concat("심").concat("먹").concat("고 합시다");

        String str04 = str03 + "심" + "먹" + "고 합시다." + 12 + null + '가';
        System.out.println(str04);

        String str05 = new StringBuilder("a")
                .append("b")
                .append("c")
                .append('A')
                .toString();
        System.out.println(str05);
        String str06 = "꿍짝";
        String str06Repeat = str06.concat("꿍짝")
                .concat("꿍짝")
                .concat("꿍짝");
        System.out.println(str06Repeat);
        String str06Repeat02 = str06.repeat(4);
        System.out.println(str06Repeat02); // 쿵짝 쿵짝 쿵짝 쿵짝
        System.out.println(str06.concat(" ").repeat(4).trim());

        String story = "아주 아주 먼 옛날 인어공주가 바다속에서 광어를 회쳐 먹고 살았습니다";
        System.out.println(story.endsWith("살았습니다"));

        String str07 = "쥐를 잡자 개를 잡자 쥐도 잡자 양도 잡자 돼지도 잡자 먹고 죽자 찍찍찍";
        // System.out.println(str07.replace("쥐", "개"));
        System.out.println(str07.replaceAll("[쥐,개,양,돼지]", "소"));
        String str08 = "java,c#,spring,python,javascript";
        String array[] = str08.split(",");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        // 문자열을 배열로 split, 배열을 문자열로 바꿀 수 있다
        // String.join("",배열)
        String arrayTxt = String.join("/", array);
        System.out.println(arrayTxt);
        String str09 = "안녕하세요. 점심 맛있게 먹었나요?";
        System.out.println(str09.substring(0, 2));
        System.out.println(str09.substring(0, 15));
        // 글자 자르기...
        System.out.println(str09); // immutable
        // String 은 immutable 불변객체이다. 메서드를 쓰더라도 새로운 String이 리턴된다.
        String aa = new String("나는 불변객체");
        String bb = "나는 불변객체";
    }
}
