import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet {
    private int loadX;
    private int speedY;
    private int posY;
    private Image img;
    public boolean end;

    Bullet(String imgSource, int loadX, int posY, int speedY) {
        this.loadX = loadX;
        this.posY = posY;
        this.speedY = speedY;
        img = new ImageIcon(imgSource).getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, loadX, posY, null);
    }

    public void moveY() {
        posY -= speedY;
        if (posY > 200) {
            end = true;
        }
        // System.out.println("내려가자");
    }
}
