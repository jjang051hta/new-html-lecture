import java.util.Calendar;

public class GoodMorning {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);
        if (hour > 4 && hour < 12) {
            System.out.println("Good Morning");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Good Afternoon");
        } else if (hour >= 18 && hour < 22) {
            System.out.println("Good Evening");
        } else {
            System.out.println("Good Night");
        }
    }
}
