import javax.swing.JFrame;

public class GameApp extends JFrame {
    GameApp() {
        this.setTitle("SHOOTING GAME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Ship());
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] args) {
        new GameApp();
    }
}
