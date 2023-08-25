import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Grid02 extends JFrame {
    Grid02() {
        setTitle("4x4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenPane = getContentPane();
        contenPane.setLayout(new GridLayout(4, 4));
        Color colors[] = {
                Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN
        };
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            String num = i < 10 ? "0" + i : "" + i;
            JLabel label = new JLabel("label" + num);
            label.setOpaque(true);
            label.setBackground(colors[random.nextInt(4)]);
            contenPane.add(label);
        }
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Grid02();
    }
}
