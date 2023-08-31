import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class RandomCirclePanel extends JPanel implements Runnable {
    private int x, y;
    private Thread thread;

    RandomCirclePanel() {
        // thread = new Thread(this);
        // thread.start();
        // 클릭했을때 시작
        thread = new Thread(this);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                thread.start();
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x = (int) (Math.random() * this.getWidth());
            y = (int) (Math.random() * this.getHeight());
            repaint();
        }
    }

}

public class RandomCircle extends JFrame {
    RandomCircle() {
        this.setTitle("DIGITAL CLOCK");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new RandomCirclePanel());
        // Container contentPane = this.getContentPane();

        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RandomCircle();
    }
}
