public class RotateString {
    public static void main(String[] args) {
        String str = "hellojava";
        // System.out.println(str.charAt(0));
        // System.out.println(str.substring(0, 1));
        String msg = str;
        // System.out.println(str.substring(1));
        for (int i = 0; i < str.length(); i++) {
            String firstStr = msg.substring(0, 1);
            String restStr = msg.substring(1);
            msg = restStr + firstStr;
            System.out.println(msg);
        }

    }
}
