import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

class NorthPanel extends JPanel {
    NorthPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        add(new JButton("열기"));
        add(new JButton("닫기"));
        add(new JButton("나가기"));
    }
}

public class MultiLayout extends JFrame {
    MultiLayout() {
        setTitle("multiLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenPane = getContentPane();
        contenPane.setLayout(new BorderLayout());
        contenPane.add(new NorthPanel(), BorderLayout.NORTH);
        // contenPane.setLayout(null);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MultiLayout();
    }
}
