import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JComboboxTest extends JFrame {
    private String fruits[] = { "apple", "banana", "kiwi", "orange", "apple" };

    JComboboxTest() {
        this.setTitle("text area");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JComboBox<String> strComboBox = new JComboBox<>(fruits);
        contentPane.add(strComboBox);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JComboboxTest();
    }
}
