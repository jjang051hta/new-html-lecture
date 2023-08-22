import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
    // Calendar는 abstract 이기 때문에 new 사용 못함...
    public static void main(String[] args) {
        // 요일, 월
        String monthArray[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        String dayArray[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

        Calendar calendar = Calendar.getInstance(); // abstract라서 new 생성자 사용 못함...
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR);// 12시간 기준
        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);// 24 시 기준
        int min = calendar.get(Calendar.MINUTE);// 분
        int sec = calendar.get(Calendar.SECOND);// 초
        int ampm = calendar.get(Calendar.AM_PM); // 오전 0 오후 1

        // 배열로 바꾸기.. sun-1,mon-2,tue-3,wed-4,thu-5,fri-6,sat-7
        System.out.println(year + "/" + monthArray[month] + "/" + date + "/" + dayArray[day - 1]);
        System.out.println(hour);
        System.out.println(hourOfDay);
        System.out.println(ampm);
        System.out.println(min);
        System.out.println(sec);
        System.out.println(calendar.getTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년MM월dd일 hh:mm:ss"); // MM Month, mminute
        String myDate = simpleDateFormat.format(calendar.getTime());
        System.out.println(myDate);
        // 시간을 구해서 인사말 하기...
        // GoodMorning(5~11) , GoodAfternoon(12~17), Good Evening(18~21), Good Night()
    }

}
