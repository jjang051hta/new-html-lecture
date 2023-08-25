import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

class NorthPanel extends JPanel {
    NorthPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        add(new JButton("열기"));
        add(new JButton("닫기"));
        add(new JButton("나가기"));
    }
}

class SouthPanel extends JPanel {
    SouthPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        add(new JButton("word input"));
        add(new JTextField(15));

    }
}

class CenterPanel extends JPanel {
    CenterPanel() {
        setLayout(null);
        setOpaque(true);
        setBackground(Color.YELLOW);
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("*");
            label.setSize(20, 20);
            label.setForeground(Color.RED);
            label.setLocation((int) (Math.random() * 200) + 50, (int) (Math.random() * 200) + 50);
            add(label);
        }
    }
}

public class MultiLayout extends JFrame {
    MultiLayout() {
        setTitle("multiLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenPane = getContentPane();
        contenPane.setLayout(new BorderLayout());
        contenPane.add(new NorthPanel(), BorderLayout.NORTH);
        contenPane.add(new CenterPanel(), BorderLayout.CENTER);
        contenPane.add(new SouthPanel(), BorderLayout.SOUTH);
        // contenPane.setLayout(null);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MultiLayout();
    }
}
