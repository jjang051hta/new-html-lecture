import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.*;

class RandomThread extends JPanel implements Runnable {
    private boolean end = false;

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    RandomThread() {
        this.setLayout(null);
    }

    @Override
    public void run() {
        while (true) {
            JLabel label = new JLabel("NAL JAVA VARA");
            label.setSize(120, 30);
            int posX = (int) (Math.random() * getWidth());
            int posY = (int) (Math.random() * getHeight());
            label.setLocation(posX, posY);
            add(label);
            repaint();
            // System.out.println(label.toString());
            try {
                Thread.sleep(100);
                if (end) {
                    removeAll();
                    label = new JLabel("end");
                    label.setForeground(Color.RED);
                    label.setSize(120, 30);
                    label.setLocation(130, 130);
                    add(label);
                    repaint();
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

public class RandomTxt extends JFrame {
    Thread thread;

    RandomTxt() {
        this.setTitle("Thread");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RandomThread randomThread = new RandomThread();
        randomThread.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                randomThread.setEnd(true);
            }
        });
        this.setContentPane(randomThread);
        thread = new Thread(randomThread);
        thread.start();
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new RandomTxt();
    }
}
