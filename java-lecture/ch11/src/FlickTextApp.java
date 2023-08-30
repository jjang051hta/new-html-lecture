import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

class FlickText extends JLabel implements Runnable {
    private long delay;

    FlickText(String msg, long delay) {
        super(msg);
        this.delay = delay;
        this.setOpaque(true);
        this.setForeground(Color.WHITE);
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int num = 0;
        while (true) {
            if (num == 0) {
                this.setBackground(Color.RED);
                num = 1;
            } else {
                this.setBackground(Color.BLUE);
                num = 0;
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class FlickTextApp extends JFrame {
    FlickTextApp() {
        this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        FlickText flickText = new FlickText("FLICK", 100);
        FlickText flickText02 = new FlickText("깜빡 깜빡 작은 별", 200);
        contentPane.add(flickText);
        contentPane.add(flickText02);
        // Thread thread = new Thread(flickText);
        // thread.start();
        // Thread thread02 = new Thread(flickText02);
        // thread02.start();

        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FlickTextApp();
    }
}
