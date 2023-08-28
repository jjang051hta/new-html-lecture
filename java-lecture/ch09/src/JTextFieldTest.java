import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class JTextFieldTest extends JFrame {
    JTextFieldTest() {
        this.setTitle("checkbox test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());

        JLabel label01 = new JLabel("ID");
        JTextField txt = new JTextField(20);

        JLabel label02 = new JLabel("PW");
        JPasswordField txt02 = new JPasswordField(20);

        JButton btn = new JButton("로그인");

        contentPane.add(label01);
        contentPane.add(txt);

        contentPane.add(label02);
        contentPane.add(txt02);

        contentPane.add(btn);

        btn.addActionListener(new ActionListener() {
            // 아이디가 jjang051 이고 password가 1234이면 통과 되게 프로그래밍 해보시오.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(txt.getText());
                System.out.println(txt02.getPassword());
                // String pw = new String(txt02.getPassword());
                // String pw = String.valueOf(txt02.getPassword());
                String pw = String.copyValueOf(txt02.getPassword());
                if (txt.getText().equals("jjang051") && pw.equals("1234")) {
                    // System.out.println("로그인");
                    JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
                } else {
                    // System.out.println("누구냐 넌?");
                    JOptionPane.showMessageDialog(null, "누구냐 넌?");
                }
            }

        });

        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JTextFieldTest();
    }
}