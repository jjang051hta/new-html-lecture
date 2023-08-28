import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelTest extends JFrame {

    JLabelTest() {
        this.setTitle("JLabel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon imageIcon = new ImageIcon("images/apple.png");

        JLabel label01 = new JLabel("gloomy monday");
        JLabel label02 = new JLabel(imageIcon);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(label01);
        contentPane.add(label02);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JLabelTest();
    }
}
