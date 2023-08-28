import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ComponentTest extends JFrame {

    ComponentTest() {
        // container는 기본적으로 layout을 가지고 있다.
        this.setTitle("컴퍼넌트 테스트");
        // 눈에는 보이지 않지만 계속 남아 있음
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new FlowLayout());
        JButton btn01 = new JButton("Red/Yellow");
        JButton btn02 = new JButton("disable");
        JButton btn03 = new JButton("x,y");
        btn01.setForeground(new Color(255, 0, 0));
        btn01.setBackground(new Color(255, 255, 0));
        btn02.setEnabled(false);
        btn01.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        // btn01.setForeground(Color.RED);
        contentPane.add(btn01);
        contentPane.add(btn02);
        contentPane.add(btn03);
        // 익명 클래스로처리...
        btn03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                ComponentTest frame = (ComponentTest) btn.getTopLevelAncestor();
                frame.setTitle(btn03.getX() + "/" + btn03.getY());
            }
        });
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ComponentTest();
    }
}
