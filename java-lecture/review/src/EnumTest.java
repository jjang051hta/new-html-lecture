
// 열거형, 목록 enumeration

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;

enum ButtonMode {
    LIGHT, DARK
}

enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATUTDAY,
    SUNDAY
}

class Button {
    private ButtonMode buttonMode = ButtonMode.DARK;

    public void setButtonMode(ButtonMode buttonMode) {
        this.buttonMode = buttonMode;
    }

}

enum Chicken {
    FRIED("후라이드", 20000),
    YANGNEOM("양념", 25000),
    MANEUL("마늘", 27000),
    SOY("간장", 25000);

    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    Chicken(String name, int price) {
        this.name = name;
        this.price = price;
    }

}

public class EnumTest {
    public static void main(String[] args) {

        Chicken menu01 = Chicken.FRIED;
        System.out.println(menu01.getName());
        System.out.println(menu01.getPrice());

        Button btn = new Button();
        btn.setButtonMode(ButtonMode.LIGHT);
        Week monday = Week.MONDAY;
        System.out.println(monday.name());
        System.out.println(monday.ordinal());
        Week weekList[] = Week.values();
        System.out.println(Arrays.toString(weekList));

        // Calendar calendar = Calendar.getInstance();
        // calendar.get(Calendar.MONTH);

        System.out.println(Math.pow(2, 64));
        BigInteger bigInt01 = new BigInteger("99999999999999999999");
        BigInteger bigInt02 = new BigInteger("11111111111111111111");
        System.out.println(bigInt01.add(bigInt02));
        var num01 = 0.2 + 0.3f; // 부동소수점 2진수
        System.out.println(num01);
        var num02 = new BigDecimal("0.2").add(new BigDecimal("0.3"));
        System.out.println(num02);
        // 정교한 데이터 다룰때 물리
        // Wrapper
        // int,short, long,double
        String strNum = "10";
        int intNum = Integer.parseInt(strNum); // 자동으로 바꿔줌...
        // Integer,Short,Long,Float,Doble,Boolean,Character,Byte
        // <>
}
