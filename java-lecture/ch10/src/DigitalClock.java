import java.awt.Container;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

class ClockTxtLabel extends JLabel implements Runnable {
    // Threaa가 필요하다.
    private Thread thread;

    ClockTxtLabel() {
        setFont(new Font("맑은 고딕", Font.PLAIN, 48));
        setHorizontalAlignment(JLabel.CENTER);
        thread = new Thread(this);
        thread.start();
        setText(showTimeTxt());

    }

    public String showTimeTxt() {
        Calendar calendar = Calendar.getInstance(); // 싱글턴 패턴
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        // 디자인 패턴 설계
        return hour + ":" + min + ":" + sec;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setText(showTimeTxt());
            // System.out.println("나는 1초에 한번 출력됩니다.");
        }
    }
}

public class DigitalClock extends JFrame {
    DigitalClock() {
        this.setTitle("DIGITAL CLOCK");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.add(new ClockTxtLabel());
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}
