import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerTest extends JFrame {
    private JLabel label = new JLabel("hello");

    MouseListenerTest() {
        setTitle("MouseListener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contenPane = getContentPane();
        // contenPane.addMouseListener(new MyMouseListener());
        contenPane.addMouseListener(new MyMouseAdapter());
        contenPane.setLayout(null);
        contenPane.add(label);
        label.setSize(50, 20);
        label.setLocation(100, 100);
        setSize(500, 500);
        setVisible(true);
    }

    // adapter 는 Listener를 내부적으로 다 구현해 놓고 있다.
    // 그러므로 내가 필요한 것만 override해서 쓰면 된다.
    class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            label.setLocation(e.getX(), e.getY());
        }

    }

    // InnerClass
    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("click");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("pressed");
            label.setLocation(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("release");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            System.out.println("enter");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            System.out.println("exit");
        }

    }

    public static void main(String[] args) {
        new MouseListenerTest();
    }
}
