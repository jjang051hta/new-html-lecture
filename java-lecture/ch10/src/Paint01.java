import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class Paint01 extends JFrame {
    private MyPanel myPanel = new MyPanel();

    Paint01() {
        this.setTitle("graphics 연습");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(myPanel);

        this.setSize(800, 600);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            // g.drawRect(10, 10, 100, 100);// 라인 그리기
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 10; j++) {
                    g.fillRect(81 * j, 51 * i, 80, 50);// 라인 그리기
                }
            }
            g.setColor(Color.BLACK);
            g.fillOval(400, 500, 20, 20);

            g.setColor(Color.BLUE);
            g.fillRect(400, 520, 100, 20);

            g.setColor(Color.RED);
            g.setFont(new Font("맑은 고딕", Font.BOLD, 64));
            g.drawString("Hello Java", 600, 400);
            g.setColor(Color.BLUE);
            g.drawLine(500, 100, 600, 300);
            int x[] = { 300, 400, 300, 200 };
            int y[] = { 300, 400, 500, 400 };
            g.setColor(Color.BLACK);
            g.fillPolygon(x, y, 4);
            int x2[] = new int[8];
            int y2[] = new int[8];
            for (int i = 0; i < 8; i++) {
                x2[i] = (int) (Math.cos(Math.PI * 2 * (i / 8.0)) * 100) + 300;
                y2[i] = (int) (Math.sin(Math.PI * 2 * (i / 8.0)) * 100) + 300;
                System.out.println(x2[i]);
            }
            g.fillPolygon(x2, y2, 8);
            ImageIcon imageIcon = new ImageIcon("images/spaceship.png");
            Image img = imageIcon.getImage();
            g.drawImage(img, 500, 500, 32, 32, null);
            // g.setColor(Color.GREEN);
            // g.drawRect(20, 20, 100, 100);
            // g.setColor(Color.BLUE);
            // g.drawRect(30, 30, 100, 100);

        }
    }

    public static void main(String[] args) {
        new Paint01();
    }
}
