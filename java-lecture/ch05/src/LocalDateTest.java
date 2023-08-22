import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println(nowDateTime);
        System.out.printf("%d년%d월%d일", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
        // SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        System.out.println(nowDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));

        ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(seoulDateTime);

    }
}
