package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

// 다중 채팅...
// 이름을 입력받아서 window열리면서 
public class Client extends JFrame {
    private String chattingName = null;
    JLabel nickLabel = new JLabel();
    JTextArea textArea = null;
    JTextField textField = null;
    JButton btn = null;

    Client() {
        chattingName = JOptionPane.showInputDialog(this, "닉네임을 쓰세요.", "닉네임", JOptionPane.YES_NO_OPTION);
        // System.out.println(chattingName);
        if (chattingName.length() == 0 || chattingName == null) {
            System.exit(0);
        }
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());
        nickLabel.setText(chattingName);
        contentPane.add(nickLabel, BorderLayout.NORTH);
        textArea = new JTextArea(20, 30);
        textArea.setBackground(Color.GREEN);
        textArea.setEditable(false);
        contentPane.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        textField = new JTextField(30);
        inputPanel.add(textField, BorderLayout.WEST);
        btn = new JButton("나가기");
        inputPanel.add(btn, BorderLayout.EAST);
        contentPane.add(inputPanel, BorderLayout.SOUTH);
        textField.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append(chattingName + " : " + textField.getText() + "\n");
                textField.setText("");
            }

        });
        this.setTitle("멀티 채팅");
        this.pack();
        this.setResizable(false);
        // this.setSize(400, 300);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Client();
    }
}
