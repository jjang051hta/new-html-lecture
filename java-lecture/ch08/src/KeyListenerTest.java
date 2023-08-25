import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyListenerTest extends JFrame {
    private JLabel label = new JLabel("비행기");

    KeyListenerTest() {
        setTitle("MouseListener");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contenPane = getContentPane();
        // contenPane.addKeyListener(new MyKeyListener());
        contenPane.addKeyListener(new MyKeyAdapter());
        contenPane.setLayout(null);
        contenPane.add(label);
        label.setSize(50, 20);
        label.setLocation(100, 100);
        setSize(500, 500);
        setVisible(true);
        // 이거 있어야 키 이벤트 잡을 수 있음....
        contenPane.setFocusable(true);
        contenPane.requestFocus();
    }

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            // label.setText("" + e.getKeyCode());
            // System.out.println(e.getKeyCode());
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    label.setLocation(label.getX() - 10, label.getY());
                    break;
                case KeyEvent.VK_RIGHT:
                    label.setLocation(label.getX() + 10, label.getY());
                    break;
                case KeyEvent.VK_UP:
                    label.setLocation(label.getX(), label.getY() - 10);
                    break;
                case KeyEvent.VK_DOWN:
                    label.setLocation(label.getX(), label.getY() + 10);
                    break;

            }
        }
    }

    class MyKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            label.setText(Integer.toString(e.getKeyCode()));
            System.out.println("pressed");
            // label.setText("" + e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

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
        new KeyListenerTest();
    }
}
