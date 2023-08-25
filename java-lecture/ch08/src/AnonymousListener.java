import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AnonymousListener extends JFrame {
    AnonymousListener() {
        setTitle("Event Listener Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenPane = getContentPane();
        contenPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btn = new JButton("나는 버튼");

        // btn.setText("I AM BUTTON");
        contenPane.add(btn);
        // 익명클래스
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setText("Let's go~~~~");
            }
        });

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnonymousListener();
    }
}
