import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NullLayout extends JFrame {
    NullLayout() {
        setTitle("Null Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null); // 자유로운 배치

        JLabel label = new JLabel("Hello JAVA");
        label.setLocation(100, 100);
        label.setSize(100, 40);
        contentPane.add(label);

        // JButton 9개를 만들어서 3x3으로 배치하기...
        JPanel btnPanel = new JPanel();
        contentPane.add(btnPanel);
        btnPanel.setLocation(100, 200);
        btnPanel.setSize(320, 200);
        btnPanel.setLayout(null);
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton("btn0" + i);
            btnPanel.add(btn);
            // btn.setBackground(Color.RED);
            // btn.setBorderPainted(false);
            // contentPane.add(btn);
            // 200,200,200
            // 235,235,235
            // 270,270,270
            // btn.setLocation(105 * (i % 3), 35 * (int) (i / 3));
            // btn.setSize(100, 30);
            btn.setBounds(105 * (i % 3), 35 * (int) (i / 3), 100, 30);
        }

        setSize(500, 500);
        setVisible(true);

    }

    public static void main(String[] args) {
        new NullLayout();
    }
}
