import java.awt.Color;
import java.awt.Container;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomLayout extends JFrame {

    RandomLayout() {
        setTitle("4x4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenPane = getContentPane();
        contenPane.setLayout(null);
        Color colors[] = {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN
        };
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String num = i < 10 ? "0" + i : "" + i;
            JLabel label = new JLabel("l" + num);
            label.setSize(20, 20);
            label.setOpaque(true);
            label.setBackground(colors[random.nextInt(4)]);
            label.setLocation(50 + random.nextInt(200), 50 + random.nextInt(200));
            contenPane.add(label);
        }
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomLayout();
    }
}
