import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MoneyChange extends JFrame {
    private int units[] = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
    private String txtUnits[] = { "오만원", "만원", "오천원", "천원", "오백원", "백원", "오십원", "십원" };
    private JTextField moneyTfList[] = new JTextField[8];

    MoneyChange() {
        this.setTitle("돈바꾸기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(150, 120, 80));
        JLabel titleLabel = new JLabel("금액");
        titleLabel.setHorizontalAlignment(JLabel.RIGHT);
        titleLabel.setSize(50, 30);
        titleLabel.setLocation(100, 50);

        JTextField txtMoney = new JTextField(30);
        JButton btn = new JButton("계산");
        txtMoney.setBounds(170, 50, 150, 30);
        btn.setBounds(350, 50, 60, 30);
        contentPane.add(titleLabel);
        contentPane.add(txtMoney);
        contentPane.add(btn);

        for (int i = 0; i < 8; i++) {
            JLabel moneyTxtLabel = new JLabel(txtUnits[i]);

            moneyTxtLabel.setBounds(100, 100 + 35 * i, 50, 30);
            moneyTxtLabel.setHorizontalAlignment(JLabel.RIGHT);
            contentPane.add(moneyTxtLabel);

            moneyTfList[i] = new JTextField(30);
            moneyTfList[i].setBounds(170, 100 + 35 * i, 150, 30);
            contentPane.add(moneyTfList[i]);

        }
        btn.addActionListener(new ActionListener() {
            int rest;

            @Override
            public void actionPerformed(ActionEvent e) {
                int inputMoney = Integer.parseInt(txtMoney.getText());
                for (int i = 0; i < units.length; i++) {
                    moneyTfList[i].setText("" + inputMoney / units[i]);
                    moneyTfList[i].setText(Integer.toString(inputMoney / units[i]));
                    inputMoney = inputMoney % units[i];
                }
            }
        });

        this.setSize(500, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MoneyChange();
    }
}
