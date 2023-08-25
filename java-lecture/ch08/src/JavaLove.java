import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JavaLove extends JFrame {
    JavaLove() {
        setTitle("왼쪽 키를 눌러서 한글자씩 바꿔보기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label = new JLabel("JAVA LOVE");
        contentPane.add(label);
        // class 따로 만들기
        // 익명 클래스 만들기
        contentPane.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                String txt = label.getText();
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    String first = txt.substring(0, 1);
                    String rest = txt.substring(1);
                    label.setText(rest + first);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    String last = txt.substring(txt.length() - 1);
                    String rest = txt.substring(0, txt.length() - 1);
                    label.setText(last + rest);
                }

            }
        });
        setSize(300, 300);
        setVisible(true);
        contentPane.setFocusable(true);
        contentPane.requestFocus();
    }

    public static void main(String[] args) {
        new JavaLove();
    }
}
