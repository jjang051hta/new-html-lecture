import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("300 x 300으로 만든 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        // contentPane이 JFrame이 기본으로 가지고 있는 Container JPanel

        contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btn = new JButton("OK");
        btn.addActionListener(new MyActionListener());
        contentPane.add(btn);
        contentPane.add(new JButton("Cancel"));

        setSize(300, 300);
        setVisible(true);

    }

    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}
