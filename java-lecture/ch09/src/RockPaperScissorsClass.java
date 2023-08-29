import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

public class RockPaperScissorsClass extends JFrame {
    private ItemPanel itemPanel = new ItemPanel();
    private ResultPanel resultPanel = new ResultPanel();

    RockPaperScissorsClass() {
        this.setTitle("text area");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(resultPanel, BorderLayout.CENTER);
        contentPane.add(itemPanel, BorderLayout.NORTH);

        this.setSize(600, 600);
        this.setVisible(true);

    }

    class ItemPanel extends JPanel {
        private JLabel itemList[] = new JLabel[3];
        private ImageIcon iconList[] = {
                new ImageIcon("images/rock.png"),
                new ImageIcon("images/paper.png"),
                new ImageIcon("images/scissors.png")
        };

        ItemPanel() {

            setLayout(new FlowLayout(FlowLayout.CENTER));
            for (int i = 0; i < 3; i++) {
                Image originalImg = iconList[i].getImage();
                Image resizeImg = originalImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                itemList[i] = new JLabel(iconList[i]);
                itemList[i].setIcon(new ImageIcon(resizeImg));
                add(itemList[i]);
                int meSelect = i;
                itemList[i].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        Random random = new Random();
                        int computerSelect = random.nextInt(3);
                        if (computerSelect == meSelect) {
                            resultPanel.judge("draw");
                        } else if ((meSelect == 0 && computerSelect == 1) || (meSelect == 1 && computerSelect == 2)
                                || (meSelect == 2 && computerSelect == 0)) {
                            resultPanel.judge("lose");
                        } else {
                            resultPanel.judge("win");
                        }
                    }
                });
            }
        }

    }

    class ResultPanel extends JPanel {
        private JLabel meLabel = new JLabel("Me");
        private JLabel computerLabel = new JLabel("Computer");
        private JLabel resultLabel = new JLabel("result");
        private ImageIcon iconList[] = {
                new ImageIcon("images/rock.png"),
                new ImageIcon("images/paper.png"),
                new ImageIcon("images/scissors.png")
        };

        ResultPanel() {

            setLayout(new FlowLayout(FlowLayout.CENTER));
            add(meLabel);
            add(computerLabel);
            add(resultLabel);
            // judge("win");
        }

        public void judge(String resultTxt) {
            System.out.println(resultTxt);
            resultLabel.setText(resultTxt);
        }
    }

    public static void main(String[] args) {
        new RockPaperScissorsClass();
    }
}
