import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ship extends JPanel implements Runnable {
    private Image ship = new ImageIcon("images/spaceship.png").getImage();
    private int posX = 400;
    private int posY = 400;
    private boolean isLeft, isRight;
    private Thread th;

    Ship() {
        this.setPreferredSize(new Dimension(800, 600));
        th = new Thread(this);
        th.start();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("눌러지나?");
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    isLeft = true;
                    // posX -= 10;
                    // repaint();

                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    isRight = true;
                    // posX += 10;
                    // repaint();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    isLeft = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    isRight = false;
                }
            }
        });
        this.setFocusable(true);
        this.requestFocus();
    }

    public void move() {
        if (isLeft) {
            posX -= 10;
        } else if (isRight) {
            posX += 10;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ship, posX, posY, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                move();
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
