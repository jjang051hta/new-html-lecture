import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    private Image ship = new ImageIcon("images/spaceship.png").getImage();
    // private Image alien = new ImageIcon("images/monster.png").getImage();

    private int posX = 400;
    private int posY = 400;
    private List<Monster> monsterList = new ArrayList<>();
    // Monster monster = new Monster("images/monster.png", 300, 10);
    // private int alienPosX = 500;
    // private int alienPosY = 500;

    private boolean isLeft, isRight, isUp, isDown;
    private Thread th;

    GamePanel() {
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
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    isRight = true;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    isUp = true;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    isDown = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    isLeft = false;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    isRight = false;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    isUp = false;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    isDown = false;
                }
            }
        });
        this.setFocusable(true);
        this.requestFocus();
    }

    public void check() {
        // double distX = posX - alienPosX;
        // double distY = posY - alienPosY;
        // double dist = Math.sqrt(Math.pow(distX, 2) + Math.pow(distY, 2));
        // System.out.println(dist);
        // if (dist < 50) {
        // System.out.println("충돌");
        // alienPosX = (int) (Math.random() * 800);
        // alienPosY = (int) (Math.random() * 600);
        // }
    }

    public void move() {
        if (isLeft) {
            posX -= 5;
        }
        if (isRight) {
            posX += 5;
        }
        if (isUp) {
            posY -= 5;
        }
        if (isDown) {
            posY += 5;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(ship, posX, posY, null);
        for (int i = 0; i < monsterList.size(); i++) {
            Monster monster = monsterList.get(i);
            monster.draw(g);
        }

        // g.drawImage(alien, alienPosX, alienPosY, null);

    }

    void makeMonster() {
        if (Math.random() < 0.1) {
            Monster monster = new Monster(
                    "images/monster.png",
                    (int) (Math.random() * 800),
                    -50,
                    (int) (Math.random() * 10 + 2));
            monsterList.add(monster);
        }
    }

    void monsterMove() {
        for (int i = 0; i < monsterList.size(); i++) {
            Monster monster = (Monster) monsterList.get(i);
            monster.moveY();
        }
    }

    void removeMonster() {
        for (int i = 0; i < monsterList.size(); i++) {
            Monster monster = (Monster) monsterList.get(i);
            if (monster.end) {
                monsterList.remove(i);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                move();
                makeMonster();
                monsterMove();
                removeMonster();
                check();
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
