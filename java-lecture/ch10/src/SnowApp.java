import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Snow {
    private int posX;
    private int posY;
    private int speedY;
    private int width;
    private int loadX;
    private double t = 0;
    private int radius;

    Snow(int loadX, int posY, int speedY, int width) {
        this.loadX = loadX;
        this.posY = posY;
        this.speedY = speedY;
        this.width = width;
        radius = (int) (Math.random() * 30 + 5);
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(posX, posY, width, width);
    }

    public void moveY() {
        posY += speedY;
        posX = (int) (Math.cos(t) * radius) + loadX;
        t += 0.02;
        if (posY > 700) {
            posY = -20;
            speedY = (int) (Math.random() * 5 + 1);
            posX = (int) (Math.random() * 400);
            width = (int) (Math.random() * 10 + 1);
        }
    }
}

class SnowPanel extends JPanel implements Runnable {
    private Image bg = new ImageIcon("images/town.jpg").getImage();
    Thread thread;
    // 눈도 여러개 만든다.
    private List<Snow> snowList = new ArrayList<>();

    SnowPanel() {
        for (int i = 0; i < 50; i++) {
            Snow snow = new Snow((int) (Math.random() * 400), (int) (Math.random() * 200),
                    (int) (Math.random() * 5) + 1, (int) (Math.random() * 8) + 2);
            snowList.add(snow);
        }
        thread = new Thread(this);
        thread.start();
    }

    private void drawSnow(Graphics g) {
        for (int i = 0; i < snowList.size(); i++) {
            Snow snow = snowList.get(i);
            snow.draw(g);
            // g.fillOval(point.x, point.y, 10, 10);
        }
    }

    @Override
    public void run() {
        // 여기에 계속 해야 하는 것들 구현...
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < snowList.size(); i++) {
                Snow snow = snowList.get(i);
                snow.moveY();
            }
            repaint();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);
        drawSnow(g);
    }
}

public class SnowApp extends JFrame {
    SnowApp() {
        this.setTitle("DIGITAL CLOCK");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new SnowPanel());
        this.setSize(424, 640);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SnowApp();
    }
}
