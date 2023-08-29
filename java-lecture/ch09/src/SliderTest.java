import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame {
    private JSlider sliderList[] = new JSlider[3];
    private JLabel label = new JLabel("color change");

    SliderTest() {
        this.setTitle("text area");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        for (int i = 0; i < 3; i++) {
            sliderList[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
            contentPane.add(sliderList[i]);
            sliderList[i].setPaintLabels(true);
            sliderList[i].setPaintTicks(true);
            sliderList[i].setPaintTrack(true);
            sliderList[i].setMajorTickSpacing(50);
            sliderList[i].setMinorTickSpacing(10);
            sliderList[i].addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int r = sliderList[0].getValue();
                    int g = sliderList[1].getValue();
                    int b = sliderList[2].getValue();
                    label.setBackground(new Color(r, g, b));
                    label.setText("color change r : " + r + " g : " + g + " b : " + b);
                }
            });
        }
        sliderList[0].setForeground(Color.red);
        sliderList[1].setForeground(Color.green);
        sliderList[2].setForeground(Color.blue);
        contentPane.add(label);
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        label.setForeground(Color.WHITE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new SliderTest();
    }
}