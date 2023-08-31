import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Boom {
    private int loadX;
    private int loadY;
    private Image img;
    private int count = 0;
    public boolean end;

    Boom(String imgSource, int loadX, int loadY) {
        this.loadX = loadX;
        this.loadY = loadY;
        img = new ImageIcon(imgSource).getImage();
    }

    public void draw(Graphics g) {
        g.drawImage(img, loadX, loadY, null);
    }

    public void disappear() {
        // System.out.println(count);
        count++;
        if (count > 30) {
            end = true;
        }
    }
}
