import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class FillArcTest extends JFrame {
    MyPanel myPanel = new MyPanel();

    FillArcTest() {
        this.setTitle("그래픽");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(myPanel);

        this.setSize(300, 300);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.drawRect(100, 100, 100, 100);
            g.setColor(Color.RED);
            g.fillRect(110, 110, 100, 100);
            g.setColor(Color.GREEN);
            g.fillOval(120, 120, 100, 100);
            g.setColor(new Color(255, 100, 150));
            g.fillArc(30, 30, 100, 100, 0, 360);
            g.drawString("apple 30%", 300, 10);
        }
    }

    public static void main(String[] args) {
        new FillArcTest();
    }
}
