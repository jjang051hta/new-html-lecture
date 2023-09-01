import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    private Image ship = new ImageIcon("images/spaceship.png").getImage();

    private Image boom = new ImageIcon("images/boom.png").getImage();

    private int posX = 400;
    private int posY = 400;

    private int boomX = 400;
    private int boomY = 400;

    private List<Monster> monsterList = new ArrayList<>();
    private List<Bullet> bulletList = new ArrayList<>();
    private List<Boom> boomList = new ArrayList<>();

    // private int alienPosX = 500;
    // private int alienPosY = 500;

    private boolean isLeft, isRight, isUp, isDown;
    private Thread th;

    private boolean isPressed;
    private int bulletCount = 0;

    private int point = 0;

    GamePanel() {
        this.setPreferredSize(new Dimension(1280, 800));
        th = new Thread(this);
        th.start();
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    isLeft = true;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    isRight = true;
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    isUp = true;
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    isDown = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isPressed = true;
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
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    isPressed = false;
                }
            }
        });
        this.setFocusable(true);
        this.requestFocus();
    }

    public void makeBullet() {
        if (isPressed) {
            if (bulletCount > 3) {
                Bullet bullet01 = new Bullet("images/bullet.png", posX + 32 - 8, posY - 10, 10);
                bulletList.add(bullet01);
                bulletCount = 0;
            } else {
                bulletCount++;
            }
        }
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
        // 로직 짜보기....
        // code 주세요.... 젭알...
        // 1. 거리...
        // Rectangle rect = new Rectangle(100, 100, 100, 100);
        // Rectangle rect02 = new Rectangle(200, 200, 100, 100);
        // System.out.println(rect.intersects(rect02));
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = bulletList.get(i);
            for (int j = 0; j < monsterList.size(); j++) {
                Monster monster = monsterList.get(j);
                Rectangle bulletRect = new Rectangle(bullet.getLoadX(), bullet.getPosY(), 16, 16);
                Rectangle monsterRect = new Rectangle(monster.getLoadX(), monster.getPosY(), 32, 32);

                if (hitTest(bulletRect, monsterRect)) {
                    // 그려보기.....
                    bulletList.remove(bullet);
                    monsterList.remove(monster);
                    Boom boom = new Boom("images/boom.png", monster.getLoadX(), monster.getPosY());
                    boomList.add(boom);
                    point++;
                }
            }
        }
    }

    public boolean hitTest(Rectangle rect01, Rectangle rect02) {
        return rect01.intersects(rect02);
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
        // 배경 그리기...
        g.drawImage(new ImageIcon("images/space.jpg").getImage(), 0, 0, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("맑은 고딕", Font.BOLD, 24));

        g.drawString("point : " + point, 1000, 50);
        g.drawImage(ship, posX, posY, null);
        // 비행기 그리기
        for (int i = 0; i < monsterList.size(); i++) {
            Monster monster = monsterList.get(i);
            monster.draw(g);
        }
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = bulletList.get(i);
            bullet.draw(g);
        }
        for (int i = 0; i < boomList.size(); i++) {
            Boom boom = boomList.get(i);
            boom.draw(g);
        }

        // g.drawImage(boom, boomX, boomY, null);
    }

    void makeMonster() {
        if (Math.random() < 0.05) {
            Monster monster = new Monster(
                    "images/monster.png",
                    (int) (Math.random() * 1200),
                    -50,
                    (int) (Math.random() * 2 + 1));
            monsterList.add(monster);
        }
    }

    void monsterMove() {
        for (int i = 0; i < monsterList.size(); i++) {
            Monster monster = (Monster) monsterList.get(i);
            monster.moveY();
        }
    }

    void bulletMove() {
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = (Bullet) bulletList.get(i);
            bullet.moveY();
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

    void boomDisappear() {
        for (int i = 0; i < boomList.size(); i++) {
            Boom boom = (Boom) boomList.get(i);
            boom.disappear();
        }
    }

    void removeBullet() {
        for (int i = 0; i < bulletList.size(); i++) {
            Bullet bullet = (Bullet) bulletList.get(i);
            if (bullet.end) {
                bulletList.remove(i);
            }
        }
    }

    void removeBoom() {
        for (int i = 0; i < boomList.size(); i++) {
            Boom boom = (Boom) boomList.get(i);
            if (boom.end) {
                boomList.remove(i);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                move();
                makeBullet();
                makeMonster();
                monsterMove();
                removeMonster();
                bulletMove();
                removeBullet();
                boomDisappear();
                removeBoom();
                check();
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
