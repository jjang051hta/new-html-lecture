import java.awt.Checkbox;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxTest extends JFrame {
    private JCheckBox checkList[] = new JCheckBox[3];
    private String imgList[] = { "images/apple-normal.png", "images/strawberry-normal.png", "images/peach.png" };
    // 3000,5000,7000
    private int sum = 0;
    private JLabel sumLabel;

    CheckBoxTest() {
        this.setTitle("checkbox test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        for (int i = 0; i < checkList.length; i++) {
            checkList[i] = new JCheckBox("", new ImageIcon(imgList[i]));
            checkList[i].setBorderPainted(true);
            contentPane.add(checkList[i]);
            checkList[i].addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        // System.out.println(e.getItem());
                        if (e.getItem() == checkList[0]) {
                            sum += 3000;
                        } else if (e.getItem() == checkList[1]) {
                            sum += 5000;
                        } else {
                            sum += 7000;
                        }
                    } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                        if (e.getItem() == checkList[0]) {
                            sum -= 3000;
                        } else if (e.getItem() == checkList[1]) {
                            sum -= 5000;
                        } else {
                            sum -= 7000;
                        }
                    }
                    sumLabel.setText("현재 가격은 " + sum + "입니다.");
                }
            });
        }

        sumLabel = new JLabel();
        contentPane.add(sumLabel);
        sumLabel.setText("현재 가격은 0 입니다.");
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}
