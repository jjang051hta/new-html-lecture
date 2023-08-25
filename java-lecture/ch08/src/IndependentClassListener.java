import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

//ActionListener 는 interface이므로 추상메서드를 구현해야 한다.
class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setText("I AM BUTTON");

    }

}

public class IndependentClassListener extends JFrame {
    IndependentClassListener() {
        setTitle("Event Listener Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contenPane = getContentPane();
        contenPane.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btn = new JButton("나는 버튼");

        // btn.setText("I AM BUTTON");
        contenPane.add(btn);
        btn.addActionListener(new MyActionListener());

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new IndependentClassListener();
    }
}
