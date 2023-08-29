import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ListTest extends JFrame {
    // private JTextField tf = new JTextField(20);
    // private JTextArea ta = new JTextArea(10, 20);
    private String fruits[] = { "apple", "banana", "kiwi", "orange", "apple" };
    private Vector<String> vector = new Vector<>();

    ListTest() {
        this.setTitle("text area");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        JList<String> strList = new JList<>(fruits);
        JList<String> vecList = new JList<>(vector);
        vector.add("bear");
        vector.add("tiger");
        vector.add("lion");
        vector.add("cat");
        contentPane.add(new JScrollPane(strList));
        contentPane.add(new JScrollPane(vecList));
        vector.add("dog");
        vecList.setListData(vector);
        // select

        strList.setVisibleRowCount(3);
        strList.setFixedCellWidth(150);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ListTest();
    }
}
