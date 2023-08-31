import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowPanel extends JPanel implements Runnable {
    private Image bg = new ImageIcon("images/town.jpg").getImage();

    // 눈도 여러개 만든다.
    private List<Point> pointList = new ArrayList<>();

    SnowPanel() {
        for (int i = 0; i < 50; i++) {
            Point point = new Point((int) (Math.random() * 424), (int) (Math.random() * 600));
            pointList.add(point);
        }
    }

    private void drawSnow(Graphics g) {
        for (int i = 0; i < pointList.size(); i++) {
            Point point = pointList.get(i);
            g.setColor(Color.WHITE);
            g.fillOval(point.x, point.y, 10, 10);
        }
    }

    @Override
    public void run() {
        // 여기에 계속 해야 하는 것들 구현...

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, null);
        drawSnow(g);
    }
}

public class Snow extends JFrame {
    Snow() {
        this.setTitle("DIGITAL CLOCK");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new SnowPanel());
        this.setSize(424, 640);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Snow();
    }
}
