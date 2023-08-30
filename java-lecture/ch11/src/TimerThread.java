import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
// 1.Thread를 상속받아서 처리...
import javax.swing.JLabel;

class TimerTest extends Thread {
    private JLabel timerLabel;

    TimerTest(JLabel timerLabel) {
        this.timerLabel = timerLabel;
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            timerLabel.setText("" + num);
            num++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }

}

public class TimerThread extends JFrame {
    TimerThread() {
        this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JLabel label = new JLabel("");
        label.setFont(new Font("맑은 고딕", Font.PLAIN, 64));
        label.setBackground(Color.RED);
        contentPane.add(label);

        TimerTest timerTest = new TimerTest(label);
        timerTest.start();

        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TimerThread();
    }
}