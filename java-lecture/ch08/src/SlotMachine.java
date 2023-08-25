import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SlotMachine extends JFrame {
    List<JLabel> labelList = new ArrayList<>();

    SlotMachine() {
        setTitle("SLOT MACHINE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        for (int i = 0; i < 3; i++) {
            JLabel label = new JLabel();
            label.setOpaque(true);
            label.setBackground(Color.RED);
            label.setForeground(Color.YELLOW);
            label.setSize(80, 50);
            label.setLocation(90 * i + 15, 100); // 300
            label.setText("0");
            label.setHorizontalAlignment(JLabel.CENTER);
            contentPane.add(label);
        }
        contentPane.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("enter");
                }
            }

        });
        setSize(300, 300);
        setVisible(true);
        contentPane.setFocusable(true);
        contentPane.requestFocus();
    }

    public static void main(String[] args) {
        new SlotMachine();
    }
}
