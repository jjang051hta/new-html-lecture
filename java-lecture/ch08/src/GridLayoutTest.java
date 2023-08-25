import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutTest extends JFrame {

    GridLayoutTest() {
        setTitle("Grid layout test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane(); // JFrame이 기본으로 가지는 container

        GridLayout gridLayout = new GridLayout(4, 2);
        gridLayout.setVgap(10);
        contentPane.setLayout(gridLayout);
        contentPane.add(new JLabel("이름"));
        contentPane.add(new JTextField());
        contentPane.add(new JLabel("학번"));
        contentPane.add(new JTextField());
        contentPane.add(new JLabel("학과"));
        contentPane.add(new JTextField());
        contentPane.add(new JLabel("과목"));
        contentPane.add(new JTextField());

        setSize(500, 300);
        setVisible(true);

    }

    public static void main(String[] args) {
        new GridLayoutTest();
    }
}
