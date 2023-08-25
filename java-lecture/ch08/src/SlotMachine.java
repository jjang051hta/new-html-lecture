import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SlotMachine extends JFrame {
    List<JLabel> labelList = new ArrayList<>();
    int nums[] = new int[3];
    Random random = new Random();

    SlotMachine() {
        setTitle("SLOT MACHINE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        JLabel resultLabel = new JLabel();
        resultLabel.setSize(300, 50);
        resultLabel.setLocation(0, 250);
        resultLabel.setText("경기를 시작합니다.");
        contentPane.add(resultLabel);
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
            labelList.add(label);
        }
        contentPane.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println("enter");
                    // int ran01 = random.nextInt(5);
                    // labelList.get(0).setText("" + ran01);
                    // int ran02 = random.nextInt(5);
                    // labelList.get(1).setText("" + ran02);
                    // int ran03 = random.nextInt(5);
                    // labelList.get(2).setText("" + ran03);
                    // if (ran01 == ran02 && ran02 == ran03) {
                    // System.out.println("빙고");
                    // }
                    Set<Integer> set = new HashSet<>();
                    // Set은 중복을 허용하지 않음...
                    for (int i = 0; i < labelList.size(); i++) {
                        int ran = random.nextInt(2);
                        labelList.get(i).setText("" + ran);
                        // nums[i] = ran;
                        set.add(ran);
                    }
                    if (set.size() == 1) {
                        System.out.println("빙고");
                        resultLabel.setText("빙고");
                    } else {
                        resultLabel.setText("땡");
                    }

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
